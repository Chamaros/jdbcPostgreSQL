import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseWork1 {
    // making the connection of our application with PostgreSQL
    // it helps to connect our java application with any database
    public Connection connect_to_db(String dbname, String user, String password) {

        // FOR MAKING THE CONNECTION WE NEED 3 THINGS
        // DATABASE NAME
        // DATABASE USERNAME
        // DATABASE PASSWORD

        //MAKING THE OBJECT OF THE CONNECTION
        Connection comm = null; // as default it is null
        try {       // we can write our success code that we need to run. in try part
            // load postgreSQL driver
            Class.forName("org.postgresql.Driver");//1. bunu sadece basta yukledigimiz driver i yuklediysek kullanabiliriz. postgreSQL-42.5.0.jar olani

            //2.SETTING UP THE CONNECTION
            comm = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, password); //DEFAULT PORT IS 5432 O YUZDEN YAZDIK

            //PASSING CONDITION TO CHECK THE CONNECTION SUCCESSFULL OR NOT
            if (comm != null) {
                System.out.println("connection established!");
            } else {
                System.out.println("connection failed!");
            }
        } catch (Exception e) {  // in catch part we get the errors. we catch the expections
            System.out.println(e);
        }
        return comm;
    }
}