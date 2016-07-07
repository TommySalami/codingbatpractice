package tommy;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.sql.*;

/**
 * Created by nicholas on 6/24/16.
 */
public class MetaDataPractice {
    public static void main(String[] args) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.1.9/nixbase", "arch", "password")) {

            String selectAll = "SELECT * FROM insurance WHERE 1=2";
            PreparedStatement ps = con.prepareStatement(selectAll);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int count = 0;


            while (count < metaData.getColumnCount()) {
                count++;
                String columnName = metaData.getColumnName(count);
                String columnTypeName = metaData.getColumnTypeName(count);
                int columnPrec = metaData.getPrecision(count);
                int columnScale = metaData.getScale(count);


                System.out.printf("Column name: %15s, Type: %10s, Precision:%5d , Scale: %5d  \n", columnName, columnTypeName, columnPrec, columnScale);


            }

        }
    }
}
