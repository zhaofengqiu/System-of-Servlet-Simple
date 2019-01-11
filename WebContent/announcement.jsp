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
<!-- ææ°ç Bootstrap æ ¸å¿ JavaScript æä»¶ -->
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
                    
                       <a href="javascript:void(0);" onclick="showChild(this)">个人信息管理</a>
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
                <a href="/administer/index">新闻</a> / <span></span>
            </div>
            <div class="admin-body">
                <div class="site-wrap">
                    
                    
                    
                </div>
                
<div class="admin-post">
    <ul>
        
        <li>
            2018-12-30
            <a class="article-title" href="http://www.wujiashuai.com/column/17wanggong/50" target="_blank">
                习近平总书记一月两次亲临我公司考察指导
            </a>

         	
        </li>
        
        <li>
            2018-12-30
            <a class="article-title" href="/administer/edit/20181230/mysqlanzhuang">
                房租抵税引房东恐慌 税务局：暂无加强房租收入征管通知
            </a>

             
        </li>
        
        <li>
            2018-12-24
            <a class="article-title" href="/administer/edit/20181224/structVPN">
              要买SUV别慌 本月新上市17款任你选
            </a>
 
        </li>
        
        <li>
            2018-12-21
            <a class="article-title" href="/administer/edit/20181221/ftppphone">
               银行窝案曝光！广发支行女行长为前夫违规放贷超亿元
            </a>
 
        </li>
        
        <li>
            2018-10-23
            <a class="article-title" href="/administer/edit/20181023/paixuduozhong">
               国民轿车一哥告别辉煌岁月：曾一辆车可买北京一套房
            </a>

         
        </li>
        
        <li>
            2018-10-21
            <a class="article-title" href="/administer/edit/20181021/gailvlunxiaojie">
                房东担忧缴税租客担心涨租 房租抵扣烦恼真的存在吗
            </a>

           
        </li>
        
        <li>
            2018-10-17
            <a class="article-title" href="/administer/edit/20181017/jiangdangwang">
               天津启动集中清理整顿保健品乱象专项整治行动，为期3个月
            </a>

         
        </li>
        
        <li>
            2018-10-08
            <a class="article-title" href="/administer/edit/20181008/bbrsheets">
              多部委划定“防风险”重点 多项金融防风险政策有望加速落地
            </a>
 
        </li>
        
        <li>
            2018-10-06
            <a class="article-title" href="/administer/edit/20181006/cssxiaojie">
                 美国文化净利两年降43% 负债率高于行业均值
            </a>
 
        </li>
        
        
        <li>
            2018-08-23
            <a class="article-title" href="/administer/edit/20180823/anzhuangpython">
               免征额提高、专项附加扣除：个税红包 照单全收
            </a>

 
        </li>
        
    </ul>
</div>

<div class="post-page site-box">
    <ul class="pages">
        
<ul class="pagination">
    <li style="display:none;">
        <a href="#">
            &laquo;
        </a>
    </li>
    
        
            
            <li>
                <a  class="active" href="/administer/posts?page=1">1</a>
            </li>
            
        
    
    <li style="display:none;">
        <a href="#">
            &raquo;
        </a>
    </li>
</ul>

    </ul>


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