/**
 * $Id: SysBroadcastController.java 18373 2013-11-25 12:48:30Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.renren.game.lyz.gmserver.domain.SysBroadcast;
import com.renren.game.lyz.gmserver.service.SysBroadcastService;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-11-8 下午05:26:05
 * @since 1.0
 */
@Controller
public class SysBroadcastController {
    @Autowired private SysBroadcastService sbService;
    
    @RequestMapping(value="/sys/broadcast", method=RequestMethod.GET)
    public String list(ModelMap model) {
        model.put("broadcasts", sbService.queryAll());
        model.put("now", new Date());
        return "broadcast";
    }
    
    @RequestMapping(value="/sys/broadcast/add", method=RequestMethod.POST)
    public String add(ModelMap model, 
            @RequestParam("content")String content,
            @RequestParam("state")int state,
            @RequestParam("start_time")@DateTimeFormat(pattern="MM/dd/yyyy hh:mm a")Date startTime,
            @RequestParam("end_time")@DateTimeFormat(pattern="MM/dd/yyyy hh:mm a")Date endTime) {
        sbService.addBroadcast(new SysBroadcast(content, startTime, endTime, state));
        return "ajax";
    }
    
    @RequestMapping(value="/sys/broadcast/update", method=RequestMethod.POST)
    public String update(ModelMap model, 
            @RequestParam("id")int id,
            @RequestParam("content")String content,
            @RequestParam("state")int state,
            @RequestParam("start_time")@DateTimeFormat(pattern="MM/dd/yyyy hh:mm a")Date startTime,
            @RequestParam("end_time")@DateTimeFormat(pattern="MM/dd/yyyy hh:mm a")Date endTime) {
        sbService.updateBroadcast(new SysBroadcast(id, content, startTime, endTime, state));
        return "ajax";
    }
    
    @RequestMapping(value="/sys/broadcast/del")
    public String del(ModelMap model, 
            @RequestParam("id")int id) {
        sbService.delBroadcast(id);
        return "ajax";
    }
}
