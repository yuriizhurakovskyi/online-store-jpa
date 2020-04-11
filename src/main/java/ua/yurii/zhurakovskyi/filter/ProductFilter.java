package ua.yurii.zhurakovskyi.filter;

import ua.yurii.zhurakovskyi.domain.UserRole;
import ua.yurii.zhurakovskyi.shared.FilterService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/product")
public class ProductFilter implements Filter {

    private final FilterService filterService = FilterService.getFilterService();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        filterService.doFilterValidation(request, response, chain, Arrays.asList(UserRole.USER));
    }

    @Override
    public void destroy() {

    }
}
