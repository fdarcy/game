import java.util.ArrayList;

public class Game {
    private ArrayList<Player> playerList;

    public Game() {
        this.playerList = new ArrayList<>();
    }

    public void register(Player player) {
        playerList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player firstPlayer = findByName(playerName1);

        if (firstPlayer == null) {
            throw new NotRegisteredException("First player is not registered");
        }

        Player secondPlayer = findByName(playerName2);

        if (secondPlayer == null) {
            throw new NotRegisteredException("Second player is not registered");
        }

        if (firstPlayer.getStrength() == secondPlayer.getStrength()) {
            return 0;
        }

        if (firstPlayer.getStrength() > secondPlayer.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }

    public Player findByName(String name) {
        for (Player player : playerList) {
            if (player.getName().equals(name)) {
                return player;
            }
        }

        return null;
    }
}
