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
		String sql = "select * from usuarios where login=?";
		boolean existe = false;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
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
