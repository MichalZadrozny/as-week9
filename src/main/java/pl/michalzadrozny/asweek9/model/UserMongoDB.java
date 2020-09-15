package pl.michalzadrozny.asweek9.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class UserMongoDB {

    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String ip_address;

    public UserMongoDB(String first_name, String last_name, String email, String gender, String ip_address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.ip_address = ip_address;
    }

    public UserMongoDB(User user){
        this.id = String.valueOf(user.getId());
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.email = user.getEmail();
        this.gender = user.getGender();
        this.ip_address = user.getIp_address();
    }
}
