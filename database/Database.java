package database;

import java.util.HashMap;


public class Database {
    private static Database database = null;
    private  HashMap<String, Table> storedTables = new HashMap<>();


    private Database(){
    }

    public static Database getInstance(){
        if (database == null)
            database = new Database();
        return database;
    }

    public Table getTable(String key){
        return storedTables.get(key);
    }

    public void add(String key, Table value){
        storedTables.put(key,value);
    }


}



