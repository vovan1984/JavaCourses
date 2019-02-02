/**
 * Performs simple search on google.com
 * 
 * @author Vladimir Igumnov
 * @since 11.0
 */
package study.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MyHttpTest
{

    public static void main(String[] args) throws Exception {
        String httpsURL = "https://alvinalexander.com/blog/post/java/simple-https-example";
        URL myUrl = new URL(httpsURL);
        URLConnection conn = myUrl.openConnection();
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String inputLine;

        while ((inputLine = br.readLine()) != null) {
            System.out.println(inputLine);
        }

        br.close();
    }

}
