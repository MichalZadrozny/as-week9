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
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ipAddress;

    public UserMongoDB(String firstName, String lastName, String email, String gender, String ipAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.ipAddress = ipAddress;
    }

    public UserMongoDB(User user){
        this.id = String.valueOf(user.getId());
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.gender = user.getGender();
        this.ipAddress = user.getIpAddress();
    }
}
