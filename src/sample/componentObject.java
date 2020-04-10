package sample;

import javafx.beans.property.SimpleStringProperty;

public class componentObject {
    public SimpleStringProperty name;
    public int price;
     public componentObject(String name, int price){
         this.name = new SimpleStringProperty(name);
         this.price = price;
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
}
