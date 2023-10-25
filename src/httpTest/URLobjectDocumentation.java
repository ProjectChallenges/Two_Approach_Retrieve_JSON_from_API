package httpTest;

public class URLobjectDocumentation {
    //Uniform Resource Locator uses class URL from java.net to represent a URL address

    //URL address-> Internet address and URL object --> the instance of the URL class
        //URLs are written once. once created cannot be changed any of the attributes.

    //URL takes the form of a string--> the protocol accesses the resource and the location of the resource

    //absolute URL and relative URL or URL components

    //parsing a URL to get the methods of the information without string parsing

    //using openStream() to read from a URL

    //openConnection() method returns a URLConnection object--> for reading, writing or querying for info

    //some URLs are connected to cgi-scripts-> allow and sometimes require you to write info to the URL

    //URL components--> Protocol identifier --> http and Resourcename--> example.com,
        //separated from by a colon and two forward slashes http://example.com
        //Hypertext Transfer Protocol
    //The Resource name contains--> Host name (server), Filename (pathname), Portname (optional),
        //and Reference (points out to specific location in a file, optional)

    //Use a String containing the text to create a URL object
        //URL myURL = new URL("http://example/");
            //absolute URL, can also be created from relative URL address

    //Relative URL to create URL object
        //html Page example.com has links to another html Page page1.html and page2.html
        //in Java then create a URL object from relative URL specification:
            //  http://example.com/pages/page1.html
            //  http://example.com/pages/page2.html
        //The common base URL is http://example.com/pages/
            //URL objects -->
                //  URL myURL = new URL("http://example.com/pages/");
                //  URL page1URL = new URL(myUrl, "page1.html");
                //  URL page2URL = new URL(myUrl, "page2.html");

    //Constructor --> lets you create a URL object from a URL object (the base) and a relative URL specification
        //  URL(URL baseURL, String relativeURL)
        // if baseURL is null, then the constructor treates the relativeURL like an Absolute URL specification
        // if the relativeURL is an absolute, the constructore ignores the baseURL

            //URL page1BottomURL = new URL(page1URL, "#BOTTOM");

    //Two additional constructors--->
        //second contructor creates a URLobject from a protocol, hostname, and filename
            // new URL("http", "example.com", "/pages/page1.html");
                                                //pathname of the file with forward slash (from the root of the host)

            //equivalent to --> new URL("http://example.com/pages/page1.html");

        //third constructor adds the PORT number
            // URL gamelan = new URL("http", "example.com, 80, "pages/page1.html");

            //equivalent to --> http://example.com:80/pages/page1.html

    //use toString() or toExternalForm() to get a String containing the complete URLaddress

    //Special characters---> http://example.com/hello world/
        // URL url = new URL("http://example.com/hello%20world");

        //use the java.net.URI class to encode -->
            //URI uri = new URI("http", "example.com", "/hello world/", "");

        //the convert URI to URL
            //URL zrl = uri.toURL();

    //Exception--> each of the constructors throws an exception if null or unknown protocol
        //use try catch and handle the exception by embedding your URL constructor statements to the try/catch pair

            /*try{
                URL myURL = new URL(..);

                }
                catch (MalformedURLException e){
                    //exception handler code here
                    //..
                }
             */

    //Parsing a URL

    //URL class (accessor) Methods to query URL objects
        //getProtocol --> returns protocol indentifier component of the URL
        //getAuthority--> returns the authority component
        //getHost --> returns the hostname
        //getPort --> returns the portnumber component
        //getPath --> returns the pathcomponent of this URL
        //getQuery --> returns the query component
        //getFIle --> returns the filename --> same as getPath plus concatenation of the value getQuery
        //getRef --> returns the reference component of the URL

        //use getX methods to get info regardless of the constructor

    //no need to parse again

    //Beispiel-->

    /*
        import java.net.*;
        import java.io.*;

        public class ParseURL {
            public static void main(String[] args) throws Exception{

                URL aURL = new URL("http://example.com:80/docs/books/tutorial"
                                    + "/index.html?name=networking#DOWNLOADING");

                System.out.println("protocol = " + aURL.getProtocol());
                System.out.println("authority = " + aURL.getAuthority());
                 System.out.println("host = " + aURL.getHost());
                  System.out.println("port = " + aURL.getPort());
                   System.out.println("path = " + aURL.getPath());
                    System.out.println("query = " + aURL.getQuery());
                     System.out.println("filename = " + aURL.getFile());
                      System.out.println("ref = " + aURL.getRef());
            }
        }

        OUTPUT =
        protocol = http
        authority = example.com:80
        host = example.com
        port = 80
        path = /docs/books/tutorial/index.html
        query = name=networking
        filename = /docs/books/tutorial/index.html?name=networking
        ref = DOWNLOADING

     */

                            //Reading directly from a URL

    //using openStream() method to get a stream from which to read the contents
        //the method returns a java.io.InputStream object --> check it out!

    //Beispiel--> getting an inputStream from http://oracle.com/
        //opening the BufferedReader on the input stream and reading from the BufferedReader thereby
            //reading the URL. every read is copied to the standard output stream:


    /*

    import java.net.*;
    import java.io.*;

    public class URLReader {
        public static void main(String[] args) throws Exception {

        URL oracle = new URL("http://www.oracle.com/");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) !=null)
            System.out.println(inputLine);
            in.close();



        }
    }

    OUTPUT:
        you will see the html commands and textual content from the html file located at the URL address
        can also hang or might see and exception stack trace
        if so set the proxy host to find e the Oracle server


     */


                                //Connecting to a URL

    //openConnection method to get a URLConnection object or one of its protocol specific subclasses
        //for example java.net.HttpURLConnection

    //use URLConnection Object to setup parameters and general request propierties that you might need
        //before connecting.

    //to connect to the remote object represented by the URL --> use the URLConnection.connect method
        //you will be initializing a communication link between Java Program and URL over the network.

    //Example opening a connection to the site example.com

    /*
    try{
    URL myURL = new URL("http://example.com/");
    URLConnection myURLConnection = myURL.openConnection();
    myURLConnection.connect();

    }
    catch (MalformedURLException e) {
    // new URL() failed
    // ...
    }
    catch (IOException e) {
    // openConnection() failed
    // ...
    }

     */


    //a new URLConnection object is created every time by calling the openConnection method of the protocol
    //handler for this URL

    //not need to always explicitly call the connect method to initiate the connection.
        //for operations that need being connected like--> getInputStream,getOutputStream will implicitly
        //perform the connnection if necessary




                        //Reading from or writing to the connection

    //reading from a URLConnection instead of reading directly from a URL might be more useful.
        //you can use the URLConnection object for example -->  to write to the URL
        //the program can hang. so proxy ist adviced.


    //Rather than getting an input stream directly from the URL, the program explicityl retrieves a
        //URLConnection object and gets an input stream from the connection.

        //the connection is opened implicitly by calling getInputStream. -> no need for .connect();

        //like URLReader the URLConnectionReader creates a BufferedReader on the input stream and reads from it.

    /*
import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL oracle = new URL("http://www.oracle.com/");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}

    //OUTPUT --> output from this program is identical to the output from the program
        //that opens a stream directly from the URL.
     */



    //Writing to a URLConnection Documentation--> https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
}
