<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  
  <body>
  	<form action="<c:url value="/log/card" />" method="get">
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
  				<th>角色名</th>
  				<th>时间</th>
  				<th>操作类型</th>
  				<th>卡牌ID</th>
  				<th>等级</th>
  				<th>经验</th>
  				<th>HP</th>
  				<th>MP</th>
  				<th>ATK</th>
  				<th>DEF</th>
  				<th>SKILL</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach items="${listLog}" var="log">
	  			<tr >
	  				<td>${log.logUid}</td>
	  				<td>${log.charId}</td>
	  				<td>${log.charName }</td>
	  				<td>${log.logDate }</td>
	  				<td>${log.reason }</td>
	  				<td>${log.cardDictId }</td>
	  				<td>${log.cardLevel }</td>
	  				<td>${log.cardExp }</td>
	  				<td>${log.hp }/${log.hpCrystal }</td>
	  				<td>${log.mp }/${log.mpCrystal }</td>
	  				<td>${log.attack }/${log.attackCrystal }</td>
	  				<td>${log.defence }/${log.defenceCrystal }</td>
	  				<td>${log.skill }</td>
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
				href="card?date=${date }&userId=${userId }&page=${page-1}">Previous</a>
			</li>
		</c:if>
		<li><a href="card?date=${date }&userId=${userId }&page=${page+1}">Next</a>
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
