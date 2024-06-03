package hn.blacknight0712.plugins;


import hn.blacknight0712.utils.LoggerManager;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.jar.JarFile;

public class PluginManager {
    private List<Plugin> plugins = new ArrayList<>();
    private Logger logger;


    public PluginManager() {
        logger = LoggerManager.getLogger("PluginManager");
    }

    public void loadPlugin() {
        File pluginDir = new File("plugin");
        // 檢查是否存在 plugin 資料夾
        if (!pluginDir.exists()) {
            if (!pluginDir.mkdirs()) {
                LoggerManager.error("Plugin 資料夾創建失敗!");
                return;
            }
        }

        File[] jarFiles = pluginDir.listFiles(((dir, name) -> name.endsWith(".jar")));
        if (jarFiles != null) {
            for (File jarFile: jarFiles) {
                try {
                    URL jarURL = jarFile.toURI().toURL();
                    LoggerManager.info("測試路徑 " + jarURL);
                    URLClassLoader classLoader = new URLClassLoader(new URL[]{jarURL}, this.getClass().getClassLoader());
                    ServiceLoader<Plugin> serviceLoader = ServiceLoader.load(Plugin.class, classLoader);
                    for (Plugin plugin: serviceLoader) {
                        plugins.add(plugin);
                        plugin.onEnable();
                        LoggerManager.info("加載測試 " + plugin.getName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onEnableAll() {
        for (Plugin plugin: plugins) {
            plugin.onEnable();
            LoggerManager.info(plugin.getName() + " Enable!");
        }
    }

    public void onDisableAll() {
        for (Plugin plugin: plugins) {
            plugin.onDisable();
            LoggerManager.info(plugin.getName() + " Disable!");
        }
    }

    public List<Plugin> getPlugins() {
        return plugins;
    }
}
