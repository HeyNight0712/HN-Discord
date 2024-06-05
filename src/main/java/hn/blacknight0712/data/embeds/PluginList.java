package hn.blacknight0712.data.embeds;

import hn.blacknight0712.utils.plugin.PluginManager;
import net.dv8tion.jda.api.EmbedBuilder;

public class PluginList {
    public EmbedBuilder getEmbed() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("插件列表");
        embed.setDescription("當前插件啟動數量 (" + PluginManager.getPluginNames().size() + ")");

        return embed;
    }
}
