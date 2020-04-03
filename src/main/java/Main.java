import java.util.List;

import ua.yurii.zhurakovskyi.domain.User;
import ua.yurii.zhurakovskyi.service.UserService;
import ua.yurii.zhurakovskyi.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		UserService userService = UserServiceImpl.getUserServiceImpl();
		userService.create(new User("test@test.test", "test", "test", "test", "test"));
		List<User> users = userService.readAll();
		users.forEach(System.out::println);
		userService.delete(3);
		userService.delete(9);
		users = userService.readAll();
		System.out.println();
		users.forEach(System.out::println);
	}
}
