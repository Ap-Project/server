package myUtilities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MyUtilities {

    public LinkedHashMap<String,String> stringToMap(String[] str){
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        for (int i = 2; i < str.length; i++) {
            String[] splitStr = str[i].split(":");
            map.put(splitStr[0],splitStr[1]);
        }
        return map;
    }

    public String mapToString(Map<String,String> map){
        StringBuilder stringBuilder = new StringBuilder();
        for (String key: map.keySet()) {
            stringBuilder.append(key);
            stringBuilder.append(":");
            stringBuilder.append(map.get(key));
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }
}
