package pl.michalzadrozny.asweek9;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.michalzadrozny.asweek9.model.User;
import pl.michalzadrozny.asweek9.model.UserMongoDB;
import pl.michalzadrozny.asweek9.repository.UserMongoDBRepo;
import pl.michalzadrozny.asweek9.service.CsvService;
import pl.michalzadrozny.asweek9.service.MongoDBService;

import java.util.List;

@Component
@Slf4j
public class Start {

    UserMongoDBRepo userMongoDBRepo;
    CsvService csvService;
    MongoDBService mongoDBService;

    @Autowired
    public Start(UserMongoDBRepo userMongoDBRepo, CsvService csvService, MongoDBService mongoDBService) {
        this.userMongoDBRepo = userMongoDBRepo;
        this.csvService = csvService;
        this.mongoDBService = mongoDBService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){

        List<List<String>> csvFile = csvService.readCsvFile("src\\main\\resources\\MOCK_DATA.csv");
        List<User> convertedCsv = csvService.convertListsIntoUsers(csvFile);

        mongoDBService.addListToDatabase(mongoDBService.convertListsIntoUsersMongoDB(convertedCsv));
    }
}
