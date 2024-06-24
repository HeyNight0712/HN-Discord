package plugin.avalon.interfaces.embeds.role;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class MinionOfMordred {
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("莫德雷德的爪牙");
        embed.setDescription(
                """
                                沒有能力的邪惡方角色
                        """);

        embed.setColor(Color.decode("#eb2323"));

        // 圖片
        embed.setThumbnail("https://andyventure.com/wp-content/uploads/boardgame/avalon/bad_people_normal.webp");
        return embed;
    }
}
