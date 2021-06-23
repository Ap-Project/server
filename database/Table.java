package database;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Table {
    File file;
    FileWriter fileWriter;

    public Table(String fileDirectory) {
        this.file = new File(fileDirectory);
        try {
            if (!this.file.exists())
                this.file.createNewFile();
        } catch (Exception e) {
        }
    }

    String myFileReader(String file) {
        StringBuilder readFromFile = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(file);
            int i;
            while ((i = fileReader.read()) != -1) {
                readFromFile.append((char) i);
            }
//            fileReader.close();
        } catch (Exception e) {
        }
        return readFromFile.toString();
    }

    public void myFileWriter(String file,String writeInFile) {
        StringBuilder recoverFile = new StringBuilder(myFileReader(file)).append(writeInFile);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(recoverFile + "::::");
            fileWriter.flush();
        } catch (IOException e) {
        }
    }

    public String getRowWithId(String file,String id){
        String recoverFile = myFileReader(file);
        String[] getEachRow = recoverFile.split("::::");
        for (int i = 0; i < getEachRow.length; i++) {
            if (getEachRow[i].startsWith("id:" + id)){
                return getEachRow[0];
            }
        }
        return null;
    }

    public void writeAndEdit(String file,String writeInFile,String id){
        String recoverFile = myFileReader(file);
        recoverFile.replace(getRowWithId(file,id),"");
        recoverFile += writeInFile;
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(recoverFile + "::::");
            fileWriter.flush();
        } catch (IOException e) {
        }
    }
}
