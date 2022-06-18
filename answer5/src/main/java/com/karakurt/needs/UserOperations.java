package com.karakurt.needs;

import com.karakurt.user.UserManager;

import java.util.Map;

public interface UserOperations {
    static Map<String,String> randomUsers = UserManager.randomUsers;
}
