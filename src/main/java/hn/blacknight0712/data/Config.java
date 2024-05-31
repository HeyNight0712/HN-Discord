package hn.blacknight0712.data;

import hn.blacknight0712.utils.ConfigManager;
import hn.blacknight0712.utils.LoggerManager;

import java.util.HashMap;
import java.util.Map;

public class Config {
    public static void instanceConfig() {
        // discord
        Map<String, Object> discord = new HashMap<>();
        discord.put("Token", "");
        discord.put("Activity", "JDA");

        // 整合
        Map<String, Object> config = new HashMap<>();
        config.put("Discord", discord);

        // Save
        ConfigManager.saveConfiig("config" ,config);
        ConfigManager.loadConfig("config");
    }
}
