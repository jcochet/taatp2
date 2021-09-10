package domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {

	private Long id;
	private Date date;
	private int duration;
	private User user;
	private Worker worker;
	private String description;

	public Appointment() {
	}

	public Appointment(Date date, int duration, User user, Worker worker, String description) {
		this.date = date;
		this.duration = duration;
		this.user = user;
		this.worker = worker;
		this.description = description;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", duration=" + duration + ", user=" + user.getId()
				+ ", worker=" + worker.getId() + ", description=" + description + "]";
	}

}
