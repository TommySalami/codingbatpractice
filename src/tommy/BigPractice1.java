package tommy;

import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by nicholas on 7/3/16.
 */
public class BigPractice1 {
    public static void main(String[] args) throws IOException, SQLException {
        FTPClient ftpc = new FTPClient();
        ftpc.connect("192.168.1.9");
        ftpc.login("tommy", "ellie");


        try (BufferedReader br = new BufferedReader(new InputStreamReader(ftpc.retrieveFileStream("insurance-linux.csv")));
             Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.1.9/nixbase", "arch", "password")) {
            br.readLine();
            String line;
            String[] splitLine;
            int count = 0;

            PreparedStatement ps = con.prepareStatement("INSERT INTO insurance VALUES (?,?,?, now())");

            while((line = br.readLine())!=null){
                count++;
                splitLine = line.split(",", 4);
                int policy = Integer.parseInt(splitLine[0]);
                String state = splitLine[1];
                String county = splitLine[2];


                ps.setInt(1,policy);
                ps.setString(2, state);
                ps.setString(3, county);
                ps.addBatch();

                if (count != 0 && count % 1000 == 0) {
                    ps.executeBatch();
                }
            }
            ps.executeBatch();


        }

    }

}


