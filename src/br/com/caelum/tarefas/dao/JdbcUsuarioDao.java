package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.tarefas.model.Usuario;

public class JdbcUsuarioDao {
	private Connection connection;
	
	public JdbcUsuarioDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean existeUsuario(Usuario usuario) {
		String sql = "select * from usuarios where login=? and senha=?";
		boolean existe = false;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs=  stmt.executeQuery();
			existe = rs.next();
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return existe;
	}
}
