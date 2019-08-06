<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>确认更改密码</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="style/css/PushChickensConfirm.css">
</head>

<body>

	<div class="container">
		<c:choose>

			<c:when test="${requestScope.password eq null}">
				<p>由於密碼為空，更改密码失败</p>
				<p>三秒后自动跳转到登录页面...</p>
			</c:when>
			<c:when test="${requestScope.password == 'notcomplete'}">
				<p>由于某种原因，更改密码失败</p>
				<p>三秒后自动跳转到登录页面...</p>
			</c:when>
			<c:otherwise>
				<p>完成更改</p>
				<p>你的新密码是:${requestScope.password}</p>
				<p>三秒后自动跳转到登录页面...</p>
			</c:otherwise>
		</c:choose>

	</div>
</body>
<script>
	window.onload = function() {
		setTimeout(function() {
			window.parent.location.href = "login.jsp";
		}, 3000)
	}
</script>
</html>
