import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChuckNorrisJokeFetcher {

    public static void main(String[] args) {
        try {
            // Define the API URL
            String apiUrl = "https://api.chucknorris.io/jokes/random";

            // Create a URL object with the API URL
            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the HTTP request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Check if the response code is OK (200)
            if (responseCode == 200) {
                // Create a BufferedReader to read the API response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                // Read the response line by line
                StringBuilder jsonResponse = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonResponse.append(line);
                }
                reader.close();

                // Close the connection
                connection.disconnect();

                // Print the JSON response
                System.out.println("JSON Response:");
                System.out.println(jsonResponse.toString());
            } else {
                System.out.println("Failed to fetch data. Response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
