package hn.blacknight0712.plugins;

import org.slf4j.Logger;

public interface Plugin {
    void onEnable();

    void onDisable();

    String getName();

    Logger getLogger();
}
