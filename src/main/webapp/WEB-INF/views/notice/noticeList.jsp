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
		<h1>${list.get(0).getNum()}</h1>
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

		
				<c:forEach items="${list}" var="dto2" varStatus="st">

					<tr class="warning">
						<td>${dto2.num}</td>
						<td><a href="./noticeSelect.notice?num=${dto2.num}">${dto2.title}</a></td>
						<td>${dto2.writer}</td>
						<td>${dto2.reg_date}</td>
						<td>${dto2.hit}</td>
						
					</tr>

				</c:forEach>

				
  
  
 
			</tbody>
		</table>
			<div>
				  <ul class="pagination">
				  				<!--gt=>표시와같다  -->
				  <c:if test="${pager.curBlock>1}">
				  	<li><a href="./noticeList?curPage=${pager.startNum-1}">이전</a></li>
				 </c:if>	
				 
				 	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				 
				 	<li><a href="./noticeList?curPage=${i}">${i}</a></li>
				 		
				 	</c:forEach>
				 			<!-- lt= <표시와 같다. -->
				 	<c:if test="${pager.curBlock lt pager.totalBlock}">
				 		<li><a href="./noticeList?curPage=${pager.lastNum+1}">다음</a></li>
				 		</c:if>
				</ul>
			</div>
		
		
  				<a href="./noticeWrite" >글쓰기</a>
		
</body>
</html>