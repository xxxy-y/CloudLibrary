<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%-- 这里必须写全路径，因为在jsp页面间的页面跳转不通过视图解析器的解析，而是通过 RequestDispatcher 进行的 --%>
<jsp:forward page="/WEB-INF/admin/login.jsp"/>
</body>
</html>