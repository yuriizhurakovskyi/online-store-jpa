package ua.yurii.zhurakovskyi.dao.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ua.yurii.zhurakovskyi.dao.CartDao;
import ua.yurii.zhurakovskyi.domain.Cart;
import ua.yurii.zhurakovskyi.shared.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CartDaoImpl implements CartDao {
	private EntityManager em = FactoryManager.getEntityManager();
	private static Logger LOGGER = LogManager.getLogger(CartDaoImpl.class);


	@Override
	public Cart create(Cart cart) {
		try{
			em.getTransaction().begin();
			em.persist(cart);
			em.getTransaction().commit();
		}catch (Exception e){
			LOGGER.error(e);
		}
		return cart;
	}

	@Override
	public Cart read(Integer id) {
		Cart cart = null;
		try {
			cart = em.find(Cart.class, id);
		}catch (Exception e){
			LOGGER.error(e);
		}
		return cart;
	}

	@Override
	public Cart update(Cart cart) {
		throw new IllegalStateException("There is no update for bucket");
	}

	@Override
	public void delete(Integer id) {
		try{
			Cart cart = read(id);
			em.getTransaction().begin();
			em.remove(cart);
			em.getTransaction().commit();
		}catch (Exception e){
			LOGGER.error(e);
		}
	}

	@Override
	public List<Cart> readAll() {
		Query query = null;
		try{
			query = em.createQuery("SELECT e FROM Cart e");
		}catch (Exception e){
			LOGGER.error(e);
		}
		return query.getResultList();
	}

}
