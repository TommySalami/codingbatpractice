package tommy;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.DriverManager;

/**
 * Created by nicholas on 6/26/16.
 */
public class DownloadingHttp {
    public static void main(String[] args) throws IOException {
        URL google = new URL("https://s-media-cache-ak0.pinimg.com/236x/01/0b/68/010b68214bf1eeb91060732aa58bed1e.jpg");
        int bufferSize = 8*1024;

        //google.openStream()

        try (BufferedInputStream bis = new BufferedInputStream(google.openStream());
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("steve.jpg"))) {

            int bytesRead= 0;
            byte[] data =new byte[1024];


            while ((bytesRead = bis.read(data)) != -1) {

                bos.write(data, 0, bytesRead);
                System.out.println(bytesRead
                );

            }
        }



    }
}
