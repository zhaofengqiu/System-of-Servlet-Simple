<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<legend> 请填写注册信息</legend>
  <form action="regist.jhtml" method="post">
    <table style="text-align: right;">
      <tr>
        <td>用户名：</td>
        <td><input type="text" name="userName" placeholder="由英文字母和数字组成的4-16位字符，以字母开头">
        </td>
      </tr>
      
      <tr>
        <td>邮箱：</td>
        <td><input type="text" name="email" placeholder="邮箱账号@域名。如good@tom.com、whj@sina.com.cn">
        </td>
      </tr>
      <tr>
        <td>密码：</td>
        <td><input type="password" name="pwd" placeholder="由英文字母和数字组成的4-10位字符">
        </td>
      </tr>
      <tr>
        <td>确认密码：</td>
        <td><input type="password" name="pwd2" placeholder="确认密码">
        </td>
      </tr>
      
      <tr>
        <td>出生日期：</td>
        <td><input type="date" name="birthday" value="2018-09-24"/>
      </tr>
      <tr>
        <td colspan="2" align="left"><input type="submit" name="submit" value="提交"></td>
      </tr>
    </table>
  </form>
</fieldset>
</body>
</html>