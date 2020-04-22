package Component;

import javafx.scene.image.Image;

import java.io.Serializable;

public class testObject implements Serializable {
    String name;
    int number;

    public testObject(String name, int number){
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return getName() + "; " + getNumber();
    }
}
