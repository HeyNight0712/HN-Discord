package hn.blacknight0712;

import hn.blacknight0712.utils.file.ConfigManager;
import hn.blacknight0712.utils.LoggerManager;
import hn.blacknight0712.utils.file.FileConfiguration;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.exceptions.InvalidTokenException;

import java.util.Map;

public class Bot {
    private static JDA jda;

    public static void startBot() {
        FileConfiguration config = ConfigManager.getConfig("config");
        try {
            jda = JDABuilder.createDefault((String) config.get("Discord.Token"))
                    .setActivity(Activity.playing((String) config.get("Discord.Activity")))
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
