/**
 * $Id: UserUtils.java 17239 2013-09-24 08:22:38Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.utils;

import javax.servlet.http.HttpSession;

import com.renren.game.lyz.gmserver.domain.User;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-9-23 下午06:44:06
 * @since 1.0
 */
public class UserUtils {
    public static final String CURRENT_USER = "current_user";

    public static User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute(CURRENT_USER);
    }
    
    public static void setCurrentUser(HttpSession session, User user) {
        session.setAttribute(CURRENT_USER, user);
    }

    /**
     * @param session
     */
    public static void clearCurrentUser(HttpSession session) {
        session.removeAttribute(CURRENT_USER);
    }
}
