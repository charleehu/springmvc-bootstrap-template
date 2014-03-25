<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<body>
	<div class="row">
		<textarea id="myEditor">
			<c:out value="${notice}" />
	    </textarea>
	</div>
	<div class="row" style="padding-top:10px;">
		<div class="col-md-10"></div>
		<div class="col-md-1">
			<button type="button" class="btn btn-primary btn-sm" onclick="save()">&nbsp;保存&nbsp;</button>
		</div>
		<div class="col-md-1">
			<button type="button" class="btn btn-primary btn-sm"
				onclick="preview()">&nbsp;预览&nbsp;</button>
		</div>
	</div>
	<script type="text/javascript">
    	var editor = UE.getEditor('myEditor');
    	
    	function save() {
    		$.post("notice/update", {content: UE.getEditor('myEditor').getContent()}, function(data) {
    			window.location.reload();
    		});
    	}
    	
    	function preview() {
    		editor.execCommand( 'preview' );
    	}
	</script>
</body>
</html>
