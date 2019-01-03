import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;


public class main extends Application {
    Controller controller ;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        controller = new Controller(primaryStage);
    }

}