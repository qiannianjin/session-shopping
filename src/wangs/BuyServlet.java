package wangs;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangs on 2017/2/23.
 */
public class BuyServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String id = request.getParameter("id");
        Book book = (Book)Db.getAll().get(id);

        HttpSession session = request.getSession(false);
        //手工以cookie形式发送sessionId，已解决关闭浏览器后，上次买的东西消失的问题
        //从Session得到用户用于保存所有书的集合（购物车）
        List list = (List) session.getAttribute("list");
        if (list == null) {
            list = new ArrayList<>();
            session.setAttribute("list", list);
        }
        list.add(book);
        String url = response.encodeRedirectURL(request.getContextPath() + "/ListCarServlet");
        response.sendRedirect(url);
    }
}
