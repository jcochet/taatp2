package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletConfig;
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
	private static EntityManager manager;

	@Override
	public void init(ServletConfig config) throws ServletException {
		manager = EntityManagerHelper.getEntityManager();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String firstname = request.getParameter("firstname");
		String age = request.getParameter("age");
		System.out.println("send {" + name + ";" + firstname + ";" + age + "} to batabase");
		List<User> users = sendToBD(name, firstname, age);
		String data = "num of users:" + users.size() + "\n";
		for (User next : users) {
			data += next.toString() + "\n";
		}
		PrintWriter out = response.getWriter();
		out.println("<HTML>\n<BODY>\n" + "<H1>Contenu de la base de donnée</H1>\n" + data + "\n</BODY></HTML>");
	}

	/**
	 * Envoie les informations du formulaire dans la base de données.
	 * 
	 * @param name      Nom de l'utilisateur
	 * @param firstname Prénom de l'utilisateur
	 * @param age       Age de l'utilisateur
	 */
	private List<User> sendToBD(String name, String firstname, String age) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			User user = new User(name, firstname, age, new ArrayList<>());
			manager.persist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		tx.commit();
		List<User> userList = manager.createNamedQuery("getUsers", User.class).getResultList();
		return userList;
	}
}
