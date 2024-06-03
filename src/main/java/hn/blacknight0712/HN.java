package hn.blacknight0712;

import hn.blacknight0712.data.Config;
import hn.blacknight0712.plugins.PluginManager;
import hn.blacknight0712.utils.LoggerManager;

public class HN {
    public static void main(String[] args) {
        LoggerManager.info("啟動中...");

        Config.instanceConfig();
        LoggerManager.info("Config 加載完畢");

        PluginManager pluginManager = new PluginManager();
        pluginManager.loadPlugin();
        pluginManager.onEnableAll();

        // Bot.startBot();
    }
}