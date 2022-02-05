package Bootcamp.Java.Fundamentals.MapOfTheHashmatique;

import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("songOne", "Lorem sdfds whatever sit amet");
        userMap.put("songTwo", "Lorem ipsum stuff sidsfsdft amet.");
        userMap.put("songThree", "Lorem ipsum huh sit amet.");
        userMap.put("songFour", "Lorem ipsum IDK sit amet.");

        String song = userMap.get("songTwo");
        System.out.println(song);

        Set<String> keys = userMap.keySet();
        for(String key : keys) {
            System.out.println(key + ": " + userMap.get(key));    
        }
    }
    }

