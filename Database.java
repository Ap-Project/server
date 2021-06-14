import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;



public class Database {
    private static Database database = null;
    private  HashMap<String,Table> storedTables = new HashMap<>();


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

    public void add(String key,Table value){
        storedTables.put(key,value);
    }


}



class Table {
    File file;
    FileReader fileReader;
    FileWriter fileWriter;

    Table(String fileDirectory) {
        this.file = new File(fileDirectory);
        try {
            this.fileReader = new FileReader(fileDirectory);
            this.fileWriter = new FileWriter(fileDirectory);
        } catch (Exception e) {
        }
    }

    String myFileReader() {
        StringBuilder readFromFile = new StringBuilder();
        try {
            int i;
            while ((i = fileReader.read()) != -1) {
                readFromFile.append((char) i);
            }
            fileReader.close();
        } catch (Exception e) {
        }

        return readFromFile.toString();
    }

    void myFileWriter(String writeInFile) {
        StringBuilder recoverFile = new StringBuilder(myFileReader()).append(writeInFile);
        try {
            fileWriter.write(recoverFile.toString());
            fileWriter.close();
        } catch (IOException e) {
        }
    }



}
