package tommy;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by nicholas on 6/18/16.
 */


public class FillTable {
    public static void main(String[] args) throws SQLException {

        // Connection connection = new Conne

        try (BufferedReader br = new BufferedReader(new FileReader("/home/nicholas/insurance-linux.csv"));
             Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.1.9/nixbase", "arch", "password")) {
            //eat first line, nomnomnom
            br.readLine();

            String fillRecord = "INSERT INTO insurance VALUES( ?,?,?, now())";
            PreparedStatement insertRecords = conn.prepareStatement(fillRecord);
            int count = 0;
            String readLine;
            while((readLine = br.readLine()) != null) {

                count++;

                String[] columns = readLine.split(",", 4);
                InsuranceRecord currentRow = new InsuranceRecord(columns);

                insertRecords.setInt(1,currentRow.policyId);
                insertRecords.setString(2,currentRow.state);
                insertRecords.setString(3,currentRow.county);
                insertRecords.addBatch();

                if(count !=0 && count % 1000 == 0){
                    insertRecords.executeBatch();
                }

            }
            insertRecords.executeBatch();

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("some other bullshit");
        }
    }

    private static class InsuranceRecord{
        int policyId;
        String state;
        String county;
        InsuranceRecord(String[] columns) {
             policyId = Integer.parseInt(columns[0]);
             state = columns[1];
             county = columns[2];
        }
    }
}
