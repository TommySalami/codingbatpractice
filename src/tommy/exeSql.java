package tommy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by nicholas on 6/19/16.
 */
public class exeSql {

    public static void main(String[] args) throws SQLException {


        try(Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.1.9/nixbase", "arch", "password")) {

            String exeSql = "CREATE TABLE insurance " +
                    "(policyId INTEGER, state VARCHAR(2), county VARCHAR(50), dateLoaded TIMESTAMP)";

            executeSql(con, exeSql);
        }


    }

    private static void executeSql(Connection con, String exeSql) throws SQLException {
        PreparedStatement ps = con.prepareStatement(exeSql);
        System.out.println("Executing..." + exeSql.substring(0, 20) + "...");

        ps.execute();
        System.out.println("Finished execution.");
    }

}
