<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="../../header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container-fluid">
	<form:form method="post" modelAttribute="animalForm" action="/animal/${id != null ? id: ''}">

		<div class="row">
			<spring:bind path="nome">
				<div class="col-md-6 form-group">
					<label class="control-label">Nome</label> 
					<form:input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" path="nome" />
					<form:errors path="nome" class="control-label" />
				</div>
			</spring:bind>
			
			<spring:bind path="especie">
				<div class="col-md-6 form-group">
					<label class="control-label">Espécie</label> 
					<form:input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" path="especie" />
					<form:errors path="especie" class="control-label" />
				</div>
			</spring:bind>
		</div>
		
		<div class="row">	
			<spring:bind path="raca">
				<div class="col-md-6 form-group">
					<label class="control-label">Raça</label> 
					<form:input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" path="raca" />
					<form:errors path="raca" class="control-label" />
				</div>
			</spring:bind>
		</div>

		<div align="right">
			<button type="submit" class="btn btn-primary">Salvar</button>
		</div>
	</form:form>
</div>

<%@ include file="../../footer.jsp"%>