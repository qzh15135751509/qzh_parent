<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>Insert title here</title>
<script type="text/javascript" src = "<%=request.getContextPath()%>/res/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	function add() {
		$.post("<%=request.getContextPath()%>/user/add",
				$("#fm").serialize(),
				function(data){
					if(data.code != 200){
						alert(data.msg);
						return;
					}
					alert(data.msg);
					window.location.href="<%=request.getContextPath()%>/user/toShow";
		})
	}
</script>
</head>
<body>
	<form id="fm">
		性名:<input type="text" name="userName" /><br/>
		密碼:<input type="text" name="userPwd" /><br/>
		年龄:<input type="text" name="userAge" /><br/>
		性别：女<input type="radio" name="userSex" value="0" />
		男<input type="radio" name="userSex" value="1" /><br />

		<input type="button" value="增加" onclick="add()"> 
	</form>
</body>
</html>