package hn.blacknight0712.core.music;

import hn.blacknight0712.plugins.Plugin;

public class Music extends Plugin {
    @Override
    public String getName() {
        return "Music";
    }

    @Override
    public void onEnable() {
        getLogger().info("測試中");
    }

    @Override
    public void onDisable() {

    }
}
