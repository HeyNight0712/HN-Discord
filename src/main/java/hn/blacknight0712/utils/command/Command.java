package hn.blacknight0712.utils.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

public abstract class Command {
    public abstract CommandData getCommandData();

    public abstract void run(SlashCommandInteractionEvent event);
}
