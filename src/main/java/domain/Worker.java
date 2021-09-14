package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.List;

@NamedQuery(name = "getWorkers", query = "Select a From Appointment a")
@Entity
public class Worker extends User {

	private long id;
	private String job;

	public Worker() {
		super();
	}

	public Worker(String name, String email, String pwd, List<Appointment> appointments, String job) {
		super(name, email, pwd, appointments);
		this.job = job;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		return "Worker [id=" + id + ", name=" +super.getName() + ", email=" + super.getEmail() + ", pwd=" + super.getPwd() + ", appointment="
				+ super.getAppointments() +"job=" + job +"]";
	}
}
