<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>进货确认</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/css/PushChickensConfirm.css">
  </head>
  
  <body>
  <c:choose>
  <c:when test="${requestScope.allHandle eq null }">
  <p>不要随便改地址拦，请<a href="views/index.jsp">访问</a></p>
  </c:when>
  
  </c:choose>
    <h3>这是你将要<strong>进货</strong>的信息，请确认</h3>
<form action="PushChickConfirm" method="post">
<table class="table_show" border="1">
    <thead>
    <tr>
        <th>种类</th>
        <th>皮重</th>
        <th>净重</th>
        <th>价格</th>
        <th>地区</th>
        <th>添加时间</th>
    </tr>
    </thead>
    <tbody>
    
    <td><input type="text" name="chickType"  value="${requestScope.allHandle.goodsType}" readonly="readonly"></td>
    <td><input type="text" name="tare" value="${requestScope.allHandle.tare}" readonly="readonly"></td>
    <td><input type="text" name="suttle" value="${requestScope.allHandle.suttle}" readonly="readonly"></td>
    <td><input type="text" name="price" value="${requestScope.allHandle.price}" readonly="readonly"></td>
    <td><input type="text" name="region" value="${requestScope.allHandle.region}" readonly="readonly"></td>
    <td><input type="text" name="date" value="${requestScope.allHandle.date}" readonly="readonly"></td>
    </tbody>
</table>
            <div class="button_style">
                <input class="submit" type="submit" name="submit" value="确认进货">
                <input class="back" type="button" value="返回修改" onclick="javascript:history.go(-1);
            location.replace(document.referrer)">
            </div>
</form>
  </body>
</html>
