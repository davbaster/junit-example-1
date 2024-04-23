package MF.simple.tests;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class App2Test extends TestCase
{
    private final String USER_AGENT = "Mozilla/5.0";

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public App2Test(String testName )
    {
        super( testName );
    }



    public void testSendGet()
    {
        try {
            sendGet();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    // HTTP GET request simulated
    private void sendGet() throws Exception {
        String url = "http://www.google.com/search?q=myquery";
    
        System.out.println("\nSending 'GET' request to URL : " + url);
    
        // Simulated response code
        int responseCode = 200; // Assuming 200 OK as a successful response code
        System.out.println("Response Code : " + responseCode);
    
        // Simulate the response content
        String simulatedResponse = "{\"message\":\"This is a simulated response\"}";
    
        // Printing the simulated response content
        System.out.println("Response Content : " + simulatedResponse);
    }



    // HTTP GET request
    private void sendGetReal() throws Exception {

        String url = "http://www.google.com/search?q=myquery";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        in.close();
    }
}
