<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*,model.Student,model.StudentPage"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<form>
		<table align="center" style="width: 60%;" border="1">
			<tr>
				<th>学生编号</th>
				<th>学生姓名</th>
				<th>学生年龄</th>
			</tr>
			<c:forEach items="${blogPage.pagerecord}" var="st">
				<tr>
					<td>${st.id}</td>
					<td>${st.name}</td>
					<td>${st.age}</td>
				</tr>
			</c:forEach>
			<tr>
				<td class="altbg2" colspan="7" rowspan="2" align="right">
					总共【${blogPage.totalpage}】页
					&nbsp;&nbsp;${blogPage.pageno}/${blogPage.totalpage}&nbsp;&nbsp; <a
					href="a.do?pageno=1">首页</a> <c:choose>
						<c:when test="${blogPage.totalpage > 1}">
							<a href="a.do?pageNo=${blogPage.pageno-1}">上一页</a>
						</c:when>
						<c:otherwise>
                                                      上一页
                    </c:otherwise>
					</c:choose> <c:choose>
						<c:when test="${blogPage.pageno <blogPage.totalpage}">
							<a href="a.do?&pageno=${blogPage.pageno+1}">下一页</a>
						</c:when>
						<c:otherwise>
                                                                 下一页
                    </c:otherwise>
					</c:choose> <a href="a.do?pageno=${blogPage.totalpage}">尾页</a>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>