package tommy;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import sun.net.ftp.FtpClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by nicholas on 6/27/16.
 */
public class Ftpdownload {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        FTPClient ftpc = new FTPClient();
        FTPClientConfig config = new FTPClientConfig();



        String server = "192.168.1.9";

        ftpc.connect(server);
        ftpc.login("tommy", "ellie");

        int reply = ftpc.getReplyCode();
        if (FTPReply.isPositiveCompletion(reply)) {

            FTPFile[] ftpfiles = ftpc.listFiles();
            for (FTPFile ftpFile:ftpfiles) {
                System.out.println(ftpFile);

            }

            try (FileInputStream inputStream = new FileInputStream("ftpTestFile")) {


                //ftpc.retrieveFile("testfile.txt", new FileOutputStream("ftpTestFile"));
                ftpc.storeFile("uploaded", new FileInputStream("ftpTestFile"));
            }finally {
                ftpc.disconnect();
            }

        }


    }
}
