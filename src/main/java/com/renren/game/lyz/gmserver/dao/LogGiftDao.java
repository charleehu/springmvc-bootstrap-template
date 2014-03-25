/**
 * $Id: LogGiftDao.java 18348 2013-11-25 09:11:56Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.renren.game.lyz.gmserver.domain.LogGift;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-2-1 下午03:27:14
 * @since 1.0
 */
@Repository
public class LogGiftDao {
    @Autowired private JdbcTemplate jdbcTemplate;

    /**
     * @param listLogGift
     */
    public void addLogGift(final LogGift logGift) {
        
        jdbcTemplate.update("insert into games_kp.log_gift(to_user_id,subject,gift,send_time) values(?,?,?,?)", new PreparedStatementSetter() {
            
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setLong(1, logGift.getToUserId());
                ps.setString(2, logGift.getSubject());
                ps.setString(3, logGift.getGift());
                ps.setTimestamp(4, new Timestamp(logGift.getSendTime().getTime()));
            }
        });
    }

    /**
     * @param date
     * @param userId
     * @return
     */
    public List<LogGift> queryLogGift(String date, Long userId, long pos, long limit) {
        String sql = "select id,to_user_id,subject,gift,send_time from games_kp.log_gift where ";
        if (date != null) sql += " date(send_time)='" + date + "' ";
        if (userId != null) sql += " and to_user_id=" + userId;
        sql += " order by id desc limit " + pos + ", " + limit;
        
        return jdbcTemplate.query(sql, new RowMapper<LogGift>(){

            @Override
            public LogGift mapRow(ResultSet rs, int rowNum) throws SQLException {
                LogGift o = new LogGift();
                o.setId(rs.getLong(1));
                o.setToUserId(rs.getLong(2));
                o.setSubject(rs.getString(3));
                o.setGift(rs.getString(4));
                o.setSendTime(rs.getTimestamp(5));
                return o;
            }
            
        });
    }
    
    public long coutLogGift(String date, Long userId) {
        String sql = "select count(*) from games_kp.log_gift where ";
        if (date != null) sql += " date(send_time)='" + date + "' ";
        if (userId != null) sql += " and to_user_id=" + userId;
        
        return jdbcTemplate.queryForObject(sql, Long.class);
    }
    
}
