package httpTest;

import java.net.*;
import java.io.*;
import java.net.URLConnection;
import java.util.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        //API without Key --> https://apipheny.io/free-api/#apis-without-key


        //URL oracle = new URL("http://www.oracle.com/");
        //URL oracle = new URL("https://catfact.ninja/fact/"); /* returns a random json */
        URL oracle = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
        URLConnection yc = oracle.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();




    }
}
