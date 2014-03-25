/**
 * $Id: UserLogController.java 18370 2013-11-25 11:53:21Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.renren.game.lyz.gmserver.service.UserLogService;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-11-25 下午06:23:21
 * @since 1.0
 */
@Controller
public class UserLogController {
    @Autowired private UserLogService userLogService;

    @RequestMapping(value="/log/{type}")
    public String log(ModelMap model, HttpServletRequest request, @PathVariable(value="type") String type) {
        String date = request.getParameter("date");
        String suserId = request.getParameter("userId");
        Long userId = StringUtils.isEmpty(suserId) ? null : Long.parseLong(suserId);
        String spage = request.getParameter("page");
        long page = StringUtils.isEmpty(spage) ? 1 : Long.parseLong(spage);
        
        if (date == null) date = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        model.put("listLog", userLogService.getLog(type, date, userId, page));
        model.put("date", date);
        model.put("userId", userId);
        model.put("page", page);
        
        return "log/" + type;
    }
    
}
