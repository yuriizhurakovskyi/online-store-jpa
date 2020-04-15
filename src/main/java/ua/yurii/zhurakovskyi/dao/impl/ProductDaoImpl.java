package ua.yurii.zhurakovskyi.dao.impl;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ua.yurii.zhurakovskyi.dao.ProductDao;
import ua.yurii.zhurakovskyi.domain.Product;
import ua.yurii.zhurakovskyi.shared.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ProductDaoImpl implements ProductDao {
    private EntityManager em = FactoryManager.getEntityManager();
    private static Logger LOGGER = LogManager.getLogger(ProductDaoImpl.class);

    @Override
    public Product create(Product product) {
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return product;
    }

    @Override
    public Product read(Integer id) {
        Product product = null;
        try {
            product = em.find(Product.class, id);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        return product;
    }

    @Override
    public void delete(Integer id) {
        try{
            Product product = read(id);
            em.getTransaction().begin();
            em.remove(product);
            em.getTransaction().commit();
        }catch (Exception e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Product> readAll() {
        Query query = null;
        try {
            query = em.createQuery("SELECT e FROM Product e");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (List<Product>) query.getResultList();
    }

}
