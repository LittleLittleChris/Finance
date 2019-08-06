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
<title>忘记密码</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="style/css/register.css">
</head>

<body>
	<h2>信息验证（正确后确认，设置新密码）</h2>
	<div class="container">
		<form action="ForgetPassword" method="post" name="formContent"
			class="formContent">
			<ul>
				<li class="same"><span>账户名:</span> <input type="text" value="${sessionScope.userInfo.username}"
					name="username" placeholder="输入账户名" required></li>
				<li class="same"><span>姓名:</span> <input type="text"   value="${sessionScope.userInfo.pName}"
					name="pName" placeholder="输入姓名" required></li>
				<li class="same"><span>地区:</span> <input type="text"	value="${sessionScope.userInfo.region}"
					name="region" placeholder="输入地区" required></li>
			</ul>
			<div class="button_style">
				<input class="submit" type="submit" name="submit" value="确认">
				<input class="reset" type="reset" name="reset" value="清空">
			</div>
		</form>
	</div>
</body>
</html>
