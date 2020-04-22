package Component;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.io.Serializable;

public class componentObject implements Serializable {
    public String name;
    public int price;
    public String type;
    public int componentID;

     public componentObject(int componentID, String name, int price, String type){
         this.componentID = componentID;
         this.name = name;
         this.price = price;
         this.type = type;
     }

    public int getComponentID() {
        return componentID;
    }

    public void setComponentID(int componentID) {
        this.componentID = componentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //Burde finne en bedre løsning senere
    @Override
    public String toString() {
        return getName() + ";" + getPrice();
    }
}
