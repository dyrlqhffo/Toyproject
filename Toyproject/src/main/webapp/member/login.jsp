<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginstyle.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>로그인</title>
</head>
<body>
    
    <div class="login-card">
        <h2>로그인</h2>
        <h3>입력해주세요.</h3>

        <form class="login-form" action="${pageContext.request.contextPath}/Login.do">
            <input type="text" id="id" name="id" placeholder="Id">
            <input type="password" id="password" name="password" placeholder="Password">
            <span id="login-result"></span>
            <button type="button" id="login-btn">LOGIN</button>
            <div style="text-align:center;">
            	<a href="${pageContext.request.contextPath}/findPassword.jsp" style="text-decoration:none;">비밀번호가 기억 안나세요?</a>
           	<h5>계정이 없으신가요?&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/member/register.jsp"	align="center" style="text-decoration: none;">지금 만드세요 :)</a></h5>
           	</div>
        </form>
    </div>
    
<script>


	$(function() {
		$("#login-btn").click(function(event) {
			let id = $("#id").val();
			let pwd = $("#password").val();
			
			$.ajax({
				type: "post",
				url: "${pageContext.request.contextPath}/LoginAjax.do",
				data: {id: id, password: pwd},
				dataType: "json",
				success:function(result){
					if(result.jsonResult == "no"){
						alert("다시 확인해주세요.");
						event.preventDefault();
					}else{
						$(".login-form").submit();
					}
				}
			}); //ajax
		}); //click
	}); //function 
</script>    
    
</body>
</html>