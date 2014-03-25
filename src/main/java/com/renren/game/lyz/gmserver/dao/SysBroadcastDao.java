/**
 * $Id: SysBroadcastDao.java 18126 2013-11-18 10:58:57Z xiaowei.hu $
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

import com.renren.game.lyz.gmserver.domain.SysBroadcast;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-11-8 下午06:13:05
 * @since 1.0
 */
@Repository
public class SysBroadcastDao {

    @Autowired private JdbcTemplate jdbcTemplate;

    public List<SysBroadcast> queryAll() {
        return jdbcTemplate.query("select id,content,start_time,end_time,is_valid,create_time,operate_user from games_kp.sys_broadcast", new RowMapper<SysBroadcast>(){

            @Override
            public SysBroadcast mapRow(ResultSet rs, int rowNum) throws SQLException {
                SysBroadcast o = new SysBroadcast();
                o.setId(rs.getInt("id"));
                o.setContent(rs.getString("content"));
                o.setStartTime(rs.getTimestamp("start_time"));
                o.setEndTime(rs.getTimestamp("end_time"));
                o.setIsValid(rs.getInt("is_valid"));
                return o;
            }
            
        });
    }
    
    public void insert(final SysBroadcast sysBroadcast) {
        jdbcTemplate.update("insert into games_kp.sys_broadcast(content,start_time,end_time,is_valid,create_time,operate_user) values(?,?,?,?,now(),?)", new PreparedStatementSetter() {
            
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, sysBroadcast.getContent());
                ps.setTimestamp(2, new Timestamp(sysBroadcast.getStartTime().getTime()));
                ps.setTimestamp(3, new Timestamp(sysBroadcast.getEndTime().getTime()));
                ps.setInt(4, sysBroadcast.getIsValid());
                ps.setString(5, sysBroadcast.getOperateUser());
            }
        });
    }

    /**
     * @param id
     */
    public void delete(final int id) {
        jdbcTemplate.update("delete from games_kp.sys_broadcast where id=?", new PreparedStatementSetter() {
            
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, id);
            }
        });
    }

    /**
     * @param sysBroadcast
     */
    public void update(final SysBroadcast sysBroadcast) {
        jdbcTemplate.update("update games_kp.sys_broadcast set content=?, start_time=?, end_time=?, is_valid=? where id=?", new PreparedStatementSetter() {
            
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, sysBroadcast.getContent());
                ps.setTimestamp(2, new Timestamp(sysBroadcast.getStartTime().getTime()));
                ps.setTimestamp(3, new Timestamp(sysBroadcast.getEndTime().getTime()));
                ps.setInt(4, sysBroadcast.getIsValid());
                ps.setInt(5, sysBroadcast.getId());
            }
        });
    }
}
