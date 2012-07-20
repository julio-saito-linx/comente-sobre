<%@ include file="/header.jsp" %> 


	<table class="table">
		<c:forEach var="disc" items="${discussaoList }">
			<tr>
				<td>${disc.id }</td>
				<td><a href="<c:url value="/discussao/${disc.id}"/>">${disc.pergunta.usuario.nome }</a></td>
				<td><a href="<c:url value="/discussao/${disc.id}"/>">${disc.pergunta.texto }</a></td>
				<%--<td>${disc.pergunta.data }</td>--%>
			</tr>
		</c:forEach>
	</table>

	<a href="<c:url value="/discussao/novaPergunta"/>">nova pergunta</a>

<%@ include file="/footer.jsp" %>