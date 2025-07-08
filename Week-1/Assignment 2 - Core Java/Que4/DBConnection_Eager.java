public class DBConnection_Eager {
    //We are making a DBConnection_Eager instance beforehand, hence it is Eager Initialization.
    //This means that the instance is created at the time of class loading, not when it is needed.
    private static DBConnection_Eager instance = new DBConnection_Eager();
    private DBConnection_Eager(){
        //Creating a private constructor to prevent instantiation of this class anywhere else.
    }
    public static DBConnection_Eager getDBConnection(){
        return instance;
        //This method returns the single instance of DBConnection class.
        //It is static so that it can be called without creating an object of DBConnection class.
        //It is public so that it can be accessed from anywhere in the application.
        //It is synchronized to ensure thread safety, so that only one thread can access this method at a time.
    }    
}
