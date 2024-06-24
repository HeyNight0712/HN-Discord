package plugin.avalon.commands;

import hn.blacknight0712.utils.command.SlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

public class Command extends SlashCommand {
    @Override
    public CommandData getCommandData() {
        return Commands.slash("avalon", "阿瓦隆")
                .addSubcommands(
                        new SubcommandData("info", "遊戲資訊"),
                        new SubcommandData("create", "創建遊戲")
                );
    }

    @Override
    public void run(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("avalon")) return; // 過濾非系列指令

        String subcommandName = event.getSubcommandName();
        if (subcommandName != null) {
            switch (subcommandName) {
                case "info":
                    Info.reply(event);
                    return;
                case "create":
                    Create.reply(event);
                    return;
            }
        }

        event.reply("該指令尚未成功寫入").queue();
    }

    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {
        if (!event.getComponentId().equals("Info:Role")) return;
        Info.replySelect(event);
    }
}
