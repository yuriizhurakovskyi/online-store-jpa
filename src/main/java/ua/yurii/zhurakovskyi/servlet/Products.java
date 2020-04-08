package ua.yurii.zhurakovskyi.servlet;

import com.google.gson.Gson;
import ua.yurii.zhurakovskyi.domain.Product;
import ua.yurii.zhurakovskyi.service.ProductService;
import ua.yurii.zhurakovskyi.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class Products extends HttpServlet {
    private ProductService productService = ProductServiceImpl.getProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.readAll();
        String json = new Gson().toJson(products);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
