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
					<th style="text-align: center;">Data</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ordemServico" items="${listOrdemServico}" varStatus="id">
					<tr>
						<td>${cliente.id}</td>
						<td>${cliente.nome}</td>
						<td>${cliente.cpf}</td>
						<td>${cliente.endereco}</td>
						<td>${cliente.telefone}</td>
						<td style="text-align: center;"><fmt:formatDate pattern = "dd/MM/yyyy" value="${cliente.data}"/></td>
						<td style="text-align: center;">
							<a href="javascript:void(0)" style="color: blue;">
								<i class="fas fa-edit"></i>
							</a>
							<a href="javascript:void(0)"style="color: red;">
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