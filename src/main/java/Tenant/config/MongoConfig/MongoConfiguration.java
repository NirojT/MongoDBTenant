package Tenant.config.MongoConfig;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;

@Configuration
public class MongoConfiguration {

  @Bean
  public MongoTemplate mongoTemplate() {
    ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/mydatabase");
    MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    return new MongoTemplate(MongoClients.create(mongoClientSettings), "mydatabase");
  }
}