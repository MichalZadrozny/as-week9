package pl.michalzadrozny.asweek9.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ipAddress;

    public User() {
    }

    public User(long id, String firstName, String lastName, String email, String gender, String ipAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.ipAddress = ipAddress;
    }
}
