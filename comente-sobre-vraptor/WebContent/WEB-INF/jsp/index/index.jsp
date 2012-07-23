<%@ include file="/header.jsp"%>


<h1>Bem vindo, ${usuarioLogado.usuario.nome }!</h1>
<br />
<form method="post" action="<c:url value="/discussao/novaPergunta"/>">
	<div class="row">
		<div class="span1" style="text-align: right;">titulo:</div>
		<div class="span10">
			<input type="text" name="titulo">
		</div>
	</div>
	<div class="row">
		<div class="span1" style="text-align: right;">detalhes:</div>
		<div class="span10">
			<textarea name="texto" cols="80" rows="4"></textarea>
		</div>
	</div>
	<div class="row">
		<div class="offset1 span2">
			<input type="submit" value="Iniciar nova discussão">
		</div>
	</div>
</form>
<br>
<ul id="mensagensErroValidacao">
	<c:forEach var="error" items="${errors}">
		<li>${error.category} - ${error.message}</li>
	</c:forEach>
</ul>
<br>
<h2>Ultimas discussões:</h2>
<ul>
	<c:forEach var="disc" items="${discussaoList }">
		<li><a href="<c:url value="/discussao/${disc.id}"/>">${disc.pergunta.texto
				}</a> <span>(${disc.pergunta.usuario.nome })</span></li>
	</c:forEach>
</ul>

<%@ include file="/footer.jsp"%>