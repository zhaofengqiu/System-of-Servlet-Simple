<%@page import="com.entity.Message"%>
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
        <div class="admin-main" style="position:relative">
            <div class="body-tabs">
                <a href="">主页</a> / <span>消息</span>
            </div>
			<div class="admin-body">
	                
					<pre>
						<div>
					
					
						<%	
									
									if(request.getAttribute("messages") != null){
										String[] readys = {"未读","已读"};
								%>
										<div class="msgtable">
										
											<table border=1>
												<tr class="message_tr">
													<td class="message_table_td">编号</td>
													<td class="message_table_td">收件人</td>
													<td class="message_table_td">发件人</td>
													<td class="message_table_content_td">内容</td>
													<td class="message_table_td">是否已读</td>
													<td class="message_table_td"> 操作</td>
													
													
												</tr>
												
												<%
													List<Message> messages = (List<Message>)(request.getAttribute("messages"));
													for(Message u:messages){
												%>
														<tr class="message_tr">
														
															<td id="userId" class="message_table_td"><%=u.getId() %></td>
														
															<td class="message_table_td"><%=u.getReceiver() %></td>
															<td class="message_table_td" ><%=u.getSender() %></td>
															<td class="message_table_content_td"><a href="javascript:void(0);" onclick="showMessage(this)"><p class="substr"><%=u.getContent() %></p></a></td>
															<td class="message_table_td"><%=readys[u.getIsread()] %></td>
															<td class="message_table_td"><a href="javascript:void(0);" onclick=dele(this)>删除</a></td>
														</tr>
												<% 	
													}
												%>
												
											</table>
											<div class="msgtablebuttom">
												<span>当前页${pageNow}</span> 
												<span><a href="messages.jhtml?pageNow=${pageNow-1}">上一页</a></span>
												<span><a href="messages.jhtml?pageNow=${pageNow+1}">下一页</a></span>
												<span><a href ="messages.jhtml?choice=sendmsg">写信</a></span>
											</div>
											
										</div>
								<% 		
									}
										
								%>
								<%
								     if("true".equals(request.getAttribute("sendmsg"))){
								    	 
								%>
						<!-- 			<div class="sendmsgtable">
										<table > 
										 <tr>
										 	<td><label class="control-label">接收者</label></td>
										 	<td><input name="reciver" type="text" class="input-large" id="reciver"></td>
										 </tr>
										  <tr>
										  	<td><label class="control-label" >消息内容</label></td>
										  </tr>
										  <tr>
										  	<td colspan="2">
										  		<div class="control-group">
													<div class="controls">
													  	<textarea name="content" id="content" rows="10" cols="50"  style="resize:none;"></textarea>	 
												  </div>
												</div>
										  	</td>
										  </tr>
										  <tr>
										  	<td>
										  		
												<div class="span10 listing-buttons">
													<input name="sender" type="hidden"  id="sender" value=<%=request.getSession().getAttribute("username")%> />
													<input class="btn btn-info" type="button" id="sendmsg" value="点击发送" >
												</div>
										  	</td>
										  </tr>
									</div>
									
						-->
						
						
								<div class="admin-write">
					
							    	<form action="/administer/write" method="post">
							        
								        <div class="aticle-body">
								            <div class="write-body">
								            	<input name="sender" type="hidden"  id="sender" value=<%=request.getSession().getAttribute("username")%> />
								                <input  id="reciver" class="articletitle"name="reciver" placeholder=" 发送给" type="text" >
								                <div class="writebody">
								                    <textarea cols="80" id="content" name="body" rows="10"  style="display:block;"></textarea><br>
								                </div>
								                
								                <p><input class="btn btn-info save_draft" id="sendmsg" name="save_draft" type="button" value="点击发送"></p>
								  
								                
								            </div>
								        </div>
							        	<div class="clear"></div>
							    	</form>
					   
								</div>
								<%
								     }
								%>
						 
						 
						</div>	
					
					</pre>
	
	            </div>
	       
    </div>
     <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/simplemde/1.11.2/simplemde.min.css">
    <script src="https://cdn.bootcss.com/simplemde/1.11.2/simplemde.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/admin.js"></script>
    <script>
        function showChild(ele) {
            var childNav = ele.parentNode.getElementsByClassName('menu-child')[0];
            if (childNav.style.display === 'none') {
                childNav.style.display = 'block';
            } else {
                childNav.style.display ='none'
            }
        }
        function showMessage(ele){
        	alert(ele.children[0].innerHTML.replace(/\s*/g,""));
        	sendRead(ele);
        }
        function sendRead(ele){
         
        	var userid=ele.parentNode.parentNode.getElementsByTagName('td')[0].innerHTML 
        	$.ajax({
    			type: "POST",
    			url: "messages.jhtml?choice=isread",
    			data: "id=" + userid ,
    			dataType: 'html',
    			success: function(result,status,xhr) {

    				if (xhr.status ==200) {
    					$(location).attr('href', '');
    					 
    				}

    			}
    		});
        }
        function dele(ele){
        	if(confirm("是否删除该条信息？")==false){
    			return false
    		}
        	var userid=ele.parentNode.parentNode.getElementsByTagName('td')[0].innerHTML 
        	$.ajax({
    			type: "POST",
    			url: "messages.jhtml?choice=delete",
    			data: "id=" + userid ,
    			dataType: 'html',
    			success: function(result,status,xhr) {
    				if (xhr.status ==200) {
    					alert("删除成功");		
    					$(location).attr('href', '');
    					 
    				}

    			}
    		});
        }
    </script>
</body>
</html>