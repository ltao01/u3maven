package user.web;

import user.bean.User;
import user.service.IUserservice;
import user.service.UserserviceImpl;
import user.util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class selectServlet extends HttpServlet {
    IUserservice service=new UserserviceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //新增
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        User user = JdbcUtil.tobean(User.class, map);
        System.out.println(user.toString2());
      int i=  service.add(user);
      request.getSession().setAttribute("add",i==1?"新增成功":"新增失败");
        response.sendRedirect("/show");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//查询单行多列

        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
       User list = service.selectId(i);

        request.getSession().setAttribute("list1",list);

       response.sendRedirect("alter.jsp");
    }
}


