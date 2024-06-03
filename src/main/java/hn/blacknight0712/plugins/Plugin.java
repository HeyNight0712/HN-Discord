package hn.blacknight0712.plugins;

import hn.blacknight0712.utils.LoggerManager;
import org.slf4j.Logger;

public abstract class Plugin {
    public abstract void onEnable();
    public abstract void onDisable();
    public abstract String getName();
    public Logger getLogger() {
        return LoggerManager.getLogger(getName());
    }
}
