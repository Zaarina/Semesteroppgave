package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class componentObject {
    public SimpleStringProperty name;
    public int price;
    public Button button;
     public componentObject(String name, int price){
         this.name = new SimpleStringProperty(name);
         this.price = price;
         this.button = new Button("X");
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

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return getName() + ";" + getPrice();
    }
}
