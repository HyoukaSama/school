<%--
  Created by IntelliJ IDEA.
  User: Hyouka
  Date: 2021/6/23
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-3.6.0.js"></script>

</head>
<body>
<input id="userlist" name="userlist" type="text" value="${userlist}">
<input id="userarray" name="userarray" type="text">
<input id="suc" name="suc" type="button" value="test">
<input id="test" type="button" value="test" onclick="click1();">
<input id="get" type="button" value="getData">
</body>
</html>

<script type="text/javascript">

    function click1() {
        var userlist1 = $("#userlist ").val();
        alert("1111");
        console.log(userlist1);
    };

    $("#get").click(function () {
        $.ajax({
            type: "get",
            url: "/user/getUserList",
            dataType: "json",
            success: function (data) {
                var suc = data.success;
                var userlist = data.userlist;
                alert(userlist);
            }
        })
    });


</script>
