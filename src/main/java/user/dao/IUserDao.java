package user.dao;

import user.bean.User;
import user.util.PageBean;

import java.util.List;

public interface IUserDao {

  ;

    int delectId(int id);

    int alter(User id);

    User selectId(int id);

    int add(User user);

    int selectCount(PageBean page);

    List<User> selectAll(PageBean page);
}
