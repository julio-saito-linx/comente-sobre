<%@ include file="/header.jsp" %> 


Id: ${usuario.id }
<br />
Nome: ${usuario.nome }
<br />
<br />
<a href="<c:url value="/usuario" />">voltar</a>
<br />
<br />
<a href="<c:url value="/usuario/${usuario.id }/xml" />">XML</a>
<br />
<a href="<c:url value="/usuario/${usuario.id }/json" />">JSON</a>

<%@ include file="/footer.jsp" %>