package hn.blacknight0712;

import hn.blacknight0712.commands.PluginCommand;
import hn.blacknight0712.core.member.Member;
import hn.blacknight0712.core.music.Music;
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
         Bot.startBot();

        // load Plugin
        initPlugin();
        initCommand();
    }

    public static void initPlugin() {
        PluginManager pluginManager = new PluginManager();
        // pluginManager.loadPlugin();
        pluginManager.addPlugins(new Music());
        pluginManager.addPlugins(new Member());

        pluginManager.onEnableAll();
    }

    public static void initCommand() {
        CommandManager commandManager = new CommandManager();

        CommandManager.addCommand(new PluginCommand());

        Bot.getJda().addEventListener(commandManager);
    }
}