package com.osmanli_building.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtConstant {
    public static String SECRET_KEY;
    public static String HEADER;

    @Value("${jwt.secret}")
    public void setSecretKey(String secretKey) {
        SECRET_KEY = secretKey;
    }

    @Value("${jwt.header}")
    public void setHEADER(String header){
        HEADER = header;
    }
}
