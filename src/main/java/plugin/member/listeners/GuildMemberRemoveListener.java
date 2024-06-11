package plugin.member.listeners;

import hn.blacknight0712.utils.file.FileConfiguration;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import plugin.member.Member;

import java.awt.*;
import java.time.Instant;

public class GuildMemberRemoveListener extends ListenerAdapter {
    private String channelId;
    private FileConfiguration config;

    public GuildMemberRemoveListener(String channelId) {
        this.channelId = channelId;
        Member.getPlugin().getLogger().info("註冊 GuildMemberRemove 事件");
        instanceConfig();
    }

    public void instanceConfig() {
        String configName = "guildMemberRemove";

        Member.getPlugin().loadConfig(configName);
        config = Member.getPlugin().getConfig(configName);

        config.addDefault("Title", "%member% 離開了合作社 .w.");
        config.addDefault("Description", "祝他心想事成");
        config.addDefault("Color", "RED");

        Member.getPlugin().saveConfig(configName);
        Member.getPlugin().loadConfig(configName);
    }

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        TextChannel channel = event.getGuild().getTextChannelById(channelId);

        if (channel != null) {
            Member.getPlugin().getLogger().info(event.getUser().getEffectiveName() + " 離開了伺服器");
            channel.sendMessageEmbeds(getEmbed(event).build()).queue();
        }
    }

    public EmbedBuilder getEmbed(GuildMemberRemoveEvent event) {
        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle(config.getString("Title").replace("%member%", event.getUser().getEffectiveName()));
        embed.setDescription(config.getString("Description"));
        embed.setThumbnail(event.getUser().getEffectiveAvatarUrl());

        embed.setColor(getColorFromString(config.getString("Color")));
        embed.setTimestamp(Instant.now());
        return embed;
    }

    private Color getColorFromString(String colorString) {
        try {
            return (Color) Color.class.getField(colorString.toUpperCase()).get(null);
        } catch (Exception e) {
            Member.getPlugin().getLogger().error("無效的顏色: " + colorString);
            return Color.RED;  // 默认颜色
        }
    }
}
