package httpTest;

import org.json.*;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class URLReaderPlusJsonParse {

    public static void main(String[] args) throws Exception {


        URL oracle = new URL("https://catfact.ninja/fact/"); /* returns a json */
        //URL oracle = new URL("https://petstore.swagger.io/#/pet/findByStatus"); //html
        //URL oracle = new URL("https://petstore.swagger.io/v2/swagger.json"); //json
        //URL oracle = new URL("https://ticketing.sta.masstack.com/v2/orgs/{org}/ticket/{ticketId}");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) !=null)
            System.out.println(inputLine);



        List<String> inputLineList = new ArrayList<>();
            inputLineList.add(in.readLine()); //is null
            inputLineList.add(oracle.toString());

        List<BufferedReader> inputLineList2 = new ArrayList<>();
        inputLineList2.add(in);

        System.out.println("This List " + inputLineList + " "
                + "This is inputLineList2 " + inputLineList2);


        in.close();
    }
}