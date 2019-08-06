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
<title>更改密码</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="style/css/register.css">
</head>

<body>


	<c:choose>

		<c:when test="${requestScope.username eq null}">
			<p>
				请先<a href="views/user/ForgetPassword.jsp">验证信息</a>
			</p>
		</c:when>

		<c:when test="${requestScope.username == 'no'}">
			<p>
				你输入的信息不正确，请<a href="views/user/ForgetPassword.jsp">返回</a>重新输入
			</p>
		</c:when>

		<c:otherwise>
			<h2>更改密码</h2>
			<div class="container">
				<form action="UpdateAccount" method="post" name="formContent"
					class="formContent">
					<ul>
						<input type="hidden" name="username"
							value="${requestScope.username}">
						<!-- 两次密码得一样JS -->
						<li class="same"><span>新密码:</span> <input type="text"
							name="password" pattern="^\S{1,12}$" placeholder="Enter password"
							required></li>
						<li class="same"><span>确认密码:</span> <input type="text"
							name="confirmPassword" pattern="^\S{1,12}$"
							placeholder="Enter password again" required></li>
					</ul>
					
					<div class="button_style">
						<input class="submit" type="submit" name="submit" value="确认">
						<input class="reset" type="reset" name="reset" value="清空">
					</div>
			
				</form>
			</div>
		</c:otherwise>
	</c:choose>
	<script>
		var allInput = document.querySelectorAll("input");
		allInput[3].onclick = function(e) {
			if (allInput[1].value !== allInput[2].value) {
				alert("两次密码不一样");
				return false;
			}
		}
	</script>
</body>
</html>
