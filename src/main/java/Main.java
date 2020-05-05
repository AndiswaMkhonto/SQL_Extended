import java.sql.*;
import org.postgresql.Driver;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:8080/db";
        String user = "user";
        String password = "pass";
        Connection connection = null;

        try {
            if(!Driver.isRegistered()){
                Driver.register();
            }

            connection = DriverManager.getConnection(url, user, password);//Connects to the database
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from customers" + "SELECT FirstName FROM Customers"+ "DELETE FROM Customers WHERE CustomerID = 2"+"SELECT COUNT(DISTINCT status) From Orders"
            +"SELECT MAX(Amount) FROM Payments"+"SELECT * FROM Customers ORDER BY Country"+"SELECT * FROM Products WHERE Amount BETWEEN 100 AND 600"+
                    "SELECT * FROM Customers WHERE Country ='Germany' AND City='Berlin'\\"+"SELECT * FROM Customers WHERE City ='Durban' OR City='Cape Town'\\"+
                    "SELECT * FROM Products WHERE Amount > 1000"+"SELECT SUM(Amount) FROM Payments"+"SELECT COUNT(status) FROM Orders WHERE status='Shipped'\\"+
                    "SELECT AVG(Amount / 12) FROM Products"+"SELECT Customers.CustomerID, Customers.FirstName, Customers.LastName, Customers.Gender, Customers.Address, Customers.Phone, Customers.Email, Customers.Country, Customers.City FROM Customers\n" +
                    "INNER JOIN Payments ON Payments.CustomerID=Customers.CustomerID"+"SELECT * FROM Products WHERE Desrciption > 'Turnable front wheels steering function'\\");//query data from the customer table

            while (resultSet.next()) { //Printing customer data from customer table
                System.out.println(
                        resultSet.getString("customerid") + "\t"
                                + resultSet.getString("firstname") + "\t"
                                + resultSet.getString("lastname") + "\t"
                                + resultSet.getString("gender") + "\t"
                                + resultSet.getString("address") + "\t"
                                + resultSet.getString("phone") + "\t"
                                + resultSet.getString("email") + "\t"
                                + resultSet.getString("city") + "\t"
                                + resultSet.getString("country")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();//Handle errors for JDBC
        }catch (Exception ex){
            ex.printStackTrace();//Handle errors for Drivers
        }finally {
            try{
                if(connection!=null)
                    connection.close();//Close database connection
            }catch(SQLException se){
                se.printStackTrace();//Handle errors for JDBC
            }
        }

    }

}