package plugin.avalon.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import org.jetbrains.annotations.NotNull;
import plugin.avalon.interfaces.embeds.InfoMenu;
import plugin.avalon.interfaces.embeds.role.*;
import plugin.avalon.interfaces.sekects.SelectInfo;

public class Info {
    public static void reply(SlashCommandInteractionEvent event) {
        event
                .replyEmbeds(new InfoMenu().getEmbed().build())
                .addActionRow(new SelectInfo().getMenu())
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
                event.editMessageEmbeds(new InfoMenu().getEmbed().build()).queue();
                return;
        }

        event.editMessage("查無此角色 肯定是被遺忘了 D:").queue();
    }
}
