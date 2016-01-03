<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jQuery Pagination分页插件demo</title>
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
	//这是一个非常简单的demo实例，让列表元素分页显示
	//回调函数的作用是显示对应分页的列表项内容
	//回调函数在用户每次点击分页链接的时候执行
	//参数page_index{int整型}表示当前的索引页
	var initPagination = function() {
		var num_entries = $("#hiddenresult div.result").length;
		// 创建分页
		$("#Pagination").pagination(num_entries, {
			num_edge_entries: 1, //边缘页数
			num_display_entries: 4, //主体页数
			callback: pageselectCallback,
			items_per_page:1 //每页显示1项
		});
	 }();
	 
	function pageselectCallback(page_index, jq){
		var new_content = $("#hiddenresult div.result:eq("+page_index+")").clone();
		$("#Searchresult").empty().append(new_content); //装载对应分页的内容
		return false;
	}
});
</script>
</head>

<body>
<h1>jQuery Pagination分页插件demo</h1>
<div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
<div id="Searchresult">分页初始化完成后这里的内容会被替换。</div>
<div id="hiddenresult" style="display:none;">
	<!-- 列表元素 -->
    <div class="result">第1项内容</div>
    <div class="result">第2项内容</div>
    <div class="result">第3项内容</div>
    <div class="result">第4项内容</div>
    <div class="result">第5项内容</div>
    <div class="result">第6项内容</div>
    <div class="result">第7项内容</div>
    <div class="result">第8项内容</div>
</div>
</body>
</html>
