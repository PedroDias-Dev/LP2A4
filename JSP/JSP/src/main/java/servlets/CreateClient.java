package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DateFormat;
import util.HibernateUtil;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "CreateClient", urlPatterns = "/CreateClient")
public class CreateClient extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String document = req.getParameter("document");
        String birthDate = req.getParameter("birthDate");

        Date formattedDate = DateFormat.dateFormat(birthDate);

        Client client = new Client(nome, surname, email, document, formattedDate);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(client);

        transaction.commit();

        resp.sendRedirect("ListClients");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("createClient.jsp");
        dispatcher.forward(req, resp);
    }
}