package com.bachelor.bachelor;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class CachedMongoClients {

    @Value("${spring.data.mongodb.authentication-database}")
    private String databaseName;
    @Value("${spring.data.mongodb.master.uri}")
    private String clientUri;


    Map<String, Tenant> tenantCache;

    //*Initialize tenants Here .
    @PostConstruct
    @Lazy
    public void initTenant() {
        tenantCache = new HashMap<>();
        // Two Db's, this expapple got two MOngo DB running in local host on different port
        Tenant tenant1 = new Tenant(MongoClients.create(clientUri), "client_a");
        Tenant tenant2 = new Tenant(MongoClients.create(clientUri), "client_b");


        tenantCache.put("DB1", tenant1);
        tenantCache.put("DB2", tenant2);
    }

    /**
     * Default Database name , for spring initialization
     *
     * @return
     */
    @Bean
    String databaseName() {
        return databaseName;
    }

    /**
     * Default Mongo Connection for spring initialization
     */
    @Bean
    public MongoClient getMongoClient() {
        return MongoClients.create(clientUri);
    }

    /**This will get called for each DB operations
     * Resiliency handlers can be added here.
     * @return MongoDatabase
     */
    public MongoDatabase getMongoDatabaseForCurrentContext() {
        return tenantCache.get(TenantProvider.getCurrentDb()).getClient().
                getDatabase(tenantCache.get(TenantProvider.getCurrentDb()).getDatabase());
    }
}
