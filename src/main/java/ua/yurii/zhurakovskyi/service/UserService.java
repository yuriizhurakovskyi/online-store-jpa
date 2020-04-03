package ua.yurii.zhurakovskyi.service;

import ua.yurii.zhurakovskyi.domain.User;
import ua.yurii.zhurakovskyi.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
    User readUserByEmail(String email);
}
