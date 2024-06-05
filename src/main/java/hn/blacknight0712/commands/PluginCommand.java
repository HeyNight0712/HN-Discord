package hn.blacknight0712.commands;

import hn.blacknight0712.utils.command.Command;
import hn.blacknight0712.utils.plugin.PluginManager;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PluginCommand extends Command {
    @Override
    public CommandData getCommandData() {
        return Commands.slash("plugin", "插件管理")
                .addOptions(new OptionData(OptionType.STRING, "function", "功能")
                        .addChoice("list","list")
                        .setRequired(false));
    }

    @Override
    public void run(SlashCommandInteractionEvent event) {
        // 過濾 非管理員 權限
        if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            event.reply("你沒有權限使用這個命令").setEphemeral(false).queue();
            return;
        }

        // 使用 plugin
        if (!event.getName().equals("plugin")) return;

        // 使用 子命令
        if (event.getOption("function") != null) {
            String functionValue = event.getOption("function").getAsString();
            if (functionValue.equals("list")) {
                event.reply("插件列表: " + PluginManager.getPluginNames()).queue();
                return;
            }

            // 非選項
            event.reply("上面沒有此選項: " + functionValue).queue();
            return;
        }

        event.reply("你沒有選擇 function").queue();

    }
}
