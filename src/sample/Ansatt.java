package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class Ansatt {

    @FXML
    public Label lblStatus;

    @FXML
    public javafx.scene.control.TextField txtBrukernavn;

    @FXML
    public PasswordField txtPassord;

    @FXML
    public ImageView view;


    public void loggInn(ActionEvent event) throws IOException {
        if (txtBrukernavn.getText().equals("admin") && txtPassord.getText().equals("admin")) {
            Parent view2 = FXMLLoader.load(getClass().getResource("Tableview.fxml"));
            Scene scene2 = new Scene(view2);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene2);
            window.show();
        } else lblStatus.setText("Brukernavn eller passord er feil"); //må fikse exception her
        //glemt passord??
    }

    public void changeScene(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

}