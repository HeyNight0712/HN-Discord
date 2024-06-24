package plugin.avalon.managers;

import net.dv8tion.jda.api.entities.Member;
import plugin.avalon.models.Game;

import java.util.HashMap;
import java.util.Map;

public class GameManager {
    private static final GameManager instance = new GameManager();
    private Map<String, Game> games;

    private GameManager() {
        this.games = new HashMap<>();
    }

    public static GameManager getInstance() {
        return instance;
    }

    /**
     * 創建 一局遊戲
     * @param channelId 語音房間 ID
     * @return 如果創建成功 則 True 反之 False
     */
    public boolean createGame(String channelId, Member owner) {
        if (games.containsKey(channelId)) return false;

        games.put(channelId, new Game(channelId, owner));
        return true;
    }

    public Game getGame(String channelId) {
        return games.get(channelId);
    }

    public void deleteGame(String channelId) {
        games.remove(channelId);
    }

    public boolean gameExists(String channelId) {
        return games.containsKey(channelId);
    }
}
