/**
 * $Id: SysNoticeController.java 18373 2013-11-25 12:48:30Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.renren.game.lyz.gmserver.service.SysNoticeService;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-11-18 下午07:27:05
 * @since 1.0
 */
@Controller
public class SysNoticeController {
    @Autowired private SysNoticeService sysNoticeService;
    
    @RequestMapping(value="/sys/notice", method=RequestMethod.GET)
    public String list(ModelMap model) {
        model.put("notice", sysNoticeService.getSysNotice());
        return "notice";
    }
    
    @RequestMapping(value="/sys/notice/update")
    public String update(ModelMap model, @RequestParam("content") String content) {
        sysNoticeService.updateSysNotice(content);
        return "ajax";
    }
}
