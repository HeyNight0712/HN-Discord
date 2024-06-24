package plugin.avalon.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Create {
    public static void reply(SlashCommandInteractionEvent event) {
        event.reply("開始遊戲").queue();
    }
}
