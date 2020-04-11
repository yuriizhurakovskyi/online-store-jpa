package ua.yurii.zhurakovskyi.servlet;

import com.google.gson.Gson;
import ua.yurii.zhurakovskyi.domain.Cart;
import ua.yurii.zhurakovskyi.domain.Product;
import ua.yurii.zhurakovskyi.dto.CartDto;
import ua.yurii.zhurakovskyi.service.CartService;
import ua.yurii.zhurakovskyi.service.ProductService;
import ua.yurii.zhurakovskyi.service.impl.CartServiceImpl;
import ua.yurii.zhurakovskyi.service.impl.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/carts")
public class CartsController extends HttpServlet {
    private CartService cartService = CartServiceImpl.getCartServiceImpl();
    private ProductService productService = ProductServiceImpl.getProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Cart> carts = cartService.readAll();
        Map<Integer, Product> idToProduct = productService.readAllMap();
        List<CartDto> listOfCartDtos = map(carts, idToProduct);
        String json = new Gson().toJson(listOfCartDtos);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

    public List<CartDto> map(List<Cart> carts, Map<Integer, Product> idToProduct) {
        return carts.stream().map(cart -> {
            CartDto cartDto = new CartDto();
            cartDto.cartId = cart.getId();
            cartDto.purchaseDate = cart.getPurchaseDate();
            Product product = idToProduct.get(cart.getProductId());
            cartDto.name = product.getName();
            cartDto.description = product.getDescription();
            cartDto.price = product.getPrice();
            return cartDto;
        }).collect(Collectors.toList());
    }


}
