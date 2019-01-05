package view;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.*;

public class GameScene extends Scene {
    private static Controller controller;
    private static Session session;
    private static GameScene instance = null;
    private static Schema schema = new Schema();
    private static HBox casesView = new HBox();
    private static Label hiddenWordLabel;
    private static Label hintWordLabel;
    private static Text scoreText;
    private static Text wordIndex;

    static Button nextBtn = new Button();

    private GameScene(Parent parent, double v, double v1) {
        super(parent, v, v1);
    }

    public static GameScene getInstance(Controller controller1, Session session1) {
        controller = controller1;
        creatCasesView(session1);
        if(instance != null) {
            return instance;
        }
        else {
            return new GameScene(creatPane(), 800, 600);
        }
    }

    private static void creatCasesView(Session session1) {
        GameScene.session = session1;
        Word word = session.getCurrentWord();
        GameScene.casesView.getChildren().clear();
        word.getBoxes().forEach(box -> {
            if(box instanceof PropositionBox) {
                ChoiceBox<Character> caseView = new ChoiceBox<>();
                caseView.getItems().addAll(((PropositionBox) box).getProposedChars());
                caseView.setStyle("-fx-background-color:#ff4005;" +
                                "-fx-font: 20 arial;" +
                                "-fx-text-fill: white;"+
                                "-fx-padding: 10px;" +
                                "-fx-border-insets: 5px;" +
                                "-fx-background-insets: 5px;");
                        GameScene.casesView.getChildren().add(caseView);
                caseView.setOnAction(actionEvent -> {
                    box.setActualAnswer(caseView.getValue());
                    if(box.isPassed()){
                        caseView.setDisable(true);
                        if(session.getCurrentWord().isPassed()){
                            session.incIndex();
                            nextBtn.setDisable(false);
                        }
                    }
                    if(box.isMissed()) {
                        session.incIndex();
                        schema.schemaSuivant();

                        casesView.getChildren().forEach(node -> node.setDisable(true));
                        nextBtn.setDisable(false);
                        if(session.endSession()) {
                            schema = new Schema();
                            controller.setEndGameScene();
                        }
                    }
                });
            }
            else{
                TextField caseview = new TextField();
                caseview.textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(final ObservableValue<? extends String> ov,
                                        final String oldValue, final String newValue) {
                        if ((caseview.getText().length() > 1)) {
                            String s = caseview.getText().substring(1, 2);
                            caseview.setText(s);
                        }else{
                            if ((caseview.getText().length() > 0)) {
                                box.setActualAnswer(caseview.getCharacters().charAt(0));
                            }
                            if(box.isPassed()){
                                caseview.setDisable(true);
                                if(session.getCurrentWord().isPassed()) {
                                    session.incIndex();
                                    nextBtn.setDisable(false);
                                }
                            }
                            if(box.isMissed()) {
                                session.incIndex();
                                schema.schemaSuivant();
                                casesView.getChildren().forEach(node -> node.setDisable(true));
                                nextBtn.setDisable(false);
                                if(session.endSession()) {
                                    schema = new Schema();
                                    GameScene.controller.setEndGameScene();
                                }
                            }
                            System.out.println("char");
                        }
                    }

                });
//                caseview.setMaxSize(0, 1);
                if(box instanceof ZeroChanceBox){

                    caseview.setStyle("-fx-background-color:#76447d;" +
                            "-fx-font: 35 arial ;" +
                            "-fx-text-fill: white;"+
                            "-fx-padding: 10px;" +
                            "-fx-border-insets: 5px;" +
                            "-fx-background-insets: 5px;");
                }else {

                    caseview.setStyle("-fx-background-color:#00a8bc;" +
                            "-fx-font: 35 arial;" +
                            "-fx-text-fill: white;" +
                            "-fx-padding: 10px;" +
                            "-fx-border-insets: 5px;" +
                            "-fx-background-insets: 5px;");
                }
                GameScene.casesView.getChildren().add(caseview);
            }

        });

    }
    private static Pane creatPane() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        grid.add(schema, 4, 4);
        wordIndex = new Text("1/10");
        wordIndex.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
        grid.add(wordIndex, 4, 0);

        Text scoretitle = new Text("Score:");
        scoretitle.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
        grid.add(scoretitle, 0, 0);

        scoreText = new Text("0");
        scoreText.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));
        grid.add(scoreText, 1, 0);

        hiddenWordLabel = new Label(session.getCurrentWord().toString());
        grid.add(hiddenWordLabel, 0, 4);

        hintWordLabel = new Label(session.getCurrentWord().getHint().toString());
        grid.add(hintWordLabel, 0, 2);

        grid.add(GameScene.casesView, 0, 3);


        nextBtn = new Button();
        nextBtn.setText("Next");
        nextBtn.setDisable(true);
        nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                wordIndex.setText((session.getIndex()+1)+"/10");
                scoreText.setText(""+session.getScore());
                creatCasesView(session);
                hintWordLabel.setText(session.getCurrentWord().getHint().toString());
                hiddenWordLabel.setText(session.getCurrentWord().toString());

                nextBtn.setDisable(true);

            }
        });
        grid.add(nextBtn, 0, 5);

        return grid;

    }
}
