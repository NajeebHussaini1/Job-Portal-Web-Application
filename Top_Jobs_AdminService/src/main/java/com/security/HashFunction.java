package com.security;

public class HashFunction {
    public static String decToHex(byte[] bytes){
        String hex = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bytes.length ;i++){
            sb.append(String.format("%02x", bytes[i]));
        }
        hex = sb.toString();
        return hex;
    }
}
