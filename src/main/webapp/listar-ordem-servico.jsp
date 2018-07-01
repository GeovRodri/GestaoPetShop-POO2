<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="../../header.jsp"%>
<jsp:useBean id="bean" class="br.edu.ifg.bean.ordemservico.ListarOrdemServicoBean" />

<div class="container-fluid">
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
				<c:forEach var="ordemServico" items="${bean.listOrdemServico}" varStatus="id">
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