package plugin.avalon.models;

import net.dv8tion.jda.api.entities.Member;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private Member owner;
    private @NotNull String channelId;
    private Set<Member> players;
    private int currentPlayers;

    public Game(String channelId, Member owner) {
        this.channelId = channelId;
        this.players = new HashSet<>();
        this.currentPlayers = 0;
        this.owner = owner;
    }

    public String getChannelId() {
        return channelId;
    }

    public Set<Member> getPlayers() {
        return players;
    }

    public int getCurrentPlayers() {
        return currentPlayers;
    }

    public Member getOwner() {
        return owner;
    }

    public boolean addPlayer(Member member) {
        if (players.size() >= 10) return false;

        players.add(member);
        currentPlayers++;
        return true;
    }

    public void removePlayer(Member member) {
        players.remove(member);
        currentPlayers--;
    }
}
