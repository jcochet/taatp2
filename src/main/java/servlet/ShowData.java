package servlet;

import domain.Appointment;
import domain.User;
import sun.tools.jconsole.Worker;

import javax.persistence.EntityManager;
import java.util.List;

public class ShowData {

    private static void listAppointments(EntityManager manager) {
        List <Appointment> resultList = manager.createNamedQuery("getAppointments", Appointment.class).getResultList();
        System.out.println("num of appointments:" + resultList.size());
        for (Appointment next : resultList) {
            System.out.println("next appointment: " + next);
        }
    }
    private static void listUser(EntityManager manager) {
        List <User> resultList = manager.createNamedQuery("getUsers", User.class).getResultList();
        System.out.println("num of appointments:" + resultList.size());
        for (User next : resultList) {
            System.out.println("next appointment: " + next);
        }
    }
    private static void listWorker(EntityManager manager) {
        List <Worker> resultList = manager.createNamedQuery("getWorkers", Worker.class).getResultList();
        System.out.println("num of appointments:" + resultList.size());
        for (Worker next : resultList) {
            System.out.println("next appointment: " + next);
        }
    }
}
