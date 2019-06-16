package part1.lesson22.task01.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import part1.lesson22.task01.filter.AuthFilter;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "errorHandler", loadOnStartup = 1, urlPatterns = "/error")
public class AppErrorHandler extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(AppErrorHandler.class);

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processError(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processError(request, response);
    }

    private void processError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Throwable throwable = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String servletName = (String) request.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME);
        logger.info("Exce", throwable);
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        // Set response content type
        response.setContentType("text/html");

        try(PrintWriter out = response.getWriter()) {
            out.write("<html><head><title>Exception/Error Details</title></head><body>");
            if (statusCode != 500) {
                out.write("<h3>Error Details</h3>");
                out.write("<strong>Status Code</strong>:" + statusCode + "<br>");
                out.write("<strong>Requested URI</strong>:" + requestUri);
            } else {
                out.write("<h3>Exception Details</h3>");
                out.write("<ul><li>Servlet Name:" + servletName + "</li>");
                out.write("<li>Exception Name:" + throwable.getClass().getName() + "</li>");
                out.write("<li>Requested URI:" + requestUri + "</li>");
                out.write("<li>Exception Message:" + throwable.getMessage() + "</li>");
                out.write("</ul>");
            }

            out.write("<br><br>");
            out.write("<a href=\"/\">Main page</a>");
            out.write("</body></html>");
        }
    }
}
