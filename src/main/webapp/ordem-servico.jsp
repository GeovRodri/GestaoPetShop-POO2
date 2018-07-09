<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="../../header.jsp"%>

<div class="container-fluid">
	<form>
		<div class="form-group">
			<div class="form-row">
				<div class="col-md-6">
					<label for="clienteInput">Cliente</label>
					<select class="form-control" name="clienteId" id="clienteInput">
						<option value="">Selecione um cliente</option>
						<c:forEach var="cliente" items="${clientes}">
							<option value="${cliente.id}">${cliente.nome}</option>
				        </c:forEach>
					</select>
				</div>
				<div class="col-md-6">
					<label for="animalInput">Animal</label>
					<select class="form-control" name="animalId" id="animalInput">
						<option value="">Selecione um Animal</option>
						<c:forEach var="animal" items="${animais}" varStatus="id">
							<option value="${animal.id}">${animal.nome}</option>
				        </c:forEach>
					</select>
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<div class="form-row">
				<div class="col-md-6">
					<label for="dataInput">Data</label> 
					<input class="form-control" id="dataInput" name="data" type="date">
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<div class="form-row">
				<div class="col-md-5">
					<label for="servicoInput">Serviço</label>
					<select class="form-control" name="servicoId" id="servicoInput">
						<option value="">Selecione um Serviço</option>
						<c:forEach var="servico" items="${servicos}" varStatus="id">
							<option value="${servico.id}">${servico.nome}</option>
				        </c:forEach>
					</select>
				</div>
				
				<div class="col-md-1" style="padding-top: 2rem;">
					<button type="button" class="btn btn-primary" onclick="salvar()">Adicionar</button>
				</div>
			</div>
		</div>
		
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th>Serviço</th>
						<th>Preço</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${itensOrdemDeServico}" varStatus="id">
						<tr>
							<td>${item.servico.nome}</td>
							<td>${item.servico.preco}</td>
							<td>
								Excluir
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div align="right">
			<button type="button" class="btn btn-primary" onclick="salvar()">Salvar</button>
		</div>
	</form>
</div>

<script>
  		function salvar() {
  			if (!$('#clienteInput').val() || $('#animalInput').val() || $('#dataInput').val()) {
  				alert('Preencha todos os campos obrigatórios!');
  			} else {
  			
	  			$.ajax({    
	                type: 'POST',
	                url: 'ordem-servico',
	                data: {
	                	clienteId: $('#clienteInput').val(),
	                	animalId: $('#animalInput').val(),
	                	data: $('#dataInput').val()
	                },
	                success: function(){
	                  alert('Ordem de Serviço salva com sucesso!');
	                },
	                error: function(error){
	                	alert('Erro ao salvar a ordem de servico!');
	                }
	           });
  			}
	    }
</script>

<%@ include file="../../footer.jsp"%>