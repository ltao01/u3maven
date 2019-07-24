package user.service;

import user.bean.User;
import user.util.PageBean;

import java.util.List;

public interface IUserservice {

   

    int delectId(int id);

    int alter(User id);

    User selectId(int id);

    int add(User user);

    List<User> selectAll(PageBean page);
}
