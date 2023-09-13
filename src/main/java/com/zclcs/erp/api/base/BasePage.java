package com.zclcs.erp.api.base;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 分页对象
 *
 * @author zclcs
 */
@Getter
public class BasePage<T> {

    /**
     * 分页对象记录列表
     */
    protected List<T> list;

    /**
     * 总条数
     */
    protected long total;

    /**
     * 每页显示条数
     */
    protected int pageSize;

    /**
     * 当前页
     */
    protected int pageNum;

    /**
     * 总页数
     */
    protected int pages;

    public BasePage(Page<T> page) {
        this.pageNum = page.getNumber();
        this.pageSize = page.getSize();
        this.total = page.getTotalElements();
        this.pages = page.getTotalPages();
        this.list = page.getContent();
    }

}
