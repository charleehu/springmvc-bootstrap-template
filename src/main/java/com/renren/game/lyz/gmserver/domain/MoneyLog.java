package com.renren.game.lyz.gmserver.domain;


public class MoneyLog extends BaseLog{
	
	private Integer current;
	private Integer addGold;
	
	
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		this.current = current;
	}
	public Integer getAddGold() {
		return addGold;
	}
	public void setAddGold(Integer addGold) {
		this.addGold = addGold;
	}
	
}

