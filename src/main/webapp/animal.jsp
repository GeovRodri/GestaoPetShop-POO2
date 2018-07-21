<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="../../header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/ -->

<div class="container-fluid">
	<form:form method="post" modelAttribute="animalForm" action="/animal">

		<div class="row">
			<!-- O nome que fica no path é o mesmo nome que vc quer mapear la no seu AnimalFormDTO-->
			<spring:bind path="nome">
				<div class="col-md-4 form-group">
					<label for="nomeInput">Nome</label> 
					<!-- Colocar o campo que vc quer, no caso se for um texto tem que ser um input do tipo text -->
					<input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" name="nome" id="nomeInput">
				</div>
			</spring:bind>
		</div>
		
			<spring:bind path="id">
				<div class="col-md-4 form-group">
					<label for="idInput">ID</label> 
					<input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" name="id" id="idInput">
				</div>
			</spring:bind>
			
			<spring:bind path="especie">
				<div class="col-md-4 form-group">
					<label for="especieInput">Espécie</label> 
					<input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" name="especie" id="especieInput">
				</div>
			</spring:bind>
			
			<spring:bind path="raca">
				<div class="col-md-4 form-group">
					<label for="racaInput">Raça</label> 
					<input type="text" class="form-control ${status.error ? 'is-invalid' : ''}" name="raca" id="racaInput">
				</div>
			</spring:bind>

		<div align="right">
			<button type="submit" class="btn btn-primary">Salvar</button>
		</div>
	</form:form>
</div>

<%@ include file="../../footer.jsp"%>