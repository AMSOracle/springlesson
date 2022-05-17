package ru.mabdullaev.lesson1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FirstServlet", urlPatterns = "/first_servlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1,"Apple",1));
        products.add(new Product(2,"Pear",2));
        products.add(new Product(3,"Orange",3));
        products.add(new Product(4,"Onion",4));
        products.add(new Product(5,"Banana",5));
        products.add(new Product(6,"Milk",6));
        products.add(new Product(7,"Avocado",7));
        products.add(new Product(8,"Grapes",8));
        products.add(new Product(9,"Carrot",9));
        products.add(new Product(10,"Lemon",10));
        resp.getWriter().printf("<html><body>");
        resp.getWriter().printf("<ul>");
        for (Product p: products ) {
            resp.getWriter().printf("<li>"+ p + "</li>");
        }
        resp.getWriter().printf("</ul>");
        resp.getWriter().printf("</body></html>");
    }

    private void printAllProducts(HttpServletResponse response){

    }
}
