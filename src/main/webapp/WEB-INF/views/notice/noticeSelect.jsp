<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp"/>
</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<h1>Notice Select Page</h1>
	<div class="container">
<table class="table">
<thead>
<tr><th>NUM</th><th>TITLE</th><th>WRITER</th><th>CONTENTS</th><th>DATE</th><th>HIT</th></tr>
</thead>
<tbody>
<tr>
<td>${requestScope.dto.num}</td>
<td>${requestScope.dto.title} </td>
<td>${requestScope.dto.writer}</td>
<td>${requestScope.dto.contents}</td>
<td>${requestScope.dto.reg_date}</td>
<td>${requestScope.dto.hit}</td>

</tr>
</tbody>
</table>
</div>


<div class="button">

<a class="btn btn-danger" href="noticeUpdate?num=${dto.num} ">Update</a>
<a href="noticeDelete?num=${dto.num}" class="btn btn-primary">Delete</a>

</div>
	
</body>
</html>