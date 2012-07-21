<%@ include file="/header.jsp" %> 


	<table class="table">
		<c:forEach var="usu" items="${usuarioList }">
			<tr>
				<td>${usu.id }</td>
				<td><a href="<c:url value="/usuario/${usu.id }"/>">${usu.nome }</a></td>
			</tr>
		</c:forEach>
	</table>

<a href="<c:url value="/usuario/novo"/>">novo usuário</a>

<%@ include file="/footer.jsp" %>