<%@ include file="/header.jsp"%>


<h1>Criar nova discussão</h1>
<br />
<h3>Sobre o que quer conversar?</h3>
<br />
<br />
<form method="post">
	<div class="row">
		<div class="span12">
			<textarea name="pergunta" cols="80" rows="4"></textarea>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<input type="submit" value="Criar">
		</div>
	</div>
</form>

<%@ include file="/footer.jsp"%>