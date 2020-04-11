<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/3/5
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <TITLE>租房网 - 用户管理系统</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK
        rel=stylesheet type=text/css href="../css/style.css">
    <script language="JavaScript" src="../scripts/jquery-1.8.3.js"></script>
    <script language="JavaScript">
        //$(function () { //加载
        // //点击事件
        // $("#delButton2").click(function () {
        //     //当前删除按钮的下一个标签-->隐藏域
        //     var vid = $(this).next().val();
        //     //发送一异步请求
        //     $.post("delHouse",{"id":vid},function (data) {
        //         if (data.result>0){
        //             alert("成功")
        //         } else {
        //             alert("失败")
        //         }
        //     },"json")
        // })
        //})

        // function delHouse(obj,id) {
        //         $.post("delHouse",{"id":id},function (data) {
        //             if (data.result>0){
        //                 alert("成功")
        //             } else {
        //                 alert("失败")
        //             }
        //         },"json")
        // }




    </script>



</head>
<body>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../images/logo.gif"></DIV>
    <DIV class=search>欢迎${sessionScope.userinfo.name}.<LABEL class="ui-green searchs"><a href="fabu.jsp" title="">发布房屋信息</a></LABEL>
        <LABEL class=ui-green><INPUT onclick='document.location="login.jsp"' value="退       出" type=button name=search></LABEL>
    </DIV>
</DIV>

<DIV class="main wrap">
    <DIV id=houseArea>
        <TABLE class=house-list>
            <TBODY>

            <c:forEach items="${houseList}" var="h">
                <TR>
                    <TD class=house-thumb><SPAN><A href="details.htm" target="_blank">

        <img src="http://localhost:80/${h.path}" width="100" height="75" alt=""></A></SPAN></TD>
                    <TD>
                        <DL>
                            <DT><A href="details.htm" target="_blank">${h.title}</A></DT>
                            <DD>${h.dname}=${h.sname},类型:${h.tname}=面积:${h.floorage}平米<BR>联系方式：${h.contact} </DD></DL></TD>
                    <TD class=house-type>
                        <c:if test="${h.ispass==0}">审核中...</c:if>
                        <c:if test="${h.ispass==1}">已审核</c:if>
                    </TD>
                    <TD class=house-type>
                        <LABEL class=ui-green><INPUT onclick="location.href='showHouse?id=${h.id}';" value="修    改" type=button name=search>
                        </LABEL>
                    </TD>
                    <TD class=house-price>
                            <%--<input value="删    除" onclick="delHouse(this,$(h.id))" id="delButton2" type="button">--%>
                        <input value="删    除" onclick="delHouse(this,${h.id});" id="delButton2" type="button">
                        <input type="hidden" value="${h.id}">
                    </TD>
                </TR>
            </c:forEach>


            </TBODY>
        </TABLE>
    </DIV>

    <DIV class=pager>
        <UL>
            <LI class=current><A id=widget_338868862
                                 href="http://localhost:8080/HouseRent/manage!ajaxList.action?number=1"
                                 parseContent="true" showError="true" targets="houseArea"
                                 ajaxAfterValidation="false" validate="false"
                                 dojoType="struts:BindAnchor">1</A>
            </LI>
            <LI class=current><A id=widget_1160989910
                                 href="http://localhost:8080/HouseRent/manage!ajaxList.action?number=2"
                                 parseContent="true" showError="true" targets="houseArea"
                                 ajaxAfterValidation="false" validate="false"
                                 dojoType="struts:BindAnchor">2</A>
            </LI></UL><SPAN class=total>1/2页</SPAN> </DIV>
</DIV>
<DIV id=footer class=wrap></DIV>

</body>
</html>
