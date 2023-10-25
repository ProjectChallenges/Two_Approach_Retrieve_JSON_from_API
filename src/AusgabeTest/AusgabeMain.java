package AusgabeTest;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class AusgabeMain {
    //basePath /
    //Json example--> {"name" : "Invoice"}
    //Paths--> /invoice
        /*
        "Invoice": {"type": "object",
       "required": [
                "id","debitor_id","receipt_id","service_period", "term_of_credit", "balance","netto", "brutto"
                ]


            PET-->
            [{"id":1,"category":{"id":1,"name":"string"},"name":"doggie",
            "photoUrls":["string"],"tags":[{"id":1,"name":"string"}],"status":"available"}]


            cats-->
            {
            "fact": "Female cats are polyestrous",
             "length": 28
            }

         */

    public static void main(String[] args) throws IOException, InterruptedException {

        ArrayList<String> petjsonArrayList = new ArrayList<>(); //to save json into ArrayList

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("APP to print Json in Console:");
            System.out.println("1. For HttpURLConnection _ BufferReader and ArrayList select 1");
            System.out.println("2. For .net.URL  _  JavaxJson JsonObject Test select 2");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You chose: GET/pet/{petId}");
                    URL httpUrl = new URL("https://petstore.swagger.io/v2/pet/2");

                    HttpURLConnection httpConn = (HttpURLConnection) httpUrl.openConnection();
                    httpConn.setRequestMethod("GET");
                    int responseCode = httpConn.getResponseCode();

                    BufferedReader readIn = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
                     
                    //adding the string from the buffer to an arraylist
                    petjsonArrayList.add(readIn.readLine());
                    System.out.println("The ArrayList of the Json into String: " + petjsonArrayList);
                    System.out.println("ResponseCode " + responseCode);

                    readIn.close();
                    break;
                case 2:
                    URL url1 = new URL("https://catfact.ninja/fact/");

                    try (InputStream readStream = url1.openStream();
                         JsonReader jsonStreamReader = Json.createReader(readStream)) {

                        JsonObject jsonMap = jsonStreamReader.readObject();
                        JsonArray jsonArrayResults = jsonMap.getJsonArray("/fact");
                        System.out.println(jsonMap);
                        System.out.println(jsonArrayResults);

                    }
                        break;
                case 3:
                System.out.println("Exiting System.");
                scanner.close();
                System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }


            }
        }
    }

