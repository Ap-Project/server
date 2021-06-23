package models;

import database.Database;
import myUtilities.MyUtilities;

import java.util.LinkedHashMap;

public class Menu {
    public static final String menuFile = "E:\\code\\database\\menu.txt";
    private LinkedHashMap<String, String> menuData;
    private MyUtilities myUtilities;

    public Menu(String[] str) {
        myUtilities = new MyUtilities();
        this.menuData = myUtilities.stringToMap(str);
    }

    public void addMenu() {
        String restaurantExistence = Database.getInstance().getTable("menu").getRowWithId(menuFile, menuData.get("id"));
        if (restaurantExistence != null) {
            restaurantExistence += myUtilities.mapToString(menuData);
            Database.getInstance().getTable("menu").writeAndEdit(menuFile,restaurantExistence,menuData.get("id"));
        }
        Database.getInstance().getTable("menu").myFileWriter(menuFile, restaurantExistence);
    }

    public String getMenu(String id) {
        return Database.getInstance().getTable("menu").getRowWithId(menuFile, id);
    }

    public void editMenu() {
        String restaurantExistence = Database.getInstance().getTable("menu").getRowWithId(menuFile, menuData.get("id"));
        LinkedHashMap<String, String> temp = myUtilities.stringToMap(restaurantExistence.split("--"));
        for (String key : temp.keySet()) {
            if (key.equals(menuData.get("oldName"))) {
                temp.remove(menuData.get("oldName"));
                temp.put(menuData.get("newName"), menuData.get("newPrice"));
                String write = myUtilities.mapToString(temp);
                Database.getInstance().getTable("menu").writeAndEdit(menuFile,write,menuData.get("id"));
                break;
            }
        }

    }
}

//server
//restaurant--getMenu--id:userId
//restaurant--addMenu--id:userId--peperoni:90000
//restaurant--editMenu--id:userId--oldName:peperoni--oldPrice:90000--newName:peperoni--newPrice:10000

//in file
//id:09129494168--peperoni:90000--salad:545541::::id:09129494164--pizza
