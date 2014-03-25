package com.renren.game.lyz.gmserver.domain;

/**
 * generate by t2d
 */

import java.io.Serializable;
import java.util.Date;

public class SysBroadcast implements Serializable {

    private static final long serialVersionUID = -8857065201031155492L;

    private int id;

    private String content;

    private String desc;

    private Date startTime;

    private Date endTime;

    private int isValid;

    private Date createTime;

    private String operateUser;

    public SysBroadcast() {
    }

    public SysBroadcast(String content, Date startTime, Date endTime, int isValid) {
        super();
        this.content = content;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isValid = isValid;
    }

    public SysBroadcast(int id, String content, Date startTime, Date endTime, int isValid) {
        super();
        this.id = id;
        this.content = content;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isValid = isValid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser;
    }

    public String getOperateUser() {
        return operateUser;
    }

}
