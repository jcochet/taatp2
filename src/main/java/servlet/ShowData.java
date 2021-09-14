package servlet;

import domain.Appointment;
import domain.User;
import domain.Worker;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "showdata", urlPatterns = { "/data" })
public class ShowData extends HttpServlet {
    private static final long serialVersionUID = -5931952924171092053L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager manager = EntityManagerHelper.getEntityManager();
        String data= "liste des données "+listAppointments(manager);
                //+listWorkers(manager)+listUsers(manager); error
        PrintWriter p = new PrintWriter(resp.getOutputStream());
        p.print(data);
        p.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private static String listAppointments(EntityManager manager) {
        List <Appointment> resultList = manager.createNamedQuery("getAppointments", Appointment.class).getResultList();
        String s ="num of appointments:" + resultList.size();

        for (Appointment next : resultList) {
           s=s+"next appointment: " + next;
        }
        return s;
    }
    private static String listUsers(EntityManager manager) {
        List <User> resultList = manager.createNamedQuery("getUsers", User.class).getResultList();
        String s ="num of user:" + resultList.size();

        for (User next : resultList) {
            s=s+"next user: " + next;
        }
        return s;
    }
    private static String listWorkers(EntityManager manager) {
        List <Worker> resultList = manager.createNamedQuery("getWorkers", Worker.class).getResultList();
        String s ="num of worker:" + resultList.size();
        for (Worker next : resultList) {
            s=s+"next worker: " + next;
        }
        return s;
    }
}
