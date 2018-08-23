package utils;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonUtils {

    /*
    * Reads the json file into a DataModel object.
     */
    public Collection<Node> getDataModel(String fileName) {

       String filePath="src/test/java/pageobjects/"+fileName;
        Gson gson = new GsonBuilder().create();
        Collection<Node> dm= null;

        Type listType = new TypeToken<ArrayList<Node>>(){}.getType();
        try {
            dm = gson.fromJson(new FileReader(filePath), listType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dm;
    }

    /*
    * Finds the node in json using the name field in the json object
     */
    public Node getValues(Collection<Node> dm, String name){
        Iterator<Node> itr=dm.iterator();
        Node n=null;
        Node node=null;
        while(itr.hasNext()&&node==null){
            n=itr.next();
            if(n.getName().toLowerCase().equals(name.toLowerCase())){
                node=n;
            }
        }
        return node;
    }
}
