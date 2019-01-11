<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login.jhtml" method="post">
    <h1>用户登陆页面</h1>   
    <hr/>
    <table align="left">
        <tr>
            <td>账号：</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td colspan="1">
            </td>
            <td>
                <input type="submit" value="登陆"/>
                <input type="reset" value="重置"/>
                <a href="reg.jsp" target="_blank">注册</a>
            </td>
        </tr>
    </table>
</form> 
</body>
</html>