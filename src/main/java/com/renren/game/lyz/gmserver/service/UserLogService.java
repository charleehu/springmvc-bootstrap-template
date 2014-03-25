/**
 * $Id: UserLogService.java 18370 2013-11-25 11:53:21Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renren.game.lyz.gmserver.dao.UserLogDao;
import com.renren.game.lyz.gmserver.utils.CollectionUtils;
import com.renren.game.lyz.gmserver.utils.PageUtil;

/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-11-25 下午06:24:47
 * @since 1.0
 */
@Service
public class UserLogService {

    @Autowired
    private UserLogDao userLogDao;

    /**
     * @param date
     * @param userId
     * @param page
     * @return
     */
    public List<Object> getLog(String type, String date, Long userId, long page) {

        try {
            long c = userLogDao.count(type, date, userId);

            PageUtil pu = PageUtil.build(c, page);
            return userLogDao.getLog(type, date, userId, pu.getPos(), pu.getLimit());
        }
        catch (Exception e) {
            e.printStackTrace();
            return CollectionUtils.newArrayList();
        }
    }

}
