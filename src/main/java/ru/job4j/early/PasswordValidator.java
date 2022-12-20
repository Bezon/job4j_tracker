package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (checkChr(password, "isDigital")) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (checkChr(password, "isSpec")) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (checkDictionary(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345"
                    + ", password, admin, user");
        }
        return password;
    }

    private static boolean checkChr(String password, String type) {
        Character ch;
        boolean rsl = true;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            switch (type) {
                case "isDigital":
                    if (Character.isDigit(ch)) {
                        rsl = false;
                    }
                    break;
                case "isSpec":
                    if ((ch >= 32 && ch <= 47) || (ch >= 58 && ch <= 64)
                            || (ch >= 91 && ch <= 96) || (ch >= 123 && ch <= 126)) {
                        rsl = false;
                    }
                    break;
                default:
                    rsl = false;
            }
        }
        return rsl;
    }

    private static boolean checkDictionary(String password) {
        String[] dictionary = new String[]{"qwerty", "12345", "password", "admin", "user"};
        for (String word: dictionary) {
            if (String.valueOf(password).toLowerCase().contains(word)) {
                return true;
            }
        }
        return false;
    }
}
