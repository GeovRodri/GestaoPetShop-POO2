<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="../../header.jsp"%>

<div class="container-fluid">
	<c:if test="${not empty successMsg}">
		<div class="alert alert-success" role="alert">
		  ${successMsg}
		</div>
	</c:if>

	<div class="table-responsive">
		<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Espécie</th>
					<th>Raça</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="animal" items="${listAnimais}" varStatus="id">
					<tr>
						<td style="white-space:nowrap;">${animal.id}</td>
						<td style="white-space:nowrap;">${animal.nome}</td>
						<td style="white-space:nowrap;">${animal.especie}</td>
						<td style="white-space:nowrap;">${animal.raca}</td>
						
						<td style="text-align: center;">
							<a href="/animal/${animal.id}" style="color: blue;">
								<i class="fas fa-edit"></i>
							</a>
							
							<a href="/animal/${animal.id}/delete" style="color: red;">
								<i class="fas fa-trash-alt"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="../../footer.jsp"%>