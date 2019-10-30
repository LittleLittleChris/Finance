<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Date today = new Date();
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
String todayStr = df.format(today);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="scripts/jquery/jquery-1.7.2.min.js"></script>
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
        border:1px solid #A9A9A9;
        height: 28px;
        padding: 0;
    }
    .table_detail input{
        border:0;
        width:100%;
        height: 97%;
        text-align: center;
        font-size: 15px;
        border-bottom:1px solid #FF4500;
        background-color: transparent;
    }
    .table_detail select{
        border: 1px  solid #FF4500;
    }

    #div_txt,#div_txt2 {
        position: relative;
        width: 100%;
    }

    #txt1 {
        width: 99%;
    }

    #div_items {
        position: absolute;
        width: 100%;
        height: 200px;
        border: 1px solid #66afe9;
        border-top: 0px;
        overflow: auto;
        display: none;
        z-index: 1;
    }

    #div_cities {
        position: absolute;
        width: 100%;
        height: 200px;
        border: 1px solid #66afe9;
        border-top: 0px;
        overflow: auto;
        display: none;
        z-index: 1;
    }

    .div_item {
        width: 100%;
        height: 20px;
        margin-top: 1px;
        font-size: 13px;
        line-height: 20px;
        background-color: white;
    }

    .div_city {
        width: 100%;
        height: 20px;
        margin-top: 1px;
        font-size: 13px;
        line-height: 20px;
        background-color: white;
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
  <form>
  <div style="width: 900px;font-size:20px;font-weight:bold;text-align: center">智联物流服务平台</div>
      <br/>
      <br/>
          <table class="table_detail" autocomplete="off">
              <tbody>
              <tr>
                  <td style="border-top-style:none;text-align: center">
                      <span style="font-size:14px;">统一客服电话：400-888-8888</span>
                  </td>
                  <td style="text-align:center;border-collapse: collapse;width: 120px;border:1px solid #A9A9A9;border-right-style:none;border-bottom-style:none;">
                      发站
                  </td>
                  <td style="text-align:center;border-collapse: collapse;width: 120px;border:1px solid #A9A9A9;border-bottom-style:none;">
                      到站
                  </td>
                  <td style="text-align:center;border-collapse: collapse;width: 120px;border:1px solid #A9A9A9;border-bottom-style:none;">
                      网点
                  </td>
              </tr>
              <tr>
                  <td style="border-top-style:none;text-align: center                      ">

                  </td>
                  <td style="border-collapse: collapse;text-align:center;width: 120px;border:1px solid #A9A9A9;border-right-style:none;border-bottom-style:none;">
                      <input type="text"></input>
                  </td>
                  <td style="border-collapse: collapse;text-align:center;width: 120px;border:1px solid #A9A9A9;border-bottom-style:none;">
                      <span id="div_txt">
                          <input type="text" id="txt1" autocomplete="off"/>
                          <!--模糊匹配窗口-->
                          <div id="div_items">
                              <c:forEach items="${requestScope.goodsTypes}" var="type">
                                  <div class="div_item" value="${type.price}">${type.goodsType}</div>
                              </c:forEach>
                          </div>
                      </span>
                  </td>
                  <td style="border-collapse: collapse;text-align:center;width: 120px;border:1px solid #A9A9A9;border-right-style:none;border-bottom-style:none;">
                      <span id="div_txt2">
                          <input type="text" id="txt_city" autocomplete="off"/>
                          <div id="div_cities">
                          </div>
                      </span>
                  </td>
              </tr>
              </tbody>
          </table>
          <table class="table_detail">
              <tbody>
              <tr style="height: 20px">
                  <td colspan="2" style="background-color:#337FE5;height: 100%;">
                      &nbsp;<span style="color:#FFFFFF;">1.收货人信息</span><br />
                  </td>
                  <td colspan="2" style="background-color:#C0C0C0;height: 100%;">
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
          <table class="table_detail" style="font-size: 15px">
              <tbody>
              <tr style="height: 20px">
                  <td colspan="10" style="background-color:#337FE5;height: 100%;">
                      &nbsp;<span style="color:#FFFFFF;">3.货物基础信息</span>
                  </td>
              </tr>
              <tr>
                  <td style="text-align:center;">
                      货物名称
                  </td>
                  <td style="text-align:center;width: 80px">
                      包装
                  </td>
                  <td style="text-align:center;">
                      件数
                  </td>
                  <td style="text-align:center;">
                      重量<span style="font-size: 9px">（公斤）</span>
                  </td>
                  <td style="text-align:center;">
                      体积<span style="font-size: 9px">（方）</span>
                  </td>
                  <td style="text-align:center;width: 80px">
                      品类
                  </td>
                  <td style="text-align:center;">
                      送货费<span style="font-size: 9px">（元）</span>
                  </td>
                  <td style="text-align:center;">
                      总运费<span style="font-size: 9px">（元）</span>
                  </td>
                  <td style="text-align:center;width: 80px">
                      付款方式
                  </td>
                  <td style="text-align:center;">
                      备注
                  </td>
              </tr>
              <tr>
                  <td style="height: 28px">
                      <input type="text"></input>
                  </td>
                  <td style="text-align:center;">
                      <select name="package" id="package">
                          <option>纸箱</option>
                          <option>编织袋</option>
                          <option>木架</option>
                          <option>托盘</option>
                          <option>膜</option>
                          <option>其他</option>
                          <option>无</option>
                      </select>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td>
                      <input type="text" id="text_weight">
                  </td>
                  <td>
                      <input type="text" id="text_volume">
                  </td>
                  <td style="text-align:center;">
                      <select name="category" id="category">
                          <option>普货</option>
                          <option>异形</option>
                      </select>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
                  <td>
                      <input type="text" id="txt2" disabled></input>
                      <input type="text" id="txt3" style="display: none"></input>
                  </td>
                  <td style="text-align:center;">
                      <select style="text-align:center;text-align-last:center;" name="pay_method" id="pay_method">
                          <option>现付</option>
                          <option>提付</option>
                      </select>
                  </td>
                  <td>
                      <input type="text"></input>
                  </td>
              </tr>
              </tbody>
          </table>
          <table class="table_detail">
              <tbody>
              <tr style="height: 20px">
                  <td colspan="6" style="background-color:#337FE5;height: 100%;">
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
          <table class="table_detail" style="display: block">
              <tbody>
              <tr style="background-color:#337FE5;color: #FFFFFF;height: 20px">
                  <td style="height: 100%;">
                      6.托运日期
                  </td>
                  <td style="height: 100%;">
                      7.收货人签字
                  </td>
                  <td style="height: 100%;">
                      8.货物托运协议确认书
                  </td>
              </tr>
              <tr style="height: 130px">
                  <td>
                      <%=todayStr%>
                  </td>
                  <td>
                      <br />
                  </td>
                  <td style="font-size: 9px;width: 600px">

                  </td>
              </tr>
              <tr>
                  <td colspan="3">
                      制单员：&nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 收银员： &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 发货地址：山东省嘉祥县<br />
                  </td>
              </tr>
              </tbody>
          </table>
  </form>
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

    var v_weight = 0;
    var v_volume = 0;

    //重量
    $("#text_weight").blur(function () {
        if(parseFloat($("#text_weight").attr("value"))<10) {
            alert("重量不能小于10公斤!");
            $("#text_weight").val(10);
        }
        var amount = $("#txt3").attr("value");

        var amount_new = (amount*$("#text_weight").attr("value")).toFixed(2);
        //alert(v_weight);
        //alert($("#text_weight").attr("value"));
        if($("#text_weight").attr("value")>v_weight) {
            $("#txt2").val(amount_new);
            $("#text_volume").val((0.005*$("#text_weight").attr("value")).toFixed(2));
        }
        intValue();
        return false;
    });

    //体积
    $("#text_volume").blur(function () {
        var amount = $("#txt3").attr("value");
        var volume = $("#text_volume").attr("value");
        if(parseFloat(volume)<0.05) {
            alert("体积不能小于0.05方!");
            $("#text_volume").val(0.05);
            volume = 0.05;
        }

        var amount_new = (amount/0.005*$("#text_volume").attr("value")).toFixed(2);
        if($("#text_volume").attr("value")>v_volume) {
            $("#txt2").val(amount_new);
            $("#text_weight").val((volume/0.005).toFixed(2));
        }

        intValue();
        return false;
    });

    //启用滚动条
    $(document.body).css({
        "overflow-x":"auto",
        "overflow-y":"auto"
    });

    //弹出列表框
    $("#txt1").click(function () {
        $("#div_items").css('display', 'block');
        return false;
    });

    //弹出列表框
    $("#txt_city").click(function () {
        $("#div_cities").css('display', 'block');
        return false;
    });

    //隐藏列表框
    $("body").click(function () {
        $("#div_items").css('display', 'none');
    });

    //移入移出效果
    $(".div_item").hover(function () {
        $(this).css('background-color', '#1C86EE').css('color', 'white');
    }, function () {
        $(this).css('background-color', 'white').css('color', 'black');
    });

    //文本框输入
    $("#txt1").keyup(function () {
        $("#div_items").css('display', 'block');//只要输入就显示列表框

        if ($("#txt1").val().length <= 0) {
            $(".div_item").css('display', 'block');//如果什么都没填，跳出，保持全部显示状态
            return;
        }

        $(".div_item").css('display', 'none');//如果填了，先将所有的选项隐藏

        for (var i = 0; i < $(".div_item").length; i++) {
            //模糊匹配，将所有匹配项显示
            if ($(".div_item").eq(i).text().indexOf($("#txt1").val()) > -1) {
            //if ($(".div_item").eq(i).text().substr(0, $("#txt1").val().length) == $("#txt1").val()) {
                $(".div_item").eq(i).css('display', 'block');
            }
        }
    });

    //项点击
    $(".div_item").click(function () {
        $("#txt1").val($(this).text());
        $("#txt2").val(($(this).attr("value")/1000).toFixed(2));
        $("#txt3").val(($(this).attr("value")/1000).toFixed(2));
        $("#text_weight").val(1);
        $("#text_volume").val(0.005);
        intValue();
        findAllDepts();
    });

    function intValue() {
        v_weight = $("#text_weight").attr("value");
        v_volume = $("#text_volume").attr("value");
    }

    function findAllDepts() {
        $.ajax({
            async : false,    //表示请求是否异步处理
            type : "post",    //请求类型
            url : "<%=path%>/FormSubmit",//请求的 URL地址
            data : "cityName=" + $("#txt1").attr("value"),
            dataType : "text",//返回的数据类型
            success: function (data) {
                $("#div_cities").html(data);
                $(".div_city").click(function () {
                    $("#txt_city").val($(this).text());
                    $("#div_cities").css('display', 'none');
                });
            }
        });
    };
</script>