<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ifsp.dsw3.model.dao.*,br.ifsp.dsw3.model.domain.*"%>
<%@page import="java.util.*"%>

<%
  Usuario u = null;
  String botao;

  if(request.getParameter("cpf")!=null){
    UsuarioDAO dao = new UsuarioDAO();
    String cpf = (request.getParameter("cpf"));
    u = dao.pesquisarPorCPF(cpf);
    botao = "Alterar";
  }else{
    u = new Usuario();
    botao = "Salvar";
  }
%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>DespesApp</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous" />
  <link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.5.0/font/bootstrap-icons.min.css">
  <link rel="stylesheet" href="css/stylecadastro.css" />
</head>

<body>

  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><i class="bi bi-currency-exchange"></i> DespesApp</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
      aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item active ml-3">
          <a class="nav-link" href="./index.html"><i class="bi bi-house-door"></i> Home</a>
        </li>
        <li class="nav-item ml-3">
          <a class="nav-link" href="./cadastro.jsp"><i class="bi bi-bookmarks"></i> Cadastrar</a>
        </li>
        <li class="nav-item ml-3">
          <a class="nav-link" href="./inserirDespesa.jsp"><i class="bi bi-cash"></i> Despesas</a>
        </li>
        <li class="nav-item ml-3">
          <a class="nav-link" href="./visualizar.jsp"><i class="bi bi-camera-video"></i> Visualizar</a>
        </li>
      </ul>
    </div>
  </nav>

  <main>
    <div class="containercard">
      <section>
        <div class="form-box">
            <div class="form-value">
                <form action="usuarios" method="POST">
                    <h2>Cadastrar Usuário</h2><br>
                    <div class="inputbox">
                        <label for="">CPF: </label>
                        <input type="number" required id="cpf" name="cpf" value="<%=u.getCpf()%>">
                    </div><br>
                    <div class="inputbox">
                        <label for="">Nome: </label>
                        <input type="text" required id="nome" name="nome" value="<%=u.getNome()%>">
                    </div><br>
                    <div class="inputbox">
                        <label for="">Salário: </label>
                        <input type="number" required id="salario" name="salario" value="<%=u.getSalario()%>">
                    </div><br>
                    <div class="inputbox">
                        <label for="">Email: </label>
                        <input type="email" required id="email" name="email" value="<%=u.getEmail()%>">
                    </div><br>
                    <div class="inputbox">
                        <label for="">Senha: </label>
                        <input type="password" required id="senha" name="senha" value="<%=u.getSenha()%>">
                    </div><br>
                    <button type="submit" name="enviar" value="<%=botao%>"><%=botao%></button>
                </form>
            </div>
        </div>
      </section>
    </div>
  </main>

  <footer>© 2023 Copyright: Leonardo Fattori</footer>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.3/umd/popper.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.2/js/bootstrap.min.js"></script>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
</body>

</html>