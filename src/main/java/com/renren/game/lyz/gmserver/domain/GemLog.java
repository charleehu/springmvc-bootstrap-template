package com.renren.game.lyz.gmserver.domain;
public class GemLog extends BaseLog{
	
	private Integer current;
	private Integer addGem;
	private int gemType;
	
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		this.current = current;
	}
	public Integer getAddGem() {
		return addGem;
	}
	public void setAddGem(Integer addGem) {
		this.addGem = addGem;
	}
    
    public int getGemType() {
        return gemType;
    }
    
    public void setGemType(int gemType) {
        this.gemType = gemType;
    }

}

