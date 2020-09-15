package pl.michalzadrozny.asweek9.model;

import lombok.Data;

@Data
public class User {

    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String ip_address;

    public User() {
    }

    public User(long id, String first_name, String last_name, String email, String gender, String ip_address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.ip_address = ip_address;
    }
}
