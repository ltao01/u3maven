package user.bean;

import java.sql.Date;

public class User {
    private int id;
    private String name;
    private int age;
    private String sex;
    private Date birth;
    private  int salary;
    private int deptId;
//员工表和部门表做逻辑外键关联
    private  Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
    public  String toString1(){
        return name  + "," + age + "," + sex  + "," + birth + "," + salary + "," + deptId+"," +id;
    }
    public  String toString2(){
        return name  + "," + age + "," + sex  + "," + birth + "," + salary + "," + deptId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", salary=" + salary +
                ", deptId=" + deptId +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
