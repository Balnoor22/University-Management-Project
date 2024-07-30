package university.management.system;
import java.sql.*;
public class Conn
{   
    Connection c;
    Statement s;        //Interfaces
    Conn()
    {
        try
        {
            //5 Steps for JDBC

            Class.forName("com.mysql.cj.jdbc.Driver");      //1-Register The Driver Class
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","password");
            s=c.createStatement();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
