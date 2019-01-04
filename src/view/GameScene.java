package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.*;

import java.util.ArrayList;

public class GameScene extends Scene {
    private static Controller controller;
    private static GameScene instance = null;
    private static Schema schema = new Schema();
    private static HBox CasesView = new HBox();

    private GameScene(Parent parent, double v, double v1) {
        super(parent, v, v1);
    }

    public static GameScene getInstance(Controller controller, Word word) {
        creatCasesView(word);
        if(instance != null) {
            return instance;
        }
        else {
            return new GameScene(creatPane(), 800, 600);
        }
    }

    private static void creatCasesView(Word word) {

        word.getBoxes().forEach(box -> {
            if(box instanceof ZeroChanceBox){

            }else if(box instanceof PropositionBox){

            }else {

            }
        });

    }
    private static Pane creatPane() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        grid.add(schema, 4, 0);

        Text scoretitle = new Text("Score:");
        scoretitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
        grid.add(scoretitle, 0, 0);

        Text scenetitle = new Text("0");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));
        grid.add(scenetitle, 1, 0);

        Label userName = new Label("Username:");
        grid.add(userName, 0, 1);



        Button btn = new Button();
        btn.setText("Next");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });
        grid.add(btn, 0, 4);

        Button ChoosePlayerbtn = new Button();
        ChoosePlayerbtn.setText("Play with an existing player");
        ChoosePlayerbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.setChoosePlayerScene();
            }
        });
    return grid;

    }
}
