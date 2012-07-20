<%@ include file="/header.jsp" %> 


<h1>Bem vindo, ${usuarioLogado.usuario.nome }!</h1>
<h2>O que você quer fazer?</h2>

<a href="<c:url value="/discussao/novaPergunta"/>">iniciar discussão</a><br />
<a href="<c:url value="/discussao/ultimas"/>">responder discussão</a>


<%@ include file="/footer.jsp" %>