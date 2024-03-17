package com.devstack.app;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    public static String hash(String rawPassword){
       return BCrypt.hashpw(rawPassword,BCrypt.gensalt(10));
    }
}
