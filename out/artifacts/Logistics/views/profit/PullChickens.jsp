<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.DateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Date today = new Date();
DateFormat df = DateFormat.getDateInstance();
String todayStr = df.format(today);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>出货</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="style/css/PushChickens.css">
  </head>
  <style>

        .printButton{
        width: 120px;
        height: 50px;
        border-radius: 20px;
        background-color: #f26798;
        color: #f2f2f2;
        display: block;
        text-align: center;
        line-height: 50px;
        text-decoration: none;
        margin:20px auto;
    }
    .printButton:hover{
        color: #f26798;
        background-color: #d2d2d2;
    }
    .printButton:active{
        color: firebrick;
    }
    .table_order{
        border-collapse: collapse;
        margin:10px auto;
        width: 70%;
        border:1px solid #ffc744;
        min-width: 500px;
    }
    .table_detail{
        width:900px;
        border-collapse: collapse;
        border:1px solid #A9A9A9;
    }
    .table_detail td{
        border:1px;
    }
    .table_detail input{
        border:0;
        border-bottom:1px solid black;
        background-color: transparent;
    }
  </style>
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
  <div style="width: 900px;font-size:20px;font-weight:bold;text-align: center">宇鑫物流</div>
      <br/>
      <br/>
          <table class="table_detail" >
              <tbody>
              <tr>
                  <td rowspan="2" style="border-top-style:none;width:350px;">
                      <img src="https://s2.ax1x.com/2019/07/14/ZIeab8.png" alt="" width="50" height="50" title="" align="" />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;<img src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=465973704,549905082&amp;fm=26&amp;gp=0.jpg" alt="" width="150" height="45" title="" align="" />
                  </td>
                  <td style="border-top-style:none;">
                      <span style="font-size:14px;">统一客服电话：400-888-8888</span>
                  </td>
                  <td style="text-align:center;border-collapse: collapse;width: 120px;border:1px solid #A9A9A9;border-right-style:none;border-bottom-style:none;">
                      发站
                  </td>
                  <td style="text-align:center;border-collapse: collapse;width: 120px;border:1px solid #A9A9A9;border-bottom-style:none;">
                      到站
                  </td>
              </tr>
              <tr>
                  <td style="border-top-style:none;">
                      查询网址：www.<a href="http://yx56.cn/">yx56.cn</a>
                  </td>
                  <td style="border-collapse: collapse;text-align:center;width: 120px;border:1px solid #A9A9A9;border-right-style:none;border-bottom-style:none;">
                      <input type="text"></input>
                  </td>
                  <td style="border-collapse: collapse;text-align:center;width: 120px;border:1px solid #A9A9A9;border-bottom-style:none;">
                      <input type="text"></input>
                  </td>
              </tr>
              </tbody>
          </table>
          <table class="table_detail">
              <tbody>
              <tr>
                  <td colspan="2" style="background-color:#337FE5;">
                      &nbsp;<span style="color:#FFFFFF;">1.收货人信息</span><br />
                  </td>
                  <td colspan="2" style="background-color:#C0C0C0;">
                      &nbsp;<span style="color:#FFFFFF;">2.发货人信息</span><br />
                  </td>
              </tr>
              <tr>
                  <td style="width: 100px;height: 28px">
                      &nbsp;收货人
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td style="width: 100px;height: 28px">
                      &nbsp;发货人
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
              </tr>
              <tr>
                  <td style="width: 100px;height: 28px">
                      &nbsp;收货电话
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td>
                      &nbsp;联系电话
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
              </tr>
              <tr>
                  <td style="width: 100px;height: 28px">
                      &nbsp;收货地址
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td>
                      &nbsp;发货地址
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
              </tr>
              </tbody>
          </table>
          <table style="width:900px;border-collapse: collapse;" cellpadding="0" cellspacing="0" border="1" bordercolor="#A9A9A9">
              <tbody>
              <tr>
                  <td colspan="6" style="background-color:#337FE5;">
                      &nbsp;<span style="color:#FFFFFF;">3.货物基础信息</span>
                  </td>
              </tr>
              <tr>
                  <td style="text-align:center;">
                      货物名称
                  </td>
                  <td style="text-align:center;">
                      包装
                  </td>
                  <td style="text-align:center;">
                      件数
                  </td>
                  <td style="text-align:center;">
                      重量
                  </td>
                  <td style="text-align:center;">
                      体积
                  </td>
                  <td style="text-align:center;">
                      品类
                  </td>
              </tr>
              <tr>
                  <td style="height: 28px">
                      <input type="text"></input>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
              </tr>
              <tr>
                  <td style="height: 28px">
                      <input type="text"></input>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
              </tr>
              </tbody>
          </table>
          <table style="width:900px;border-collapse: collapse;" cellpadding="0" cellspacing="0" border="1" bordercolor="#A9A9A9">
              <tbody>
              <tr>
                  <td colspan="6" style="background-color:#337FE5;">
                      &nbsp;<span style="color:#FFFFFF;">4.财务相关信息</span>
                  </td>
              </tr>
              <tr>
                  <td style="width: 100px;height: 28px">
                      &nbsp;代收货款<br />
                  </td>
                  <td colspan="2">
                      <input type="text"></input>
                  </td>
                  <td style="width: 100px;height: 28px">
                      &nbsp;代收大写
                  </td>
                  <td colspan="2">
                      <input type="text"></input>
                  </td>
              </tr>
              <tr>
                  <td>
                      &nbsp;银行卡号<br />
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td style="width: 50px;height: 28px">
                      &nbsp;姓名
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td style="width: 60px;height: 28px">
                      &nbsp;开户行
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
              </tr>
              </tbody>
          </table>
          <table style="width:900px;border-collapse: collapse;" cellpadding="2" cellspacing="0" border="1" bordercolor="#A9A9A9">
              <tbody>
              <tr style="background-color:#337FE5;color: #FFFFFF;">
                  <td>
                      5.扫码查货
                  </td>
                  <td>
                      6.托运日期
                  </td>
                  <td>
                      7.收货人签字
                  </td>
                  <td >
                      8.货物托运协议确认书
                  </td>
              </tr>
              <tr style="height: 130px">
                  <td>
                      <br />
                  </td>
                  <td>
                      <%=todayStr%>
                  </td>
                  <td>
                      <br />
                  </td>
                  <td style="font-size: 9px;width: 600px">
                      1. 甲方应于装运前 5 天向乙方提供海运出口委托单，并协助乙方拖车至甲方指定工厂装运货物。<br/>
                      2. 甲方应对其提供的核销文件、发票、装箱单等有关文件、单证之真实性、合法性、完备性负责。<br/>
                      3. 甲方按本协议结算条款及偿付运费及其他相应费用的责任，甲方不得以自身或任何第三方原因拒绝或拖延本协议项下运费的偿付。<br/>
                      4. 甲方应对因未能履行上述第一条第二款之责任或其他自身原因引起的运期推迟、额外支出及其它后果负责。<br/>
                      5. 甲方不得向乙方提出不合理、不合法的要求，且不得以次类要求未能满足为由不履行本协议。<br/>
                      <br/>
                      <span style="font-size: 16px;">&nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;发货人签字（建议保价）：</span>
                      <br/>
                      <br/>
                  </td>
              </tr>
              <tr>
                  <td colspan="4">
                      制单员：&nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 收银员： &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 发货地址：山东省嘉祥县大张楼镇滨湖社区<br />
                  </td>
              </tr>
              </tbody>
          </table>
          <br />


    <form action="PullChick" method="post" style="display: none">
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
                   <select name="chickType" style="width:90px;text-align: center; text-align-last: center;">
                   <c:forEach items="${requestScope.allType}" var="regard">
                   <option \ value="${regard.chickType}">${regard.chickType}</option>
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
            <input class="submit" type="submit" name="submit" value="确认">
            <input class="reset" type="reset" name="reset" value="清空">
        </div>
    </form>



    <div class="table_info" style="display: none">
        <h3>当前出货单</h3>
        <table class="table_show" border="1">
            <thead>
            <tr>
                <th>种类</th>
                <th>毛重</th>
                <th>皮重</th>
                <th>净重</th>
                <th>单价</th>
                <th>全额</th>
            </tr>
            </thead>
            <tbody>
             <c:forEach items="${requestScope.pullChickens}" var="pullChick">
            <tr>
                <td>${pullChick.chickType}</td>
                <td>${pullChick.sumWeight}</td>
                <td>${pullChick.tare}</td>
                <td>${pullChick.suttle}</td>
                <td>${pullChick.price}</td>
                <td>${pullChick.sumPrice}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <a class="printButton" href="PullChickConfirm">确认当前出货订单</a>
    </div>
</div>
  </c:otherwise>
  </c:choose>
  </body>
</html>

<script type="text/javascript">
    //启用滚动条
    $(document.body).css({
        "overflow-x":"auto",
        "overflow-y":"auto"
    });
</script>