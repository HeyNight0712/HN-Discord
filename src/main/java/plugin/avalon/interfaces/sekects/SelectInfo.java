package plugin.avalon.interfaces.sekects;

import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

public class SelectInfo {

    public StringSelectMenu getMenu() {
        return StringSelectMenu.create("Info:Role")
                .setPlaceholder("查看角色資訊")
                .addOption("刺客 (邪惡方)", "Assassin")
                .addOption("亞瑟的忠臣 (正義方)", "LoyalServantOfArthur")
                .addOption("梅林 (正義方)", "Merlin")
                .addOption("莫德雷德的爪牙 (邪惡方)", "MinionOfMordred")
                .addOption("莫德雷德 (邪惡方)", "Mordred")
                .addOption("莫甘娜 (邪惡方)", "Morgana")
                .addOption("奧伯倫 (邪惡方", "Oberon")
                .addOption("派西維爾 (正義方)", "Percival")
                .addOption("遊戲資訊", "Menu")
                .build();
    }
}
