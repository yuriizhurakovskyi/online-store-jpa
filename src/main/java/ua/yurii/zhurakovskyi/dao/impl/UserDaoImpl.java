package ua.yurii.zhurakovskyi.dao.impl;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ua.yurii.zhurakovskyi.dao.UserDao;
import ua.yurii.zhurakovskyi.domain.User;
import ua.yurii.zhurakovskyi.shared.FactoryManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDaoImpl implements UserDao {

    private EntityManager em = FactoryManager.getEntityManager();
    private static Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);

    @Override
    public User create(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User read(Integer id) {
        User user = null;
        try {
            user = em.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User user) {
        return user;
    }

    @Override
    public void delete(Integer id) {
        try {
            User user = read(id);
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<User> readAll() {
        Query query = null;
        try {
            query = em.createQuery("SELECT e FROM User e");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (List<User>) query.getResultList();
    }

    @Override
    public User readUserByEmail(String email) {
        User user = null;
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> from = criteriaQuery.from(User.class);
            criteriaQuery.select(from);
            criteriaQuery.where(criteriaBuilder.equal(from.get("email"), email));
            TypedQuery<User> typedQuery = em.createQuery(criteriaQuery);
            user = typedQuery.getSingleResult();
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return user;
    }
}
