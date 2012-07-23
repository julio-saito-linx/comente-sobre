<%@ include file="/header.jsp" %> 


	<h1>LOGON</h1>
	<br />
	<h3>Usuário:</h3>
	<form method="post">
		<input name="nome">
		<input type="submit" value="Entrar">
	</form>
	
	<ul id="mensagensErroValidacao">
	<c:forEach var="error" items="${errors}">
		<li>
			${error.category} - ${error.message}
		</li>
	</c:forEach>
	</ul>
	
<%@ include file="/footer.jsp" %>