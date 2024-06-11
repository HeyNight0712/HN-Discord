package hn.blacknight0712.utils.plugin;


import hn.blacknight0712.utils.LoggerManager;
import org.slf4j.Logger;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class PluginManager {
    private static Logger logger = LoggerManager.getLogger("PluginManager");
    private static final File pluginDir = new File("plugin");
    private static final List<Plugin> plugins = new ArrayList<>();


    public PluginManager() {
        logger = LoggerManager.getLogger("PluginManager");
    }

    public static boolean createPluginFolder() {
        if (!pluginDir.exists()) {
            if (!pluginDir.mkdirs()) {
                logger.error("Plugin 資料夾創建失敗!");
                return false;
            }
        }
        return true;
    }

    public static File getPluginDir() {
        return pluginDir;
    }

    public void loadPlugins() {
        // 檢查是否存在 plugin 資料夾
        if (!createPluginFolder()) return;

        File[] jarFiles = pluginDir.listFiles(((dir, name) -> name.endsWith(".jar")));
        if (jarFiles == null) return;

        for (File jarFile : jarFiles) {
            try {
                ServiceLoader<Plugin> serviceLoader = ServiceLoader.load(Plugin.class, new URLClassLoader(new URL[]{jarFile.toURI().toURL()}));
                for (Plugin plugin : serviceLoader) {
                    plugins.add(plugin);
                    logger.info("偵測到 " + plugin.getName() + " 插件");
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    public void onEnableAll() {
        for (Plugin plugin: plugins) {
            plugin.onEnable();
            logger.info(plugin.getName() + " Enable!");
        }
    }

    public void onDisableAll() {
        for (Plugin plugin: plugins) {
            plugin.onDisable();
            logger.info(plugin.getName() + " Disable!");
        }
    }

    public static List<Plugin> getPlugins() {
        return plugins;
    }

    public static List<String> getPluginNames() {
        List<String> pluginNames = new ArrayList<>();
        for (Plugin plugin: plugins) {
            pluginNames.add(plugin.getName());
        }
        return pluginNames;
    }

    public void addPlugins(Plugin plugin) {
        plugins.add(plugin);
    }
}
