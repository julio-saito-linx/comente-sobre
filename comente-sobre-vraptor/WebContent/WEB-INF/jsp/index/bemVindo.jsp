<%@ include file="/header.jsp" %> 


<h1>Bem vindo, ${usuarioLogado.usuario.nome }!</h1>
<br />
<h2>Aqui você pode comentar a vontade!</h2>
<br />
<h4><a href="<c:url value="/discussao/novaPergunta"/>">iniciar uma nova discussão</a></h4>
<br />
<h4><a href="<c:url value="/discussao/ultimas"/>">participar de uma conversa</a></h4>


<%@ include file="/footer.jsp" %>