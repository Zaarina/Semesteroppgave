package fileManagement;

import Component.componentObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class readFile {
    //Leser fra fil og returnerer en liste med componentObject
    public static List<componentObject> readSerializedFile(){
        System.out.println("Reading file.");
        //ObservableList<componentObject> list = FXCollections.observableArrayList();
        try{
            FileInputStream fl = new FileInputStream("objectSuperList.txt");
            ObjectInputStream ob = new ObjectInputStream(fl);

            List<componentObject> obj = (List<componentObject>) ob.readObject();

            System.out.print("Objects are read from file.");

            System.out.println();
            System.out.println("Read Successful.\n");
            ob.close();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Read Failed.\n" );
            return null;
        }
    }

    public static ObservableList<componentObject> read(Path path) throws Exception {
        ObservableList<componentObject> list = FXCollections.observableArrayList();
        String line;
        BufferedReader reader = Files.newBufferedReader(path);

        while((line=reader.readLine()) != null){
            list.add(parseObject(line));
        }
        return list;
    }

    public static componentObject parseObject(String line) throws Exception{
        String[] split = line.split(",");
        if(split.length != 4){
            throw  new Exception();
        }

        int id = parseNumber(split[0], "Error");
        String name =split[1];
        int price = parseNumber(split[2], "Error");
        String type = split[3];

        return new componentObject(id, name, price, type);
    }

    private static int parseNumber (String str, String errorMessage) throws Exception{
        int number;
        try{
            number = Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new Exception(errorMessage);
        }
        return number;
    }

    public static void read () {
        System.out.print("Reading object");

        try {
            FileInputStream fi = new FileInputStream("test.ser");
            ObjectInputStream os = new ObjectInputStream(fi);

            componentObject[] componentObjects = (componentObject[])os.readObject();

            for(componentObject comp: componentObjects){
                System.out.print(comp);
            }
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
