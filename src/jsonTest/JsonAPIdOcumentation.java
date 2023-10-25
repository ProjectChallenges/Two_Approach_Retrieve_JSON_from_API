package jsonTest;

public class JsonAPIdOcumentation {
    /*
    portable API for--> parsing, generating, transforming and querying JSON

    JSON --> JavaScript Object Notation - text based, data exchange,

    Two Structure Types --> Objects and Arrays

        Object ist unordered collection of zero or more name/pairs

        Array is ordered sequence of zero or more values

           Values--> Strings, numbers, booleans, null, and the two structure types

    JSON Object representation of a person -->
            Strings for name, number for age, object for address and array value of phone number objects

                {
    "firstName": "John",
    "lastName": "Smith",
    "age": 25,
    "address": {
        "streetAddress": "21 2nd Street",
        "city": "New York",
        "state": "NY",
        "postalCode": 10021
    },
    "phoneNumbers": [
        {
            "type": "home",
            "number": "212 555-1234"
        },
        {
            "type": "fax",
            "number": "646 555-4567"
        }
    ]
}




    JSON will be used for Ajax, configurations, databases, Restful web services--> data exchange


    JSon Processing--> the Java API (JSR 353) provides portables APIs to
     parse, generate, transform and query JSON using object model and streaming APIs.

        Object model is a tree like structure that creates random-access to JSON data
                tree will be navigated and queried. -< flexible but not as efficient as streaming model
                   and requires more memory

        Streaming model-> parse and generate JSON in streaming fashion.
            event-based parser and allows developer to ask for the next event than rather handling
                the event in callback.
            gives Developer procedural contrl over JSON processing.
                Application can process or discard the parser event and ask for next event (pull the event)

            Streaming ist adequate for local processing where random-access is not required
                Streaming provides a way to generate well-formed JSON to a stream writing one event at a time.


    Object Model API
        The object model API is similar to the Document Object Model (DOM) API for XML.
            provides immutable object models for JSON object and array Strucures

        JsonObject provides a Map view --> unordered collecion of zero or more name/value pairs from the model.

        JsonArray provies a List view to access the ordered sequence of zero or more values from the model.

        JsonObject, JsonArray, JsonString and JsonNumber are subtypes of JsonValue. these constants are defined for
            null, true, and false JSON values.


        Object model uses builder patterns to create object models from scratch.

        Application code can use JsonObjectBuilder to create models that represent JSON objects.
            The resulting model is of type JsonObject.

        App code can use the interface JsonArrayBuilder to create models that represent JSON arrays.
            resulting model is type JsonArray.


        Can be also created from input source-< InputStream or Reader using the interface JsonReader.

            this models can be written to an ouput source--< OutputSream or Writer using JsonWriter.


        Example Facebook API gives the search results in the JSON format-->

1 {
2      "data" : [
3         { "from" : { "name" : "xxx", ... }, "message" : "yyy", ... },
4         { "from" : { "name" : "ppp", ... }, "message" : "qqq", ... },
5         ...
6     ],
7     ...
8 }


        use object model API to get names and public posts about term java.

1 URL url = new URL("https://graph.facebook.com/search?q=java&type=post");
 2 try (InputStream is = url.openStream();
 3      JsonReader rdr = Json.createReader(is)) {
 4
 5     JsonObject obj = rdr.readObject();
 6     JsonArray results = obj.getJsonArray("data");
 7     for (JsonObject result : results.getValuesAs(JsonObject.class)) {
 8         System.out.print(result.getJsonObject("from").getString("name"));
 9         System.out.print(": ");
10         System.out.println(result.getString("message", ""));
11         System.out.println("-----------");
12     }
13 }


        lines 1 to 3 create JsonReader.
        line 5 creates JsonObject for the results.
        line 7 loops over each result.
        lines 8 to 11 get the name of the person who posted, get the public post and prints them.


       JsonReader and other objects ca be used with try-with-resources statement (Try/catch)
        Also called ARM.> automatic resource management.



     */
}
