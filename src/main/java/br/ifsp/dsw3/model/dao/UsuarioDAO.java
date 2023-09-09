package br.ifsp.dsw3.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ifsp.dsw3.model.domain.Usuario;

public class UsuarioDAO {
    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios(" +
                "cpf varchar(20) PRIMARY KEY UNIQUE NOT NULL," +
                "nome varchar(40), email varchar(30), senha varchar(30)," +
                "salario float)";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuarios(cpf,nome, email, senha, salario) values (?,?,?,?,?)";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, usuario.getCpf());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.setDouble(5, usuario.getSalario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(String cpf) {
        String sql = "DELETE FROM usuarios WHERE cpf=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome=?, salario=?, email=?, senha=? WHERE cpf=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setDouble(2, usuario.getSalario());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getCpf());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> usuario = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("cpf"), rs.getString("nome"), rs.getString("email"),
                        rs.getString("senha"), rs.getDouble("salario"));
                usuario.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario pesquisarPorCPF(String cpf) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE cpf=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(rs.getString("cpf"), rs.getString("nome"), rs.getString("email"),
                        rs.getString("senha"), rs.getDouble("salario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
