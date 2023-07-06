<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
<script src="https://unpkg.com/isotope-layout@3.0.4/dist/isotope.pkgd.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/js/jquery.nice-select.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>board</title>
</head>
<body>
<h2 align="center">Q&A</h2>
<article>
<div class="container">
	<div class="table-responsive">
		<table class="table table-striped table-sm">

			<colgroup>
				<col style="width:5%;" />
				<col style="width:auto;" />
				<col style="width:15%;" />
				<col style="width:10%;" />
				<col style="width:10%;" />
			</colgroup>
			<thead>
				<tr>
					<th>NO</th>
					<th>글제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
					<c:if test="${list==null}">
					<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>
					</c:if>
					<c:forEach items="${list}" var="list">
						<tr>
							<td>${list.boardNo}</td>
							<td><a href="${pageContext.request.contextPath}/ReadQA.do?no=${list.boardNo}">${list.title}</a></td>
							<td>${list.member.id}</td>
							<td>${list.hits}</td>
							<td>${list.regDate}</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>

</div>

</article>
</body>

</html>