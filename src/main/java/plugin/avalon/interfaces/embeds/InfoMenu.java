package plugin.avalon.interfaces.embeds;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class InfoMenu {
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("遊戲資訊");
        embed.setDescription(
                """
                遊戲中玩家分成兩大陣營 每個陣營內有能力者和普通角色
                玩家要通過邏輯推理和對話來試探彼此的陣營
                與狼人殺不同的是 遊戲中玩家不會被殺出局
                「梅林」(可以知道玩家陣營的角色)則是要躲藏好
                否則身份曝光的話會在結尾被翻盤
                """);

        embed.setColor(Color.decode("#eb9b23"));

        embed.addField("遊戲人數", "5 ~ 10 人", true);
        embed.addField("最佳人數", "7 ~ 8 人", true);

        embed.addField("設計者",
                """
                程式: 嘿夜
                美術: 易滑
                """, false);
        return embed;
    }
}
