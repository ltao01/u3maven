package user.web;

import user.bean.User;
import user.service.IUserservice;
import user.service.UserserviceImpl;
import user.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class showServlet extends HttpServlet {

    IUserservice service=new UserserviceImpl();
    PageBean page = new PageBean();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currPage = request.getParameter("currPage");
        if (currPage!=null){
            page.setCurrPage(Integer.parseInt(currPage));
        }

      List<User> list= service.selectAll(page);

        request.getSession().setAttribute("page",page);

      request.getSession().setAttribute("list",list);

      response.sendRedirect("show.jsp");


    }
}
