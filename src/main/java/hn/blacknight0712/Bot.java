package hn.blacknight0712;

import hn.blacknight0712.utils.ConfigManager;
import hn.blacknight0712.utils.LoggerManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.exceptions.InvalidTokenException;

import java.util.Map;

public class Bot {
    private static JDA jda;

    public static void startBot() {
        Map<String, Object> config = ConfigManager.getConfig("config");
        Map<String, Object> discordConfig = (Map<String, Object>) config.get("Discord");
        try {
            jda = JDABuilder.createDefault((String) discordConfig.get("Token"))
                    .setActivity(Activity.playing((String) discordConfig.get("Activity")))
                    .build();
        } catch (InvalidTokenException e) {
            LoggerManager.error("Token 錯誤");
        }

        LoggerManager.info("Bot 加載完畢");
    }

    public static JDA getJda() {
        return jda;
    }
}
