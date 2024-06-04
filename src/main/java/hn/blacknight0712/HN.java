package hn.blacknight0712;

import hn.blacknight0712.core.member.Member;
import hn.blacknight0712.core.music.Music;
import hn.blacknight0712.data.Config;
import hn.blacknight0712.plugins.PluginManager;
import hn.blacknight0712.utils.LoggerManager;

public class HN {

    public static void main(String[] args) {
        LoggerManager.info("啟動中...");

        // load Config
        Config.instanceConfig();

        // load Bot
        // Bot.startBot();

        // load Plugin
        initPlugin();

    }

    public static void initPlugin() {
        PluginManager pluginManager = new PluginManager();
        // pluginManager.loadPlugin();
        pluginManager.addPlugins(new Music());
        pluginManager.addPlugins(new Member());

        pluginManager.onEnableAll();
    }
}