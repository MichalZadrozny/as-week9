package pl.michalzadrozny.asweek9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import pl.michalzadrozny.asweek9.annotation.Timer;
import pl.michalzadrozny.asweek9.model.User;
import pl.michalzadrozny.asweek9.model.UserMongoDB;

import java.util.ArrayList;
import java.util.List;

@Service
public class MongoDBService {

    private final MongoRepository<UserMongoDB,String> mongoRepository;

    @Autowired
    public MongoDBService(MongoRepository<UserMongoDB,String> mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    public List<UserMongoDB> convertListsIntoUsersMongoDB(List<User> users){
        List<UserMongoDB> userMongoDBList = new ArrayList<>();
        users.forEach(user -> userMongoDBList.add(new UserMongoDB(user)));

        return userMongoDBList;
    }

    @Timer
    public void addListToDatabase(List<UserMongoDB> users){
        try{
            mongoRepository.saveAll(users);
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Timer
    public List<UserMongoDB> getAllUsers(){
        return mongoRepository.findAll();
    }




}
