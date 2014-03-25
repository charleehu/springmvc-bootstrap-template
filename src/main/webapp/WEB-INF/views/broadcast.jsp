<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  
  <body>
    
    <div class="row">
	  <div class="col-md-2 col-md-offset-11"><button type="button" class="btn btn-primary btn-sm" onclick="addPop()">&nbsp;添加&nbsp;</button></div>
	</div>
  	<table class="table table-hover">
  		<thead>
  			<tr>
  				<th>ID</th>
  				<th width="40%" style='overflow:hidden;white-space:nowrap;'>内容</th>
  				<th>开始时间</th>
  				<th>结束时间</th>
  				<th>状态</th>
  				<th>操作</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach items="${broadcasts}" var="broadcast">
	  			<tr onclick="modifyPop(${broadcast.id},'${broadcast.content}','<fmt:formatDate type="date" pattern="MM/dd/yyyy hh:mm a" value="${broadcast.startTime}"/>', '<fmt:formatDate type="date" pattern="MM/dd/yyyy hh:mm a" value="${broadcast.endTime}"/>', ${broadcast.isValid})">
	  				<td>${broadcast.id}</td>
	  				<td>${broadcast.content}</td>
	  				<td><fmt:formatDate type="date" pattern="MM/dd/yyyy hh:mm a" value="${broadcast.startTime}"/></td>
	  				<td><fmt:formatDate type="date" pattern="MM/dd/yyyy hh:mm a" value="${broadcast.endTime}"/></td>
	  				<td>
	  					<c:if test="${broadcast.endTime>now}">
			        		<c:if test="${broadcast.isValid eq 1}"><font color="green">正常</font></c:if>
			        	    <c:if test="${broadcast.isValid eq 0}"><font color="red">已暂停</font></c:if>
			        	</c:if>
				        <c:if test="${broadcast.endTime<=now}">
				        	<font color="gray">已过期</font>
				        </c:if>
	  				</td>
	  				<td>
	  					<button type="button" class="btn btn-link btn-xs" data-toggle="modal" data-target="#myModal" onclick="modifyPop(${broadcast.id},'${broadcast.content}','<fmt:formatDate type="date" pattern="MM/dd/yyyy hh:mm a" value="${broadcast.startTime}"/>', '<fmt:formatDate type="date" pattern="MM/dd/yyyy hh:mm a" value="${broadcast.endTime}"/>', ${broadcast.isValid})"><span class="glyphicon glyphicon-wrench" title="修改"></span></button>
	  					<button type="button" class="btn btn-link btn-xs" data-toggle="modal" data-target="#myModal" onclick="del(${broadcast.id})"><span class="glyphicon glyphicon-trash" title="删除"></span></button>
	  				</td>
	  			</tr>
  			</c:forEach>
  		</tbody>
  	</table>
  	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title" id="myModalLabel">添加系统广播</h4>
	      </div>
	      <div class="modal-body" >
	      	<form role="form">
	      	  <input type="hidden" id="id"/>
			  <div class="form-group">
			    <label for="exampleInputEmail1">开始时间</label>
			    <div class='input-group date' id='datetimepicker1'>
                     <input type='text' class="form-control" id="start_time" readonly="readonly"/>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">结束时间</label>
			    <div class='input-group date' id='datetimepicker2'>
                    <input type='text' class="form-control" id="end_time" readonly="readonly"/>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">状态</label>
				<div class="radio">
					<label> <input type="radio" name="optionsRadios"
						id="optionsRadios1" value="1" checked>有效</label>
				</div>
				<div class="radio">
					<label> <input type="radio" name="optionsRadios"
						id="optionsRadios2" value="0">无效</label>
				</div>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail1">内容(最大长度60)</label>
			    <textarea class="form-control" rows="2" id="content" placeholder="广播内容" maxlength="60"></textarea>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" id="addOrUpdate">Save changes</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker({
                	
                });
                $('#datetimepicker2').datetimepicker();
                
            });
            
            function reset() {
            	
            }
            
            function addPop() {
            	$("#myModalLabel").text("添加系统广播");
            	
	            $('#myModal').modal({
	            	  keyboard: false
	            })
	            
	            $("#addOrUpdate").click(function(){
	            	$.post("broadcast/add", { content: $("#content").val(), start_time: $("#start_time").val(), end_time: $("#end_time").val(), state: $('input[name=optionsRadios]:checked').val()}, function(data){
	            		window.location.reload();
	            	});
	            });
            }
            
            function del(id) {
            	$.post("broadcast/del", {id: id}, function(data){
            		window.location.reload();
            	});
            }
            
            function modifyPop(id,content,startTime,endTime,state) {
            	$("#myModalLabel").text("修改系统广播");
            	
            	$("#id").val(id);
            	$("#content").val(content);
            	$('#datetimepicker1').data("DateTimePicker").setDate(startTime);
            	$('#datetimepicker2').data("DateTimePicker").setDate(endTime);
           	    var $radios = $('input:radio[name=optionsRadios]');
         	    $radios.filter('[value=' + state + ']').prop('checked', true);
            	
            	$('#myModal').modal({
	            	  keyboard: false
	            })
	            
	            $("#addOrUpdate").click(function(){
	            	$.post("broadcast/update", { id: $("#id").val(), content: $("#content").val(), start_time: $("#start_time").val(), end_time: $("#end_time").val(), state: $('input[name=optionsRadios]:checked').val()}, function(data){
	            		window.location.reload();
	            	});
	            });
            }
     </script>
  </body>
</html>
