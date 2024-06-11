package plugin.member;

import hn.blacknight0712.utils.file.FileConfiguration;
import plugin.member.data.Config;
import hn.blacknight0712.utils.plugin.Plugin;
import plugin.member.listeners.GuildMemberJoinListener;
import plugin.member.listeners.GuildMemberRemoveListener;

public class Member extends Plugin {
    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Config.createPluginFolder();
        Config.instanceConfig();

        FileConfiguration config = getConfig("config");

        // 註冊 監聽器
        if (config.getBoolean("GuildMemberJoin.Enable")) {
            getJda().addEventListener(new GuildMemberJoinListener(config.getString("GuildMemberJoin.Channel")));
        }

        if (config.getBoolean("GuildMemberRemove.Enable")) {
            getJda().addEventListener(new GuildMemberRemoveListener(config.getString("GuildMemberRemove.Channel")));
        }

        getLogger().info(getName() + " 啟動完畢");
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
