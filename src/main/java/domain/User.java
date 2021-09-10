package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
    private String name;
    private String email;
    private String pwd;
    private Appointment appointment;
    private long id;
    public User(){}

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    @OneToMany
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", appointment=" + appointment +
                '}';
    }
}
