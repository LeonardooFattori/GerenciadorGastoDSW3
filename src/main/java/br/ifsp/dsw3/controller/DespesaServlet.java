package br.ifsp.dsw3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifsp.dsw3.model.dao.DespesasDAO;
import br.ifsp.dsw3.model.domain.Despesas;

@WebServlet(name = "despesaServlet", value = "/despesas")
public class DespesaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        DespesasDAO dao = new DespesasDAO();
        dao.excluir(id);
        resp.sendRedirect("visualizar.jsp");
    }

    @Override
    public void init() throws ServletException {
        DespesasDAO dao = new DespesasDAO();
        dao.criarTabela();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(req.getParameter("id"));
        String descricao = req.getParameter("descricao");
        String categoria = req.getParameter("categoria");
        Double valor = Double.parseDouble(req.getParameter("valor"));
        String cpfusuario = req.getParameter("cpfusuario");
        String enviar = req.getParameter("enviar");
        Despesas d = new Despesas(id, descricao, categoria, valor, cpfusuario);
        DespesasDAO dao = new DespesasDAO();
        if (enviar.contains("Salvar")) {
            dao.inserir(d);
        } else {
            dao.alterar(d);
        }
        resp.sendRedirect("inserirDespesa.jsp");
    }
}
