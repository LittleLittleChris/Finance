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

<title>注册页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"	href="style/css/PushChickensConfirm.css">

</head>

<body>
	<c:choose>
		<c:when test="${requestScope.register eq null }">
			<p>
				不要随便改地址拦，请<a href="Login">访问</a>
			</p>
		</c:when>

		<c:otherwise>
			<h3>
				这是你将要<strong>注册</strong>的信息，请确认
			</h3>
			<form action="RegisterConfirm" method="post">
				<table class="table_show" border="1">
					<thead>
						<tr>
							<th>登录名</th>
							<th>姓名</th>
							<th>密码</th>
							<th>地区</th>
						</tr>
					</thead>
					<tbody>

						<td><input type="text" name="username"
							value="${requestScope.register.username}" readonly="readonly"></td>
						<td><input type="text" name="pName"
							value="${requestScope.register.pName}" readonly="readonly"></td>
						<td><input type="text" name="password"
							value="${requestScope.register.password}" readonly="readonly"></td>
						<td><input type="text" name="region"
							value="${requestScope.register.region}" readonly="readonly"></td>
					</tbody>
				</table>
				<div class="button_style">
					<input class="submit" type="submit" name="submit" value="注册">
					<input class="back" type="button" value="返回修改"
						onclick="javascript:history.go(-1);location.replace(document.referrer)">
				</div>
			</form>
		</c:otherwise>
	</c:choose>

</body>
</html>
