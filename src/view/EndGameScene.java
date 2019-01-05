package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Player;
import model.Session;



public class EndGameScene extends Scene{


    private static Controller controller;
    private static EndGameScene view = null;
    private static ListView<Player> mListView = new ListView<>();

    private EndGameScene(Parent parent, double v, double v1) {
        super(parent, v, v1);
    }
    public static EndGameScene getInstance(Controller controller, Session session) {
        if (EndGameScene.view == null) {
            GridPane grid = new GridPane();

            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));

            Text scenetitle;
            if(session.isWin())
                scenetitle = new Text("You win <3");
            else
                scenetitle = new Text("Loser :(");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            grid.add(scenetitle, 0, 0, 2, 1);

            Text scoretitle = new Text(session.getScore()+"");
            scoretitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            grid.add(scoretitle, 0, 1, 2, 1);

            Button btn = new Button();
            btn.setText("Restart");
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controller.startGame(session.getPlayer());
                }
            });
            grid.add(btn, 0, 2);

            Button chooseAnotherPlayerbtn = new Button();
            chooseAnotherPlayerbtn.setText("Choose another player");
            chooseAnotherPlayerbtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controller.setChoosePlayerScene();
                }
            });
            grid.add(chooseAnotherPlayerbtn, 1, 2);

            view  = new EndGameScene(grid, 800, 600);
        }
        return view;
    }

}
