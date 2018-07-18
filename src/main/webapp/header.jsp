<!DOCTYPE html>
<html lang="pt-BR">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Gestão de PetShop</title>
  <!-- Bootstrap core CSS-->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
  <!-- Custom styles for this template-->
  <link href="assets/css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.jsp">Gestão de PetShop</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Ordem de Serviço">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseOrdemServico" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-angle-right"></i>
            <span class="nav-link-text">Ordem de Serviço</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseOrdemServico">
            <li>
              <a href="ordem-servico">Novo</a>
            </li>
            <li>
              <a href="listar-ordem-servico">Listar</a>
            </li>
          </ul>
        </li>
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Clientes">
       	  <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseClientes" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-angle-right"></i>
            <span class="nav-link-text">Clientes</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseClientes">
            <li>
              <a href="cliente.jsp">Novo</a>
            </li>
            <li>
              <a href="listar-clientes.jsp">Listar</a>
            </li>
          </ul>
        </li>
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Animais">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseAnimais" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-angle-right"></i>
            <span class="nav-link-text">Animais</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseAnimais">
            <li>
              <a href="animal.jsp">Novo</a>
            </li>
            <li>
              <a href="listar-animais.jsp">Listar</a>
            </li>
          </ul>
        </li>
        
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="ServiÃ§o">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseServico" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-angle-right"></i>
            <span class="nav-link-text">Serviço</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseServico">
            <li>
              <a href="servico.jsp">Novo</a>
            </li>
            <li>
              <a href="listar-servicos.jsp">Listar</a>
            </li>
          </ul>
        </li>
        
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">