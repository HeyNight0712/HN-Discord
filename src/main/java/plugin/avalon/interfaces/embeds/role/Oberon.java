package plugin.avalon.interfaces.embeds.role;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Oberon {
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("奧伯倫");
        embed.setDescription(
                """
                                屬於邪惡方角色，但是邪惡方陣營的玩家不曉得他的身份，他也不知道其他邪惡方的角色是誰
                                `加入【奧伯倫】反而會對正義方有幫助`
                        """);

        embed.setColor(Color.decode("#eb2323"));

        // 圖片
        embed.setThumbnail("https://andyventure.com/wp-content/uploads/boardgame/avalon/bad_people_oberon.webp");
        return embed;
    }
}
