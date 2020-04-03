package ua.yurii.zhurakovskyi.dao;

import ua.yurii.zhurakovskyi.domain.User;
import ua.yurii.zhurakovskyi.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User> {
    User readUserByEmail(String email);
}
