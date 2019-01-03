package view;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class AddPlayerScene extends Scene {
    private static TextField userTextField ;
    private static Label errorLabel;
    private AddPlayerScene(Parent parent, double v, double v1) {
        super(parent, v, v1);
    }

    public static AddPlayerScene getInstance(){
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
                System.out.println("Game started");
            }
        });
        grid.add(btn, 0, 3);

        errorLabel = new Label();
        grid.add(errorLabel, 0, 4);

        return new AddPlayerScene(grid, 800, 600);
    }
    public static String getUsername(){
        return userTextField.getText();
    }
    public static void setPlayerExistErrorLabel() {
        String ERROR_TEXT = "Joueur exist déjà";
        errorLabel.setText("Error: " + ERROR_TEXT);
    }
    public static void setPlayerNameErrorLabel() {
        String ERROR_TEXT = "Le nom est inacceptable";
        errorLabel.setText("Error: " + ERROR_TEXT);
    }

}