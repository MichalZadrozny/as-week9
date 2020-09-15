package pl.michalzadrozny.asweek9.service;

import org.springframework.stereotype.Service;
import pl.michalzadrozny.asweek9.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CsvService {

    public List<List<String>> readCsvFile(String path){
        List<List<String>> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
            return records;

        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> convertListsIntoUsers(List<List<String>> list){
        List<User> users = new ArrayList<>();

        list.forEach(user -> {
            users.add(new User(Long.parseLong(user.get(0)),user.get(1),user.get(2),user.get(3),user.get(4),user.get(5)));
        });

        return users;
    }
}
