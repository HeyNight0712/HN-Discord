package hn.blacknight0712.core.member.data;

import hn.blacknight0712.core.member.Member;
import hn.blacknight0712.utils.LoggerManager;
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
        Member.getPlugin().loadConfig("config");
        FileConfiguration config = Member.getPlugin().getConfig("config");

        // 加入 公會事件
        Map<String, Object> joinGuildEvent = new HashMap<>();
        joinGuildEvent.put("Enable", true);
        joinGuildEvent.put("Channel", "00000000");
        config.addDefault("JoinGuildEvent", joinGuildEvent);

        // 離開 公會事件
        Map<String, Object> leavingGuildEvent = new HashMap<>();
        leavingGuildEvent.put("Enable", true);
        leavingGuildEvent.put("Channel", "00000000");
        config.addDefault("LeavingGuildEvent", leavingGuildEvent);

        Member.getPlugin().saveConfig("config");
        LoggerManager.info("Config 加載完畢");
    }
}
