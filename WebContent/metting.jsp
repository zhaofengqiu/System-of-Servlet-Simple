<%@page import=" com.entity.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><%=request.getSession().getAttribute("username")%></title>
    <meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1" />
    <meta name="apple-mobile-web-app-status-bar-style" content="blank" />
    
    <link rel="stylesheet" type="text/css" href="css/blog.css">
    <link rel="stylesheet" type="text/css" href="css/column.css">
    <link rel="stylesheet" type="text/css" href="http://www.wujiashuai.com/static/css/fontello.css">
    <link rel="stylesheet" href="css/default.css"/>
    
</head>
<body data-spy="scroll" data-target="#toc">
    <div class="container">

        <div id="header" class="site-header headroom">
            <!-- PC -->
            <div class="site-wrap">

                <div class="site-logo">
                    <a href="login.jhtml" class="logo">
                        	公司公告
                        
                    </a>
                    <span><%=request.getSession().getAttribute("username")%></span>
                </div>
                
                

            </div>
        </div>

        <div class="site-wrap main-container">

 <div class="article-main site-box">
    <div class="column-list">
        
        <div class="column-box">
            <a class="column" href="/column/14">2019年元旦放假事宜</a>
            <div class="article-meta" style="padding: 0;">
                <span class="post-time"><i class="demo-icon icon-calendar"></i>2018-11-20</span>
                <span><i class="demo-icon icon-heart-empty">已读：2</i></span>
            </div>
            <div class="column-profile">
           ,我们召开这个座谈会,主要是听听...企业中,我国民营企业由2010年的1家增加到2018年的...
            </div>
        </div>
        
        <div class="column-box">
            <a class="column" href="/column/13">国庆加班人员工资补偿</a>
            <div class="article-meta" style="padding: 0;">
                <span class="post-time"><i class="demo-icon icon-calendar"></i>2018-10-23</span>
                <span><i class="demo-icon icon-heart-empty">已读：2</i></span>
            </div>
            <div class="column-profile">
            018年国庆期间加班工资该怎么算?2018年周末加班...加班费或者经济补偿;劳动报酬低于当地最低工资标准的...
            </div>
        </div>
        
        <div class="column-box">
            <a class="column" href="http://www.wujiashuai.com/column/17wanggong/51" target="_blank">双十一停电公告</a>
            <div class="article-meta" style="padding: 0;">
                <span class="post-time"><i class="demo-icon icon-calendar"></i>2018-10-07</span>
                <span><i class="demo-icon icon-heart-empty">已读：4</i></span>
            </div>
            <div class="column-profile">
            家电网平顶山供电公司发布公告:因电网改造与维修,11月8-12日平顶山市区一些地方将停电。
            </div>
        </div>
        
        <div class="column-box">
            <a class="column" href="/column/11">公司志愿者活动</a>
            <div class="article-meta" style="padding: 0;">
                <span class="post-time"><i class="demo-icon icon-calendar"></i>2018-10-01</span>
                <span><i class="demo-icon icon-heart-empty">已读：3</i></span>
            </div>
            <div class="column-profile">
            公司与长圻廖社区联合开展了学雷锋慰问孤寡老人志愿者活动,志愿者们进行入户调慰问孤寡老人、困难老人、残疾老年人,了解一些老人的生活情况,给予力所...
            </div>
        </div>
        
        <div class="column-box">
            <a class="column" href="/column/10">深度学习课程开展</a>
            <div class="article-meta" style="padding: 0;">
                <span class="post-time"><i class="demo-icon icon-calendar"></i>2018-09-09</span>
                <span><i class="demo-icon icon-heart-empty">已读：5</i></span>
            </div>
            <div class="column-profile">
            java学习课程-致力于互联网应用研发培训,中国程序员认可的培训机构;java学习课程 开设Java,H5,UI设计,PHP,VR,linux,大数据,pyhton,物联网,区块链等12大课程培训!
            </div>
        </div>
        
        <div class="column-box">
            <a class="column" href="/column/9">学习Java课程的开展</a>
            <div class="article-meta" style="padding: 0;">
                <span class="post-time"><i class="demo-icon icon-calendar"></i>2018-09-08</span>
                <span><i class="demo-icon icon-heart-empty">已读：5</i></span>
            </div>
            <div class="column-profile">
            java学习课程-致力于互联网应用研发培训,中国程序员认可的培训机构;java学习课程 开设Java,H5,UI设计,PHP,VR,linux,大数据,pyhton,物联网,区块链等12大课程培训!
            </div>
        </div>
        
        <div class="column-box">
            <a class="column" href="/column/8">公司八八建军节的开展</a>
            <div class="article-meta" style="padding: 0;">
                <span class="post-time"><i class="demo-icon icon-calendar"></i>2018-08-27</span>
                <span><i class="demo-icon icon-heart-empty">已读：6</i></span>
            </div>
            <div class="column-profile">
            在中国人民解放军建军91周年到来之际,总公司开展了“八·一”建军节慰问活动。总公司机关、下属各单位协调...
            </div>
        </div>
        
        <div class="column-box">
            <a class="column" href="/column/6">关于做好习近平总书记的报告</a>
            <div class="article-meta" style="padding: 0;">
                <span class="post-time"><i class="demo-icon icon-calendar"></i>2018-08-24</span>
                <span><i class="demo-icon icon-heart-empty">已读：5</i></span>
            </div>
            <div class="column-profile">
           
            </div>
        </div>
        
    </div>
</div>




        </div>

        <div class="footer-box">
            <div class="footer">
                <div class="copyright">
                    2017  <i class="demo-icon icon-heart"></i>
                    <span></span>
                </div>
                <span class="powered-by"><a href="http://www.miitbeian.gov.cn/" target="_blank">浙ICP备18039472号</a></span>
                <!--<span class="cnzz-span"><script src="https://s22.cnzz.com/z_stat.php?id=1263956682&web_id=1263956682" language="JavaScript"></script></span>-->
            </div>
        </div>

        <div><span id="go-to-top"></span></div>
    </div>

<script src="js/myStorage.js"></script>
<script src="js/headroom.min.js"></script>
<script>
    // headroom
    var header = new Headroom(document.getElementById("header"), {
        tolerance: 0,
        offset : 70
    });
    header.init();
</script>

</body>
</html>