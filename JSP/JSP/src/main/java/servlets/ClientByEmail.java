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


@WebServlet(value = "ClientByEmail")
public class ClientByEmail extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM clientes c WHERE c.email = :email";

        org.hibernate.query.Query<Client> query = session.createQuery(hql, Client.class);
        query.setParameter("email", email);

        List<Client> clients = query.list();
        session.close();

        if (!clients.isEmpty()) {
            request.setAttribute("client", clients.get(0));
            RequestDispatcher dispatcher = request.getRequestDispatcher("clientDetails.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().write("Cliente não encontrado.");
        }
    }
}
