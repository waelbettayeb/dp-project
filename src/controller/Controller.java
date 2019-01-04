package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import model.PlayerManager;
import model.PseudoExeption;
import view.AddPlayerScene;
import view.ChoosePlayerScene;

import java.util.ArrayList;

public class Controller {
    Scene view;
    Stage primaryStage;
    ArrayList<Player> players = PlayerManager.loadPlayers();

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

    }
    public void setEndGameScene(){

    }

    public void startGame(Player selectedItem) {
        this.setGameScene();
    }

    public void creatPlayer(String string) {
        try {
            startGame(PlayerManager.creatPlayer(string));
        }
        catch (PseudoExeption e){
            AddPlayerScene.getInstance(this, !players.isEmpty()).setPlayerNameErrorLabel();
        }
    }
}
