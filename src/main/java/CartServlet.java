import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private static Logger log = LoggerFactory.getLogger(CartServlet.class);
    Product[] products = new Product[10];


    public void fillCart() {
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product(i + 1, "product" + i, 10 + i * 0.89);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("New cart request for homework with 10 products");
//        getServletContext().getRequestDispatcher("/header.html").include(req, resp);

        fillCart();

        resp.getOutputStream().println("<p> id |    title  | cost | </p>");

        for (Product product : products) {
            resp.getOutputStream().println("<p> id" + product.getId() + " | " + product.getTitle() + " | " + product.getCost() + "$ </p>");
            resp.getOutputStream().println("<p>-------------------------------------</p>");
        }
        double total = 0;
        for (Product product : products) {
            total = total + product.getCost();
        }
        resp.getOutputStream().println("<p>        total  | " + total + "$ | </p>");

//        getServletContext().getRequestDispatcher("/footer.html").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
