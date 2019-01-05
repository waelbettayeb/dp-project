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
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class AddPlayerScene extends Scene {
    private static AddPlayerScene instance = null;
    private static Controller controller;
    private static TextField userTextField ;
    private static Label errorLabel;
    private AddPlayerScene(Parent parent, double v, double v1) {
        super(parent, v, v1);
    }

    public static AddPlayerScene getInstance(Controller aController, boolean isPlayerlistNotEmpty){
        controller = aController;
        if(instance != null) {
            return instance;
        }
        else {
            return new AddPlayerScene(creatPane(isPlayerlistNotEmpty), 800, 600);
        }
    }
    private static Pane creatPane(boolean isPlayerlistNotEmpty) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Button btn = new Button();
        btn.setText("Start");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.print("[" + this + "] UsernameLabelText : " + userTextField.getCharacters().toString()+ '\n');
                controller.creatPlayer(userTextField.getCharacters().toString());
            }
        });
        grid.add(btn, 0, 3);

        Button ChoosePlayerbtn = new Button();
        ChoosePlayerbtn.setText("Play with an existing player");
        ChoosePlayerbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.setChoosePlayerScene();
            }
        });
        if(isPlayerlistNotEmpty)
            grid.add(ChoosePlayerbtn, 1, 3);

        errorLabel = new Label();
        grid.add(errorLabel, 0, 4);
        return grid;
    }
    public static String getUsername(){
        return userTextField.getText();
    }
    public static void setPlayerExistErrorLabel() {
        String ERROR_TEXT = "Joueur exist déjà";
        errorLabel.setText("Error: " + ERROR_TEXT);
    }
    public static void setPlayerNameErrorLabel() {
        String ERROR_TEXT = "Your name must start with uppercase";
        errorLabel.setText("Error: " + ERROR_TEXT);
    }

}
