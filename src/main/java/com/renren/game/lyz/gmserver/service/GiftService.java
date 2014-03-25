/**
 * $Id: GiftService.java 18348 2013-11-25 09:11:56Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renren.game.lyz.gmserver.dao.LogGiftDao;
import com.renren.game.lyz.gmserver.dao.UserInfoDao;
import com.renren.game.lyz.gmserver.domain.LogGift;
import com.renren.game.lyz.gmserver.utils.ListUtil;
import com.renren.game.lyz.gmserver.utils.PageUtil;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-11-19 下午02:16:57
 * @since 1.0
 */
@Service
public class GiftService {
    @Autowired private UserInfoDao userInfoDao;
    @Autowired private LogGiftDao logGiftDao;

    public List<Object> getItemType() {
        return CmdManageService.sendCmd(CmdManageService.GET_ITEM_TYPE);
    }

    /**
     * @param type
     * @return
     */
    public List<Object> getItemByType(int type) {
        return CmdManageService.sendCmd(CmdManageService.GET_ITEM_BY_TYPE, type);
    }

    /**
     * @param subject
     * @param giftList
     * @param receiver
     * @return
     */
    public List<Long> sendGift(String subject, String giftList, String receiver) {
        List<Object> res = CmdManageService.sendCmd(CmdManageService.SEND_GIFT, ListUtil.string2LongList(receiver), subject, giftList);
        
        return ListUtil.obj2Long(res);
    }

    /**
     * @param subject
     * @param giftList
     * @return
     */
    public List<Long> sendGiftToAll(String subject, String giftList) {
        List<Object> res = new ArrayList<Object>();
        //一次请求的id数量
        int idCount = 5000;
        //查素有id
        List<Long> userIds = userInfoDao.getUserId();
//      ExecutorService e = Executors.newFixedThreadPool(threadTotal);
        int i = 0;
        while(i < userIds.size() / idCount + 1){
            List<Long> l = new ArrayList<Long>();
            for(int j = 0; j < idCount && (i * idCount + j) < userIds.size(); j++){
                long id = userIds.get(i * idCount + j).longValue();
                l.add(id);
            }
            res.addAll(CmdManageService.sendCmd(CmdManageService.SEND_GIFT, l, subject, giftList));
            i++;
        }
        return ListUtil.obj2Long(res);
    }
    
    /**
     * @param successedList
     * @param subject
     * @param giftListShow
     */
    public void addLogGift(List<Long> successedList, String subject, String giftListShow) {
        Date now = new Date();
        for (Long l : successedList) {
            logGiftDao.addLogGift(new LogGift(l, subject, giftListShow, now));
        }
    }

    /**
     * @param date
     * @param object
     */
    public List<LogGift> getLogGift(String date, Long userId, long page) {
        long c = logGiftDao.coutLogGift(date, userId);
        
        PageUtil pu = PageUtil.build(c, page);
        
        return logGiftDao.queryLogGift(date, userId, pu.getPos(), pu.getLimit());
    }

}
