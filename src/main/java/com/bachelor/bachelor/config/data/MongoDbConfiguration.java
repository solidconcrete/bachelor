package com.bachelor.bachelor.config.data;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDbConfiguration {

    @Value("${spring.data.mongodb.master.uri}")
    private String masterClient;

    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory() throws Exception {
        return new SimpleMongoClientDatabaseFactory(mongoClient(), "client_a");
    }
//
//    @Bean
//    @Primary
//    public MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(mongoDatabaseFactory());
//    }
    public @Bean
    MongoClient mongoClient () {
        return MongoClients.create(masterClient);
    }
}
