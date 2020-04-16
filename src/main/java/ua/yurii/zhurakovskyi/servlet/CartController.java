package ua.yurii.zhurakovskyi.servlet;

import ua.yurii.zhurakovskyi.domain.Cart;
import ua.yurii.zhurakovskyi.domain.Product;
import ua.yurii.zhurakovskyi.domain.User;
import ua.yurii.zhurakovskyi.service.CartService;
import ua.yurii.zhurakovskyi.service.ProductService;
import ua.yurii.zhurakovskyi.service.UserService;
import ua.yurii.zhurakovskyi.service.impl.CartServiceImpl;
import ua.yurii.zhurakovskyi.service.impl.ProductServiceImpl;
import ua.yurii.zhurakovskyi.service.impl.UserServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    private CartService cartService = CartServiceImpl.getCartServiceImpl();
    private ProductService productService = ProductServiceImpl.getProductServiceImpl();
    private UserService userService = UserServiceImpl.getUserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String productId = req.getParameter("productId");
        Product product = productService.read(Integer.parseInt(productId));
        HttpSession session = req.getSession(true);
        Integer userId = (Integer) session.getAttribute("userId");
        User user = userService.read(userId);
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setPurchaseDate(new Date());
        cartService.create(cart);
        resp.setContentType("text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cartId = req.getParameter("cartId");
        cartService.delete(Integer.parseInt(cartId));
        resp.setContentType("text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }
}
