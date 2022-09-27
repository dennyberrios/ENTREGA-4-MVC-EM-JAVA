package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Destino;

public class DestinoDao  implements DestinoCRUD{
	
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void create(Destino destino) {
		sql = "INSERT INTO destino VALUES (null, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, destino.getNome());
			preparedStatement.setString(2, destino.getCidade());
			preparedStatement.setString(3, destino.getEstado());
			preparedStatement.setString(4, destino.getDataIda());
			preparedStatement.setString(5, destino.getDataVolta());
			preparedStatement.setString(6, destino.getValor());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database");
			
			
		}catch(SQLException e) {
			System.out.println("--incorrect insert on database. "+ e.getMessage());
		}
	}
	
	public static void delete(int destinoId) {
		
		sql = "DELETE FROM destino WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, destinoId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on destino");
			
		}catch(SQLException e) {
			
			System.out.println("--incorrect delete on destino. "+ e.getMessage());
			
		}
		
	};
	
	public static List<Destino> find(String pesquisa){
		
		sql = String.format("SELECT * FROM destino WHERE nome LIKE '%s%%' OR cidade LIKE '%s%%'", pesquisa, pesquisa);
		List<Destino> destinos = new ArrayList<Destino>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Destino destino = new Destino();
				destino.setId(resultSet.getInt("id"));
				destino.setNome(resultSet.getString("nome"));
				destino.setCidade(resultSet.getString("cidade"));
				destino.setEstado(resultSet.getString("estado"));
				destino.setDataIda(resultSet.getString("dataIda"));
				destino.setDataVolta(resultSet.getString("dataVolta"));
				destino.setValor(resultSet.getString("valor"));
				
				destinos.add(destino);
				
			};
			
			System.out.println("--Correct find destinos");
			return destinos;
			
		}catch(SQLException e) {
			System.out.println("--incorrect find destinos. "+ e.getMessage());
			return null;
		}
		
		
	}
	
	public static Destino findByPk(int destinoId) {
		
		sql = String.format("SELECT * FROM destino WHERE id = '%d'", destinoId);

		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Destino destino = new Destino();
			while(resultSet.next()) {
				
				destino.setId(resultSet.getInt("id"));
				destino.setNome(resultSet.getString("nome"));
				destino.setCidade(resultSet.getString("cidade"));
				destino.setEstado(resultSet.getString("estado"));
				destino.setDataIda(resultSet.getString("dataIda"));
				destino.setDataVolta(resultSet.getString("dataVolta"));
				destino.setValor(resultSet.getString("valor"));
				
				
			};
			
			System.out.println("--Correct find By Pk destinos");
			return destino;
			
		}catch(SQLException e) {
			System.out.println("--incorrect find By Pk destinos"+ e.getMessage());
			return null;
		}
	}
	
	public static void update(Destino destino) {
		
     sql = "UPDATE destino SET nome=?, cidade=?, estado=?, dataIda=?, dataVolta=?, valor=? WHERE id=?" ;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, destino.getNome());
			preparedStatement.setString(2, destino.getCidade());
			preparedStatement.setString(3, destino.getEstado());
			preparedStatement.setString(4, destino.getDataIda());
			preparedStatement.setString(5, destino.getDataVolta());
			preparedStatement.setString(6, destino.getValor());
			preparedStatement.setInt(7, destino.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct Update on database");
			
			
		}catch(SQLException e) {
			System.out.println("--incorrect Update on database. "+ e.getMessage());
		}
		
	}


}
