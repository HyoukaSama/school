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
    <title>userinfo</title>
</head>
<body>
<input id="user" type="text" value="${user}">
<tr>
    <td> name</td>
    <td id="name"></td>
</tr>
<tr>
    <td> age</td>
    <td id="age"></td>
</tr>
<tr>
    <td> sex</td>
    <td id="sex"></td>
</tr>
<tr>
    <td> account</td>
    <td id="account"></td>
</tr>
<tr>
    <td> passwd</td>
    <td id="passwd"></td>
</tr>
</body>
</html>
<script>
    function getUserInfo() {
        var user = $("#user").val();
        var obj = eval('(' + str + ')');
        $("#name").val(obj.name);
    }


</script>
