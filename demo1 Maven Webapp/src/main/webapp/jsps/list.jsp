<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>测试</title>
<head>
    <base href="<%=basePath%>">
  <script type="text/javascript" src="/res/js/jquery-1.11.0.min.js"></script> 
  </head>
  
  <body>
     ${name} 
     <button type="button" onclick = "test();">测试</button>
  </body>
  <script>
  function test(){
  var data = {
    "id": "hello"
};
  var data1 = '{"id" : "test"}';
   console.log("{\"id\" : \"test\"}");
  console.log('{"id":"hello"}');
  //console.log(JSON.parse(data));
  $.post("/demo/test.json",data,function(data){
 alert(data.id);
  })
  }
  </script>
</html>
