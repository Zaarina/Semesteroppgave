package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class Tableview implements Initializable {

    //region FXML setup
    @FXML private TableView<?> myTableView;
    @FXML private TreeView<String> myTreeView;
    //endregion

    //Lager en ny komponent type
    public TreeItem<String> makeNewComponentType(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        //item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    //Lager en ny komponent under en komponent type
    public TreeItem<String> makeNewComponent(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        //item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Opretter en rot item som alle komponent typer skal ha som parent
        TreeItem<String> root = new TreeItem<>();
        myTreeView.setRoot(root);
        //Unødvendig å kunne se rot objekt
        myTreeView.setShowRoot(false);

        //Her lager jeg nye komponent typer som alle komponenter skal ha som parent
        TreeItem<String> CPU = makeNewComponentType("CPU", root);
        TreeItem<String> Motherboard = makeNewComponentType("Motherboard", root);
        TreeItem<String> Storage = makeNewComponentType("Storage", root);
        TreeItem<String> Powersupply = makeNewComponentType("Powersupply", root);

        //Her legger jeg til nye komponenter i komponent type CPU
        makeNewComponent("Intel CPU", CPU);
        makeNewComponent("AMD CPU", CPU);
        makeNewComponent("RADION CPU", CPU);
        makeNewComponent("FLASH CPU", CPU);

        //Her legger jeg til nye komponenter i komponent type Storage
        makeNewComponent("Sandisk", Storage);
        makeNewComponent("Harddrive 2000", Storage);
        makeNewComponent("Super saver 3000", Storage);
        makeNewComponent("Save me", Storage);



    }


}
