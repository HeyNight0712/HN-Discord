package hn.blacknight0712;

import plugin.member.Member;
import hn.blacknight0712.data.Config;
import hn.blacknight0712.utils.command.CommandManager;
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
        initCommand();
        LoggerManager.info("啟動完畢...");
    }

    public static void initPlugin() {
        PluginManager pluginManager = new PluginManager();
        // pluginManager.loadPlugin();
        pluginManager.addPlugins(new Member());

        pluginManager.onEnableAll();
    }

    public static void initCommand() {
        CommandManager commandManager = new CommandManager();

        // CommandManager.addCommand(new PluginCommand());

        Bot.getJda().addEventListener(commandManager);
    }
}