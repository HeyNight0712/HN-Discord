package hn.blacknight0712.utils.command;

import hn.blacknight0712.Bot;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {
    private static final List<CommandData> commands = new ArrayList<>();
    private static final List<Command> commandsRun = new ArrayList<>();

    public CommandManager() {}

    public static void addCommand(Command command) {
        commands.add(command.getCommandData());
        commandsRun.add(command);
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Bot.getJda().updateCommands().addCommands(commands).queue();
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        for (Command command: commandsRun) {
            command.run(event);
        }
    }
}
