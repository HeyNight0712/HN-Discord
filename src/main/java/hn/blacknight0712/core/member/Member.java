package hn.blacknight0712.core.member;

import hn.blacknight0712.core.member.data.Config;
import hn.blacknight0712.utils.plugin.Plugin;

public class Member extends Plugin {
    private static Plugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
        Config.createPluginFolder();
        Config.instanceConfig();

        getLogger().info(getName() + " 啟用");
    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    @Override
    public String getName() {
        return "Member";
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
