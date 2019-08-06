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
    
    <title>进货</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/css/PushChickens.css">

  </head>
  
  <body>
  <c:choose>
  <c:when test="${sessionScope.userInfo eq null}">
    <p>请先<a href="Logout">登录</a></p>
  </c:when>
  
  <c:when test="${requestScope.regard eq null}">
  <p>请按顺序<a href="views/index.jsp">访问</a></p>
  </c:when>
  
  <c:otherwise>
  
  
  <div class="container">
  <h3>进货界面</h3>
    <form action="PushChickTransition" method="post">
        <table class="table_add" border="1">
            <thead>
            <tr>
                <th>种类</th>
                <th>皮重</th>
                <th>净重</th>
                <th>价格</th>
            </tr>
            </thead>
            <tr>
                <td>
                   <select name="chickType" style="width:80px;">
                   <c:forEach items="${requestScope.allType}" var="regard">
                   		<option value="${regard.goodsType}">${regard.goodsType}</option>
                   </c:forEach>
                   </select>
                </td>
                <td>
                    <input type="text" name="tare" pattern="^\d+(.\d+)?$" placeholder="输入皮重" required>
                </td>
                <td><input type="text" name="suttle" pattern="^\d+(.\d+)?$" placeholder="输入净重" required></td>
                <td><input type="text" name="price" pattern="^\d+(.\d+)?$" placeholder="输入价格" required></td>
            </tr>
        </table>
        <div class="button_style">
            <input class="submit" type="submit" name="submit" value="添加">
            <input class="reset" type="reset" name="reset" value="清空">
        </div>
    </form>
    <c:if test="${requestScope.completePush != null}">
    <h3 class="complete">完成进货</h3>
    </c:if>
    <div class="table_info">
        <h3>${sessionScope.userInfo.pName}的仓库</h3>
        <table class="table_show" border="1">
            <thead>
            <tr>
                <th>种类</th>
                <th>皮重</th>
                <th>净重</th>
                <th>价格</th>
                <th>&nbsp;&nbsp;</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.regard}" var="regard">
            <tr>
                <td>${regard.chickType}</td>
                <td>${regard.tare}</td>
                <td>${regard.suttle}</td>
                <td>${regard.price}</td>
                <form action="PushChick" method="post">
                 <input type="hidden" name="chick" value="${regard.chickType}">
                <td><input class="delete" type="submit" value="删除"></td>
                </form>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
  </c:otherwise>
  </c:choose>
  </body>

</html>
