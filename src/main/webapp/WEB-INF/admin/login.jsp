<%--
  Created by IntelliJ IDEA.
  User: wqt19
  Date: 2024/1/5
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>云借阅-图书管理系统</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<div class="loginManage">
    <div class="py-container">
        <h4 class="sui-nav nav-tabs tab-wraped">
            云借阅-图书管理系统
        </h4>
        <div class="loginForm">
            <ul class="sui-nav nav-tabs tab-wraped">
                <li class="active">
                    <h3>账号登录</h3>
                </li>
            </ul>
            <div class="tab-content tab-wraped">
                <%-- 登录提示信息 --%>
                <span style="color: red">${msg}</span>
                <div id="profile" class="tab-pane active">
                    <form id="loginForm" class="sui-form" action="${pageContext.request.contextPath}/login" method="post">
                        <div class="input-prepend">
                            <span class="add-on loginName">用户名</span>
                            <input type="text" placeholder="企业邮箱" class="span2 input-xfat" name="email">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
