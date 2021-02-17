package lk.sliit.itpmProject.db;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Base64;

public class DEPCrypt {
    public DEPCrypt() {
    }

    public static String encode(String input, String key) {
        char[] chars = (input + key).toCharArray();
        String encodeString = "";

        for(int i = chars.length - 1; i >= 0; --i) {
            encodeString = encodeString + chars[i];
        }

        return Base64.getEncoder().encodeToString(encodeString.getBytes());
    }

    public static String decode(String cipher, String key) {
        byte[] decode = Base64.getDecoder().decode(cipher.getBytes());
        String s = new String(decode);
        s = (new StringBuilder(s)).reverse().toString();
        if (!s.endsWith(key)) {
            throw new RuntimeException("Invalid Key");
        } else {
            return s.substring(0, s.length() - key.length());
        }
    }
}
