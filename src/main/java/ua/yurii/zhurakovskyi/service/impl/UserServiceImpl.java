package ua.yurii.zhurakovskyi.service.impl;

import java.util.List;

import ua.yurii.zhurakovskyi.dao.UserDao;
import ua.yurii.zhurakovskyi.dao.impl.UserDaoImpl;
import ua.yurii.zhurakovskyi.domain.User;
import ua.yurii.zhurakovskyi.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao;
    private static UserService userServiceImpl;

    public static UserService getUserServiceImpl() {
        if (userServiceImpl == null)
            userServiceImpl = new UserServiceImpl();
        return userServiceImpl;
    }

    private UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User create(User t) {
        return userDao.create(t);
    }

    @Override
    public User read(Integer id) {
        return userDao.read(id);
    }

    @Override
    public User update(User t) {
        return userDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public List<User> readAll() {
        return userDao.readAll();
    }

    @Override
    public User readUserByEmail(String email) {
        return userDao.readUserByEmail(email);
    }
}
