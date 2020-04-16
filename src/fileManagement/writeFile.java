package fileManagement;

import Component.componentObject;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class writeFile {
    //Lagrer toStringen til objektene fra tableview til en tekstfil.
    public static void save (List<String> componentList, Path filePath) throws IOException{
        //Files.write(filePath, formatConfiguration.formatConfig(componentList));
        try {
            Files.write(filePath, formatter.formatComfig(componentList).getBytes());
        }catch (IOException e){
            e.getMessage();
            return;
        }
            System.out.println("Saved");
    }
}
