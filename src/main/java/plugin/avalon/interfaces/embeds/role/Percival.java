package plugin.avalon.interfaces.embeds.role;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Percival {
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("派西維爾");
        embed.setDescription(
                """
                                在遊戲開始時的辨識身份階段，可以知道誰是【梅林】。
                                #在五人遊戲中使用【派西維爾】的話，邪惡方就要使用【莫德雷德】或【莫甘娜】
                        """);

        embed.setColor(Color.decode("#237feb"));

        // 圖片
        embed.setThumbnail("https://andyventure.com/wp-content/uploads/boardgame/avalon/good_people_percival.webp");
        return embed;
    }
}
