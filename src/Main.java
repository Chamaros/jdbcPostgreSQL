import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        //Making an object of DatabaseWork1 class
        DatabaseWork1 db = new DatabaseWork1();

        //calling the database connection function
        Connection conn = db.connect_to_db("Database1","postgres","Dante927.");

        //calling the method to make a new table
        db.createTable(conn,"employee");

    }
}
