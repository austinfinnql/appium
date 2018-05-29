package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.*;

public class JsonUtils {
    public DataModel getDataModel(String filename,String name) throws FileNotFoundException{

        JsonReader reader = new JsonReader(new FileReader(filename));
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(reader, DataModel.class);

    }
}
