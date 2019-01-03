package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Player;
import view.AddPlayerScene;
import view.ChoosePlayerScene;

import java.util.ArrayList;

public class Controller {
    Scene view;
    Stage primaryStage;
    public Controller(Stage primaryStage){
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Wael"));
        players.add(new Player("Yahia"));
        view = ChoosePlayerScene.getInstance(players);
        primaryStage.setScene(view);
//        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
