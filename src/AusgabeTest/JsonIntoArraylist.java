package AusgabeTest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonIntoArraylist {

    public static void main(String[] args) {

        JSONObject newJsonObject = new JSONObject();
        newJsonObject.put("id",1);
        newJsonObject.put("name","Parson");
        System.out.println("Json petJson : " + newJsonObject.toString());

        ArrayList<String> jsonArrayList = new ArrayList<>();
        jsonArrayList.add(newJsonObject.toString());
        System.out.println("The ArrayList of the Json into String: " + jsonArrayList);

        //get throws out of bounds
        String indexFromJoin = jsonArrayList.get(0); //shows all the array
        List<String> fromIndexToIndex = jsonArrayList.subList(0,0);
        System.out.println("index 0: " + indexFromJoin);
        System.out.println("from index to index: " + fromIndexToIndex); //shows an empty array

    }

}
