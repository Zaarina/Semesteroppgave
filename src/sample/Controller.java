package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Controller {

    @FXML
    public void ansattScene(ActionEvent event)throws IOException{
        Parent view2 = FXMLLoader.load(getClass().getResource("Ansatt.fxml"));

        Scene scene2 = new Scene(view2);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    public void kundeScene(ActionEvent event)throws IOException{
        Parent view2 = FXMLLoader.load(getClass().getResource("Kunde.fxml"));

        Scene scene2 = new Scene(view2);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();

    }

}
