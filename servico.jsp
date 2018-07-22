<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="../../header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container-fluid">
	<form:form method="post" modelAttribute="servicoForm" action="/servico/${id != null ? id: ''}">

		<div class="row">
			<spring:bind path="tipo">
				<div class="col-md-6 form-group">
					<label class="control-label">Tipo</label> 
					<form:input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" path="tipo" />
					<form:errors path="tipo" class="control-label" />
				</div>
			</spring:bind>
			
			<spring:bind path="valor">
				<div class="col-md-6 form-group">
					<label class="control-label">Valor</label> 
					<form:input type="number" step="any" class="form-control ${status.error ? 'is-invalid' : ''}" path="valor" />
					<form:errors path="valor" class="control-label" />
				</div>
			</spring:bind>
		</div>
		
		<div class="row">	
			<spring:bind path="descricao">
				<div class="col-md-6 form-group">
					<label class="control-label">Descricao</label> 
					<form:input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" path="descricao" />
					<form:errors path="descricao" class="control-label" />
				</div>
			</spring:bind>
		</div>

		<div align="right">
			<button type="submit" class="btn btn-primary">Salvar</button>
		</div>
	</form:form>
</div>

<%@ include file="../../footer.jsp"%>