package ua.yurii.zhurakovskyi.servlet;

import ua.yurii.zhurakovskyi.domain.Product;
import ua.yurii.zhurakovskyi.service.ProductService;
import ua.yurii.zhurakovskyi.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/product")
public class ProductController extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    //to create resource(product)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        productService.create(new Product(name, description, getValidatedPrice(price)));
        resp.setContentType("text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }

    private Double getValidatedPrice(String price) {
        if (price == null || price.isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(price);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
