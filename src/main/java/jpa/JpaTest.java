package jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import domain.Appointment;
import domain.User;
import domain.Worker;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			createAppointments(manager);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		listAppointments(manager);

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		// factory.close();
	}

	private static void createAppointments(EntityManager manager) {
		int numOfAppointments = manager.createQuery("Select a From Appointment a", Appointment.class).getResultList()
				.size();
		if (numOfAppointments == 0) {
			User jcochet = new User("Julien Cochet", "julien.cochet@etudiant.univ-rennes1.fr", "password",
					new ArrayList<>());
			manager.persist(jcochet);
			Worker sababou = new Worker("Sarah Ababou", "sarah.ababou@etudiant.univ-rennes1.fr", "password",
					new ArrayList<>(), "Développeuse logicielle");
			manager.persist(sababou);
			Appointment app1 = new Appointment(new Date(0), 45, jcochet, sababou, "Entretien de 45 minutes");
			manager.persist(app1);
			Appointment app2 = new Appointment(new Date(100000000), 45, jcochet, sababou,
					"Second entretien de 45 minutes");
			manager.persist(app2);
		}
	}

	private static void listAppointments(EntityManager manager) {
		List<Appointment> resultList = manager.createNamedQuery("getAppointments", Appointment.class).getResultList();
		System.out.println("num of appointments:" + resultList.size());
		for (Appointment next : resultList) {
			System.out.println("next appointment: " + next);
		}
	}

}
