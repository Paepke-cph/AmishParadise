package storage;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {
    private static DBContext instance = new DBContext();
    private static SQLConnector connector;
    private DBContext() {
        try {
            connector = new SQLConnector(true);
        } catch (SQLException | ClassNotFoundException ex) {
            instance = null;
        }
    }
    
    public static DBContext getInstance() { 
        if(instance == null) instance = new DBContext();
        return instance; 
    }
    
    public SQLConnector getDB() { return connector; }
}
