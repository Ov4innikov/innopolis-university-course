package part1.lesson23.task01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Фильтр для логирования.
 *
 * @autor Овчинников Евгений
 */
@WebFilter(displayName = "logFilter", urlPatterns = "/*")
public class LogFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.warn("init logFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String uri = "Requested Uri::" + req.getRequestURI();
        logger.warn(uri);
        String method = "Requested Method::" + req.getMethod();
        logger.warn(method);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.warn("destroy logFilter");
    }
}
