package br.com.projsqlite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConnectionSQLite {

	private Connection conexao;
	public Statement statement;
	public ResultSet resultset;
	public PreparedStatement prep;

	public ConnectionSQLite() throws Exception {
		Class.forName("org.sqlite.JDBC");
		conexao = DriverManager.getConnection("jdbc:sqlite:C:/tmp/base_dados/dados.db");
		statement = conexao.createStatement();
		conexao.setAutoCommit(true);
		System.out.println("Connected!");
	}

	public ResultSet execWithReturn(String sql) throws Exception {
		return statement.executeQuery(sql);
	}
	
	public void exec(String sql) throws Exception {
		statement.execute(sql);
	}

	public void desconecta() {
		boolean result = true;
		try {
			conexao.close();
			JOptionPane.showMessageDialog(null, "Connection Closed!");
		} catch (SQLException fecha) {
			JOptionPane.showMessageDialog(null, "Error - Connection Closing..." + fecha);
			result = false;
		}
	}
}
