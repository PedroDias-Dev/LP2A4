package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;
import org.hibernate.Session;
import util.HibernateUtil;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "ListClients")
public class ListClients extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Client> clients = session.createQuery("from clientes", Client.class).list();

        req.setAttribute("clients", clients);
        RequestDispatcher dispatcher = req.getRequestDispatcher("listClients.jsp");
        dispatcher.forward(req, resp);
    }
}

