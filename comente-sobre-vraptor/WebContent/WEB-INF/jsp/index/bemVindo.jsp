<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index: Bem Vindo</title>
</head>
<body>
<h1>Bem vindo, ${usuarioLogado.usuario.nome }!</h1>
<h2>O que voc� quer fazer?</h2>

<a href="<c:url value="/discussao/novaPergunta"/>">iniciar discuss�o</a><br />
<a href="<c:url value="/discussao/ultimas"/>">responder discuss�o</a>

</body>
</html>