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

public class deleteServlet extends HttpServlet {
    IUserservice service=new UserserviceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //修改
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> map = request.getParameterMap();
        User user1 = JdbcUtil.tobean(User.class, map);
        System.out.println(user1.getId());
        int i= service.alter(user1);
        request.getSession().setAttribute("alter",i==1?"修改成功":"修改失败");
        response.sendRedirect("/show");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //删除
        String id = request.getParameter("id");
        int i1 = Integer.parseInt(id);
        int i= service.delectId(i1);
           request.getSession().setAttribute("delete",i==1?"删除成功":"删除失败");
           response.sendRedirect("/show");
    }
}
