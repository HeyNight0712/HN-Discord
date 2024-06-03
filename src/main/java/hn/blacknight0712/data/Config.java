package hn.blacknight0712.data;

import hn.blacknight0712.utils.LoggerManager;
import hn.blacknight0712.utils.file.ConfigManager;
import hn.blacknight0712.utils.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class Config {
    public static void instanceConfig() {
        // discord
        ConfigManager.loadConfig("config");
        FileConfiguration config = ConfigManager.getConfig("config");

        config.addDefault("Test", "封裝成功");

        Map<String, Object> discord = new HashMap<>();
        discord.put("Token", "");
        discord.put("Activity", "JDA");
        config.addDefault("Discord", discord);

        ConfigManager.saveConfig("config");
        ConfigManager.loadConfig("config");

        LoggerManager.info("Config 加載完畢");
    }
}
