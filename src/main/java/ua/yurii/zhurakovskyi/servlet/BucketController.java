package ua.yurii.zhurakovskyi.servlet;

import ua.yurii.zhurakovskyi.domain.Bucket;
import ua.yurii.zhurakovskyi.service.BucketService;
import ua.yurii.zhurakovskyi.service.impl.BucketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {
    private BucketService bucketService = BucketServiceImpl.getBucketServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productId");
        HttpSession session = req.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        Bucket bucket = new Bucket(userId, Integer.parseInt(productId), new Date());
        bucketService.create(bucket);
        resp.setContentType("text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }
}
