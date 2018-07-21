<%@ include file="../../header.jsp"%>

<div class="container-fluid">
<div class="container-fluid">
	<form:form method="post" modelAttribute="clienteForm" action="/cliente">
		
		<div class="row">
			<spring:bind path="nome">
				<div class="col-md-4 form-group">
					<label>Nome</label>
					<input type="text" name="nome"/>
				</div>
			</spring:bind>
		</div>
		
		<div class="row">
			<spring:bind path="cpf">
				<div class="col-md-4 form-group">
					<label>CPF</label>
					<input type="number" name="cpf"/>
				</div>
			</spring:bind>
		</div>
		
		<div class="row">
			<spring:bind path="endereco">
				<div class="col-md-4 form-group">
					<label>Endereço</label>
					<input type="text" name="endereco"/>
				</div>
			</spring:bind>
		</div>
		
		<div class="row">
			<spring:bind path="telefone">
				<div class="col-md-4 form-group">
					<label>Telefone</label>
					<input type="text" name="telefone"/>
				</div>
			</spring:bind>
		</div>
		
		
		<spring:bind path="dt_cad">
			<div class="col-md-4 form-group">
				<label for="dataInput">Data</label> 
				<input class="form-control ${status.error ? 'is-invalid' : ''}" id="dataInput" name="dt_cad" type="date">
			</div>
		</spring:bind>
		
		
		<div align="right">
			<button type="submit" class="btn btn-primary">Salvar</button>
		</div>
		
	</form:form>

<%@ include file="../../footer.jsp"%>