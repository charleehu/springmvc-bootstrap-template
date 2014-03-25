/**
 * $Id: SysBroadcastService.java 18138 2013-11-19 05:38:35Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renren.game.lyz.gmserver.dao.SysBroadcastDao;
import com.renren.game.lyz.gmserver.domain.SysBroadcast;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-11-8 下午05:59:34
 * @since 1.0
 */
@Service
public class SysBroadcastService {

    @Autowired SysBroadcastDao sysBroadcastDao;
    
    public List<SysBroadcast> queryAll() {
        return sysBroadcastDao.queryAll();
    }

    /**
     * @param sysBroadcast
     */
    public void addBroadcast(SysBroadcast sysBroadcast) {
        sysBroadcastDao.insert(sysBroadcast);
        
        sendClearSysBroadcastCacheCmd();
    }

    /**
     * @param id
     */
    public void delBroadcast(int id) {
        sysBroadcastDao.delete(id);
        
        sendClearSysBroadcastCacheCmd();
    }

    /**
     * @param sysBroadcast
     */
    public void updateBroadcast(SysBroadcast sysBroadcast) {
        sysBroadcastDao.update(sysBroadcast);
        
        sendClearSysBroadcastCacheCmd();
    }
    
    public void sendClearSysBroadcastCacheCmd() {
        
        CmdManageService.sendCmd(CmdManageService.CLEAR_GLOBAL_CACHE, "SYS_BROADCAST");
    }
}
