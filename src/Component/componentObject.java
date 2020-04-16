package Component;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class componentObject {
    public SimpleStringProperty name;
    public int price;
    public SimpleStringProperty type;

     public componentObject(String name, int price, String type){
         this.name = new SimpleStringProperty(name);
         this.price = price;
         this.type = new SimpleStringProperty(type);
     }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    //Burde finne en bedre løsning senere
    @Override
    public String toString() {
        return getName() + ";" + getPrice();
    }
}
