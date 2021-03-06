package com.bachelor.bachelor;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class CachedMongoClients {

    @Value("${spring.data.mongodb.master.uri}")
    private String clientUri;

    @Bean
    String databaseName() {
        return "client_a";
    }

    @Bean
    public MongoClient getMongoClient() {
        return MongoClients.create(clientUri);
    }

    public MongoDatabase getMongoDatabaseForCurrentContext() {
        return MongoClients.create(clientUri).getDatabase(TenantProvider.getCurrentDb());
    }
}

