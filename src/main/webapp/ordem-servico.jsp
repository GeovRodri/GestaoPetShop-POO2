<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="../../header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/ -->

<div class="container-fluid">
	<form:form method="post" modelAttribute="ordemServicoForm" action="/ordem-servico">
		
		<div class="row">
			<spring:bind path="clienteId">
				<div class="col-md-4 form-group">
					<label for="clienteInput">Cliente</label>
					<select class="form-control ${status.error ? 'is-invalid' : ''}" name="clienteId" id="clienteInput">
						<option value="">Selecione um cliente</option>
						<c:forEach var="cliente" items="${clientes}">
							<option value="${cliente.id}">${cliente.nome}</option>
				        </c:forEach>
					</select>
				</div>
			</spring:bind>
			
			<spring:bind path="animalId">
				<div class="col-md-4 form-group">
					<label for="animalInput">Animal</label>
					<select class="form-control ${status.error ? 'is-invalid' : ''}" name="animalId" id="animalInput">
						<option value="">Selecione um Animal</option>
						<c:forEach var="animal" items="${animais}" varStatus="id">
							<option value="${animal.id}">${animal.nome}</option>
				        </c:forEach>
					</select>
				</div>
			</spring:bind>
		
			<spring:bind path="data">
				<div class="col-md-4 form-group">
					<label for="dataInput">Data</label> 
					<input class="form-control ${status.error ? 'is-invalid' : ''}" id="dataInput" name="data" type="date">
				</div>
			</spring:bind>
		</div>
		
		<div class="row">
			<spring:bind path="servicos">
				<div class="col-md-6 form-group">
					<label>Serviços</label>
					<form:select path="servicos" multiple="true" class="form-control ${status.error ? 'is-invalid' : ''}">
					    <form:options items="${servicos}" itemLabel="tipo" itemValue="id" />
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

<%@ include file="../../footer.jsp"%>