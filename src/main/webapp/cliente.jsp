<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="../../header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="container-fluid">
	<form:form method="post" modelAttribute="clienteForm" action="/cliente/${id != null ? id: ''}">
		
		<div class="row">
			<spring:bind path="nome">
				<div class="col-md-4 form-group">
					<label class="control-label">Nome</label> 
					<form:input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" path="nome" />
					<form:errors path="nome" class="control-label" />
				</div>
			</spring:bind>
			
			<spring:bind path="cpf">
				<div class="col-md-4 form-group">
					<label class="control-label">CPF</label> 
					<form:input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" path="cpf" />
					<form:errors path="cpf" class="control-label" />
				</div>
			</spring:bind>
		</div>
			
		<div class="row">	
			<spring:bind path="endereco">
				<div class="col-md-4 form-group">
					<label class="control-label">Endereço</label> 
					<form:input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" path="endereco" />
					<form:errors path="endereco" class="control-label" />
				</div>
			</spring:bind>
			
			<spring:bind path="telefone">
				<div class="col-md-4 form-group">
					<label class="control-label">Telefone</label> 
					<form:input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" path="telefone" />
					<form:errors path="telefone" class="control-label" />
				</div>
			</spring:bind>
		</div>
		
		<div align="right">
			<button type="submit" class="btn btn-primary">Salvar</button>
		</div>
		
	</form:form>
</div>
<%@ include file="../../footer.jsp"%>