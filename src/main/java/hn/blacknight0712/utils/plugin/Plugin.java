package hn.blacknight0712.utils.plugin;

import hn.blacknight0712.Bot;
import net.dv8tion.jda.api.JDA;
import plugin.member.Member;
import hn.blacknight0712.utils.LoggerManager;
import hn.blacknight0712.utils.file.ConfigManager;
import hn.blacknight0712.utils.file.FileConfiguration;
import org.slf4j.Logger;

import java.io.File;

public abstract class Plugin {
    public abstract void onEnable();
    public abstract void onDisable();
    public abstract String getName();
    public Logger getLogger() {
        return LoggerManager.getLogger(getName());
    }

    /**
     * 獲取 插件資料夾位置
     * @return File
     */
    public File getPluginFolder() {
        return new File(PluginManager.getPluginDir() + "/" + Member.getPlugin().getName());
    }


    // 加載 Config
    public void loadConfig(String file) {
        ConfigManager.loadConfig(getPluginFolder() + "/" + file);
    }

    public FileConfiguration getConfig(String file) {
        return ConfigManager.getConfig(getPluginFolder() + "/" + file);
    }

    public void saveConfig(String file) {
        ConfigManager.saveConfig(getPluginFolder() + "/" + file);
    }

    // 獲取 jda
    public JDA getJda() {
        return Bot.getJda();
    }
}
