package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.*;
import java.util.Iterator;

public class JsonUtils {

    /*
    * Reads the json file into a DataModel object.
     */
    public DataModel getDataModel(String fileName) throws FileNotFoundException{

        String filePath="src/test/java/pagepbjects"+fileName;
        JsonReader reader = new JsonReader(new FileReader(filePath));
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(reader, DataModel.class);

    }

    /*
    * Finds the node in json using the name field in the json object
     */
    public Node getValues(DataModel dm, String name){
        Iterator<Node>itr= dm.getNode().iterator();
        Node node=null;
        while(itr.hasNext()){
            node=itr.next();
            if(node.getName().equals(name)){
                break;
            }
        }
        return node;
    }
}
