# Invoices
README.md

# Json Output Console App

This repository contains a simple Java application that retrieves JSON data from different APIs and displays it in the console. The application demonstrates two different approaches using different libraries to fetch and process JSON data.

## Description

The `AusgabeMain` class provides two methods for retrieving JSON data from different endpoints. The first method utilizes `HttpURLConnection` and `BufferedReader` to retrieve JSON data from the Swagger Petstore API. The second method uses the `java.net.URL` class and the `javax.json` package to retrieve and process JSON data from the Cat Fact API.

## Prerequisites

- Java Development Kit (JDK)
- IDE (Integrated Development Environment) for Java (e.g., IntelliJ, Eclipse, NetBeans)
- Basic knowledge of Java programming

## Usage

Clone the repository and open the project in your preferred Java IDE. Run the `AusgabeMain` class, and you will be prompted to select one of the following options:

1. Use `HttpURLConnection` and `BufferedReader` to fetch and display JSON data from the Swagger Petstore API.
2. Use `java.net.URL` and `javax.json` to retrieve and process JSON data from the Cat Fact API.
3. Exit the application.

Select the desired option by entering the corresponding number and observe the JSON output in the console.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
