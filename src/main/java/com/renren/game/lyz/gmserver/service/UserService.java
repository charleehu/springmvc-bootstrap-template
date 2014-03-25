/**
 * $Id: UserService.java 18335 2013-11-25 05:59:51Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.service;

import org.springframework.stereotype.Service;

import com.renren.game.lyz.gmserver.utils.SpringPropertiesUtil;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-9-24 下午04:04:02
 * @since 1.0
 */
@Service
public class UserService {

    /**
     * @param username
     * @param password
     * @return
     */
    public boolean checkUser(String username, String password) {
        return username.equals(SpringPropertiesUtil.getProperty("gm.user")) && password.equals(SpringPropertiesUtil.getProperty("gm.pwd"));
    }

    
}
