<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>회원가입</title>
</head>
<body>
    
    <div class="circle"></div>
    <div class="card">
        <div class="logo">
            <img src="${pageContext.request.contextPath}/images/logo.png" width="100" height="100">
        </div>
        <h2>Create Account</h2>
        <form class="form" action="${pageContext.request.contextPath}/RegisterMember.do" id="register-form">
            <input type="text" id="id" name="id" placeholder="Id"><span id="id-checkDuplicate"></span>
            <input type="password" id="password" name="password" placeholder="Password">
            <input type="text" id="name" name="name" placeholder="Name">
            <input type="text" id="tel" name="tel" placeholder="Tel">
            <input type="text" id="address" name="address" placeholder="address">
            <button type="button" id="register-btn">SIGN UP</button>
        </form>
        <footer>
            계정이 있다면?
            <a href="#">Here</a>
        </footer>
    </div>
    
<script>
	$(function() {
		
		$("#register-btn").click(function(event) {
			let id = $("#id").val();
			let pwd = $("#password").val();
			let name = $("#name").val();
			let tel = $("#tel").val();
			let address = $("#address").val();
			
			if(id.trim()==""){
				alert("아이디를 입력해주세요.");
				event.preventDefault();
			}else if(pwd.trim()==""){
				alert("비밀번호를 입력해주세요.");
				event.preventDefault();
			}else if(name.trim()==""){
				alert("이름을 입력해주세요.");
				event.preventDefault();
			}else if(tel.trim()==""){
				alert("번호를 입력해주세요.");
				event.preventDefault();
			}else if(address.trim()==""){
				alert("주소를 입력해주세요.");
				event.preventDefault();
			}
			
			
			
			$.ajax({
				type: "post",
				url: "${pageContext.request.contextPath}/RegisterAjax.do",
				data: {id: id},
				dataType: "json",
				success:function(result){
					if(result.jsonResult == "ok"){
						$("#id-checkDuplicate").html("<font color=red>존재하는 아이디입니다.</font>")
						event.preventDefault();
					}else{
						$("#register-form").submit();
					}
				}
				
			});//ajax
		})//click;
	});//function

</script>    
    
</body>
</html>