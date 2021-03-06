package sample;

import Component.componentObject;
import Validator.ProductValidator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static fileManagement.readFile.readSerializedFile;
import static fileManagement.writeFile.writeObject;

public class Tableview implements Initializable{

    @FXML private TableView<componentObject> superTableView;
    @FXML private TableColumn<componentObject, String> superNameColumn;
    @FXML private TableColumn<componentObject, Integer> superPriceColumn;

    @FXML private TableView<componentObject> localTableView;
    @FXML private TableColumn<componentObject, String> localNameColumn;
    @FXML private TableColumn<componentObject, Integer> localPriceColumn;

    @FXML private ChoiceBox<String> dropDown;

    @FXML private TextField nameTxt;

    @FXML private TextField numberTxt;

    @FXML void logOut(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    //Oppretter ObservableLists som skal inneholde objekt data.
    ObservableList<componentObject> superList = FXCollections.observableArrayList();

    @FXML
    void Write(ActionEvent event) {

        //Lagrer eksisterende objekter i en liste
        List<componentObject> list = new ArrayList<>(readSerializedFile());

        //Oppretter og legger til komponent
        componentObject item = new componentObject(1, nameTxt.getText(), Integer.parseInt(numberTxt.getText()), "Type");
        list.add(item);

        //Skriver til fil, oppdaterer tableview og klarerer inputfelt.
        writeObject(list);
        setSuperTableView();
        nameTxt.clear();
        numberTxt.clear();
    }

    //Denne metoden oppdaterer tableview og viser lagrede objekter.
    public void setSuperTableView(){
        superList = FXCollections.observableArrayList(readSerializedFile());
        superTableView.setItems(superList);
    }

    //Sletter valgt(e) komponent(er)
    public void DeleteBtnClicked(){

        ObservableList<componentObject> SelectedRows, allComponent;
        allComponent = superTableView.getItems();

        //Tar radene som er valgt
        SelectedRows = superTableView.getSelectionModel().getSelectedItems();

        //Går i loop for de valgte radene fra componentObject
        for (componentObject ComponentObj: SelectedRows){
            allComponent.remove(ComponentObj);

        }

        List<componentObject> list = new ArrayList<>(allComponent);
        writeObject(list);
    }

    //Endrer verdier i tableView
    public void EditName(TableColumn.CellEditEvent<componentObject, String> nameEdit) {
        try{
            ObservableList<componentObject> chosenComponent;
            chosenComponent = superTableView.getItems();

            componentObject name = superTableView.getSelectionModel().getSelectedItem();
            name.setName(nameEdit.getNewValue());

            List<componentObject> list = new ArrayList<>(chosenComponent);
            writeObject(list);
        } catch (IllegalArgumentException e){
            Dialog.showErrorDialog("Ugyldig navn " + e.getMessage());
        }


        // IKKE SKRIV: writeobject(superlist)
    }

    public void EditPrice (TableColumn.CellEditEvent<componentObject, Integer> editPrice){

        try {
            ObservableList<componentObject> chosenComponent;
            chosenComponent = superTableView.getItems();

            componentObject price = superTableView.getSelectionModel().getSelectedItem();
            price.setPrice((editPrice.getNewValue()));

            List<componentObject> list = new ArrayList<>(chosenComponent);
            writeObject(list);
        } catch (IllegalArgumentException e){
            Dialog.showErrorDialog("Ugyldig pris " + e.getMessage());
        }

    }

    //Exception må håndteres
    //Denne metoden kopierer og legger til et valgt objekt fra superTable til localTable
    ObservableList<componentObject> localList = FXCollections.observableArrayList();
    @FXML void getSelectedItem(ActionEvent event) throws NullPointerException{

        if(superTableView.getSelectionModel().getSelectedItem() == null){
            throw new NullPointerException("Null");
        }

        componentObject object = superTableView.getSelectionModel().getSelectedItem();
        localList.add(object);
        localTableView.setItems(localList);
        superTableView.getSelectionModel().select(null);
        //System.out.print(dropDown.getSelectionModel().getSelectedItem());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Innitialiserer kolonnene i tableviews.
        superNameColumn.setCellValueFactory(new PropertyValueFactory<componentObject, String>("name"));
        superPriceColumn.setCellValueFactory(new PropertyValueFactory<componentObject, Integer>("price"));
        localNameColumn.setCellValueFactory(new PropertyValueFactory<componentObject, String>("name"));
        localPriceColumn.setCellValueFactory(new PropertyValueFactory<componentObject, Integer>("price"));


        //Admin kan velge flere rader samtidig
        superTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Oppdatere Komponent
        superTableView.setEditable(true); //Kommentar: Sjekket bruk uten denne metoden, funker helt fint
        superNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        superPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        try{
            setSuperTableView();
        }catch (Exception e){
            e.getMessage();
        }
        //write();


    }

}
