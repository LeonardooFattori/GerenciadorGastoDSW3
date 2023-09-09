<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.ifsp.dsw3.model.dao.*,br.ifsp.dsw3.model.domain.*"%>
<%@page import="java.util.*"%>
<%
  UsuarioDAO cdao = new UsuarioDAO();
  cdao.criarTabela();
  ArrayList<Usuario> usuarios = cdao.listar();

  DespesasDAO dao = new DespesasDAO();
  dao.criarTabela();
  ArrayList<Despesas> despesas = dao.listar();
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
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/styleVisualizar.css" />
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

    <div class="container" id="listagem">
      <h2 class="text-center">Lista de Usuarios</h2><br>
        <table class="table table-light table-striped table-hover table-sm">
          <thead>
            <tr>
              <th>CPF</th>
              <th>Nome</th>
              <th>Salário</th>
              <th>Email</th>
              <th>Senha</th>
              <th>Ação</th>
            </tr>
          </thead>
          <tbody>
            <% for(Usuario u:usuarios){ %>
            <tr>
              <td><%=u.getCpf()%></td>
              <td><%=u.getNome()%></td>
              <td><%=u.getSalario()%></td>
              <td><%=u.getEmail()%></td>
              <td><%=u.getSenha()%></td>
              <td>
                <a class="btn btn-info btn-sm" href="cadastro.jsp?cpf=<%=u.getCpf()%>" role="button">
                  <span class="bi bi-brush" title="Editar" aria-hidden="true"></span>
                </a>
                <a class="btn btn-danger btn-sm" href="usuarios?cpf=<%=u.getCpf()%>" role="button">
                  <span class="bi bi-trash" title="Excluir" aria-hidden="true"></span>
                </a>
              </td>
            </tr>
            <% } %>
          </tbody>
        </table>
        <h2 class="text-center">Lista de Despesas</h2><br>
        <table class="table table-light table-striped table-hover table-sm">
          <thead>
            <tr>
              <th>ID</th>
              <th>CPF Usuario</th>
              <th>Descrição</th>
              <th>Categoria</th>
              <th>Valor</th>
              <th>Ação</th>
            </tr>
          </thead>
          <tbody>
            <% for(Despesas d:despesas){ %>
            <tr>
              <td><%=d.getId()%>
              <td><%=d.getCpfusuario()%></td>
              <td><%=d.getDescricao()%></td>
              <td><%=d.getCategoria()%></td>
              <td><%=d.getValor()%></td>
              <td>
                <a class="btn btn-info btn-sm" href="inserirDespesa.jsp?id=<%=d.getId()%>" role="button">
                  <span class="bi bi-brush" title="Editar" aria-hidden="true"></span>
                </a>
                <a class="btn btn-danger btn-sm" href="despesas?id=<%=d.getId()%>" role="button">
                  <span class="bi bi-trash" title="Excluir" aria-hidden="true"></span>
                </a>
              </td>
            </tr>
          <% } %>
        </tbody>
      </table>
    </div>

    <footer>
      <p>© 2023 Leonardo Fattori</p>
    </footer>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.2/js/bootstrap.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>
