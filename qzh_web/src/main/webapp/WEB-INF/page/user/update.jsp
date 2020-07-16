<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/res/js/jquery-1.12.4.js"></script>

<script type="text/javascript">


	function update() {
		$.post("<%=request.getContextPath()%>/user/update",
				$("#fm").serialize(),
				function(data){
			if(data.code != 200) {
				alert("删除失败")
			}
			window.location.href="<%=request.getContextPath()%>/user/toShow";
		})
	}
</script>
</head>
<body>

	<form id="fm">
			<input type="hidden" name="id" value="${user.id}" /> 
			用户名：<input type="text" name="userName" value="${user.userName}" /><br /> 
			密码：<input type="text" name="userPwd" value="${user.userPwd}" /><br />
			年龄：<input type="text" name="userAge" value="${user.userAge}" /><br />
			性别：女<input type="radio" name="userSex" value="0" />
				 男<input type="radio" name="userSex" value="1" /><br />

		<input type="button" onclick="update()" value="修改" /><br />
	</form>
</body>
</html>