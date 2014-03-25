<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>龙语者GM后台管理系统1.0</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/datepicker.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/ladda-themeless.min.css" />"
	rel="stylesheet" type="text/css" />

<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->

</head>

<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.8.0-min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/demo.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/json2.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/date.format.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/moment.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap-datetimepicker.ru.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/ueditor/ueditor.config.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/ueditor/ueditor.all.min.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/js/spin.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/ladda.min.js" />"></script>	

<body>

	<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">龙语者GM后台管理系统1.0</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value="/" />">Home</a></li>
				</ul>
				
				<ul class="nav navbar-nav navbar-right">
			      	<li><a href='<c:url value='/logout'/>'>退出</a></li>
			    </ul>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-12 col-sm-9">
				<decorator:body />
			</div>

			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar"
				role="navigation">
				<div class="well sidebar-nav">
					<c:import url="/WEB-INF/views/tags/menu.jsp" />
				</div>
			</div>
			
		</div>

		<hr>

		<footer>
			<c:import url="/WEB-INF/views/tags/footer.jsp" />
		</footer>

	</div>

</body>
</html>