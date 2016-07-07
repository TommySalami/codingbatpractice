package tommy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by nicholas on 7/3/16.
 */
public class Pract1 {
    public static void main(String[] args) throws IOException {
        URL yahoo = new URL("https://i.imgur.com/2zZSFMU.jpg");
        HttpURLConnection httpYah = ((HttpURLConnection) yahoo.openConnection());
        httpYah.setRequestProperty("http.agent","");

        try (BufferedInputStream bis = new BufferedInputStream(httpYah.getInputStream());
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("yahoo"))) {


            int bytesRead = 0;
            byte[] data = new byte[1024];

            while ((bytesRead = bis.read(data)) != -1) {
                bos.write(data, 0, bytesRead);
                System.out.println(bytesRead);

            }

        }
    }
}
