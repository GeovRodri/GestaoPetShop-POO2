<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="../../header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/ -->

<div class="container-fluid">
	<form:form method="post" modelAttribute="ordemServicoForm" action="/ordem-servico/${id != null ? id: ''}">
		
		<div class="row">
			<spring:bind path="clienteId">
				<div class="col-md-4 form-group">
					<label class="control-label">Cliente</label>
					<form:select path="clienteId" class="form-control ${status.error ? 'is-invalid' : ''}">
						<form:option value="">Selecione um cliente</form:option>
						<c:forEach var="cliente" items="${clientes}">
							<form:option value="${cliente.id}">${cliente.nome}</form:option>
				        </c:forEach>
					</form:select>
					<form:errors path="clienteId" class="control-label" />
				</div>
			</spring:bind>
			
			<spring:bind path="animalId">
				<div class="col-md-4 form-group">
					<label class="control-label">Animal</label>
					<form:select path="animalId" class="form-control ${status.error ? 'is-invalid' : ''}">
						<form:option value="">Selecione um Animal</form:option>
						<c:forEach var="animal" items="${animais}" varStatus="id">
							<form:option value="${animal.id}">${animal.nome}</form:option>
				        </c:forEach>
					</form:select>
					<form:errors path="animalId" class="control-label" />
				</div>
			</spring:bind>
		
			<spring:bind path="data">
				<div class="col-md-2 form-group">
					<label class="control-label">Data</label> 
					<form:input path="data" class="form-control ${status.error ? 'is-invalid' : ''}" type="date" id="datePicker"/>
					<form:errors path="data" class="control-label" />
				</div>
			</spring:bind>
			
							
				<div class="col-md-2 form-group">
					<label class="control-label">Serviço Recorrente</label>					
						<div class="custom-control custom-checkbox">
						  <form:checkbox class="custom-control-input" path="recurringService" id="recurringService"/>
						  <form:errors path="recurringService" class="control-label" />
						  <label class="custom-control-label" for="recurringService"></label>
						</div>
				</div>
					
					
				<!-- 
				<div class="col-md-2 form-group">
					<label class="control-label">Serviço Recorrente</label>					
						<div class="custom-control custom-checkbox">
						  <input type="checkbox" class="custom-control-input" id="recurringService">
						  <label class="custom-control-label" for="recurringService"></label>
						</div>
				</div>
				-->
				
		</div>
		
		<div class="row">
			<spring:bind path="servicos">
				<div class="col-md-6 form-group">
					<label class="control-label">Serviços</label>
					<form:select path="servicos" multiple="true" class="form-control ${status.error ? 'is-invalid' : ''}">
					    <form:options items="${listServicos}" itemLabel="tipoeValor" itemValue="id" />
					</form:select>
					<form:errors path="servicos" class="control-label" />
			  	</div>
			</spring:bind>
		</div>
		
		
		<div align="right">
			<button type="submit" class="btn btn-primary">Salvar</button>
		</div>
	</form:form>
</div>

<script>
	document.getElementById('datePicker').valueAsDate=new Date();
</script>

<%@ include file="../../footer.jsp"%>