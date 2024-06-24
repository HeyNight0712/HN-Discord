package hn.blacknight0712;

import hn.blacknight0712.utils.command.SlashCommandManager;
import plugin.avalon.Avalon;
import plugin.member.Member;
import hn.blacknight0712.data.Config;
import hn.blacknight0712.utils.plugin.PluginManager;
import hn.blacknight0712.utils.LoggerManager;

public class HN {

    public static void main(String[] args) {
        LoggerManager.info("啟動中...");

        // load Config
        Config.instanceConfig();

        // load Bot
        if (!Bot.startBot()) return;

        // load Plugin
        initPlugin();
        Bot.getJda().addEventListener(new SlashCommandManager());


        LoggerManager.info("啟動完畢...");
    }

    public static void initPlugin() {
        PluginManager pluginManager = new PluginManager();
        // pluginManager.loadPlugin();
        pluginManager.addPlugins(new Member());
        pluginManager.addPlugins(new Avalon());

        pluginManager.onEnableAll();
    }
}