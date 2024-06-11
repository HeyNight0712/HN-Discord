package plugin.member.data;

import plugin.member.Member;
import hn.blacknight0712.utils.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class Config {

    public static boolean createPluginFolder() {
        if (!Member.getPlugin().getPluginFolder().exists()) {
            if (!Member.getPlugin().getPluginFolder().mkdirs()) {
                Member.getPlugin().getLogger().error("Plugin 資料夾創建失敗!");
                return false;
            }
        }
        return true;
    }

    public static void instanceConfig() {
        String configName = "config";
        Member.getPlugin().loadConfig(configName);
        FileConfiguration config = Member.getPlugin().getConfig(configName);

        // 加入 公會事件
        Map<String, Object> joinGuildEvent = new HashMap<>();
        joinGuildEvent.put("Enable", true);
        joinGuildEvent.put("Channel", "00000000");
        config.addDefault("GuildMemberJoin", joinGuildEvent);

        // 離開 公會事件
        Map<String, Object> leavingGuildEvent = new HashMap<>();
        leavingGuildEvent.put("Enable", true);
        leavingGuildEvent.put("Channel", "00000000");
        config.addDefault("GuildMemberRemove", leavingGuildEvent);

        Member.getPlugin().saveConfig(configName);
    }
}
