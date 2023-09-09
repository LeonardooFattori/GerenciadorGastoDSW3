package br.ifsp.dsw3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.dsw3.model.domain.Despesas;

public class DespesasDAO {
    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS despesas(id integer PRIMARY KEY AUTOINCREMENT, descricao varchar(40), categoria varchar(20), valor float, cpfusuario varchar(20), FOREIGN KEY (cpfusuario) REFERENCES usuario(cpf))";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Despesas despesas) {
        String sql = "INSERT INTO despesas(descricao,categoria,valor,cpfusuario) values (?,?,?,?)";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, despesas.getDescricao());
            stmt.setString(2, despesas.getCategoria());
            stmt.setDouble(3, despesas.getValor());
            stmt.setString(4, despesas.getCpfusuario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(Integer id) {
        String sql = "DELETE FROM despesas WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Despesas despesas) {
        String sql = "UPDATE despesas SET descricao=?, categoria=?, valor=? WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, despesas.getDescricao());
            stmt.setString(2, despesas.getCategoria());
            stmt.setDouble(3, despesas.getValor());
            stmt.setInt(4, despesas.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Despesas> listar() {
        ArrayList<Despesas> despesass = new ArrayList<>();
        String sql = "SELECT * FROM despesas";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Despesas d = new Despesas(rs.getInt("id"), rs.getString("descricao"), rs.getString("categoria"),
                        rs.getDouble("valor"), rs.getString("cpfusuario"));
                despesass.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return despesass;
    }

    public Despesas pesquisarPorId(Integer id) {
        Despesas despesas = null;
        String sql = "SELECT * FROM despesas WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                despesas = new Despesas(rs.getInt("id"), rs.getString("descricao"), rs.getString("categoria"),
                        rs.getDouble("valor"), rs.getString("cpfusuario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return despesas;
    }
}
