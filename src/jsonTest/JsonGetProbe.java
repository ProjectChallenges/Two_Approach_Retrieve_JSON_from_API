package jsonTest;

import javax.json.*;
import java.net.*;
import java.io.InputStream;

public class JsonGetProbe {

    public static void main(String[] args) throws Exception {
/*
         URL url = new URL("https://graph.facebook.com/search?q=java&type=post");
         try (InputStream is = url.openStream();
       JsonReader rdr = Json.createReader(is)) {

                 JsonObject obj = rdr.readObject();
                JsonArray results = obj.getJsonArray("data");
                for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                         System.out.print(result.getJsonObject("from").getString("name"));
                         System.out.print(": ");
                         System.out.println(result.getString("message", ""));
                         System.out.println("-----------");
                     }
             }

 */
/*
        PET-->
            [{"id":1,"category":{"id":1,"name":"string"},"name":"doggie",
                "photoUrls":["string"],"tags":[{"id":1,"name":"string"}],"status":"available"}]

                {
  "id": 1,
  "category": {
    "id": 1,
    "name": "cat"
  },
  "name": "dog",
  "photoUrls": [],
  "tags": [],
  "status": "sold"
}

{
    "fact": "Female cats are polyestrous",
    "length": 28
}

 */


         //URL url1 = new URL("https://petstore.swagger.io/v2/pet/2");
        URL url1 = new URL("https://catfact.ninja/fact/");
         try (InputStream readStream = url1.openStream();
         JsonReader jsonStreamReader = Json.createReader(readStream)) {

             JsonObject jsonMap = jsonStreamReader.readObject();
             JsonArray jsonArrayResults = jsonMap.getJsonArray("/fact");
             System.out.println(jsonMap);
             System.out.println(jsonArrayResults);

             /*
             JsonObject jsonMap = jsonStreamReader.readObject();
             JsonArray jsonArrayResults = jsonMap.getJsonArray("2");
             System.out.println(jsonMap);
             //System.out.println(jsonArrayResults);

*/


             }
         }

    }

