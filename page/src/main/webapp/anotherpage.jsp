<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><c:out value="${title}"></c:out></title>
<link rel="stylesheet" href="css/pagination.css" />
<style type="text/css">
body{font-size:84%; color:#333333; line-height:1.4;}
a{color:#34538b;}
#Searchresult{width:300px; height:100px; padding:20px; background:#f0f3f9;}
</style>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript">

$(function(){
	var afterAnnoyingOnLoad = false;

	var initPagination = function() {
		var num_entries = ${result.total};
		// 创建分页
		$("#Pagination").pagination(num_entries, {
			num_edge_entries: 1, //边缘页数
			num_display_entries: 4, //主体页数
			callback: pageselectCallback,
			current_page: ${result.pageNum} - 1,
			items_per_page:${result.pageSize} //每页显示1项
		});
	 }();
	 function pageselectCallback(page_index, jq){
		console.log(afterAnnoyingOnLoad);
		if (afterAnnoyingOnLoad){
			console.log("false");
			$("#pageNumber").val((page_index+1));
			console.log(page_index + " " +(new Date()));
			$("#stuForm").submit();
			return false;
		}
		else{
			console.log("true");
			afterAnnoyingOnLoad = true;
		}
	}
});
	
</script>
</head>

<body>
<h1>jQuery Pagination分页插件demo</h1>
<div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
<%
	String context = request.getContextPath();
%>

<div>
	<form action="<%=context%>/anotherpage" id="stuForm" method="post">
		<input type="hidden" name="pageNumber" id="pageNumber"/>
		<input type="submit"/>
	</form>
	<br/>
	
	
	<table border="1px" cellspacing="0px" style="border-collapse:collapse">
		<thead>
			<tr height="30">
				<th>ID</th>
				<th>name</th>
				<th>gendar</th>
			</tr>
		</thead>
		<c:forEach items="${result.list}" var="student">
			<tr>
				<td><c:out value="${student.id}"></c:out></td>
				<td><c:out value="${student.name}"></c:out></td>
				<td><c:out value="${student.gendar}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>
