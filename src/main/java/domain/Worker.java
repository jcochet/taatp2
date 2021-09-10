package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Worker extends User {

	private long id;
	private String job;

	public Worker() {
	}
	
	public Worker(String job) {
		this.job = job;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Worker [id=" + id + ", job=" + job + "]";
	}
	
}
