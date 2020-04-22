package fileManagement;

import Component.componentObject;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

    //Denne metoden tar inn en liste med objekter og lagrer listen til fil.
    public static void writeObject(List<componentObject> objList) {
        System.out.println("Writing object.");

        try {
            FileOutputStream fs = new FileOutputStream("objectSuperList.txt", false);
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(objList);

            System.out.println("Objects are written to file.");
            os.close();
            System.out.println("Writing complete.\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Writing failed.\n");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Writing failed.\n");
        }
    }
}
