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
			
			<h1>QnA List Page</h1>
			
			
		
		<table class="table">
			<thead>
				<tr class="info">
					<th>Num</th>
					<th>Title</th>
					<th>Writer</th>
					<th>Date</th>
					<th>Hit</th>
					<th>Ref</th>
					<th>Step</th>
					<th>Depth</th>
				</tr>
			</thead>
			<tbody>

		
				<c:forEach items="${list}" var="dto" varStatus="st">

					<tr class="warning">
						<td>${dto.num}</td>
						<td><a href="">${dto.title}</a></td>
						<td>${dto.writer}</td>
						<td>${dto.reg_date}</td>
						<td>${dto.hit}</td>
						<td>${dto.ref}</td>
						<td>${dto.step}</td>
						<td>${dto.depth}</td>
						
					</tr>

				</c:forEach>

				
  
  
 
			</tbody>
		</table>
</body>
</html>