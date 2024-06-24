package plugin.avalon.data.embeds.info.role;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Assassin {
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("刺客");
        embed.setDescription(
                """
                                當遊戲結束，邪惡方失敗時，可以刺殺【梅林】來反敗為勝
                        """);

        embed.setColor(Color.decode("#eb2323"));

        // 圖片
        embed.setThumbnail("https://andyventure.com/wp-content/uploads/boardgame/avalon/bad_people_assassin.webp");
        return embed;
    }
}
