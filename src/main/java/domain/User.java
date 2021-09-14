package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(name = "getUsers", query = "Select a From Appointment a")
@Entity
public class User {

	private long id;
	private String name;
	private String email;
	private String pwd;
	private List<Appointment> appointments;

	public User() {
		this.appointments = new ArrayList<Appointment>();
	}

	public User(String name, String email, String pwd, List<Appointment> appointments) {
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.appointments = appointments;
	}

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

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@OneToMany(mappedBy = "date")
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", appointment="
				+ appointments + "]";
	}

}
