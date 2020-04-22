package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Original source sample.fxml
        //Source for testing av superbruker Tableview.fxml
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Semesteroppgave2020");
        /*Original størrelse
        primaryStage.setScene(new Scene(root, 445, 297));
         */
        //Test størrelse
        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
