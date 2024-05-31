package hn.blacknight0712;

import hn.blacknight0712.data.Config;
import hn.blacknight0712.utils.ConfigManager;
import hn.blacknight0712.utils.LoggerManager;

import java.util.HashMap;
import java.util.Map;

public class HN {
    public static void main(String[] args) {
        LoggerManager.info("啟動中...");

        Config.instanceConfig();
        LoggerManager.info("Config 加載完畢");

        Bot.startBot();
    }
}