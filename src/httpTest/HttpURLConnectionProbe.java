package httpTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;

public class HttpURLConnectionProbe {

    public static void main(String[] args) throws IOException {

        //URL httpUrl = new URL ("https://catfact.ninja/fact/");  //check!
        //URL httpUrl = new URL("https://petstore.swagger.io/v2/pet/findByStatus?status=available"); //check!
        URL httpUrl = new URL("https://petstore.swagger.io/v2/pet/1"); //check!

        //URL httpUrl = new URL("https://api.fynbill.fynbird.io/v1/invoices/debit/list?page=1&limit=25"); //Response 403
        HttpURLConnection httpConn = (HttpURLConnection) httpUrl.openConnection();
        httpConn.setRequestMethod("GET");
        int responseCode = httpConn.getResponseCode();

        BufferedReader readIn = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

        String checkNotNull = readIn.readLine();
            System.out.println(checkNotNull);
        System.out.println("ResponseCode " + responseCode);


        readIn.close();

    }




}
