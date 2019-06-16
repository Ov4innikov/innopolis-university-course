package part1.lesson23.task01.servlet;

import part1.lesson23.task01.entity.Person;
import part1.lesson23.task01.service.PersonService;
import part1.lesson23.task01.service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * Сервлет для отображения списка Person.
 *
 * @autor Овчинников Евгений
 */
@WebServlet(name = "personList", loadOnStartup = 1, urlPatterns = "/person/list")
public class ListPersonServlet extends HttpServlet {

    private PersonService person;

    @Override
    public void init() throws ServletException {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
        person = new PersonServiceImpl(connection);
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> res = person.getList();
        req.setAttribute("persons", res);
        req.getRequestDispatcher("/persons.jsp")
                .forward(req, resp);
    }
}
