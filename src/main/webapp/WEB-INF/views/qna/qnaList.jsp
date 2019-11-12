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
		<form id= "frm" action="./qnaList">
			<input type="hidden" id="curPage" value="1" name="curPage">
			
			<select name="kind">
				<option id="kt" value="kt">Title</option>
				<option id="kc" value="kc" >Contents</option>
				<option id="kw"  value="kw">Writer</option>
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
			 	<span id="${pager.startNum-1 }" class="List">이전</span>
		 	 </c:if>
			  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				 <span id="${i}" class="List">${i}</span> 
			  	</c:forEach>
			 <c:if test="${pager.curBlock lt pager.totalBlock }">
				<span id="${pager.lastNum+1 }" class="List">다음</span>
			 </c:if>
	  	 </ul>
	  </div>
	  
	  <a href="./qnaWrite">Write</a>
	 
	 
	 <!-- 제이쿼리 -->
	 <script type="text/javascript">
	 
	 	var kind ='${pager.kind}'
	 	
	 	if(kind=''){
	 		kind="kt";
	 	}
	 	$("#"+kind).prop("selected" ,true);
	 	$(".List").click(function () {
	 		$("#curPage").val($(this).attr("id"));
			$("#frm").submit();
			
		});
	 	
	
	 </script>
</body>
</html>