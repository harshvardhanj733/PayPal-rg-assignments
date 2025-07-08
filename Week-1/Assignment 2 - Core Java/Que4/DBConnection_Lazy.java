public class DBConnection_Lazy {
    //Here, the instance of DBConnection_Lazy is created only when it is needed, hence it is Lazy Initialization.
    //This means that the instance is created when the getDBConnection method is called for the first time, not when the class is loaded.
    private static DBConnection_Lazy instance;
    private DBConnection_Lazy() {
        // Private constructor to prevent instantiation from outside
    }
    public static DBConnection_Lazy getDBConnection() {
        if (instance == null) {
            //If there is no pre-existing instance, create a new one
            instance = new DBConnection_Lazy();
        }
        //Else return the existing instance
        return instance;
        //This method returns the single instance of DBConnection class.
        //It is static so that it can be called without creating an object of DBConnection class.
        //It is public so that it can be accessed from anywhere in the application.
    }    
}
