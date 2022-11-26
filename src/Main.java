public class Main {
    public static void main(String[] args) {

        //Making an object of DatabaseWork1 class
        DatabaseWork1 db = new DatabaseWork1();

        //calling the database connection function
        db.connect_to_db("Database1","postgres","Dante927.");


    }
}
