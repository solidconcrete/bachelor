package com.bachelor.bachelor.security;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;


@Configuration
@CommonsLog
public class PublicKeyConfiguration {

    @Value("${security.jwt-properties.public-key}")
    private Resource keyPath;

    @Bean
    public PublicKey publicKey() throws IOException, GeneralSecurityException {
        try (InputStream is = keyPath.getInputStream()) {
            byte[] bytes = new byte[is.available()];
            if (is.read(bytes) > 0) {
                KeyFactory kf = KeyFactory.getInstance("RSA");
                return kf.generatePublic(new X509EncodedKeySpec(bytes));
            }
            return null;
        }
    }

}
