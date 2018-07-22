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
					<th>Tipo</th>
					<th>Valor</th>
					<th>Descrição</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="servico" items="${listServicos}" varStatus="id">
					<tr>
						<td>${servico.id}</td>
						<td>${servico.tipo}</td>
						<td>${servico.valor}</td>
						<td>${servico.descricao}</td>
						
						<td style="text-align: center;">
							<a href="/servico/${servico.id}" style="color: blue;">
								<i class="fas fa-edit"></i>
							</a>
							
							<a href="/servico/${servico.id}/delete" style="color: red;">
								<i class="fas fa-trash-alt"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
