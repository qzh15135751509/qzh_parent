<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src ="<%=request.getContextPath()%>/res/js/jquery-1.12.4.js"></script>
    <script type="text/javascript">

       function test() {
            $.ajax({
                url:"<%=request.getContextPath()%>/users",
                dataType:"json",
                type:"post",
                data: {
                    "_method": "PUT", "id": 13,"userName":"kkkk",
                    success: function (data) {
                        alert(data);
                    }
                }
            });
       }
       function add() {
            $.ajax({
                url:"<%=request.getContextPath()%>/users",
                dataType:"json",
                type:"post",
                data: {
                    "_method": "POST","userName":"kkkk",
                    success: function (data) {
                        alert("操作成功");
                    }
                }
            });
       }
       function del() {
            $.ajax({
                url:"<%=request.getContextPath()%>/users",
                dataType:"json",
                type:"DELETE",
                data: {
                     "id": 17,
                },
                success: function (data) {
                    alert("操作成功");
                }
            });
       }
       function tests(){
           $.post("<%=request.getContextPath()%>/users/show",
               {"url":"http://localhost:8081/user/1"},
               function(data){

               })
       }



    </script>
</head>

<body>
    <input type="button" value="update" onclick="test()">
    <input type="button" value="add" onclick="add()">
    <input type="button" value="delete" onclick="del()">
    <input type="button" value="正向代理" onclick="tests()">
</body>
</html>
