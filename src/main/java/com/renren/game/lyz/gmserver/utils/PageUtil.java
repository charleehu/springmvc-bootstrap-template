/**
 * $Id: PageUtil.java 18348 2013-11-25 09:11:56Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.utils;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-11-25 下午03:43:54
 * @since 1.0
 */
public class PageUtil {
    private long page;
    private long pages;
    
    private PageUtil(long count, long page) {
        super();
        this.page = page;
        this.pages = Math.round(count / 20.0);
        
        page = Math.min(page, pages);
        page = Math.max(page, 1);
    }

    public static PageUtil build(long count, long page) {
        return new PageUtil(count, page);
    }
    
    public long getPos() {
        return (page - 1) * 20;
    }
    
    public long getLimit() {
        return 20;
    }
}
