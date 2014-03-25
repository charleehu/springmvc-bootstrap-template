package com.renren.game.lyz.gmserver.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.renren.game.lyz.gmserver.utils.SpringPropertiesUtil;

import scala.actors.threadpool.Arrays;
import client.bean.Action;
import client.bean.Player;
import client.bean.Session;
import client.http.Response;
import client.http.Server;

public class CmdManageService {

	/** CmdManageService LOG */
	private static final Logger logger = LoggerFactory.getLogger("telnet");

	public static final String CLEAR_GLOBAL_CACHE = "clearGlobalCache";
	public static final String GET_ITEM_TYPE = "getItemType";
	public static final String GET_ITEM_BY_TYPE = "getItemByType";
	public static final String SEND_GIFT = "sendGift";
	public static final String GET_OPPONENT_INFO = "getOpponentInfo";
	public static final String GET_GM_INFO = "getGmUserInfo";
	public static final String GET_SYS_NOTICE = "getSysNotice";
    public static final String UPDATE_SYS_NOTICE = "updateSysNotice";
    public static final String GET_SERVER_INFO = "getServerInfo";
    public static final String SET_MAINTAIN_DATETIME = "setMaintainDatetime";
    public static final String CLEAR_MAINTAIN_DATETIME = "clearMaintainDatetime";
    public static final String QUERY_ALL_USER_BAN = "queryAllUserBan";
    public static final String ADD_USER_BAN = "addUserBan";
    public static final String REMOVE_USER_BAN = "removeUserBan";

    public static final String QUERY_USER_MONEY_LOG = "queryUserMoneyLog";
    public static final String QUERY_USER_GEM_LOG = "queryUserGemLog";
    public static final String QUERY_USER_EXP_LOG = "queryUserExpLog";
    public static final String QUERY_USER_CARD_LOG = "queryUserCardLog";
    public static final String QUERY_USER_ITEM_LOG = "queryUserItemLog";

    public static final String QUERY_USER_PT_LOG = "queryUserPTLog";

    public static final String QUERY_USER_EXCHANGE_LOG = "queryUserExchangeLog";

    public static final String QUERY_USER_QUERY_ALL_RECHARGE = "queryAllRecharge";
    
    
    public static final String GET_GM_USER_LIST = "getGMUserList";
    public static final String ADD_GM_USER = "addGMUser";
    public static final String DEL_GM_USER = "delGMUser";
    
	public static List<Object> sendCmd(String method, Object ...param) {
	    Collection<Collection<Object>> result = (Collection<Collection<Object>>) sendCmd(SpringPropertiesUtil.getProperty("game.server.url"), method, param);
	    
	    return new ArrayList(result.iterator().next());
	}
	
	private static Object sendCmd(String serverUrl, String method, Object ...param) {
        logger.info("send cmd to server: " + serverUrl);
        logger.info("cmd: " + method);
        Response response = new Server(serverUrl).request(new Player(-1000, new Session("c48387310b64c36b60485ad50e2a1ba8")), new Action(method, Arrays.asList(param)));
        return response.getResult();
    }
	
}
