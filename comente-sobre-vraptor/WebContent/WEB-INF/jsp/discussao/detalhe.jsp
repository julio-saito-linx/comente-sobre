<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Discussão</title>
</head>
<body>
	<h2>Discussão</h2>
	<h3>${discussao.pergunta.texto }</h3>
	<h4>${discussao.pergunta.usuario.nome }</h4>
	<br />
	<br />
	<h3>Respostas</h3>
	<table>
		<c:forEach var="mensagem" items="${discussao.respostas }">
			<tr>
				<td>${mensagem.usuario.nome }</td>
				<td>${mensagem.texto }</td>
			</tr>
		</c:forEach>
	</table>

	<h3>Responder:</h3>
	<form method="post">
		<input name="resposta"> <input type="submit" value="Responder">
	</form>

</body>
</html>