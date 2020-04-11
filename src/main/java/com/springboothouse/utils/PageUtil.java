package com.springboothouse.utils;

public class PageUtil {
    private Integer page=1; //接受页码
    private Integer rows=5; //页大小

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
