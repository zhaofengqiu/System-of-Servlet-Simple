<%@page import=" com.entity.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<%	
				
				if(request.getAttribute("contacts") != null){

			%>
					<div class="contacttable">
					
					
						<div>
							<table >
								<tr>
									<td>编号</td>
									<td>姓名</td>
									<td>性别</td>
									<td>电话</td>
									<td>邮箱</td>
									<td>qq号码</td>
									<td>工作地点</td>
									<td>住址</td>
									<td>邮编</td>
									<td><a href="">操作</a></td>
								</tr>
								
								<%
									List<Contact> contacts = (List<Contact>)(request.getAttribute("contacts"));
									for(Contact u:contacts){
								%>
										<tr>
											<td><%=u.getId()%></td>
											<td><%=u.getName()%></td>
											<td><%=u.getSex()%></td>
											<td><%=u.getPhone()%></td>
											<td><%=u.getEmail()%></td>
											<td><%=u.getQq()%></td>
											<td><%=u.getWorkspace()%></td>
											<td><%=u.getAddress()%></td>
											<td><%=u.getPostcode()%></td>
											<td><a Shref="javascript:void(0);" onclick=deleteuser(<%=u.getId() %>)>删除</a></td>
										</tr>
								<% 		
									}
								%>
								
							</table>
						
						</div>
						
						<div class="contacttablebuttom">
							<span>当前页${pageNow}</span> 
							<span><a href="contains.jhtml?pageNow=${pageNow-1}">上一页</a></span>
							<span><a href="contains.jhtml?pageNow=${pageNow+1}">下一页</a></span>
							<span><a href ="contains.jhtml?choice=createnew">新建联系人</a></span>
						</div>
					</div>
					
			<% 		
				}
					
			%>
			<%
				if("true".equals(request.getAttribute("create"))){
			%>		<div class="createcontacttable">
						<table border=1>
							<tr>
								<th>姓名</th>
								<th><input type="text" id="name"/></th>
							</tr>
							<tr>
								<th>性别</th>
								<th><input type="text" id="sex" /></th>
							</tr>
							<tr>
								<th>手机</th>
								<th><input type="text" id="phone" /></th>
							</tr>
							<tr>
								<th>E—mail</th>
								<th><input type="text" id="email" /></th>
							</tr>
							<tr>
								<th>QQ号码</th>
								<th><input type="text" id="qq" /></th>
							</tr>
							<tr>
								<th>工作单位</th>
								<th><input type="text" id="workspace" /></th>
							</tr>
							<tr>
								<th>地址</th>
								<th><input type="text" id="address" /></th>
							</tr>
							<tr>
								<th>邮编</th>
								<th><input type="text" id="postcode" /></th>
							</tr>
							<tr>
								<th><button id="update" class="btn btn-primary btn-lg active btn-sm">提交</button></th>
								<th><button onclick="window.location.href='contains.jhtml?choice=createnew'" class="btn btn-primary btn-lg active btn-sm">重置</button></th>
							</tr>
						</table>
						<span><a class="btn btn-primary btn-sm" href ="contains.jhtml">查看通讯录</a></span>
					</div>
					
						
					
			<%
				}
			%>	
				
			
			
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