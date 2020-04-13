package sample;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Kunde implements Initializable {

    @FXML
    AnchorPane rootPane;
    @FXML
    VBox vBox;

    @FXML VBox firstSubVBox;
    @FXML VBox firstSubMenuList;
    @FXML
    Button firstMenu;

    @FXML VBox secondSubVBox;
    @FXML VBox secondSubMenuList;
    @FXML Button secondMenu;

    @FXML VBox thirdSubVBox;
    @FXML VBox thirdSubMenuList;
    @FXML Button thirdMenu;

    @FXML VBox fourthSubVBox;
    @FXML VBox fourthSubMenuList;
    @FXML Button fourthMenu;

    @FXML VBox fifthSubVBox;
    @FXML VBox fifthSubMenuList;
    @FXML Button fifthMenu;
    Map<VBox,VBox> map = new HashMap<VBox,VBox>();

    @FXML
    private ImageView imageView;

    //laster inn et test bilde
    @FXML
    void loadImage(ActionEvent event) {
        Image image = new Image("sample/Bilder/GPU.jpg");
        imageView.setImage(image);
    }

    //Knapp som fjerner alle objekter fra listen
    @FXML
    void clearList(ActionEvent event) {
        components.clear();
    }

    //Knapp som lagrer tableview objektene til fil
    Path filePath = Paths.get("C:\\Users\\kunta\\OneDrive\\Desktop\\Documents\\OsloMet\\Java\\Semesteroppgave\\src\\sample\\PC Configuration");
    @FXML
    void lagreKonfigurasjon(ActionEvent event) throws IOException{
        saveConfiguration.save(components, filePath);
        components.clear();
    }

    //Tableview
    @FXML private TableView<componentObject> tableView;
    @FXML private TableColumn<componentObject, String> nameColumn;
    @FXML private TableColumn<componentObject, Integer> priceColumn;
    @FXML private TableColumn<componentObject, Button> actionColumn;

    //Når man trykker på G-MAX2000
    @FXML
    void addComponent(ActionEvent event) {
        components.add( new componentObject("G-MAX2000", 2000));
        System.out.println();
    }


    //oppretter en arraylist som skal inneholde alle komponenter
    ArrayList<componentObject> availableComponents = new ArrayList<>();


    //Oppretter en observable list og legger til objekter. Returnerer listen.
    ObservableList<componentObject> components = FXCollections.observableArrayList();
    public ObservableList<componentObject> getComponents(){
        //Legger til objekter i listen. Returnerer listen.
        components.add(new componentObject("Intel Pentium", 1500));
        components.add(new componentObject("GTX1060", 4500));
        components.add(new componentObject("ASUS TUF X299", 2399));
        components.add(new componentObject("HyperX Impact", 1919));
        System.out.println(new componentObject("Intel Pentium", 1500).toString());
        return components;
    }

    public void initialize(URL location, ResourceBundle resources) {

        //setter opp kolonnene i tableview
        nameColumn.setCellValueFactory(new PropertyValueFactory<componentObject, String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<componentObject, Integer>("price"));
        //Legger til kolonnen med knapp
        actionColumn.setCellValueFactory(new PropertyValueFactory<componentObject, Button>("button"));
        //TableColumn removeItem = new TableColumn("Action");
        //tableView.getColumns().addAll(removeItem);
        //Legger til objekter i tableview.
        tableView.setItems(getComponents());

        addMenusToMap();
        setComponentsSize();


        firstMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                toolsSlider(firstSubVBox,firstSubMenuList);
                removeOtherMenus(firstSubVBox);
            }

        });

        secondMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                toolsSlider(secondSubVBox,secondSubMenuList);
                removeOtherMenus(secondSubVBox);
            }
        });

        thirdMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                toolsSlider(thirdSubVBox,thirdSubMenuList);
                removeOtherMenus(thirdSubVBox);
            }
        });

        fourthMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                toolsSlider(fourthSubVBox,fourthSubMenuList);
                removeOtherMenus(fourthSubVBox);
            }
        });

        fifthMenu.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                toolsSlider(fifthSubVBox,fifthSubMenuList);
                removeOtherMenus(fifthSubVBox);
            }
        });
    }

    /**
     * Set stage size as per screen resolution
     */
    private void setComponentsSize() {
        vBox.setPrefWidth(200);
    }
    /**
     * Add Menus to map
     */
    private void addMenusToMap() {
        addMenusToMapImpl();
    }

    private void addMenusToMapImpl() {

        map.put(firstSubVBox,firstSubMenuList);
        map.put(secondSubVBox, secondSubMenuList);
        map.put(thirdSubVBox,thirdSubMenuList);
        map.put(fourthSubVBox, fourthSubMenuList);
        map.put(fifthSubVBox, fifthSubMenuList);

        /**
         * Remove the components from VBox on load of stage
         */
        for (Map.Entry<VBox,VBox> entry : map.entrySet()) {
            entry.getKey().getChildren().remove(entry.getValue());
        }
    }
    /**
     * Menu slider
     * @param menu
     * @param subMenu
     */
    public void toolsSlider(VBox menu,VBox subMenu){
        toolsSliderImpl(menu,subMenu);
    }

    private void toolsSliderImpl(VBox menu,VBox subMenu) {
        if(menu.getChildren().contains(subMenu)){
            final FadeTransition transition = new FadeTransition(Duration.millis(500), menu);
            transition.setFromValue(0.5);
            transition.setToValue(1);
            transition.setInterpolator(Interpolator.EASE_IN);
            menu.getChildren().remove(subMenu);
            transition.play();
        }else{
            final FadeTransition transition = new FadeTransition(Duration.millis(500), menu);
            transition.setFromValue(0.5);
            transition.setToValue(1);
            transition.setInterpolator(Interpolator.EASE_IN);
            menu.getChildren().add(subMenu);
            transition.play();
        }
    }
    /**
     * Remove other menus
     * @param menu
     */
    public void removeOtherMenus(VBox menu){
        removeOtherMenusImpl(menu);
    }
    private void removeOtherMenusImpl(VBox menu) {
        for (Map.Entry<VBox,VBox> entry : map.entrySet()) {
            if(!entry.getKey().equals(menu))
                entry.getKey().getChildren().remove(entry.getValue());
        }
    }

    public void changeScene(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

}