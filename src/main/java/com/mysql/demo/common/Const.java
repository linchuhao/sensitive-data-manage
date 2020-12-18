package com.mysql.demo.common;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Const {


    public static final String PRIVATE_KEY = "'private_key'";

    public static String PRIVATE_KEY_FROM_PATH;


    @Value("${text.key}")
    public void setPrivateKeyFromPath(String privateKeyFromPath) {
        PRIVATE_KEY_FROM_PATH = privateKeyFromPath;
    }

}
