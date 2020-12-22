/******************
 * Andre Stadler
 * 22.12.2020
 ******************/
package sample;
import Main.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        MainController.show(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
