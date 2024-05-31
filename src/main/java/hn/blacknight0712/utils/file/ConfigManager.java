package hn.blacknight0712.utils.file;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

public class ConfigManager {
    private static final HashMap<String, FileConfiguration> configs = new HashMap<>();
    private static final HashMap<FileConfiguration, File> configFiles = new HashMap<>();

    private ConfigManager() {} // 防止實例化

    public static FileConfiguration getConfig(String file) {
        return configs.get(file);
    }

    public static void reload() {

    }

    public static void loadConfig(String file) {
        FileConfiguration config = configs.getOrDefault(file, new FileConfiguration(file));
        config.loadConfig();
        configs.put(file, config);
        configFiles.put(config, new File(file + ".yml"));
    }

    public static void saveConfig(String file) {
        FileConfiguration config = configs.get(file);
        if (config != null) {
            config.saveConfig();
        }
    }

    public static Set<String> getAllConfigNames() {
        return configs.keySet();
    }
}
