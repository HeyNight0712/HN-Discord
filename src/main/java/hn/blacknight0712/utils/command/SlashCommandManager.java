package hn.blacknight0712.utils.command;


import hn.blacknight0712.Bot;
import hn.blacknight0712.utils.LoggerManager;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SlashCommandManager extends ListenerAdapter {
    private static final List<CommandData> commandDatas = new ArrayList<>();
    private static final List<SlashCommand> slashCommandRuns = new ArrayList<>();

    public SlashCommandManager() {}

    public static void addCommand(SlashCommand slashCommand) {
        SlashCommandManager.commandDatas.add(slashCommand.getCommandData());
        slashCommandRuns.add(slashCommand);
        LoggerManager.info("註冊 " + slashCommand.getCommandData().getName() + " 指令");
    }

    public static List<CommandData> getCommandDatas() {
        return commandDatas;
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        System.out.println("測試");
        Bot.getJda().updateCommands().addCommands(commandDatas).queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        for (SlashCommand slashCommand: slashCommandRuns) {
            slashCommand.run(event);
        }
    }

    @Override
    public void onStringSelectInteraction(@NotNull StringSelectInteractionEvent event) {
        for (SlashCommand slashCommand: slashCommandRuns) {
            slashCommand.onStringSelectInteraction(event);
        }
    }
}
