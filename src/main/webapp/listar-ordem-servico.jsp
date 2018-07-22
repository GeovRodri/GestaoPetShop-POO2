<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
					<th style="text-align: center;">Data</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ordemServico" items="${listOrdemServico}" varStatus="id">
					<tr>
						<td>${ordemServico.id}</td>
						<td>${ordemServico.cliente.nome}</td>
						<td>${ordemServico.animal.nome}</td>
						<td style="text-align: center;"><fmt:formatDate pattern = "dd/MM/yyyy" value="${ordemServico.dataServico}"/></td>
						<td style="text-align: center;">
							<a href="/ordem-servico/${ordemServico.id}" style="color: blue;">
								<i class="fas fa-edit"></i>
							</a>
							
							<a href="/ordem-servico/${ordemServico.id}/delete" style="color: red;">
								<i class="fas fa-trash-alt"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div align="right">
			<button type="submit" name = "criarCSV" class="btn btn-primary">Criar CSV</button>
		</div>
	</div>
</div>

<%@ include file="../../footer.jsp"%>