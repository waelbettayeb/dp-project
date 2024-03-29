package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import view.AddPlayerScene;
import view.ChoosePlayerScene;
import view.EndGameScene;
import view.GameScene;

import java.util.ArrayList;

public class Controller {
    private Session session;
    private Scene view;
    private Stage primaryStage;
    private ArrayList<Player> players = PlayerManager.loadPlayers();

    public Controller(Stage Stage){
        this.primaryStage = Stage;

        if(players.isEmpty()) {
            this.setAddPlayerScene();
        }
        else {
            this.setChoosePlayerScene();
        }
//        primaryStage.setFullScreen(true);
        this.primaryStage.show();
    }
    public void setAddPlayerScene(){
        view = AddPlayerScene.getInstance(this, !players.isEmpty());
        this.primaryStage.setScene(view);
    }
    public void setChoosePlayerScene(){

        view = ChoosePlayerScene.getInstance(this, PlayerManager.loadPlayers());
        this.primaryStage.setScene(view);
    }
    public void setGameScene(){
        view = GameScene.getInstance(this, session);
        this.primaryStage.setScene(view);
    }
    public void setEndGameScene(){
        this.saveState();
        view = EndGameScene.getInstance(this, session);
        this.primaryStage.setScene(view);
    }

    public Session getSession() {
        return session;
    }

    public void startGame(Player player) {
        this.session = SessionManager.startSession(player);
        this.setGameScene();
    }
    public void saveState(){
        session.getPlayer().addNewScore(session.getScore());
        PlayerManager.savePlayer(session.getPlayer());
    }
    public void creatPlayer(String string) {
        try {
            startGame(PlayerManager.creatPlayer(string));
        }
        catch (PseudoExeption e){
            AddPlayerScene.setPlayerNameErrorLabel();
        }
    }
}
