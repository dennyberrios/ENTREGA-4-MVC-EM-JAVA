<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="header-footer.css">
<link rel="shortcut icon" href="./assets/ico/logo-ico.png" type="image/x-icon">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>CRUD JAVA - Atualizar Cliente</title>
</head>
<body>
<!-- Cabeçalho/Barra de navegação -->
<header>
    <nav class="navbar navbar-expand-lg navbar-dark" id="navega">
        <div id="topo">
            <a href="#"><img class="logo" src="./assets/logo/life-logo.png" alt="Logo Life Style"></a>
        </div>
        <div>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <ul class="navbar-nav">
	                        <li class="nav-item dropdown">
						          <a class="nav-link active dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						            CLIENTE
						          </a>
						          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						            <li><a class="dropdown-item" href="index.html">Cadastre-se</a></li>
						            <li><a class="dropdown-item" href="lista.jsp">Lista de Clientes</a></li>
						          </ul>
					        </li>
			                <li class="nav-item dropdown">
						          <a class="nav-link active dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						            HOSPEDAGEM
						          </a>
						          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						            <li><a class="dropdown-item" href="hospedagemCadastro.jsp">Hospede-se</a></li>
						            <li><a class="dropdown-item" href="listaHospedagens.jsp">Lista de Hospedagem</a></li>
						          </ul>
					         </li>
                             <li class="nav-item dropdown">
						          <a class="nav-link active dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						            DESTINO
						          </a>
					          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					            <li><a class="dropdown-item" href="destino.html">Cadastrar Destino</a></li>
					            <li><a class="dropdown-item" href="listaDestino.jsp">Lista de destino</a></li>
					          </ul>
				        </li>
                    </ul>
                </ul>
            </div>
        </div>
    </nav>
</header>
<br>
<div class="container">
		    <div class="row">
         <div class="cold-md-7">
             <hr>
             <h3>Atualizar Hospedagem</h3>
             <hr>
             <form action="HospedagemUpdate" method="POST">
             	   <input value="${hospedage.id}" name="id" type="number" style="visibility:hidden">
                   <div class="form-floating mg-3">
                       <input value="${hospedage.nomeHotel}" name="nomeHotel" maxlength="80" type="text" class="form-control" id="floatingInput1" >
                       <label>Nome Completo</label>
                   </div>
                   <br>
                   <div class="form-floating mg-3">
                       <input value="${hospedage.endereco}" name="endereco" maxlength="20" type="text" class="form-control" >
                       <label>Cidade</label>
                   </div>
                   <br>
                   <div class="form-floating mg-3">
                       <input value="${hospedage.estado}" name="estado" maxlength="50" type="text" class="form-control" id="floatingInput1" >
                       <label>Estado</label>
                   </div>
                   <br>
                   <div class="form-floating mg-3">
                       <input value="${hospedage.valor}" name="valor" maxlength="50" type="text" class="form-control" id="floatingInput1" >
                       <label>Valor</label>
                   </div>
                   <br>
                   <div class="form-floating mg-3">
                       <input value="${hospedage.checkIn}" name="checkIn" maxlength="50" type="date" class="form-control" >
                       <label>Data de Ida </label>
                   </div>
                   <br>
                   <div class="form-floating mg-3">
                       <input value="${hospedage.checkOut}" name="checkOut" maxlength="50" type="date" class="form-control" >
                       <label>Data de volta </label>
                   </div>
                   <br>
                   <div class="form-floating mg-3">
                       <input value="${hospedage.telefoneHotel}" name="telefoneHotel" maxlength="50" type="text" class="form-control" id="floatingInput1">
                       <label>Telefone do hotel</label>
                   </div>
                   <br>
                   <button class="btn btn-success" type="submit">Atualizar Dados</button>
                   <button class="btn btn-secondary" type="reset">Limpar formulário</button>
             </form>
             <br>
         </div>
    </div>
</div>
   <!-- Rodape de apresentação de desenvolvimentor/voltar para o inicio do site -->
<footer>
        <div class="red-sociais">
            <div>
                <p>Conecte-se conosco nas redes sociais:</p>
            </div>
            <div>
                <a href="#"><img width="25px" src="./assets/svg/twiter.svg" alt="twiter"></a>
                <a href="#"><img width="25px" src="./assets/svg/gmail.svg" alt="gmail"></a>
                <a href="#"><img width="25" src="./assets/svg/linkedin.svg" alt="linkedin"></a>
                <a href="#"><img width="25" src="./assets/svg/github.svg" alt="github"></a>
            </div>
        </div>
        <hr>
        <div class="box-table">
            <div class="tab">
                <table>
                    <tr>
                        <th>
                            <h3><img width="50" src="./assets/ico/logo-ico-SFundo.png" alt=""> Life Style</h3>
                        </th>
                    </tr>
                    <tr>
                        <td>Empresa conceituada com 15 <br> anos no mercado. Os melhores <br> preços e serviços você
                            encontra <br> aqui.</td>
                    </tr>
                </table>
            </div>
            <div class="tab">
                <table>
                    <tr class="tr-footer">
                        <th><a class="rodFlex" href="">PRODUTOS</a></th>
                    </tr>
                    <tr class="tr-footer">
                        <td><a href="#">Hoteis</a></td>
                        <td><a href="#">Pacotes</a></td>
                        <td><a href="#">Passagens</a></td>
                        <td><a href="#">Transportes</a></td>
                    </tr>
                </table>
            </div>
            <div class="tab">
                <table>
                    <tr class="tr-footer">
                        <th><a class="rodFlex" href="">LINKS ÚTEIS</a></th>
                    </tr>
                    <tr class="tr-footer">
                        <td><a href="lista.jsp">Lista Cliente</a></td>
                        <td><a href="listaDestino.jsp">Lista Destino</a></td>
                        <td><a href="listaHospedagens.jsp">Lista Hospedagem</a></td>
                        <td><a href="#">Suporte</a></td>
                    </tr>
                </table>
            </div>
            <div class="tab">
                <table>
                    <tr class="tr-footer">
                        <th><a class="rodFlex" href="">CONTATO</a></th>
                    </tr>
                    <tr class="tr-footer">
                        <td><a class="rodFlex" href="#"> Brasil, Br 0000, BR</a></td>
                        <td><a class="rodFlex" href="#"> info@example.com</a></td>
                        <td><a class="rodFlex" href="#"> + 55 71 0000-0000</a></td>
                        <td><a class="rodFlex" href="#"> + 55 71 0000-0000</a></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="tab">
            <p>&copy; 2022 Copyright: <a href="#navega">Life-Style-viagens.com</a></p>

        </div>
</footer>
		<!-- JavaScript Bootstrap -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>