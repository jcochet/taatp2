package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Worker extends User {

    private String job;
    private int id;

    public Worker(){}

    @Id
    @GeneratedValue
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Worker{" +
                "job='" + job + '\'' +
                ", id=" + id +
                '}';
    }
}
