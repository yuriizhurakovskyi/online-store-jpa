package ua.yurii.zhurakovskyi.service.impl;

import java.util.List;

import ua.yurii.zhurakovskyi.dao.CartDao;
import ua.yurii.zhurakovskyi.dao.impl.CartDaoImpl;
import ua.yurii.zhurakovskyi.domain.Cart;
import ua.yurii.zhurakovskyi.service.CartService;

public class CartServiceImpl implements CartService {
	private CartDao cartDao;
	private static CartService cartServiceImpl;

	public static CartService getCartServiceImpl() {
		if (cartServiceImpl == null)
			cartServiceImpl = new CartServiceImpl();
		return cartServiceImpl;
	}

	private CartServiceImpl() {
		cartDao = new CartDaoImpl();
	}

	@Override
	public Cart create(Cart cart) {
		return cartDao.create(cart);
	}

	@Override
	public Cart read(Integer id) {
		return cartDao.read(id);
	}

	@Override
	public Cart update(Cart cart) {
		return cartDao.update(cart);
	}

	@Override
	public void delete(Integer id) {
		cartDao.delete(id);
	}

	@Override
	public List<Cart> readAll() {
		return cartDao.readAll();
	}
}
