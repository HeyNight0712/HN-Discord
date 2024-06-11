package plugin.member.listeners;

import hn.blacknight0712.utils.file.FileConfiguration;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import plugin.member.Member;

import java.awt.*;

public class GuildMemberJoinListener extends ListenerAdapter {
    private String channelId;
    private FileConfiguration config;

    public GuildMemberJoinListener(String channelId) {
        this.channelId = channelId;
        Member.getPlugin().getLogger().info("註冊 GuildMemberJoin 事件");
        instanceConfig();
    }

    public void instanceConfig() {
        String configName = "guildMemberJoin";

        Member.getPlugin().loadConfig(configName);
        config = Member.getPlugin().getConfig(configName);

        config.addDefault("Title", "%member% 來到了伺服器 .w.");
        config.addDefault("Description", "歡迎加入，請記得詳讀規則和其他說明");
        config.addDefault("Color", "GREEN");

        Member.getPlugin().saveConfig(configName);
        Member.getPlugin().loadConfig(configName);
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        TextChannel channel = event.getGuild().getTextChannelById(channelId);

        if (channel != null) {
            Member.getPlugin().getLogger().info(event.getMember().getEffectiveName() + " 加入伺服器");
            channel.sendMessageEmbeds(getEmbed(event).build()).queue();
        }
    }

    public EmbedBuilder getEmbed(GuildMemberJoinEvent event) {
        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle(config.getString("Title").replace("%member%", event.getMember().getEffectiveName()));
        embed.setDescription(config.getString("Description"));
        embed.setThumbnail(event.getMember().getUser().getEffectiveAvatarUrl());

        embed.setColor(getColorFromString(config.getString("Color")));
        embed.setTimestamp(event.getMember().getTimeJoined());
        return embed;
    }

    private Color getColorFromString(String colorString) {
        try {
            return (Color) Color.class.getField(colorString.toUpperCase()).get(null);
        } catch (Exception e) {
            Member.getPlugin().getLogger().error("無效的顏色: " + colorString);
            return Color.GREEN;  // 默认颜色
        }
    }
}
