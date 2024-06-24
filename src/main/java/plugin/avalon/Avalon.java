package plugin.avalon;

import hn.blacknight0712.utils.command.SlashCommandManager;
import hn.blacknight0712.utils.plugin.Plugin;
import plugin.avalon.commands.Command;

public class Avalon extends Plugin {
    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        SlashCommandManager.addCommand(new Command());
        getLogger().info(getName() + " 啟動完畢");
    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    @Override
    public String getName() {
        return "Avalon";
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
