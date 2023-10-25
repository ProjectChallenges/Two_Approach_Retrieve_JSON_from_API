package httpTest;

import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        //URL oracle = new URL("http://www.oracle.com/"); //nichts
        //URL oracle = new URL("https://apipheny.io/free-api/#apis-without-key/"); //html
        URL oracle = new URL("https://catfact.ninja/fact/"); /* returns a json */
        //URL oracle = new URL("https://api.fynbill.fynbird.io/GET/v1/invoices/debit/list"); //Exception
        //URL oracle = new URL("http://petstore.swagger.io/v2/store/inventory"); HTML

        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) !=null)
            System.out.println(inputLine);
        in.close();



    }
}