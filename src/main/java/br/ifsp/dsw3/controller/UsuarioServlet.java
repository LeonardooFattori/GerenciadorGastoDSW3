package br.ifsp.dsw3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifsp.dsw3.model.dao.UsuarioDAO;
import br.ifsp.dsw3.model.domain.Usuario;

@WebServlet(name = "usuarioServlet", value = "/usuarios")
public class UsuarioServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        UsuarioDAO dao = new UsuarioDAO();
        dao.criarTabela();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = (req.getParameter("cpf"));
        UsuarioDAO dao = new UsuarioDAO();
        dao.excluir(cpf);
        resp.sendRedirect("visualizar.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String cpf = (req.getParameter("cpf"));
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        double salario = Double.parseDouble(req.getParameter("salario"));
        String enviar = req.getParameter("enviar");
        Usuario u = new Usuario(cpf, nome, email, senha, salario);
        UsuarioDAO dao = new UsuarioDAO();
        if (enviar.contains("Salvar")) {
            dao.inserir(u);
        } else {
            dao.alterar(u);
        }
        resp.sendRedirect("cadastro.jsp");
    }
}
