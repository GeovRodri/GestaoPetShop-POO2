<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="../../header.jsp"%>

<div class="container-fluid">
	<c:if test="${not empty successMsg}">
		<div class="alert alert-success" role="alert">${successMsg}</div>
	</c:if>

	<div class="table-responsive">
		<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
			<thead>
				<tr>
					<!-- Titulo das tabelas -->
					<th>Id</th>
					<th>Animal</th>
					<th>Espécie</th>
					<th>Raça</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<!-- Esse items tem que ser igual ao nome que vc colocou lá no controller, no metodo listar-animal -->
				<c:forEach var="animal" items="${listAnimal}" varStatus="id">
					<tr>
						<!-- Conteudo das tabelas -->
						<!-- Antes de colocar os campos aqui verificar no Animal.java -->
						<td>${animal.id}</td>
						<td>${animal.dono.nome}</td>
						<td>${animal.idade}</td>
						
						<!-- Tem que transformar esses dois em links um para remover e o outro para atualizar -->
						<!-- Mas primeiro termina o cadastro e a listagem -->
						<td>Editar Excluir</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="../../footer.jsp"%>