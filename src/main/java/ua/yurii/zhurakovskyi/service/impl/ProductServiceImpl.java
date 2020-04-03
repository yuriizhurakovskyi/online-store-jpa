package ua.yurii.zhurakovskyi.service.impl;

import java.util.List;

import ua.yurii.zhurakovskyi.dao.ProductDao;
import ua.yurii.zhurakovskyi.dao.impl.ProductDaoImpl;
import ua.yurii.zhurakovskyi.domain.Product;
import ua.yurii.zhurakovskyi.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	private static ProductService productServiceImpl;

	public static ProductService getProductServiceImpl() {
		if (productServiceImpl == null)
			productServiceImpl = new ProductServiceImpl();
		return productServiceImpl;
	}

	private ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}

	@Override
	public Product create(Product product) {
		return productDao.create(product);
	}

	@Override
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public Product update(Product product) {
		return productDao.update(product);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}
}
