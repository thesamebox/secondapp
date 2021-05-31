import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "BasicServlet", urlPatterns = "/basic_servlet")
public class BasicServlet implements Servlet {

    private static Logger log = LoggerFactory.getLogger(BasicServlet.class);
    private transient ServletConfig config;

    //the method is called by container after class servlet is created
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    //the method is called for every new HTTP request to the current servlet
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        log.info("New request");
        //Getting object of BufferedWriter and write down a response for the request
        servletResponse.getOutputStream().println("<h1>Servlet content</h1>");

    }

    @Override
    public String getServletInfo() {
        return String.valueOf(BasicServlet.class);
    }

    //Container calls the method for every servlet from the app during finishing webapp
    @Override
    public void destroy() {
        log.info("Servlet {} destroyed", getServletInfo());
    }
}
