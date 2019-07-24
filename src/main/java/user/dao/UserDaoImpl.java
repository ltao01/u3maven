package user.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import user.bean.Dept;
import user.bean.User;
import user.util.JdbcUtil;
import user.util.PageBean;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {



    //删除
    @Override
    public int delectId(int id) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            return qr.update("delete  from user where id=?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //修改
    @Override
    public int alter(User id) {

        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

        try {
            return qr.update("update user set name=?,age=?,sex=?,birth=?,salary=?,deptId=? where id=?", id.toString1().split(","));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public User selectId(int id) {
        //查询单行多列
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {
            return qr.query("select * from user where id=?", new BeanHandler<User>(User.class), id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int add(User user) {
        //新增
        QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
        try {//查询出的总记录数是Long类型 使用inValue().转换成int
            System.out.println(user.toString2());
            return runner.update("insert into user (name,age,sex,birth,salary,deptId) values(?,?,?,?,?,?)", user.toString2().split(","));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int selectCount(PageBean page) {
        //查询总记录数
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try {

            return qr.query("select  count(*) from user",new ScalarHandler<Long>()).intValue();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> selectAll(PageBean page) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        try{
        int startRow=(page.getCurrPage()-1)*page.getSize();
       List<User> list= qr.query( " select * from user limit ?,? ",new BeanListHandler<User>(User.class)
                , startRow, page.getSize());
        for(User o:list){
          Dept dept= qr.query(" select * from dept where id=? ",new BeanHandler<Dept>(Dept.class),o.getDeptId());
            o.setDept(dept);
        }
            return list;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
    }




