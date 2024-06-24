package plugin.avalon.commands;

import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import plugin.avalon.interfaces.embeds.CreateMenu;
import plugin.avalon.managers.GameManager;
import plugin.avalon.models.Game;

public class Create {
    public static void reply(SlashCommandInteractionEvent event) {
        Member member = event.getMember();
        if (member == null) {
            event.reply("無法獲取用戶訊息").setEphemeral(true).queue();
            return;
        }

        GuildVoiceState voiceState = member.getVoiceState();

        if (voiceState == null || !voiceState.inAudioChannel()) {
            event.reply("你需要進入語音頻道才可以使用此命令").setEphemeral(true).queue();
            return;
        }

        if (voiceState.getChannel() == null) {
            event.reply("獲取語音頻道狀態失敗").setEphemeral(true).queue();
            return;
        }

        String channelId = voiceState.getChannel().getId();

        GameManager.getInstance().createGame(channelId, event.getMember());
        Game game = GameManager.getInstance().getGame(channelId);
        game.addPlayer(event.getMember());

        event.replyEmbeds(new CreateMenu().getEmbed(game).build()).queue();
    }
}
