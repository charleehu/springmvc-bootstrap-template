<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<body>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">礼包标题</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="title"
					placeholder="最大长度6" maxlength="6">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">礼包内容<span class="glyphicon glyphicon-plus" onclick="addPop()"></span></label>
			<div class="col-sm-10" id="giftListShow"></div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">接收人</label>
			<div class="col-sm-10">
				<textarea id="reciver" class="form-control" rows="3" placeholder="以','分隔玩家ID"></textarea>
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label> <input type="checkbox" id="allcb"> 全服发放 </label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" class="btn btn-primary ladda-button" data-style="expand-right" id="sbBtn"><span class="ladda-label">提交</span></button><span id="errorMsg" style="padding-left:20px;color:red"></span>
			</div>
		</div>
	</form>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">选择礼包内容</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">类型</label>
							<div class="col-sm-10">
								<select id="type" onchange="changeSubType(this)" class="form-control">
									<option value="-1"></option>
									<c:forEach items="${items}" var="it">
										<option value="${it.id }">${it.name}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">子类型</label>
							<div class="col-sm-10">
								<select id="subtype" class="form-control">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">数量</label>
							<div class="col-sm-10">
								<input type="number" class="form-control" id="number"/>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<span id="errorMsgPop" style="padding-right:20px;color:red"></span>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" onclick="saveGift()">Save
						changes</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<script type="text/javascript">
	function addPop() {
		$('#myModal').modal({
	  	  keyboard: false
	  	});
	}
	
	function changeSubType(select) {
		var type = $(select).val();
		
		if (type != -1) {
			$.post("gift/subtype", {type: type},
					function(data){
				var subtype = $("#subtype");
				subtype.empty();
				$.each(eval(data), function(i, n) {
					$("<option value=" + n.id + ">" + n.id + "-" + n.name + "</option>").appendTo(subtype);
				});
			});
			
		}
		
	}
	
	function showErrorMsg(msg) {
		$("#errorMsg").text(msg);
	}
	
	function showErrorMsgPop(msg) {
		$("#errorMsgPop").text(msg);
	}
	
	function saveGift() {
		var type = $("#type");
		var subtype = $("#subtype");
		var number = $("#number");
		
		if (type.val() == -1) {
			showErrorMsgPop("请选择类型");
			return;
		}
		
		if (!/^[1-9]*[1-9][0-9]*$/.test(number.val())) {
			showErrorMsgPop("请输入数量");
			return;
		}
		
		$("#giftListShow").append("<p><span id='gift' v='" + type.val() + "-" + (subtype.val() == null ? 0 :subtype.val())  + "-" + number.val() + "'>" + type.find("option:selected").text() + "-" + subtype.find("option:selected").text() + "-" + number.val() + " </span><span class='glyphicon glyphicon-trash' onclick='javascript:delGift(this)'></span></p>");
		
		$('#myModal').modal('hide');
	}
	
	function delGift(a) {
		$(a).parent().remove();
	}
	
	function _submit() {
		
		
		var title = $("#title").val();
		var giftList = new Array();
		var giftListShow = new Array();
		$("#giftListShow").children().each(function(i, p){
			giftList.push($(p).children("span").attr("v"));
			giftListShow.push($(p).children("span").text());
		});
		var receiver = $.trim($("#reciver").val());
		
		if (!$.trim(title)) {
			showErrorMsg("请输入主题");
			return false;
		}
		if (giftList.length <= 0) {
			showErrorMsg("请选择礼物");
			return false;
		}
		
		var allCheckBox = $("#allcb").is(':checked');
		if(!allCheckBox){
			if (!receiver) {
				showErrorMsg("请输入接收人ID");
				return false;
			}
		
			if (!/^[1-9]*[1-9][0-9]*(,[1-9]*[1-9][0-9]*)*$/.test(receiver)) {
				showErrorMsg("接收人格式不对,请以','分隔用户ID");
				return false;
			}
		}
		else {
			if(!window.confirm("给所有人发送礼物需要很长时间，确定吗?!")){
				return false;
			}
		}
		
		$.post("gift/send", {title: title, giftList: giftList.join(","), receiver: receiver, giftListShow: giftListShow.join(","), reciverRadio: allCheckBox},
			function(data) {
			window.location.reload(true);
		});
		
		return true;
	}
	
	$(function(){
		$('#sbBtn').on('click', function(e) {
			e.preventDefault();
			var l = Ladda.create(this);
			if (_submit()) l.start();
		});
	});
	</script>
</body>
</html>
