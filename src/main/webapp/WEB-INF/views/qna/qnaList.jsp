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
			
				</tr>
			</thead>
			<tbody>

		
				<c:forEach items="${list}" var="vo" >

					<tr class="warning">
						<td>${vo.num}</td>
						<td><a href="./qnaSelect?num=${vo.num}">${vo.title}</a></td>
						<td>${vo.writer}</td>
						<td>${vo.reg_date}</td>
						<td>${vo.hit}</td>
					
					</tr>

				</c:forEach>

				

			</tbody>
		</table>
		
		<c:if test="${pager.curBlock gt 1} ">
		
			<a href="./qnaList?curPage=${pager.startNum-1}">[이전]</a>
		
		</c:if>
		
		<c:forEach begin="${pager.startNum} " end="${pager.lastNum }" var="i">
			<a href="./qnaList?curPage=${i}">${i}</a>
		</c:forEach>
		
		<c:if test="${pager.curBlock lt pager.totalBlock} ">
				<a href="./qnaList?curPage=${pager.lastNum+1}">[다음]</a>
		</c:if>
</body>
</html>