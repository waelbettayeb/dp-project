package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Player;

import java.util.ArrayList;

public class ChoosePlayerScene extends Scene {
    private static Controller controller;
    private static ChoosePlayerScene view = null;
    private static ListView<Player> mListView = new ListView<>();
    private ChoosePlayerScene(Parent parent, double v, double v1) {
        super(parent, v, v1);
    }

    public static ChoosePlayerScene getInstance(Controller controller, ArrayList<Player> playersList) {

        ChoosePlayerScene.setListView(playersList);
        if(ChoosePlayerScene.view == null ) {
            GridPane grid = new GridPane();

            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));


            Text scenetitle = new Text("Choose a player");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            grid.add(scenetitle, 0, 0, 2, 1);

            mListView.getSelectionModel().select(0);
            grid.add(mListView, 0, 1);

            Button btn = new Button();
            btn.setText("Start");
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controller.startGame(mListView.getSelectionModel().getSelectedItem());
                }
            });
            grid.add(btn, 0, 2);


            Button CreateNewPlayerbtn = new Button();
            CreateNewPlayerbtn.setText("Create a New Player");
            CreateNewPlayerbtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controller.setAddPlayerScene();
                }
            });
            grid.add(CreateNewPlayerbtn, 0, 3);

            return new ChoosePlayerScene(grid, 800, 600);
        }
        return ChoosePlayerScene.view;
    }

    public static void setListView(ArrayList<Player> playersList) {
        ChoosePlayerScene.mListView.getItems().clear();
        ChoosePlayerScene.mListView.getItems().addAll(playersList);
    }
}