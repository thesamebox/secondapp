import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "IncludeServlet", urlPatterns = "/include_servlet")
public class IncludeServlet extends HttpServlet {

    private static Logger log = LoggerFactory.getLogger(ForwardServlet.class);
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException,
            IOException {
        log.info("New GET request with include");
        getServletContext().getRequestDispatcher("/header.html").include(req, resp);
        resp.getOutputStream().println("<p>Response body from servlet<p>");
        getServletContext().getRequestDispatcher("/footer.html").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}