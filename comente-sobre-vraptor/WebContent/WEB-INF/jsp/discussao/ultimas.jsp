<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Últimas</title>
</head>
<body>
	<table>
		<c:forEach var="disc" items="${discussaoList }">
			<tr>
				<td>${disc.id }</td>
				<td><a href="<c:url value="/discussao/${disc.id}"/>">${disc.pergunta.usuario.nome }</a></td>
				<td><a href="<c:url value="/discussao/${disc.id}"/>">${disc.pergunta.texto }</a></td>
				<%--<td>${disc.pergunta.data }</td>--%>
			</tr>
		</c:forEach>
	</table>

	<a href="<c:url value="/discussao/novaPergunta"/>">nova pergunta</a>
</body>
</html>