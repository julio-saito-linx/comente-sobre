﻿<%@ include file="/header.jsp" %> 


	<h2>Discussão</h2>
	<h3>${discussao.pergunta.texto }</h3>
	<h4>${discussao.pergunta.usuario.nome }</h4>
	<br />
	<br />
	<h3>Respostas</h3>
	<table class="table">
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


<%@ include file="/footer.jsp" %>