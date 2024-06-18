package Tenant.All;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChoirService {

    private final MongoTemplate mongoTemplate;

    public ChoirService(@Lazy MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void saveChoir(Choir choir) {
        mongoTemplate.save(choir);
    }

    public List<Choir> getAllChoirs() {
        return mongoTemplate.findAll(Choir.class);

    }
}