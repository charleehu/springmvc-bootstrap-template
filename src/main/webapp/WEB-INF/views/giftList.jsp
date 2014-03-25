<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  
  <body>
  	<form action="<c:url value="/log/gift" />" method="get">
  	<div class="row">
		<div class="col-sm-3">
			<div class='input-group date' id='datetimepicker1'>
				<input type='text' name="date" class="form-control" id="start_time"
					readonly="readonly" placeholder="日期" data-format="YYYY-MM-DD" value="${date }"/> <span class="input-group-addon"><span
					class="glyphicon glyphicon-calendar"></span> </span>
			</div>
		</div>
		<div class="col-sm-3">
			<input type="text" name="userId" class="form-control" id="inputEmail3"
				placeholder="用户ID" value="${userId}">
		</div>
		<div class="col-sm-3">
				<button type="submit" class="btn btn-primary">查询</button>
		</div>
  	</div>
  	</form>
  
  	<table class="table table-striped">
  		<thead>
  			<tr>
  				<th>序号</th>
  				<th>用户ID</th>
  				<th>礼包标题</th>
  				<th width="40%" style='overflow:hidden;white-space:nowrap;'>礼包内容</th>
  				<th>发送时间</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach items="${listLogGift}" var="logGift">
	  			<tr >
	  				<td>${logGift.id}</td>
	  				<td>${logGift.toUserId}</td>
	  				<td>${logGift.subject }</td>
	  				<td>${logGift.gift }</td>
	  				<td><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${logGift.sendTime}"/></td>
	  			</tr>
  			</c:forEach>
  		</tbody>
  	</table>
	<ul class="pager">
		<c:if test="${page <= 1 }">
			<li class="disabled"><a
				href="javascript:void(0)">Previous</a>
			</li>
		</c:if>
		<c:if test="${page > 1 }">
			<li><a
				href="gift?date=${date }&userId=${userId }&page=${page-1}">Previous</a>
			</li>
		</c:if>
		<li><a href="gift?date=${date }&userId=${userId }&page=${page+1}">Next</a>
		</li>
	</ul>

	<script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker({
                	pickTime: false
                });
            });
            
     </script>
  </body>
</html>
