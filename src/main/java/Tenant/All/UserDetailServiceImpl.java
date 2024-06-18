package Tenant.All;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    public UserDetailServiceImpl(MongoTemplate mongoTemplate) {
        System.out.println("UserDetailServiceImpl created++++++++++++++++");
        this.mongoTemplate = mongoTemplate;
    }
    public final MongoTemplate mongoTemplate;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Query query = new Query();
        query.addCriteria((Criteria.where("name").is(username)));
        return mongoTemplate.findOne(query, Users.class);

    }
}
