package wangs;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by wangs on 2017/2/23.
 * 购物车功能
 */
public class ListCarServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session == null) {
            out.write("您没有购过任何商品<br/>");
            return;
        }

        out.write("您购买了如下商品：<br/>");
        List<Book> list = (List) session.getAttribute("list");
        for (Book book : list) {
            out.write(book.getName()+"<br/>");
        }
    }
}
