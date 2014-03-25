/**
 * $Id: LogGift.java 18198 2013-11-20 06:10:17Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-2-1 下午03:25:53
 * @since 1.0
 */
public class LogGift implements Serializable {

    private static final long serialVersionUID = -8724342657446433797L;

    private long id;

    private long toUserId;

    private String subject;

    private String gift;

    private Date sendTime;

    private String operateUser;

    public LogGift() {
        super();
    }

    public LogGift(long toUserId, String subject, String gift, Date date) {
        super();
        this.toUserId = toUserId;
        this.subject = subject;
        this.gift = gift;
        this.sendTime = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser;
    }

}
