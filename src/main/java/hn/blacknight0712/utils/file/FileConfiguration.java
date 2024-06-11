package hn.blacknight0712.utils.file;

import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileConfiguration{
    private final File configFile;
    private final Map<String, Object> configMap;
    private final Map<String, Object> defaults;

    public FileConfiguration(String fileName) {
        this.configFile = new File(fileName + ".yml");
        this.configMap = new HashMap<>();
        this.defaults = new HashMap<>();
    }

    public void loadConfig(){
        if (!configFile.exists()) return;

        try (FileReader reader = new FileReader(configFile)) {
            Yaml yaml = new Yaml();
            Map<String, Object> loadedConfig = yaml.load(reader);
            if (loadedConfig != null) {
                configMap.putAll(loadedConfig);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Object> entry : defaults.entrySet()) {
            configMap.putIfAbsent(entry.getKey(), entry.getValue());
        }

        applyDefaults(configMap, defaults);
    }

    public void saveConfig(){
        applyDefaults(configMap, defaults);

        try (FileWriter writer = new FileWriter(configFile)) {
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setIndent(2);
            options.setPrettyFlow(true);
            Yaml yaml = new Yaml(options);
            yaml.dump(configMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取 String 类型的值
    public String getString(@NotNull String key) {
        Object value = get(key);
        return value != null ? value.toString() : null;
    }

    // 获取 Integer 类型的值
    public Integer getInt(@NotNull String key) {
        Object value = get(key);
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        return null;
    }

    // 获取 Boolean 类型的值
    public Boolean getBoolean(@NotNull String key) {
        Object value = get(key);
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        return null;
    }

    // 获取 Double 类型的值
    public Double getDouble(@NotNull String key) {
        Object value = get(key);
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        return null;
    }

    // 获取 Long 类型的值
    public Long getLong(@NotNull String key) {
        Object value = get(key);
        if (value instanceof Number) {
            return ((Number) value).longValue();
        }
        return null;
    }

    // 获取 Float 类型的值
    public Float getFloat(@NotNull String key) {
        Object value = get(key);
        if (value instanceof Number) {
            return ((Number) value).floatValue();
        }
        return null;
    }

    public Object get(@NotNull String key) {
        String[] keys = key.split("\\.");
        Map<String, Object> currentMap = configMap;
        for (int i = 0; i < keys.length - 1; i++) {
            currentMap = (Map<String, Object>) currentMap.get(keys[i]);
            if (currentMap == null) {
                return null;
            }
        }
        return currentMap.get(keys[keys.length - 1]);
    }

    public void set(String key, Object value) {
        configMap.put(key, value);
    }

    public void addDefault(String key, Object value) {
        defaults.put(key, value);
    }

    private void applyDefaults(Map<String, Object> configMap, Map<String, Object> defaults) {
        for (Map.Entry<String, Object> entry : defaults.entrySet()) {
            configMap.putIfAbsent(entry.getKey(), entry.getValue());
        }
    }

    public Set<String> getKey() {
        return configMap.keySet();
    }
}
