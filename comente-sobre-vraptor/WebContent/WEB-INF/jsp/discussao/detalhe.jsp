<%@ include file="/header.jsp"%>

<div class="row">
	<div class="span12">
		<h3>${discussao.pergunta.titulo }</h3>
	</div>
</div>
<div class="row">
	<div class="span12">
		<h4>${discussao.pergunta.texto }</h4>
	</div>
</div>
<div class="row">
	<div class="span2">autor: ${discussao.pergunta.usuario.nome }</div>
</div>

<br />
<br />

<c:forEach var="mensagem" items="${discussao.respostas }">
	<div class="row">
		<div class="span12">
			<p class="resposta">${mensagem.texto }</p>
		</div>
		<div class="row"></div>
		<div class="span2">
			<p class="autor">comentário de: ${mensagem.usuario.nome }</p>
			<br/>
		</div>
	</div>
</c:forEach>

<form method="post" action="<c:url value="/discussao/${discussao.getId()}"/>">
	<div class="row">
		<div class="span12">
			<input name="resposta">
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<input type="submit" value="Responder">
		</div>
	</div>
</form>
<ul id="mensagensErroValidacao">
	<c:forEach var="error" items="${errors}">
		<li>${error.category} - ${error.message}</li>
	</c:forEach>
</ul>

<%@ include file="/footer.jsp"%>