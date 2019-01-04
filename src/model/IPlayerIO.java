package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public interface IPlayerIO {
    public void createNewPlayer(Player player) throws PseudoExeption;
    public void savePlayerStat(Player player);
    public ArrayList<Player> loadPlayers();
}
