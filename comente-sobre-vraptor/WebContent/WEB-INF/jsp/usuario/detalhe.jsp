<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhe do Usuário</title>
</head>
<body>
Id: ${usuario.id }
<br />
Nome: ${usuario.nome }
<br />
<br />
<a href="<c:url value="/usuario" />">voltar</a>
<br />
<br />
<a href="<c:url value="/usuario/${usuario.id }/xml" />">XML</a>
<br />
<a href="<c:url value="/usuario/${usuario.id }/json" />">JSON</a>
</body>
</html>