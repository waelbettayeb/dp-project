package model;

import java.io.*;
import java.util.ArrayList;

public class FilePlayerIO implements IPlayerIO{
    private final String FILE_PATH = "./players.obj";
    @Override
    public void createNewPlayer(Player player) throws PseudoExeption{
        ArrayList<Player> players = loadPlayers();
        players.removeIf(player1 -> (player1.getPseudo().equals(player.getPseudo())));
        players.add(player);
        try {

            new FileOutputStream(FILE_PATH, true).close();
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(players);
            out.close();
            fileOut.close();
        }catch (IOException i) {
            i.printStackTrace();
        }
    }
    @Override
    public void savePlayerStat(Player player){
        ArrayList<Player> players = loadPlayers();
        players.removeIf(player1 -> (player1.getPseudo().equals(player.getPseudo())));
        players.add(player);
        try {
            new FileOutputStream(FILE_PATH, true).close();
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(players);
            out.close();
            fileOut.close();
        }catch (IOException i) {
            i.printStackTrace();
        }
    }
    @Override
    public ArrayList<Player> loadPlayers(){
        ArrayList<Player> players = null;
        try {
            FileInputStream fileIn = new FileInputStream(FILE_PATH);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            players = (ArrayList<Player>) in.readObject();
            in.close();
            fileIn.close();
        }catch (FileNotFoundException i){
            players = new ArrayList<Player>();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Players class not found");
            c.printStackTrace();
        }
        return players;
    }
}
