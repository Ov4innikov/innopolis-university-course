package part1.lesson22.task01.servlet;

import part1.lesson22.task01.service.PersonService;
import part1.lesson22.task01.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Фильтр для добавления Person.
 *
 * @autor Овчинников Евгений
 */
@WebServlet(name = "person", loadOnStartup = 1, urlPatterns = "/person")
public class PersonServlet extends HttpServlet {

    private PersonService person;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        person = new PersonServiceImpl(connection);
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String birth = req.getParameter("birth");
        person.addPerson(name, birth);

        resp.sendRedirect(req.getContextPath() + "/person/list");
    }
}
