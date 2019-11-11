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

		<h1>Notice List Page</h1>
		<!-- <a href="./noticeSelect?n=33">Select One</a>
		<a href="./noticeWrite">Notice Write</a>
		<img alt="" src="../resources/images/Iu3.jpg"> -->
		
		<table class="table">
			<thead>
				<tr class="info">
					<th>Num</th>
					<th>Title</th>
					<th>Writer</th>
					<th>Date</th>
					<th>Hit</th>
				</tr>
			</thead>
			<tbody>


				<c:forEach items="${list}" var="dto" varStatus="st">

					<tr class="warning">
						<td>${dto.num}</td>
						<td><a href="./noticeSelect.notice?num=${pageScope.dto.num}">${pageScope.dto.title}</a></td>
						<td>${dto.writer}</td>
						<td>${dto.reg_date}</td>
						<td>${dto.hit}</td>
						
					</tr>

				</c:forEach>

				
  
  
 
			</tbody>
		</table>
			<div>
				  <ul class="pagination">
				 	<c:forEach begin="1" end="${totalPage}" var="i">
				 
				 	<li><a href="./noticeList?curPage=${i}">${i}</a></li>
				 		
				 	</c:forEach>
				</ul>
			</div>
		
		
  				<a href="./noticeWrite" >글쓰기</a>
		
</body>
</html>