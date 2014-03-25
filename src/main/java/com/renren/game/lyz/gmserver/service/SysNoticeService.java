/**
 * $Id: SysNoticeService.java 18138 2013-11-19 05:38:35Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.service;

import java.util.List;

import org.springframework.stereotype.Service;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-11-19 下午01:04:29
 * @since 1.0
 */
@Service
public class SysNoticeService {

    public String getSysNotice() {
        List<Object> res = CmdManageService.sendCmd(CmdManageService.GET_SYS_NOTICE);
        return (String) res.get(0);
    }

    /**
     * @param content
     */
    public void updateSysNotice(String content) {
        CmdManageService.sendCmd(CmdManageService.UPDATE_SYS_NOTICE, content);
    }
}
