<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.chen.pojo.Paging" %>
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
    
    <title>添加种类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/css/editChickType.css">

  </head>
  
  <body>
  <c:choose>
  <c:when test="${requestScope.single eq null}">
  <h3>请先<a href="Logout">登录</a></h3>
  </c:when>

  <c:otherwise>
  <div class="all">
      <h3>添加目的地</h3>
      <div class="add_type">
          <form class="add_" action="EditChickType" method="post">
              <input type="text" class="special" name="addChick" pattern="^\S{1,12}$"  placeholder="输入目的地" required>
              &nbsp;&nbsp;<input type="text" class="special" style="width: 120px" name="addPrice" placeholder="输入价格" required>
              &nbsp;<input type="submit" value="添加">
          </form>
      </div>

    <div class="header" align="center">
    <table border="1" cellspacing="0" >
    	<thead>
    		<tr>
    			<th style="width: 30%;">目的地</th>
                <th style="width: 30%;">价 格</th>
    			<th style="width: 30%;">操作</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${requestScope.allType}" var="type">
    			<form class="formData" method="post" action="EditChickType">
            	<tr>
            		<td><input type="text" class="normal" name="deleteChick"  value="${type.goodsType}"
                               readonly="readonly"></td>
                    <td><input type="text" class="normal" name="deleteChick"  value="${type.price}"
                               readonly="readonly"></td>
            		<td style="text-align:center;width: 60px;"><input class="delete" type="submit" name="submit" value="删除"></td>
            	</tr>
              	</form>
            </c:forEach>
    	</tbody>
    </table>
        <table>
            <tr>
                <td colspan="3" height="60px">
                    <a href="EditChickType?page=${paging.indexpage-1}"> 首页 </a>
                    <a href="EditChickType?page=${paging.page-1 }">     上一页 </a>
                    <strong>第${paging.page+1}页/共${paging.pagenumber}页</strong>
                    <a href="EditChickType?page=${paging.page+1}">下一页 </a>
                    <a href="EditChickType?page=${paging.pagenumber-1}">末页 </a>
                </td>
            </tr>
        </table>
    </div>
    </div>
  </c:otherwise>
  </c:choose>
  </body>
</html>
