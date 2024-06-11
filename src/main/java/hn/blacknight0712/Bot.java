package hn.blacknight0712;

import hn.blacknight0712.utils.file.ConfigManager;
import hn.blacknight0712.utils.LoggerManager;
import hn.blacknight0712.utils.file.FileConfiguration;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.exceptions.InvalidTokenException;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot {
    private static JDA jda;

    public static boolean startBot() {
        FileConfiguration config = ConfigManager.getConfig("config");
        try {
            jda = JDABuilder.createDefault((String) config.get("Discord.Token"))
                    .enableIntents(
                            GatewayIntent.GUILD_MEMBERS,
                            GatewayIntent.GUILD_PRESENCES,
                            GatewayIntent.GUILD_MESSAGES,
                            GatewayIntent.GUILD_MESSAGE_REACTIONS,
                            GatewayIntent.GUILD_EMOJIS_AND_STICKERS)
                    .setActivity(Activity.playing((String) config.get("Discord.Activity")))
                    .build();

            jda.awaitReady();
        } catch (InterruptedException e){
            LoggerManager.error("初始化 JDA 時出錯 " + e);
            return false;
        }catch (InvalidTokenException e) {
            LoggerManager.error("Token 錯誤");
            return false;
        }
        return true;
    }

    public static JDA getJda() {
        return jda;
    }
}
