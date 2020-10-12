package pl.michalzadrozny.asweek9;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.michalzadrozny.asweek9.model.User;
import pl.michalzadrozny.asweek9.model.UserMongoDB;
import pl.michalzadrozny.asweek9.repository.HibernateRepo;
import pl.michalzadrozny.asweek9.repository.UserMongoDBRepo;
import pl.michalzadrozny.asweek9.service.CsvService;
import pl.michalzadrozny.asweek9.service.HibernateService;
import pl.michalzadrozny.asweek9.service.MongoDBService;

import java.util.List;

@Component
@Slf4j
public class Start {

    private UserMongoDBRepo userMongoDBRepo;
    private CsvService csvService;
    private MongoDBService mongoDBService;
    private HibernateRepo hibernateRepo;
    private HibernateService hibernateService;

    @Autowired
    public Start(UserMongoDBRepo userMongoDBRepo, CsvService csvService, MongoDBService mongoDBService, HibernateRepo hibernateRepo, HibernateService hibernateService) {
        this.userMongoDBRepo = userMongoDBRepo;
        this.csvService = csvService;
        this.mongoDBService = mongoDBService;
        this.hibernateRepo = hibernateRepo;
        this.hibernateService = hibernateService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        List<List<String>> csvFile = csvService.readCsvFile("src\\main\\resources\\MOCK_DATA.csv");
        List<User> convertedCsv = csvService.convertListsIntoUsers(csvFile);

//        hibernateRepo.save(convertedCsv.get(0));

//        hibernateService.addListToDatabase(convertedCsv);

        List<UserMongoDB> userMongoDBList = mongoDBService.convertListsIntoUsersMongoDB(convertedCsv);
//
        mongoDBService.addListToDatabase(userMongoDBList);

        List<UserMongoDB> users = mongoDBService.getAllUsers();
//        List<User> users = hibernateService.getAllUsers();
        users.forEach(System.out::println);

    }
}
