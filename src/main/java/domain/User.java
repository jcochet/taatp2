package domain;

public class User {
    private String name;
    private String email;
    private String pwd;
    private Appointnent appointment;
    public User(){}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public Appointnent getAppointment() {
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

    public void setAppointment(Appointnent appointment) {
        this.appointment = appointment;
    }
}
