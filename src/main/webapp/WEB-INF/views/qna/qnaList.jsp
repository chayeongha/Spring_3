<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/bootStrap.jsp" />

</head>
<body>
	<div>
		<form action="./qnaList">
			<select name="kind">
				<option value="kt">Title</option>
				<option value="kc" >Contents</option>
				<option value="kw">Writer</option>

			</select> <input type="text" name="search" value="${pager.search}">
			<button>검색</button>

		</form>

	</div>

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


			<c:forEach items="${list}" var="vo">

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

	 <div>
	 	 <ul class="pagination">
		 	 <c:if test="${pager.curBlock gt 1}">
			 	 <li><a href="./qnaList?curPage=${pager.startNum-1 }">이전</a></li>
		 	 </c:if>
			  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				  	<li><a href="./qnaList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			  	</c:forEach>
			 <c:if test="${pager.curBlock lt pager.totalBlock }">
				 <li><a href="./qnaList?curPage=${pager.lastNum+1 }">다음</a></li>		 
			 </c:if>
	  	 </ul>
	  </div>
	  <a href="./qnaWrite">Write</a>
	 </div>	
</body>
</html>