package models;

import java.util.LinkedHashMap;
import database.Database;
import myUtilities.MyUtilities;

public class RestaurantUser {
    private LinkedHashMap<String, String> restaurantData;
    private MyUtilities myUtilities;
    public static final String file = "E:\\code\\database\\restaurant_register.txt";


    public RestaurantUser(String[] str) {
        myUtilities = new MyUtilities();
        this.restaurantData = myUtilities.stringToMap(str);
    }


    boolean checkPhoneNumberExistence() {
        if (Database.getInstance().getTable("restaurantRegister").getRowWithId(file, restaurantData.get("id")) != null)
            return false;
        return true;
    }

    public String serverResponseToRegister() {
        if (checkPhoneNumberExistence()) {
            if (restaurantData.containsKey("name")) {
                String write = myUtilities.mapToString(restaurantData);
                Database.getInstance().getTable("restaurantRegister").myFileWriter(file, write);
            }
            return "Registered successfully";
        }
        return "try again";
    }

}

//from server
//restaurant--register--id:id--name:name--address:address--category:category--phone:phone--pass:pass


//in file
//id:09129494168--name:Bouno--address:reheejn--category:ddv--phone:64545--pass:Ghazal1234::::id:09129494168--name:Bouno--address:reheejn--category:ddv--phone:64545--pass:Ghazal1234
