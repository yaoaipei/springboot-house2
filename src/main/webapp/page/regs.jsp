<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/4/7
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>租房网 - 用户注册</TITLE>
        <META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK
                rel=stylesheet type=text/css href="../css/style.css">
        <META name=GENERATOR content="MSHTML 8.00.7601.17514">
        <script language="JavaScript" src="../scripts/jquery-1.8.3.js"></script>
        <script language="JavaScript">
            $(function () {//预加载
              $("#but1").click(function () {
                  $.post("checkName",{"name":$("#txtName").val()},function (data) {
                      if (data.result==0){
                          $("#check").text("用户名可用").css("color","green")
                      } else {
                          $("#check").text("用户名不可用").css("color","green")
                      }
                  },"json")
              });


            });
        </script>
    </head>
<body>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../images/logo.gif">
    </DIV>
</DIV>
<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DL class=clearfix>
            <DT>新用户注册</DT>
            <DD class=past>填写个人信息</DD></DL>
        <DIV class=box>
            <form method="post" action="reg" name="form1">
                <div class="infos">
                    <table class="field">
                        <tbody>
                        <tr>
                            <td class="field">用 户 名: </td>
                            <td>
                                <input type="text" class="text" name="name" id="txtName"><span id="check"></span>
                                <input type="button" id="but1" value="检查用户是否存在">
                            </td>
                        </tr>
                        <tr>
                            <td class="field">密    码: </td>
                            <td>
                                <input type="password" name="password" class="text">
                            </td>
                        </tr>
                        <tr>
                            <td class="field">确 认 密码: </td>
                            <td>
                                <input type="password" class="text" name="repassword">
                            </td>
                        </tr>
                        <tr>
                            <td class="field">电　　话：</td>
                            <td>
                                <input type="text" class="text" name="telephone">
                            </td>
                        </tr>
                        <tr>
                            <td class="field">年龄：</td>
                            <td>
                                <input type="text" class="text" name="age">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="buttons">
                        <input type="submit" name="adduser" value="开始注册">
                    </div>
                </div>
            </form>
        </DIV>
    </DIV>
</DIV>

</body>
</html>
