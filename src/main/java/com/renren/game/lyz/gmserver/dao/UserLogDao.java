/**
 * $Id: UserLogDao.java 18374 2013-11-26 03:47:28Z xiaowei.hu $
 * Copyright 2013-2014 Oak Pacific Interactive. All rights reserved.
 */
package com.renren.game.lyz.gmserver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.renren.game.lyz.gmserver.domain.CardLog;
import com.renren.game.lyz.gmserver.domain.ExpLog;
import com.renren.game.lyz.gmserver.domain.FriendPointLog;
import com.renren.game.lyz.gmserver.domain.GemLog;
import com.renren.game.lyz.gmserver.domain.ItemLog;
import com.renren.game.lyz.gmserver.domain.MoneyLog;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2013-11-25 下午06:25:06
 * @since 1.0
 */
@Repository
public class UserLogDao {
    /** CmdManageService LOG */
    private static final Logger logger = LoggerFactory.getLogger("dao");
    
    @Autowired private JdbcTemplate jdbcTemplate;

    /**
     * @param type
     * @param date
     * @param userId
     * @return
     */
    public long count(String type, String date, Long userId) {
        String sql = "select count(*) from lyz_log." + type + "_log_" + date.replaceAll("-", "_") + " where 1=1";
        if (userId != null) sql += " and char_id=" + userId;
        
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    /**
     * @param type
     * @param date
     * @param userId
     * @param pos
     * @param limit
     * @return
     */
    public List<Object> getLog(final String type, String date, Long userId, long pos, long limit) {
        
        String sql = "select * from lyz_log." + type + "_log_" + date.replaceAll("-", "_") + " where 1=1";
        if (userId != null) sql += " and char_id=" + userId;
        sql += " order by log_time desc limit " + pos + ", " + limit;
        
        logger.debug(sql);
        return jdbcTemplate.query(sql, new RowMapper<Object>(){

            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object o = null;
                if (type.equals("gem")) {
                    GemLog oo = new GemLog();
                    oo.setLogUid(rs.getInt("log_uid"));
                    oo.setCharId(rs.getLong("char_id"));
                    oo.setCharName(rs.getString("char_name"));
                    oo.setLogTime(rs.getLong("log_time"));
                    oo.setReason(rs.getInt("reason"));
                    
                    oo.setCurrent(rs.getInt("current"));
                    oo.setAddGem(rs.getInt("add_gem"));
                    oo.setGemType(rs.getInt("gem_type"));
                    o = oo;
                }
                else if (type.equals("money")) {
                    MoneyLog oo = new MoneyLog();
                    oo.setLogUid(rs.getInt("log_uid"));
                    oo.setCharId(rs.getLong("char_id"));
                    oo.setCharName(rs.getString("char_name"));
                    oo.setLogTime(rs.getLong("log_time"));
                    oo.setReason(rs.getInt("reason"));
                    
                    oo.setCurrent(rs.getInt("current"));
                    oo.setAddGold(rs.getInt("add_gold"));
                    o = oo;
                }
                else if (type.equals("friendpoint")) {
                    FriendPointLog oo = new FriendPointLog();
                    oo.setLogUid(rs.getInt("log_uid"));
                    oo.setCharId(rs.getLong("char_id"));
                    oo.setCharName(rs.getString("char_name"));
                    oo.setLogTime(rs.getLong("log_time"));
                    oo.setReason(rs.getInt("reason"));
                    
                    oo.setCurrent(rs.getInt("current"));
                    oo.setAddValue(rs.getInt("add_value"));
                    o = oo;
                }
                else if (type.equals("item")) {
                    ItemLog oo = new ItemLog();
                    oo.setLogUid(rs.getInt("log_uid"));
                    oo.setCharId(rs.getLong("char_id"));
                    oo.setCharName(rs.getString("char_name"));
                    oo.setLogTime(rs.getLong("log_time"));
                    oo.setReason(rs.getInt("reason"));
                    
                    oo.setItemId(rs.getInt("item_id"));
                    oo.setCurrent(rs.getInt("current"));
                    oo.setAddNum(rs.getInt("add_num"));
                    o = oo;
                }
                else if (type.equals("exp")) {
                    ExpLog oo = new ExpLog();
                    oo.setLogUid(rs.getInt("log_uid"));
                    oo.setCharId(rs.getLong("char_id"));
                    oo.setCharName(rs.getString("char_name"));
                    oo.setLogTime(rs.getLong("log_time"));
                    oo.setReason(rs.getInt("reason"));
                    
                    oo.setLevel(rs.getInt("level"));
                    oo.setCurExp(rs.getInt("cur_exp"));
                    oo.setAddExp(rs.getInt("add_exp"));
                    o = oo;
                }
                else if (type.equals("card")) {
                    CardLog oo = new CardLog();
                    oo.setLogUid(rs.getInt("log_uid"));
                    oo.setCharId(rs.getLong("char_id"));
                    oo.setCharName(rs.getString("char_name"));
                    oo.setLogTime(rs.getLong("log_time"));
                    oo.setReason(rs.getInt("reason"));
                    
                    oo.setCardId(rs.getLong("card_id"));
                    oo.setCardDictId(rs.getLong("card_dict_id"));
                    oo.setCardLevel(rs.getInt("card_level"));
                    oo.setCardExp(rs.getInt("card_exp"));
                    oo.setHp(rs.getInt("hp"));
                    oo.setHpCrystal(rs.getInt("hp_crystal"));
                    oo.setMp(rs.getInt("mp"));
                    oo.setMpCrystal(rs.getInt("mp_crystal"));
                    oo.setAttack(rs.getInt("attack"));
                    oo.setAttackCrystal(rs.getInt("attack_crystal"));
                    oo.setDefence(rs.getInt("defence"));
                    oo.setDefenceCrystal(rs.getInt("defence_crystal"));
                    oo.setSkill(rs.getString("skill"));
                    o = oo;
                }
                
                return o;
            }
            
        });
    }
    
    
}
