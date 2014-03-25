/**
 * $Id: UserLoginController.java 17239 2013-09-24 08:22:38Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.renren.game.lyz.gmserver.domain.User;
import com.renren.game.lyz.gmserver.service.UserService;
import com.renren.game.lyz.gmserver.utils.UserUtils;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-9-23 下午09:00:45
 * @since 1.0
 */
@Controller
public class UserLoginController {
    
    @Autowired private UserService userService;
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginPage(ModelMap model) {
        System.out.println("#########");
        return "login";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(HttpSession session, @RequestParam("username")String username, @RequestParam("password")String password) {
        
        if (userService.checkUser(username, password)) {
            UserUtils.setCurrentUser(session, new User());
            return "redirect:/home";
        }
        
        return null;
    }
    
    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(HttpSession session) {
        UserUtils.clearCurrentUser(session);
        return "login";
    }
    
    @RequestMapping(value={"/home", "/"}, method=RequestMethod.GET)
    public String home() {
        return "home";
    }
}
