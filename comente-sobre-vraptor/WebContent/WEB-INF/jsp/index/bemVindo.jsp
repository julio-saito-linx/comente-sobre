<%@ include file="/header.jsp" %> 


<h1>Bem vindo, ${usuarioLogado.usuario.nome }!</h1>
<h2>O que voc� quer fazer?</h2>

<a href="<c:url value="/discussao/novaPergunta"/>">iniciar discuss�o</a><br />
<a href="<c:url value="/discussao/ultimas"/>">responder discuss�o</a>


<%@ include file="/footer.jsp" %>