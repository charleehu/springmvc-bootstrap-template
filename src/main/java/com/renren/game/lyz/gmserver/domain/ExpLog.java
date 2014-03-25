package com.renren.game.lyz.gmserver.domain;
public class ExpLog extends BaseLog{
	private Integer level;
	private Integer curExp;
	private Integer addExp;
	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getCurExp() {
		return curExp;
	}
	public void setCurExp(Integer curExp) {
		this.curExp = curExp;
	}
	public Integer getAddExp() {
		return addExp;
	}
	public void setAddExp(Integer addExp) {
		this.addExp = addExp;
	}
}
