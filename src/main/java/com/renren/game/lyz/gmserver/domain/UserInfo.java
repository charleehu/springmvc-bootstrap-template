/**
 * $Id: UserInfo.java 18178 2013-11-19 11:05:36Z xiaowei.hu $
 * Copyright 2012-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.domain;

import java.util.Date;

/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2012-7-9 下午04:05:05
 * @since 1.0
 */

public class UserInfo {

    private static final long serialVersionUID = 6101632051290242521L;

    //用户id
    private long userId;

    //用户名
    private String name;

    //等级
    private int level;

    //经验
    private int exp;

    //体力(PVE)
    private int stamina;

    //精力(PVP)
    private int energy;

    //金币数
    private long money;

    //友情点
    private long friendPoint;

    //性别
    private int gender;

    //头像
    private String headUrl;

    //用户数据初始化tag
    private long initStep;

    //更新时间
    private Date upTime;

    //建立时间
    private Date createTime;

    //背包扩展数
    private int expandPack;

    //宝石数
    private int gem;

    //有价宝石数
    private int rechargeGem;

    //阵营
    private int guild;

    //签名
    private String signature;

    //新手引导
    private long guideStep;

    //玩家是否删除
    private int isDeleted;

    private long rrid;

    //扩充好友
    private int expandFriendNum;

    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getExpandPack() {
        return expandPack;
    }

    public void setExpandPack(int expandPack) {
        this.expandPack = expandPack;
    }

    public int getGem() {
        return gem;
    }

    public void setGem(int gem) {
        this.gem = gem;
    }

    /**
     * @return the money
     */
    public long getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(long money) {
        this.money = money;
    }

    /**
     * @return the friendPoint
     */
    public long getFriendPoint() {
        return friendPoint;
    }

    /**
     * @param friendPoint the friendPoint to set
     */
    public void setFriendPoint(long friendPoint) {
        this.friendPoint = friendPoint;
    }

    public int getGuild() {
        return guild;
    }

    public void setGuild(int guild) {
        this.guild = guild;
    }

    /**
     * @return the initStep
     */
    public long getInitStep() {
        return initStep;
    }

    /**
     * @param initStep the initStep to set
     */
    public void setInitStep(long initStep) {
        this.initStep = initStep;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "UserInfo [userId=" + userId + ", name=" + name + ", level=" + level + ", exp="
                + exp + ", stamina=" + stamina + ", energy=" + energy + ", money=" + money
                + ", friendPoint=" + friendPoint + ", gender=" + gender + ", headUrl=" + headUrl
                + ", initStep=" + initStep + ", upTime=" + upTime + ", createTime=" + createTime
                + ", expandPack=" + expandPack + ", gem=" + gem + ", guild=" + guild
                + ", signature=" + signature + "]";
    }

    public long getGuideStep() {
        return guideStep;
    }

    public void setGuideStep(long guideStep) {
        this.guideStep = guideStep;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public long getRrid() {
        return rrid;
    }

    public void setRrid(long rrid) {
        this.rrid = rrid;
    }

    public int getExpandFriendNum() {
        return expandFriendNum;
    }

    public void setExpandFriendNum(int expandFriendNum) {
        this.expandFriendNum = expandFriendNum;
    }

    public int getRechargeGem() {
        return rechargeGem;
    }

    public void setRechargeGem(int rechargeGem) {
        this.rechargeGem = rechargeGem;
    }

}
