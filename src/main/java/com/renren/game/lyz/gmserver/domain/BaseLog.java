package com.renren.game.lyz.gmserver.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseLog {
	private Integer logUid;
	private Integer regionId;
	private Integer serverId;
	

	private Long charId;
	private String charName;
	private Integer reason;
	private long logTime;
	private String logDate;
	private String reasonName;
	
	
	public String getReasonName() {
		return reasonName;
	}
	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public long getLogTime() {
		return logTime;
	}
	public void setLogTime(long logTime) {
		this.logTime = logTime;
		
		if(logTime > 0) {
			Date date = new Date(logTime);
			setLogDate(sdf.format(date));
		}
		
	}
	
	public Integer getServerId() {
		return serverId;
	}
	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	public Integer getReason() {
		return reason;
	}
	public void setReason(Integer reason) {
		this.reason = reason;
	}
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public Integer getLogUid() {
		return logUid;
	}
	public void setLogUid(Integer logUid) {
		this.logUid = logUid;
	}
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	
	public Long getCharId() {
		return charId;
	}
	public void setCharId(Long charId) {
		this.charId = charId;
	}
	public String getCharName() {
		return charName;
	}
	public void setCharName(String charName) {
		this.charName = charName;
	}
}

