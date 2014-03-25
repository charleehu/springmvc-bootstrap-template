<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
ul li, a {
	height:30px;
}
.nav > li.disabled.nav-header > a {
    cursor: default;
    font-size: 12px;
    font-weight: bold;
    text-transform: uppercase;
    padding-left: 10px;
}
ul.nav-stacked.nav-pills.nav > li > a {
	padding: 5px 15px;
}
</style>
<ul class="nav nav-pills nav-stacked">
　<li class="nav-header disabled"><a>游戏管理</a></li>
  <li><a href="<c:url value="/sys/broadcast" />">系统广播</a></li>
  <li><a href="<c:url value="/sys/notice" />">系统公告</a></li>
  <li><a href="<c:url value="/sys/gift" />">礼包发放</a></li>
  <li><a href="<c:url value="/log/gift" />">礼包查询</a></li>
  <li class="nav-header disabled"><a>游戏日志</a></li>
  <li><a href="<c:url value="/log/gem" />">宝石</a></li>
  <li><a href="<c:url value="/log/money" />">金币</a></li>
  <li><a href="<c:url value="/log/friendpoint" />">友情点</a></li>
  <li><a href="<c:url value="/log/item" />">道具</a></li>
  <li><a href="<c:url value="/log/exp" />">经验</a></li>
  <li><a href="<c:url value="/log/card" />">卡牌</a></li>
</ul>

<script>
$(function(){
	$("a[href='" + location.pathname + "']").parent().addClass("active");
});
</script>