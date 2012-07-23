<%@ include file="/header.jsp"%>

<img src="<c:url value="/img/comente-sobre-logo.png"/>">

<br />
<br />
<h2>Discussões anteriores:</h2>
<ul id="listaIndexDiscussoes">
	<c:forEach var="disc" items="${discussaoList }">
		<li><a
			href="<c:url value="/${disc.getPergunta().getTituloAmigavel()}"/>">${disc.pergunta.texto
				}</a> [ autor: ${disc.pergunta.usuario.nome } - ${disc.getRespostas().size() } respostas ]</li>
	</c:forEach>
</ul>
<br />
<h2>Iniciar nova discussão:</h2>
<form method="post" action="<c:url value="/discussao/novaPergunta"/>">
	<div class="row">
		<div class="span1" style="text-align: right;">titulo:</div>
		<div class="span10">
			<input type="text" name="titulo">
		</div>
	</div>
	<div class="row">
		<div class="span1" style="text-align: right;">descrição:</div>
		<div class="span10">
			<textarea name="texto" cols="80" rows="4"></textarea>
		</div>
	</div>
	<div class="row">
		<div class="offset1 span2">
			<input type="submit" value="Gravar">
		</div>
	</div>
</form>
<br>
<ul id="mensagensErroValidacao">
	<c:forEach var="error" items="${errors}">
		<li>${error.category} - ${error.message}</li>
	</c:forEach>
</ul>

<%@ include file="/footer.jsp"%>