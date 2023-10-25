package httpTest;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLConnection;



public class CreatingURLConnection {


    public static void main(String[] args) throws Exception {

        try {
            URL myURL = new URL("http://example.com/");
           URLConnection myURLConnection =  myURL.openConnection();
           myURLConnection.connect();


        } catch (MalformedURLException e) {
            System.out.println("new URL() failed");
            // ...
        } catch (IOException e) {
            System.out.println("openConnection() failed");
            // ...
        }
    }

}
