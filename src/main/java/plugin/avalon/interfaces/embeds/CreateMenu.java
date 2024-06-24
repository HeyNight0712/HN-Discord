package plugin.avalon.interfaces.embeds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import plugin.avalon.Avalon;
import plugin.avalon.models.Game;

public class CreateMenu {
    public EmbedBuilder getEmbed(Game game) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("阿瓦隆");

        // 房主
        embed.addField("房主", game.getOwner().getAsMention(), true);

        // 頻道
        VoiceChannel voiceChannel = Avalon.getPlugin().getJda().getVoiceChannelById(game.getChannelId());
        embed.addField("頻道", voiceChannel.getAsMention(), true);

        // 人數
        StringBuilder players = new StringBuilder();
        for (Member player : game.getPlayers()) {
            players.append(player.getAsMention()).append("\n");
        }
        embed.addField("當前人數 (" + game.getPlayers().size() + ")", players.toString(), false);

        embed.setThumbnail("https://static.wikia.nocookie.net/colorbeeboardgame/images/6/6f/%E9%98%BF%E7%93%A6%E9%9A%86.jpg/revision/latest/scale-to-width-down/375?cb=20161007095350&path-prefix=zh");

        return embed;
    }
}
