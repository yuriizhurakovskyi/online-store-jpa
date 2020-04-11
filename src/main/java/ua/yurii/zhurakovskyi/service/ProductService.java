package ua.yurii.zhurakovskyi.service;

import ua.yurii.zhurakovskyi.domain.Product;
import ua.yurii.zhurakovskyi.shared.AbstractCRUD;

import java.util.Map;

public interface ProductService extends AbstractCRUD<Product> {
    Map<Integer, Product> readAllMap();
}
