package plugin.avalon.interfaces.embeds.role;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Merlin {
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("梅林");
        embed.setDescription(
                """
                        擁有知道所有邪惡方陣營玩家的能力，但不知道【莫德雷德】是誰。
                        如果最後被【刺客】刺殺，邪惡方就會獲勝
                """);

        embed.setColor(Color.decode("#237feb"));

        // 圖片
        embed.setThumbnail("https://andyventure.com/wp-content/uploads/boardgame/avalon/good_people_merlin.webp");
        return embed;
    }
}
