public class Main {
    public static void main(String[] args) {
        //Here we are creating an instance of DBConnection using the getDBConnection static method.
        DBConnection_Eager DBConnEager = DBConnection_Eager.getDBConnection();
        
        System.out.println("DBConnection instance: " + DBConnEager);

        //Trying to create another instance of DBConnection using the getDBConnection static method
        //This will return the same instance as before, thus fulfilling the Singleton Design Pattern
        DBConnection_Eager DBConnEager2 = DBConnection_Eager.getDBConnection();
        System.out.println("Another DBConnection instance: " + DBConnEager2);

        DBConnection_Lazy DBConnLazy = DBConnection_Lazy.getDBConnection();
        System.out.println("DBConnection_Lazy instance: " + DBConnLazy);

        //Trying to create another instance of DBConnection_Lazy using the getDBConnection static method
        //This will return the same instance as before, thus fulfilling the Singleton Design Pattern
        DBConnection_Lazy DBConnLazy2 = DBConnection_Lazy.getDBConnection();
        System.out.println("Another DBConnection_Lazy instance: " + DBConnLazy2);
    }    
}
