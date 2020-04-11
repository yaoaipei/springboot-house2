<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/4/7
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK
        rel=stylesheet type=text/css href="../css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
</head>
<body>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../images/logo.gif"></DIV>
</DIV>
<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DIV class=box>
            <H4>用户登录</H4>
            <form method="post" action="loginAction" name="user" id="user">
                <div class="infos">
                    <table class="field">
                        <tbody>
                        <tr>
                            <td colspan="2"></td>
                        </tr>
                        <tr>
                            <td class="field">用 户 名: </td>
                            <td>
                                <input type="text" id="user_name" class="text" name="username">
                            </td>
                        </tr>
                        <tr>
                            <td class="field">密    码: </td>
                            <td>
                                <input type="password" id="user_password" class="text" name="password">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="buttons">
                        <input type="submit" value="登陆" name="sub">
                        <input onclick='document.location="regs.jsp"'type="button" value="注册">
                    </div>
                </div>
            </form>

        </DIV>
    </DIV>
</DIV>

</body>
</html>
