import java.sql.*;
import java.util.ArrayList;

public class Connector {


    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("connnnnnn");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList sql = new ArrayList();
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/db","user","pass");
                Statement mystmt = con.createStatement();
                sql.add(1,"select * from db.customer");
                sql.add(2,"select Firstname from db.customer");
                sql.add(3,"select Firstname from db.customer where CustomerID=1");
                sql.add(4,"update db.customer set Firstname='Lerato',Lastname='Mabisto' where CustomerID=1");
                sql.add(5,"delete from db.customer where CustomerID=2");
                sql.add(6,"select count(distinct Status)from db.orders");
                sql.add(7,"select concat('R',max(Amount))as 'maximum payment'from db.payment");
                ResultSet result = mystmt.executeQuery(String.valueOf(sql));

                while (result.next())
                {
                    System.out.println(result.getString("Firstname"));
                }
                mystmt.close();
                con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }

    }

