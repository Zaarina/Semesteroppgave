package sample;

import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class saveConfiguration {
    //Lagrer toStringen til objektene fra tableview til en tekstfil.
    public static void save (ObservableList<componentObject> objectList, Path filePath) throws IOException{
            Files.write(filePath, objectList.toString().getBytes());
            System.out.println("Saved");
    }
}
