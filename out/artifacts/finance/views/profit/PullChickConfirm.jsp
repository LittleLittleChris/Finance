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
    
    <title>出货订单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/css/PullPrint.css">

  </head>
  
  <body>
      <c:choose>
  <c:when test="${requestScope.pullChicks eq null || sessionScope.userInfo eq null}">
  <p>不要随便该地址拦，请<a href="views/index.jsp">访问</a></p>
  </c:when>
  
  <c:otherwise>
  <h3>欢迎使用微信支付，支付宝支付</h3>
<h2>销售发货单</h2>
<div class="container">
        <table class="header">
            <tr>
                <td>所属地区：</td>
                <td>${sessionScope.userInfo.region}</td>
            </tr>
            <tr>
                <td>发货人：</td>
                <td><input type="text" placeholder="请输入名字"></td>
            </tr>
            <tr>
                <td>发货日期：</td>
                <td>${requestScope.normalTime}</td>
            </tr>
            <tr>
                <td>打单时间：</td>
                <td>${requestScope.nowTime}</td>
            </tr>
        </table>
        <table class="content">
            <thead>
            <tr>
                <th>品种</th>
                <th>毛重</th>
                <th>净重</th>
                <th>皮重</th>
                <th>单价</th>
                <th>全额</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.pullChicks}" var="data">
            <tr>
                    <td>${data.chickType}</td>
                    <td>${data.sumWeight}</td>
                    <td>${data.suttle}</td>
                    <td>${data.tare}</td>
                    <td>${data.price}</td>
                    <td>${data.sumPrice}</td>
                </tr>
            </c:forEach>
            <tr>
                <td>&nbsp;</td>
                <td>${requestScope.sumWeight}</td>
                <td>${requestScope.suttleBigDecimal}</td>
                <td>${requestScope.tareBigDecimal}</td>
                <td>${requestScope.priceBigDecimal}</td>
                <td>${requestScope.sumPrice}</td>
            </tr>
            </tbody>
        </table>
    <table class="footer">
        <tr>
            <td class="right">销售金额：</td>
            <td>${requestScope.sumPrice}</td>
        </tr>
        <tr>
            <td class="right">联系电话：</td>
            <td><input type="text" placeholder="请输入电话"></td>
        </tr>
        <tr>
            <td class="right">收货人签名：</td>
            <td>&nbsp;</td>
        </tr>

    </table>
</div>
    <div class="print">
        <a onclick="print()">打印</a>
    </div>
<h4>为确保本公司及客户的资金安全，广大客户在支付货款时，请直接支付发货人账户，不要汇入私人账户。</h4>
  </c:otherwise>
  </c:choose>
    
  </body>
</html>
