package hn.blacknight0712.utils.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public abstract class SlashCommand {
    public abstract CommandData getCommandData();
    public abstract void run(SlashCommandInteractionEvent event);

    public abstract void onStringSelectInteraction(StringSelectInteractionEvent event);
}
