package ua.yurii.zhurakovskyi.servlet;

import ua.yurii.zhurakovskyi.domain.Cart;
import ua.yurii.zhurakovskyi.service.CartService;
import ua.yurii.zhurakovskyi.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    private CartService cartService = CartServiceImpl.getCartServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String productId = req.getParameter("productId");
        HttpSession session = req.getSession(true);
        Integer userId = (Integer) session.getAttribute("userId");
        Cart cart = new Cart(userId, Integer.parseInt(productId), new Date());
        cartService.create(cart);
        resp.setContentType("text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardId = req.getParameter("cardId");
        cartService.delete(Integer.parseInt(cardId));
        resp.setContentType("text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }
}
