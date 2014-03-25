/**
 * $Id: UserInfoDao.java 18178 2013-11-19 11:05:36Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-1-5 上午10:38:54
 * @since 1.0
 */
@Repository
public class UserInfoDao {
    @Autowired private JdbcTemplate jdbcTemplate;

    /**
     * 查玩家总数
     * @return
     */
    public List<Long> getUserId() {
        return jdbcTemplate.query("select user_id from games_kp.user_info", new RowMapper<Long>(){

            @Override
            public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getLong("user_id");
            }
            
        });
    }
    

}
