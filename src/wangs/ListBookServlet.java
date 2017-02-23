package wangs;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangs on 2017/2/23.
 * 展示所有的商品
 */
@javax.servlet.annotation.WebServlet(name = "ListBookServlet")
public class ListBookServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        request.getSession();

        out.print("本网站有如下商品：<br/>");
        Map<String, Book> map = Db.getAll();
        for (Map.Entry<String, Book> entry : map.entrySet()) {
            Book book = entry.getValue();
            String url = response.encodeURL("/session-shopping/BuyServlet?id=" + book.getId());
            out.print(book.getName() + "<a href='" + url +"' target='_blank'>购买</a><br>");
        }

    }
}

//简单模拟数据库的数据
class Db {
    private static Map<String, Book> map = new HashMap<>();

    static {
        map.put("1", new Book("1", "JavaWeb开发", "小明", "编程类书籍"));
        map.put("2", new Book("2", "JDBC开发", "小明", "编程类书籍"));
        map.put("3", new Book("3", "Spring开发", "小明", "编程类书籍"));
        map.put("4", new Book("4", "Struts开发", "小明", "编程类书籍"));
        map.put("5", new Book("5", "Android开发", "小明", "编程类书籍"));
    }

    public static Map getAll() {
        return map;
    }
}

class Book implements Serializable{
    private String id;
    private String name;
    private String author;
    private String description;

    public Book() {
        super();
    }

    public Book(String id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
