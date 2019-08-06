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

<title>注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="style/css/register.css">

</head>

<body>
	<c:choose>

		<c:when
			test="${sessionScope.userInfo eq null || sessionScope.userInfo.authority <= 0}">
			<h3>
				权限不够或没有登录，请用管理员账户<a href="login.jsp">登录</a>
			</h3>
		</c:when>


		<c:otherwise>
			<h2>新增用户</h2>
			<c:if test="${requestScope.exist != null}">
				<h3 class="complete">非法用户名，请重新注册</h3>
			</c:if>
			<c:if test="${requestScope.success != null}">
				<h3 class="complete">用户:${requestScope.username},注册成功！</h3>
			</c:if>

			<div class="container">
				<c:if test="${requestScope.success == null}">
					<form action="RegisterForNormal" method="post" name="formContent"
						class="formContent">
						<ul>
							<li class="same"><span>用户名:</span> <input type="text"
								name="username" pattern="^\S{1,12}$" placeholder="输入登录名"
								required></li>
							<li class="same"><span>用户姓名:</span> <input type="text"
								name="pName" pattern="^\S{1,12}$" placeholder="输入用户姓名" required>
							</li>
							<li class="same"><span>地区:</span> <input type="text"
								name="region" pattern="^\S{1,12}$" placeholder="输入地区" required>
							</li>
							<li class="same"><span>密码:</span> <input type="text"
								name="password" pattern="^\S{1,12}$" placeholder="输入密码" required>
							</li>
						</ul>
						<div class="button_style">
							<input class="submit" type="submit" name="submit" value="确认">
							<input class="reset" type="reset" name="reset" value="重置">
						</div>
					</form>
				</c:if>
			</div>

		</c:otherwise>
	</c:choose>
</body>
</html>
