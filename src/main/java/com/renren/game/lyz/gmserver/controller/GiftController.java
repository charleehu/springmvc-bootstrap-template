/**
 * $Id: GiftController.java 18373 2013-11-25 12:48:30Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.renren.game.lyz.gmserver.service.GiftService;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-11-19 下午02:16:40
 * @since 1.0
 */
@Controller
public class GiftController {
    @Autowired private GiftService giftService;

    @RequestMapping(value="/sys/gift", method=RequestMethod.GET)
    public String gift(ModelMap model) {
        JSONArray jarr = new JSONArray();
        for (Object o : giftService.getItemType()) {
            Iterator<Object> iterator = ((Collection<Object>) o).iterator();
            
            JSONObject jo = new JSONObject();
            jo.put("id", iterator.next());
            jo.put("name", iterator.next());
            jarr.add(jo);
        }
        model.put("items", jarr);
        
        System.out.println(System.getProperty("jdbc.user"));
        return "gift";
    }
    
    @RequestMapping(value="/log/gift", method=RequestMethod.GET)
    public String giftList(ModelMap model, HttpServletRequest request) {
        String date = request.getParameter("date");
        String suserId = request.getParameter("userId");
        Long userId = StringUtils.isEmpty(suserId) ? null : Long.parseLong(suserId);
        String spage = request.getParameter("page");
        long page = StringUtils.isEmpty(spage) ? 1 : Long.parseLong(spage);
        
        if (date == null) date = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        model.put("listLogGift", giftService.getLogGift(date, userId, page));
        model.put("date", date);
        model.put("userId", userId);
        model.put("page", page);
        return "giftList";
    }
    
    @RequestMapping(value="/sys/gift/subtype")
    public String subtype(ModelMap model, @RequestParam("type")int type) {
        JSONArray jarr = new JSONArray();
        for (Object o : giftService.getItemByType(type)) {
            Iterator<Object> iterator = ((Collection<Object>) o).iterator();
            
            JSONObject jo = new JSONObject();
            jo.put("id", iterator.next());
            jo.put("name", iterator.next());
            jarr.add(jo);
        }
        System.out.println(jarr);
        model.put("ajax", jarr);
        return "ajax";
    }
    
    @RequestMapping(value="/sys/gift/send")
    public String send(ModelMap model, 
            @RequestParam("title")String subject,
            @RequestParam("giftList")String giftList,
            @RequestParam("giftListShow")String giftListShow,
            @RequestParam("receiver")String receiver,
            @RequestParam("reciverRadio")String receiverRadio) {
        
        List<Long> successedList = null;
        if(receiverRadio.equals("false")){
            successedList = giftService.sendGift(subject, giftList, receiver);
        }
        else {
            successedList = giftService.sendGiftToAll(subject, giftList);
        }
        giftService.addLogGift(successedList, subject, giftListShow);
        return "ajax";
    }
    
}
