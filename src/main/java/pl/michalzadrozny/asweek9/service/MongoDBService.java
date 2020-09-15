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

    private MongoRepository mongoRepository;

    @Autowired
    public MongoDBService(MongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    public List<UserMongoDB> convertListsIntoUsersMongoDB(List<User> users){
        List<UserMongoDB> userMongoDBList = new ArrayList<>();
        users.forEach(user -> {
            userMongoDBList.add(new UserMongoDB(user));
        });

        return userMongoDBList;
    }

    @Timer
    public boolean addListToDatabase(List<UserMongoDB> users){
        try{
            users.forEach(user -> {
                mongoRepository.save(user);
            });
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }




}
