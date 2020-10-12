package pl.michalzadrozny.asweek9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalzadrozny.asweek9.annotation.Timer;
import pl.michalzadrozny.asweek9.model.User;
import pl.michalzadrozny.asweek9.repository.HibernateRepo;

import java.util.List;

@Service
public class HibernateService {

    private HibernateRepo hibernateRepo;

    @Autowired
    public HibernateService(HibernateRepo hibernateRepo) {
        this.hibernateRepo = hibernateRepo;
    }

    @Timer
    public void addListToDatabase(List<User> users){
        try{
            hibernateRepo.saveAll(users);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Timer
    public List<User> getAllUsers(){
        return hibernateRepo.findAll();
    }
}
