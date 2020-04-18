package br.com.projsqlite;

import java.sql.ResultSet;

import br.com.projsqlite.util.ConnectionSQLite;

public class MainApplication {
	
	public static void main(String[] args) {
		
		System.out.println("Exemplo - Conex�o com um banco de dados SQLite:");
		
		try {
			
			ConnectionSQLite connection = new ConnectionSQLite();
			
			System.out.println("Teste inclus�o");
			//Exemplo inclus�o de informa��es no banco de dados:
			connection.exec("insert into tb_teste (id, nome) values ('11','teste inclusao c#')");
			System.out.println("Fim Teste inclus�o");
			
			System.out.println("teste consulta");
			ResultSet rs = connection.execWithReturn("select id, nome from tb_teste");
			while (rs.next()) {
				System.out.println(" { 'Id': '" + rs.getInt("id") + "', 'nome': '" + rs.getString("nome")+"'}");
			}
			System.out.println("fim teste consulta");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
