package model;

public class SessionManager {
    static IWordIO wordIO = new FileWordIO();
    public static Session startSession(Player player){
        return new Session(player, wordIO.getWords());
    }

}
