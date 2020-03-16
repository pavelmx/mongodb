package com.innowise.mongodb.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(host, Integer.parseInt(port));
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }
}
