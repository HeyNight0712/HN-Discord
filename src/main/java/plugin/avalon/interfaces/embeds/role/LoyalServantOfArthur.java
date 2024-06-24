package plugin.avalon.interfaces.embeds.role;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class LoyalServantOfArthur {
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("亞瑟的忠臣");
        embed.setDescription(
                """
                                沒有能力的正義方角色
                        """);

        embed.setColor(Color.decode("#237feb"));

        // 圖片
        embed.setThumbnail("https://andyventure.com/wp-content/uploads/boardgame/avalon/good_people_normal.webp");
        return embed;
    }
}
