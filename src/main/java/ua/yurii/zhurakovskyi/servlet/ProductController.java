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

    private ProductService productService = ProductServiceImpl.getProductServiceImpl();

    //to create resource(product)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(Double.parseDouble(price));
        productService.create(product);
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("id");
        Product product = productService.read(Integer.parseInt(productId));
        req.setAttribute("product", product);
        req.getRequestDispatcher("singleProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }


}
