package ua.yurii.zhurakovskyi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.yurii.zhurakovskyi.domain.User;
import ua.yurii.zhurakovskyi.domain.UserRole;
import ua.yurii.zhurakovskyi.service.UserService;
import ua.yurii.zhurakovskyi.service.impl.UserServiceImpl;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService = UserServiceImpl.getUserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        if (!email.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty()) {
            userService.create(new User(email, firstName, lastName, UserRole.USER.name(), password));
        }
        request.setAttribute("userEmail", email);
        request.getRequestDispatcher("cabinet.jsp").forward(request, response);
    }

}
