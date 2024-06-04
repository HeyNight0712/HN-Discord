package hn.blacknight0712.core.music;

import hn.blacknight0712.plugins.Plugin;

public class Music extends Plugin {
    @Override
    public String getName() {
        return "Music";
    }

    @Override
    public void onEnable() {
        getLogger().info("測試中 暫未開放");
        onDisable();
    }

    @Override
    public void onDisable() {
        getLogger().info("關閉...");
    }
}
