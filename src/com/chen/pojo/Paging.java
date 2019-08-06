package com.chen.pojo;

import java.util.ArrayList;
import java.util.List;

public class Paging {
    private int page = 0;//当前页
    private int pagesize;//页面数据条数
    private int indexpage = 1;//首页
    private int endpage;//尾页
    private int count;//总数据条数
    private int pagenumber;//总页面数
    private List<GoodsType> list;//得到的数据放入list集合中

    public List<GoodsType> getResultList() {
        return resultList;
    }

    public void setResultList(List<GoodsType> resultList) {
        this.resultList = resultList;
    }

    private List<GoodsType> resultList;//分页list
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPagesize() {
        return pagesize;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
    public int getIndexpage() {
        return indexpage;
    }
    public void setIndexpage(int indexpage) {
        this.indexpage = indexpage;
    }
    public int getEndpage() {

        return endpage;
    }
    public void setEndpage() {
        this.endpage=pagenumber;
    }
    public int getCount() {
        this.count=list.size();
        return count;
    }
    public void setCount() {
        this.count=list.size();
    }

    public int getPagenumber() {
        return pagenumber;
    }
    public void setPagenumber() {
        this.pagenumber=(count%pagesize==0)?count/pagesize:count/pagesize+1;
    }
    public List<GoodsType> getList() {
        return list;
    }
    public void setList(List<GoodsType> list) {
        this.list = list;
    }

    public Paging(String str_page, List<GoodsType> list) {
        this.setList(list);//从数据库得到数据存入的list集合
        this.setCount();//数据总数
        this.setPagesize(10);//一个页面的数据多少条
        this.setPagenumber();//总的页面数
        this.setEndpage();//最后一页
        this.setIndexpage(1);//第一页
        if (str_page!=null) {
            //将页转换整型判断其大小
            int pag=Integer.parseInt(str_page);
            //当大于零，将传过来的pag值赋给当前页page
            if (pag>=0) {
                page=pag;
                //如果小于最大值时则，将其传过来的值减1在赋值给当前页，让其一直在最后一页
                if (pag>(this.getPagenumber()-1)) {
                    page=pag-1;
                }
            }
        }
        List<GoodsType> list_page =new ArrayList<>();
        //将当前页的值传给新的list_page集合中，list集合是全部数据综合，用i调用其中的几条数据给list_page
        for (int i = this.getPage()*this.getPagesize(); i <(this.getPage()+1)*this.getPagesize()&&i<list.size(); i++) {
            list_page.add(list.get(i));
        }
        this.setResultList(list_page);
        this.setPage(page);//最终确认当前页
    }
}
