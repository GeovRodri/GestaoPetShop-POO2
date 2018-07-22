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
					<th>CPF</th>
					<th>Endereço</th>
					<th>Telefone</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cliente" items="${listClientes}" varStatus="id">
					<tr>
						<td>${cliente.id}</td>
						<td>${cliente.nome}</td>
						<td>${cliente.cpf}</td>
						<td>${cliente.endereco}</td>
						<td>${cliente.telefone}</td>
						
						<td style="text-align: center;">
							<a href="/cliente/${cliente.id}" style="color: blue;">
								<i class="fas fa-edit"></i>
							</a>
							
							<a href="/cliente/${cliente.id}/delete" style="color: red;">
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