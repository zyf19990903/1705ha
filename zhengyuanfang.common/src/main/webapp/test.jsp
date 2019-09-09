<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path=request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="<%=path%>/css/css.css"/> 
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(":button").click(function(){
			$.post("test.do",$("form").serialize(),function(data){
				if(data==0){
					alert("验证失败")
				}
			})
		})
	})
</script>
</head>
<body>
	<form>
		<table>
			<tr>
				<td>介绍</td>
				<td>
					<textarea rows="10" cols="20" name="str">
						
					</textarea>
				</td>
			</tr>
			<tr>
				<td>手机号</td>
				<td>
					<input type="text" name="phone">
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td>
					<input type="text" name="email">
				</td>
			</tr>
			<tr>
				<td colspan="10">
					<input type="button" value="提交">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>