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