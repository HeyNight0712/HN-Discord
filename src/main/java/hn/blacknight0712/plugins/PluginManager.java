package hn.blacknight0712.plugins;


import hn.blacknight0712.utils.LoggerManager;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PluginManager {
    private List<Plugin> plugins = new ArrayList<>();
    private Logger logger;


    public PluginManager() {
        logger = LoggerManager.getLogger("PluginManager");
    }

    public void loadPlugin(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            Plugin plugin = (Plugin) clazz.getDeclaredConstructor(Logger.class).newInstance(logger);
            plugins.add(plugin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onEnableAll() {
        for (Plugin plugin: plugins) {
            plugin.onEnable();
        }
    }

    public void onDisableAll() {
        for (Plugin plugin: plugins) {
            plugin.onDisable();
        }
    }

    public List<Plugin> getPlugins() {
        return plugins;
    }
}
