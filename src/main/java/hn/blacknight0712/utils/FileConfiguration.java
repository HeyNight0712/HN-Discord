package hn.blacknight0712.utils;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileConfiguration {
    private final File configFile;
    private final Map<String, Object> configMap;

    public FileConfiguration(String fileName) {
        this.configFile = new File(fileName);
        this.configMap = new HashMap<>();

    }

    public void loadConfig() {
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
    }

    public void saveConfig() {
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

    public Object get(String key) {
        return configMap.get(key);
    }

    public void set(String key, Object value) {
        configMap.put(key, value);
    }

    public Set<String> getKey() {
        return configMap.keySet();
    }
}
