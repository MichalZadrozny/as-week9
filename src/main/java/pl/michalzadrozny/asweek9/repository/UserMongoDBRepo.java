package pl.michalzadrozny.asweek9.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.michalzadrozny.asweek9.model.UserMongoDB;

@Repository
public interface UserMongoDBRepo extends MongoRepository<UserMongoDB,String> {
}
