<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="../../header.jsp"%>
<jsp:useBean id="bean" class="br.edu.ifg.bean.ordemservico.OrdemServicoBean" />

<div class="container-fluid">
	<form>
		<div class="form-group">
			<div class="form-row">
				<div class="col-md-6">
					<label for="clienteInput">Cliente</label>
					<select class="form-control" name="clienteId" id="clienteInput">
						<option value="">Selecione um cliente</option>
						<c:forEach var="cliente" items="${bean.clientes}" varStatus="id">
							<option value="${cliente.id}">${cliente.nome}</option>
				        </c:forEach>
					</select>
				</div>
				<div class="col-md-6">
					<label for="animalInput">Animal</label>
					<select class="form-control" name="animalId" id="animalInput">
						<option value="">Selecione um Animal</option>
						<c:forEach var="animal" items="${bean.animais}" varStatus="id">
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
		
		<button type="button" class="btn btn-primary" onclick="salvar()">Salvar</button>
	</form>
</div>

<script>
  		function salvar() {
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
                	alert(error);
                }
              });
	    }
</script>

<%@ include file="../../footer.jsp"%>