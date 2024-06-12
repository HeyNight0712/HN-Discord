package plugin.member.listeners;

import hn.blacknight0712.utils.file.FileConfiguration;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import plugin.member.Member;

import java.awt.*;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class PeachContainerListener extends ListenerAdapter {
    private String channelId;
    private FileConfiguration config;

    public PeachContainerListener(String channelId) {
        this.channelId = channelId;
        Member.getPlugin().getLogger().info("註冊 PeachContainer 事件");
        instanceConfig();
    }

    public void instanceConfig() {
        String configName = "peachContainer";

        Member.getPlugin().loadConfig(configName);
        config = Member.getPlugin().getConfig(configName);

        config.addDefault("Title", "%member% 離開了合作社 .w.");
        config.addDefault("Description", "祝他心想事成");
        config.addDefault("Color", "RED");

        Member.getPlugin().saveConfig(configName);
        Member.getPlugin().loadConfig(configName);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return; // 過濾 機器人
        if (!event.getChannel().getId().equals(channelId)) return; // 過濾 非水蜜桃頻道
        event.getMessage().delete().queue();
        event.getChannel().sendMessageEmbeds(getEmbed(event).build()).queue();
        banMemberAndDeleteMessages(event.getGuild(), event.getMember());
        Member.getPlugin().getLogger().info("已封鎖 " + event.getAuthor().getEffectiveName());
    }

    public EmbedBuilder getEmbed(MessageReceivedEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        String userName = event.getAuthor().getEffectiveName();
        embed.setTitle(userName + " 想跑去當水蜜桃司機");
        embed.setDescription("`由於在此頻道 發送訊息 將自動封鎖`");
        embed.setThumbnail(event.getAuthor().getEffectiveAvatarUrl());
        embed.setColor(Color.PINK);
        embed.setTimestamp(Instant.now());
        return embed;
    }

    private void banMemberAndDeleteMessages(Guild guild, net.dv8tion.jda.api.entities.Member member) {
        guild.ban(member, 7, TimeUnit.DAYS).queue();
    }

}
