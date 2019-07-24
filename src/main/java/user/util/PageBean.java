package user.util;

public class PageBean {
    //1，分页的四大参数
    private  int currPage=1;//当前页
    private  int size=5;  //每页显示的记录数
    private  int totalPage;//总页数
    private  int count; //总记录数  select  count(*) from emp


    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
