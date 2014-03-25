package com.renren.game.lyz.gmserver.domain;

public class ItemLog extends BaseLog{
	private Integer current;
	private Integer addNum;
	private Integer itemId;
	private String itemName;
	
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		this.current = current;
	}
	public Integer getAddNum() {
		return addNum;
	}
	public void setAddNum(Integer addNum) {
		this.addNum = addNum;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	

}

