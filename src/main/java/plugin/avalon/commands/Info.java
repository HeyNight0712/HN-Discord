package plugin.avalon.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import org.jetbrains.annotations.NotNull;
import plugin.avalon.data.embeds.info.role.*;

public class Info {
    public static void reply(SlashCommandInteractionEvent event) {
        event
                .replyEmbeds(new plugin.avalon.data.embeds.info.Info().getEmbed().build())
                .addActionRow(new plugin.avalon.data.select.Info().getMenu())
                .setEphemeral(true)
                .queue();
    }

    public static void replySelect(@NotNull StringSelectInteractionEvent event) {
        String select = event.getValues().get(0);

        switch (select) {
            // 人物系列介紹
            case "Assassin":
                event.editMessageEmbeds(new Assassin().getEmbed().build()).queue();
                return;
            case "LoyalServantOfArthur":
                event.editMessageEmbeds(new LoyalServantOfArthur().getEmbed().build()).queue();
                return;
            case "Merlin":
                event.editMessageEmbeds(new Merlin().getEmbed().build()).queue();
                return;
            case "MinionOfMordred":
                event.editMessageEmbeds(new MinionOfMordred().getEmbed().build()).queue();
                return;
            case "Mordred":
                event.editMessageEmbeds(new Mordred().getEmbed().build()).queue();
                return;
            case "Morgana":
                event.editMessageEmbeds(new Morgana().getEmbed().build()).queue();
                return;
            case "Oberon":
                event.editMessageEmbeds(new Oberon().getEmbed().build()).queue();
                return;
            case "Percival":
                event.editMessageEmbeds(new Percival().getEmbed().build()).queue();
                return;
            case "Menu":
                event.editMessageEmbeds(new plugin.avalon.data.embeds.info.Info().getEmbed().build()).queue();
                return;
        }

        event.editMessage("查無此角色 肯定是被遺忘了 D:").queue();
    }
}
