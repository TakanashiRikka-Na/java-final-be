package com.takanashi.final_server.util;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswdUtil {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

    public static boolean isValid(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public static String encoded(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public static boolean check(String password, String encodedPassword) {
        return BCrypt.checkpw(password, encodedPassword);
    }
}
