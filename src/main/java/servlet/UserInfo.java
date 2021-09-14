package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import jpa.EntityManagerHelper;

@WebServlet(name = "userinfo", urlPatterns = { "/UserInfo" })
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = -873272075166276907L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>\n<BODY>\n" + "<H1>Recapitulatif des informations</H1>\n" + "<UL>\n" + " <LI>Nom: "
				+ request.getParameter("name") + "\n" + " <LI>Prenom: " + request.getParameter("firstname") + "\n"
				+ " <LI>Age: " + request.getParameter("age") + "\n" + "</UL>\n" + "</BODY></HTML>");

		String name = request.getParameter("name");
		String firstname = request.getParameter("firstname");
		String age = request.getParameter("age");
		System.out.println("send {" + name + ";" + firstname + ";" + age + "} to batabase");
		sendToBD(name, firstname, age);
	}

	/**
	 * Envoie les informations du formulaire dans la base de données.
	 * 
	 * @param name      Nom de l'utilisateur
	 * @param firstname Prénom de l'utilisateur
	 * @param age       Age de l'utilisateur
	 */
	private void sendToBD(String name, String firstname, String age) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			User user = new User(name, firstname, age, new ArrayList<>());
			manager.persist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		tx.commit();
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
	}
}
