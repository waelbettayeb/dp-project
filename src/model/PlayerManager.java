package model;

import java.util.ArrayList;

public class PlayerManager {
    private static IPlayerIO playerIO = new FilePlayerIO();
    public static Player creatPlayer(String string) throws PseudoExeption{
        if (!verifyPlayerName(string))
            throw new PseudoExeption();
        Player player = new Player(string);
        playerIO.createNewPlayer(player);
        return player;
    }
    public static void savePlayer(Player player) {
        playerIO.savePlayerStat(player);
    }
    private static boolean verifyPlayerName(String string){
        int charInt = (int) string.charAt(0);
        return (charInt >= 'A') && (charInt <= 'Z');
    }

    public static ArrayList<Player> loadPlayers() {
        return playerIO.loadPlayers();
    }
}
