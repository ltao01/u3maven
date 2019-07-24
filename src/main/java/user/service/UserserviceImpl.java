package user.service;

import user.bean.User;
import user.dao.IUserDao;
import user.dao.UserDaoImpl;
import user.util.PageBean;

import java.util.List;

public class UserserviceImpl implements IUserservice {
    IUserDao dao=new UserDaoImpl();


    @Override
    public int delectId(int id) {
        return dao.delectId(id);
    }

    @Override
    public int alter(User id) {
        return dao.alter(id);
    }

    @Override
    public User selectId(int id) {
        return  dao.selectId(id);
    }

    @Override
    public int add(User user) {
        return dao.add(user);
    }

    @Override
    public List<User> selectAll(PageBean page) {
        //查询所有的记录数  算出 总页数
        int count=dao.selectCount(page);//select count(*) from emp
        int size = page.getSize();
        int totalPage=count%size==0?(count/size):(count/size+1);
        //将总记录数和总页数  存进page对象中
        page.setCount(count);
        page.setTotalPage(totalPage);

        return dao.selectAll(page);//查询总记录数
    }

}

