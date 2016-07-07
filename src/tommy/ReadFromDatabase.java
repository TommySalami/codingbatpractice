package tommy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nicholas on 6/20/16.
 */
public class ReadFromDatabase {
    public static void main(String[] args) throws SQLException, IOException {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.1.9/nixbase", "arch", "password");
             BufferedWriter br = new BufferedWriter(new FileWriter("TommyInsurance.txt"))) {

            String graball = "SELECT * FROM insurance";
            PreparedStatement grabTable = con.prepareStatement(graball);
            ResultSet insuranceTable = grabTable.executeQuery();
            int count = 0;
            String policyId, state, county, dateAdded;
            String tommyINC = String.format("Tommy Car Insurance Inc. \t\t\t\t Page ");
            String titleBar = String.format("%-25s %-25s %-25s %-25s", "PolicyId", "State", "County", "DateAdded");
            int pageNum = 1;

            br.newLine();
            br.write(tommyINC + pageNum);
            br.newLine();
            br.newLine();
            br.write(titleBar);
            br.newLine();
            br.newLine();

            Map<String, String> record = new HashMap<>();
            ResultSetMetaData metaData = insuranceTable.getMetaData();

            while (insuranceTable.next()) {


                for(int col = 1; col <= metaData.getColumnCount(); col++) {

                    record.put(metaData.getColumnName(col), insuranceTable.getString(col));

                }

                count++;
                 policyId = insuranceTable.getString(1);
                 state = insuranceTable.getString(2);
                 county = insuranceTable.getString(3);
                 dateAdded = insuranceTable.getString(4);

                br.write(String.format("%-25s %-25s %-25s %-25s", policyId, state, county, dateAdded.substring(0,10)));
                br.newLine();
                if (count != 0 && count % 50 == 0) {
                    pageNum++;
                    br.newLine();
                    br.write(tommyINC +pageNum);
                    br.newLine();
                    br.newLine();
                    br.write(titleBar);
                    br.newLine();
                    br.newLine();
                    System.out.println("Wrote page " + pageNum);
                }


            }
        }
    }
}
