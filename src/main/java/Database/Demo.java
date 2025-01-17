package Database;


import javax.sql.RowSet;
import java.sql.*;

public class Demo {

    public static void main(String[] args) {

        try{

            String url = "jdbc:oracle:thin:@10.169.88.28:1535/HCMPDEV";
            String userName = "HCMP_CRM_DEV";
            String pass = "WegYr4#m";
            String driver = "oracle.jdbc.OracleDriver";
            String Query = "SELECT REASON FROM CRM_NE_TXN_SUMMARY cnts ";

            // driver establishment
            Class.forName(driver);

            // connection establishment
            Connection connection = DriverManager.getConnection(url,userName,pass);

            // statement creation
            Statement statement = connection.createStatement();

            PreparedStatement statement1 = connection.prepareStatement(Query);

            // statement execution
            ResultSet resultSet = statement.executeQuery(Query);

            // results handling
            while (resultSet.next()){
                System.out.println("Reson : "+resultSet.getString("REASON"));
            }


            Thread t1 = new Thread("hello");

            // transactions handling if needed

            // connection closing
            resultSet.close();
            statement.close();
            connection.close();

        }catch (Exception e){
            System.out.println("Exception = "+e.getMessage());
            e.printStackTrace();
        }
    }
}
