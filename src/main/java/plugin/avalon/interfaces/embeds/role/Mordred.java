package plugin.avalon.interfaces.embeds.role;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Mordred {
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("莫德雷德");
        embed.setDescription(
                """
                                可以不被【梅林】看到
                        """);

        embed.setColor(Color.decode("#eb2323"));

        // 圖片
        embed.setThumbnail("https://andyventure.com/wp-content/uploads/boardgame/avalon/bad_people_mordred.webp");
        return embed;
    }
}
