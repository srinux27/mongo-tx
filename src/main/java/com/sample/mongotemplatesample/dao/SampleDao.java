package com.sample.mongotemplatesample.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SampleDao {
    @Value("${primary.sample-db.uri}")
    String connectionString;

    String databaseName;

    //@Bean
    public MongoClient mongoClient() {
        return MongoClients.create(connectionString);
    }

}
