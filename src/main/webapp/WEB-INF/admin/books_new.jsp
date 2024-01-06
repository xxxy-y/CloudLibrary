<%--
  Created by IntelliJ IDEA.
  User: wqt19
  Date: 2024/1/6
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
	<thead>
	<tr>
		<th class="sorting_asc">图书名称</th>
		<th class="sorting">图书作者</th>
		<th class="sorting">出版社</th>
		<th class="sorting">标准ISBN</th>
		<th class="sorting">书籍状态</th>
		<th class="sorting">借阅人</th>
		<th class="sorting">借阅时间</th>
		<th class="sorting">预计归还时间</th>
		<th class="text-center">操作</th>
	</tr>
	</thead>

	<tbody>
	<c:foreach items="${pageResult.rows}" var="book">
		<tr>
			<td>${book.name}</td>
			<td>${book.author}</td>
			<td>${book.press}</td>
			<td>${book.isbn}</td>
			<td>
				<c:if test="${book.statusB == 0}">可借阅</c:if>
				<c:if test="${book.statusB == 1}">借阅中</c:if>
				<c:if test="${book.statusB == 2}">归还中</c:if>
			</td>
			<td>${}</td>
			<td></td>
		</tr>
	</c:foreach>
	</tbody>
</table>
</body>
</html>
