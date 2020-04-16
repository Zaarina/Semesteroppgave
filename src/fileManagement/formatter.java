package fileManagement;

import Component.componentObject;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class formatter {
    public static String formatComfig(List<String> compList){
        StringBuffer stringBuffer = new StringBuffer();
        for(String s: compList){
            stringBuffer.append(s);
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public static String DELIMITER = ",";
    public static String formatComponent(componentObject comp){
        String formatert = comp.getName() + DELIMITER + comp.getPrice() + DELIMITER + comp.getType();
        return formatert;
    }
}
