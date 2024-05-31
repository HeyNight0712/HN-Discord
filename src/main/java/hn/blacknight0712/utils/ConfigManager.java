package hn.blacknight0712.utils;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConfigManager {
    private static final HashMap<String, FileConfiguration> configs = new HashMap<>();
    private static final HashMap<FileConfiguration, File> configFiles = new HashMap<>();

    private ConfigManager() {} // 防止實例化

    public static FileConfiguration getConfig(String file) {
        return configs.get(file);
    }

    public static void reload() {
        loadConfig("config.yml");
    }

    public static void loadConfig(String file) {
        File configFile = new File(file + ".yml");
        Map<String, Object> configMap = configs.getOrDefault(file, FileConfiguration);

        configFiles.put(file, configFile);
        configs.put(file, configMap);

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

    public static void saveConfiig(String fileName, Map<String, Object> config) {
        File configFile = new File(fileName + ".yml");

        if (configFile.exists()) return;

        configFiles.put(fileName, configFile);
        configs.put(fileName, config);

        try (FileWriter writer = new FileWriter(configFile)) {
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setIndent(2);
            options.setPrettyFlow(true);
            Yaml yaml = new Yaml(options);
            yaml.dump(config, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<String> getAllConfigNames() {
        return configs.keySet();
    }
}
