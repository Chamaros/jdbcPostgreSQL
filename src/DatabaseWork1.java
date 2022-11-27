import com.sun.source.tree.TryTree;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseWork1 {
    // making the connection of our application with PostgreSQL
    // it helps to connect our java application with any database
    public Connection connect_to_db(String dbname, String user, String password) {

        // FOR MAKING THE CONNECTION WE NEED 3 THINGS
        // DATABASE NAME
        // DATABASE USERNAME
        // DATABASE PASSWORD

        //MAKING THE OBJECT OF THE CONNECTION
        Connection conn = null; // as default it is null
        try {       // we can write our success code that we need to run. in try part
            // load postgreSQL driver
            Class.forName("org.postgresql.Driver");//1. bunu sadece basta yukledigimiz driver i yuklediysek kullanabiliriz. postgreSQL-42.5.0.jar olani

            //2.SETTING UP THE CONNECTION
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, password); //DEFAULT PORT IS 5432 O YUZDEN YAZDIK

            //PASSING CONDITION TO CHECK THE CONNECTION SUCCESSFULL OR NOT
            if (conn != null) {
                System.out.println("connection established!");
            } else {
                System.out.println("connection failed!");
            }
        } catch (Exception e) {  // in catch part we get the errors. we catch the expections
            System.out.println(e);
        }
        return conn;
    }
    // method for creating a new table
    //STATEMENT IS A CONCEPT THAT HELPS US TO EXECUTE THE SQL queries'
    public void createTable(Connection conn, String table_name){
        // make an object of the statement
        Statement statement;
        try {
            // in postgreSQL if you want auto increment then there is a  keyword that is:SERIAL
            // ORACLE DA ISE AUTO_INCREMENT olarak geciyor bu .
            String query = "create table"+table_name+ "(Emp_Id SERIAL, name varchar(200), email varchar(200), country varchar(200), primary key(Emp_Id)";
                 //create a statement
            statement = conn.createStatement();
            //executing our query by putting it into statement
            statement.executeUpdate(query);
            System.out.println("Table created!");
        }catch (Exception e){
            System.out.println(e);
        }

    }



}