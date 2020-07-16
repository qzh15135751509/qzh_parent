<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript"src="<%=request.getContextPath()%>/res/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	//赋选中复选框的值
	function selectedValue() {
		appliancesIds = $('input[name="id"]:checked');
		var chk_value = [];
		$.each(appliancesIds,function(){
			chk_value.push($(this).val());
		})
		$("#ids").val(chk_value);
		return chk_value;
	}
var pageNo = 0;
	//初始加载函数
	$(function(){
		search();
	})
	//展示
	function search(){
		$.post("<%=request.getContextPath()%>/user/show",
				$("#fm").serialize(),
				function(data){
					var html="";
					for (var i = 0; i <data.data.userList.length; i++) {
						var u = data.data.userList[i];
						html +="<tr>";
						html+="<td><input type = 'checkbox' name='id' value="+u.id+" /></td>";
						html +="<td>"+u.userName+"</td>";
						html +="<td>"+u.userPwd+"</td>";
						html +="<td>"+u.userAge+"</td>";

						if(u.userSex==0){
							html +="<td>女</td>";
						}else {
							html +="<td>男</td>";
						}
						html +="<td><input type='button' value='删除' onclick='del("+u.id+")'><input type='button' value='修改' onclick='toUpdate("+u.id+")'></td>";
						html +="</tr>";
					}
					$("#tbd").html(html);
					var pageNo = $("#pageNo").val();
					var pageHtml = "<a href='javascript:page("+(pageNo - 1)+")'>上一页</a>";
						pageHtml += "<a href='javascript:page("+(pageNo*1 + 1)+")'>下一页</a>";
						$("#pageInfo").html(pageHtml);
						pages = data.data.pages;
		})
	}

	function del(id) {
		$.post("<%=request.getContextPath()%>/user/delUser",
				{"id":id},
				function (data){
				if (data.code != 200){
					return;
				}
				search();
		});

	}
	function toUpdate(id) {
		location.href="<%=request.getContextPath()%>/user/toUpdate?id="+id;
	}

	function add() {
		location.href="<%=request.getContextPath()%>/user/toAdd";
	}
	function page(pageNo) {
		$("#pageNo").val(pageNo);
		if(pageNo < 1){
			return;
		}
		if(pageNo > pages){
			return;
		}
		search();
	}
	
</script>
</head>
		
<body>
<form id="fm">
	<input type="hidden" name="pageNo" value="1" id="pageNo">
	用户名:<input type="text" name="userName">
	年龄:<input type="text" name="startAge">~<input type="text" name="endAge">
	性别:女<input type="checkbox" name="userSex" value="0"> 男<input type="checkbox" name="userSex" value="1">
	<input type="button" value="查询" onclick="search()">
</form>
<input type="button" value="新增" onclick="add()">
	<table>
		
		<tr>
			<td>id</td>
			<td>姓名</td>
			<td>密码</td>
			<td>年龄</td>
			<td>性别</td>
		</tr>
		<tbody id="tbd">
		</tbody>
	</table>
<div id="pageInfo">

</div>
</body>
</html>