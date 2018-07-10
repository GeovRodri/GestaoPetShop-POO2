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
					<th>Cliente</th>
					<th>Animal</th>
					<th>Data</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ordemServico" items="${listOrdemServico}" varStatus="id">
					<tr>
						<td>${ordemServico.id}</td>
						<td>${ordemServico.cliente.nome}</td>
						<td>${ordemServico.animal.nome}</td>
						<td>${ordemServico.dataServico}</td>
						<td>
							Editar Excluir
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="../../footer.jsp"%>