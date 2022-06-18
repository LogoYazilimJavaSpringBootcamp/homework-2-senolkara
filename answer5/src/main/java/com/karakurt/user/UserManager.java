package com.karakurt.user;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    public static Map<String,String> randomUsers;
    public Map<String,String> createRandomUsers(Map<String,String> randomUsers){
        randomUsers.put("Tami Benj","London");
        randomUsers.put("Antonia Cayley","Manchester");
        randomUsers.put("Kyleigh Drummond","Nottingham");
        randomUsers.put("Sierra Madeline","Norwich");
        randomUsers.put("Dillan Steph","Aston");
        randomUsers.put("Marlene Hansen","Brighton");
        randomUsers.put("Nellie Schmidt","Southampton");
        randomUsers.put("Jim Hudson","Hull");
        randomUsers.put("Aaron Moore","Fulham");
        randomUsers.put("Leona Flores","Watford");
        return randomUsers;
    }
    public Map<String,String> addUser(String firstName, String lastName, String address){
        Map<String,String> randomUserList = new HashMap<>();
        randomUserList.put(firstName + " " + lastName,address);
        return createRandomUsers(randomUserList);
    }
    public Map<String,String> getRandomUsers(){
        return randomUsers;
    }
    public void setRandomUsers(Map<String,String> randomUserList){
        randomUsers = randomUserList;
    }
}
