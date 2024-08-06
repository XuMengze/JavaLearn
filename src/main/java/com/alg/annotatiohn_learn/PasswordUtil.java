package com.alg.annotatiohn_learn;

import java.util.List;

public class PasswordUtil {
    @UseCase(id = 47, description = "validate password")
    public boolean validatePassword(String password) {
        return true;
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return "";
    }

    @UseCase(id = 49, description = "check for new password")
    public boolean checkForNewPassword(List<String> prevPasswords, String passwd) {
        return false;
    }
}
