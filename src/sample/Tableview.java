package sample;

import Component.componentObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Tableview implements Initializable {
    @FXML private TableView<componentObject> superTableView;
    @FXML private TableColumn<componentObject, String> superNameColumn;
    @FXML private TableColumn<componentObject, Integer> superPriceColumn;

    @FXML private TableView<componentObject> localTableView;
    @FXML private TableColumn<componentObject, String> localNameColumn;
    @FXML private TableColumn<componentObject, Integer> localPriceColumn;

    //Exception må håndteres
    @FXML void getSelectedText(ActionEvent event) throws NullPointerException{
        if(superTableView.getSelectionModel().getSelectedItem().equals(null)){
            throw new NullPointerException("Null");
        }
        componentObject object = superTableView.getSelectionModel().getSelectedItem();
        localList.add(object);
        localTableView.setItems(localList);
        superTableView.getSelectionModel().select(null);
    }

    ObservableList<componentObject> superList = FXCollections.observableArrayList();

    ObservableList<componentObject> localList = FXCollections.observableArrayList();

    public ObservableList<componentObject> getSuperList(){
        //Setter inn test data. Denne metoden burde lese fra fil og laste inn objektene automatisk.
        superList.add(new componentObject(1,"Intel Pentium", 1499, "Processor"));
        superList.add(new componentObject(1,"GTX 1080", 3499, "Graphics Card"));
        superList.add(new componentObject(1,"ASUS Motherboard", 1299, "Motherboard"));
        superList.add(new componentObject(1,"Corsair 32GB DDR3", 1500, "Memory"));
        superList.add(new componentObject(1,"Sanadisk 1T", 1000, "Storage"));
        superList.add(new componentObject(1,"Corsair 1500Watt", 1499, "Powersupply"));
        superList.add(new componentObject(1,"Cooler Master Tower TX", 1100, "Case"));
        return superList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        superNameColumn.setCellValueFactory(new PropertyValueFactory<componentObject, String>("name"));
        superPriceColumn.setCellValueFactory(new PropertyValueFactory<componentObject, Integer>("price"));

        superTableView.setItems(getSuperList());

        localNameColumn.setCellValueFactory(new PropertyValueFactory<componentObject, String>("name"));
        localPriceColumn.setCellValueFactory(new PropertyValueFactory<componentObject, Integer>("price"));
    }




}
