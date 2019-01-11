<%@page import=" com.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户中心-<%=request.getSession().getAttribute("username")%></title>
    
    <link  type="text/css" href="css/admin.css" rel="stylesheet">
       <link rel="stylesheet" href="css/bootstrap.min.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/blog.css">
	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="js/admin.js"></script>
</head>
<body>
    
    <div class="container">
        <div class="admin-menu">
            <div class="admin-logo"><a href="login.jhtml"><%=request.getSession().getAttribute("username")%></a></div>
            <div class="menu-scroll">
                <ul class="menu-list">
                    <li class="menu-item">
                        <a href="javascript:void(0);" onclick="showChild(this)">通讯录</a>
                         <dl class="menu-child" style="display: none;">
                            <dd class="child-item"><a href="contains.jhtml">通讯录管理</a></dd>
                            <dd class="child-item"><a href="messages.jhtml">短消息管理</a></dd>
                        </dl>
                    </li>
                    <li class="menu-item">
                    
                       <a href="javascript:void(0);" onclick="showChild(this)">个人信息管理</a>
                       <dl class="menu-child" style="display: none;">
                        <dd class="child-item"><a href="informsg.jhtml">查看个人信息</a></dd>
                        <dd class="child-item"><a href="informsg.jhtml?choice=xiugai">修改个人信息</a></dd>
                      </dl>
                    </li>
                    <li class="menu-item">
                    
                        <a href="javascript:void(0);" onclick="showChild(this)">企业新闻</a>
                         <dl class="menu-child" style="display: none;">
                       <dd class="child-item"><a href="announcement.jsp">公司公告</a></dd>
                        <dd class="child-item"><a href="metting.jsp">工作会议</a></dd>
                        </dl>
                    </li>
                    <li class="menu-item"><a href="login.jhtml?choose=exit">登出</a></li>
                </ul>
            </div>
        </div>
        <div class="admin-main">
            <div class="body-tabs">
                <a href="/administer/index">主页</a> / <span></span>
            </div>
            <div class="admin-body">
                <div class="site-wrap">
                    
                    
                    
                </div>
                
<pre>
	<div>
	<%
		if("true".equals(request.getAttribute("showmsg")) ){
			User user = (User)request.getAttribute("user");
	%>
		<div class="imformation_div">
		
			<img src="images/<%=user.getName() %>.jpg" />
			<table >
				<tr>
					<td>姓名</td>
					<td><%=user.getName() %></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><%=user.getPassword() %></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><%=user.getPhone() %></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td> <%=user.getEmail() %></td>
				</tr>
				<tr>
					<td>邮编</td>
					<td><%=user.getYoubian() %></td>
				</tr>		
			</table>
		</div>
		
	<%
		}
	%>
	<%
		if("true".equals(request.getAttribute("xiugai"))){
			User user = (User)request.getAttribute("user");
	%>
		<div class="imformation_div">
			<img id="UserImg"  src="images/<%=user.getName() %>.jpg" />
			<input type="file" name="image" id="imgOne" accept=".png,.jpg,.gif" onchange="preImg(this.id);" style=" position: absolute;
	 left: 250px;
	 top: 250px;">
			<input class="btn btn-info" onclick="saveUserImg()" type="submit" value="提交" >
			<table style="top:20px;left:450px;">
			<input type="hidden" id ="userid" value="<%=user.getId() %>"/>
					<tr>
						<td>姓名</td>
						<td><input type="text" id ="name" value="<%=user.getName() %>"/></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input type="text" id ="password" value="<%=user.getPassword() %>"/></td>
					</tr>
					<tr>
						<td>电话</td>
						<td><input type="text" id ="phone" value="<%=user.getPhone() %>"/></td>
					</tr>
					<tr>
						<td>邮箱</td>
						<td><input type="text" id ="email" value="<%=user.getEmail() %>"/> </td>
					</tr>
					<tr>
						<td>邮编</td>
						<td><input type="text" id ="postcode" value="<%=user.getYoubian()%>"/></td>
					</tr>	
					<tr>
						<td colspan="2" align="center" ><input type="button" id="changemsg" value="修改个人信息"/></td>
					</tr>
				</table>
		
		</div>
			
	<%
		}
	%>
	
	
	</div>	
</pre>

            </div>
        </div>
    </div>
    <script>
        function showChild(ele) {
            var childNav = ele.parentNode.getElementsByClassName('menu-child')[0];
            console.log(childNav)
            if (childNav.style.display === 'none') {
                childNav.style.display = 'block';
            } else {
                childNav.style.display ='none'
            }
        }
        
    </script>
    

</body>
</html>