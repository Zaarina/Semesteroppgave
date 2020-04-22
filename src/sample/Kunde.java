package sample;

import Component.componentObject;
import fileManagement.formatter;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static fileManagement.readFile.readSerializedFile;

public class Kunde implements Initializable {

    //region FXML setup
    @FXML
    AnchorPane rootPane;

    @FXML public void changeScene(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    private ImageView imageView;

    //Super tableview
    @FXML private TableView<componentObject> superTableView;
    @FXML private TableColumn<componentObject, String> superNameColumn;
    @FXML private TableColumn<componentObject, Integer> superPriceColumn;

    //Local Tableview
    @FXML private TableView<componentObject> configurationTableView;
    @FXML private TableColumn<componentObject, String> localNameColumn;
    @FXML private TableColumn<componentObject, Integer> localPriceColumn;
    @FXML private TableView<componentObject> objectTableView;
    //endregion

    //laster inn et test bilde
    @FXML
    void loadImage(ActionEvent event) {
        Image image = new Image("sample/Bilder/GPU.jpg");
        imageView.setImage(image);
    }

    //Fjerner valgte objekter fra tableview & listen.
    @FXML
    void clearItem(ActionEvent event) throws NullPointerException{
        configurationTableView.getItems().removeAll(configurationTableView.getSelectionModel().getSelectedItem());
    }

    //Knapp som fjerner alle objekter fra listen
    @FXML
    void clearList(ActionEvent event) {
        localList.clear();
    }

    //Oppretter filplassering for lagrings filen av configurasjonen
    Path filePath = Paths.get("C:\\Users\\kunta\\OneDrive\\Desktop\\Documents\\OsloMet\\Java\\Semesteroppgave\\src\\sample\\Save.csv");
    //Knapp som lagrer tableview objektene til fil. WIP
    @FXML
    void saveConfiguration(ActionEvent event) throws IOException{
        //Fjerner componenter fra
        localList.clear();
        //printer string listen av componenentene til en tekst fil
        fileManagement.writeFile.save(componentConfig, filePath);
    }

    //Når man trykker på G-MAX2000
    componentObject testObject = new componentObject(1,"testObject", 25, "Test");

    @FXML
    void addComponent(ActionEvent event) throws IOException{
        components.add( new componentObject(1,"G-MAX2000", 2000, "Graphics Card"));
        componentConfig.add(formatter.formatComponent(new componentObject(1,"G-MAX2000", 2000, "Graphics Card")));
    }


    //oppretter en arraylist som skal inneholde alle komponenter
    List<String> componentConfig = new ArrayList<>();

    //Oppretter en observable list og legger til objekter. Returnerer listen.
    public static ObservableList<componentObject> components = FXCollections.observableArrayList();

    //Legger til test objekter i listen. Returnerer listen.
    public static ObservableList<componentObject> getComponents(){
        components.add(new componentObject(1,"Intel Pentium", 1500, "Processor"));
        components.add(new componentObject(2,"GTX1060", 4500, "Graphics Card"));
        components.add(new componentObject(3,"ASUS TUF X299", 2399, "Motherboard"));
        components.add(new componentObject(4,"HyperX Impact", 1919, "Memory"));
        return components;
    }

    public void setSuperTableView(){
        ObservableList<componentObject> list = FXCollections.observableArrayList(readSerializedFile());
        superTableView.setItems(list);
    }

    ObservableList<componentObject> localList = FXCollections.observableArrayList();
    @FXML void getSelectedItem(ActionEvent event) throws NullPointerException{

        if(superTableView.getSelectionModel().getSelectedItem() == null){
            throw new NullPointerException("Null");
        }

        componentObject object = superTableView.getSelectionModel().getSelectedItem();
        localList.add(object);
        configurationTableView.setItems(localList);
        superTableView.getSelectionModel().select(null);
        //System.out.print(dropDown.getSelectionModel().getSelectedItem());
    }

    public void initialize(URL location, ResourceBundle resources) {
        //Setter opp kolonnene i superTableView
        superNameColumn.setCellValueFactory(new PropertyValueFactory<componentObject, String>("name"));
        superPriceColumn.setCellValueFactory(new PropertyValueFactory<componentObject, Integer>("price"));

        //setter opp kolonnene i tableview
        localNameColumn.setCellValueFactory(new PropertyValueFactory<componentObject, String>("name"));
        localPriceColumn.setCellValueFactory(new PropertyValueFactory<componentObject, Integer>("price"));
        //Legger til objekter i tableview.
        configurationTableView.setItems(localList);

        setSuperTableView();

        //Legger til test objecter
        componentConfig.add(formatter.formatComponent(new componentObject(1,"Intel Pentium", 1500, "Processor")));
        componentConfig.add(formatter.formatComponent(new componentObject(2,"GTX1060", 4500, "Graphics Card")));
        componentConfig.add(formatter.formatComponent(new componentObject(3,"ASUS TUF X299", 2399, "Motherboard")));
        componentConfig.add(formatter.formatComponent(new componentObject(4,"HyperX Impact", 1919, "Memory")));

    }
}