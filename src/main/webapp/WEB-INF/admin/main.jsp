<%--
  Created by IntelliJ IDEA.
  User: wqt19
  Date: 2024/1/6
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
	<ul class="nav navbar-nav">
		<li class="dropdown user user-menu">
			<a>
				<img src="${pageContext.request.contextPath}/img/user.jpg" class="user-image" alt="User Image"/>
				<span class="hidden-xs">${USER_SESSION.name}</span>
			</a>
		</li>
		<li class="dropdown user user-menu">
			<a href="${pageContext.request.contextPath}/logout">
				<span class="hidden-xs">注销</span>
			</a>
		</li>
	</ul>
</body>
</html>