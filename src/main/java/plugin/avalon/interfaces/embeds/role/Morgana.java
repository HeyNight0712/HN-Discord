package plugin.avalon.interfaces.embeds.role;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Morgana {
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("莫甘娜");
        embed.setDescription(
                """
                                在遊戲開始時的辨識身份階段，可以假扮成【梅林】，混淆【派西維爾】
                        """);

        embed.setColor(Color.decode("#237feb"));

        // 圖片
        embed.setThumbnail("https://andyventure.com/wp-content/uploads/boardgame/avalon/good_people_normal.webp");
        return embed;
    }
}
