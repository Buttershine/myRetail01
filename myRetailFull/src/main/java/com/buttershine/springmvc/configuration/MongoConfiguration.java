package com.buttershine.springmvc.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Override
    public String getDatabaseName() {
        return "myRetail";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost" , 27017 );
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.buttershine.springmvc.model";
    }
}
