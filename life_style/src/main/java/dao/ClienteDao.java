package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Cliente;

public class ClienteDao implements ClienteCRUD {
	
	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;
	
	public static void create(Cliente cliente) {
		sql = "INSERT INTO cliente VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cliente.getCpf());
			preparedStatement.setString(2, cliente.getNome());
			preparedStatement.setString(3, cliente.getRua());
			preparedStatement.setString(4, cliente.getBairro());
			preparedStatement.setString(5, cliente.getCep());
			preparedStatement.setString(6, cliente.getCidade());
			preparedStatement.setString(7, cliente.getEstado());
			preparedStatement.setString(8, cliente.getEmail());
			preparedStatement.setString(9, cliente.getTelefone());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct insert on database");
			
			
		}catch(SQLException e) {
			System.out.println("--incorrect insert on database. "+ e.getMessage());
		}
	}
	
	public static void delete(int clienteId) {
		
		sql = "DELETE FROM cliente WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, clienteId);
			preparedStatement.executeUpdate();
			
			System.out.println("--correct delete on cliente");
			
		}catch(SQLException e) {
			
			System.out.println("--incorrect delete on cliente. "+ e.getMessage());
			
		}
		
	};
	
	public static List<Cliente> find(String pesquisa){
		
		sql = String.format("SELECT * FROM cliente WHERE nome LIKE '%s%%' OR cpf LIKE '%s%%'", pesquisa, pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setRua(resultSet.getString("rua"));
				cliente.setBairro(resultSet.getString("bairro"));
				cliente.setCep(resultSet.getString("cep"));
				cliente.setCidade(resultSet.getString("cidade"));
				cliente.setEstado(resultSet.getString("estado"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getString("telefone"));
				
				clientes.add(cliente);
				
			};
			
			System.out.println("--Correct find clientes");
			return clientes;
			
		}catch(SQLException e) {
			System.out.println("--incorrect find clientes"+ e.getMessage());
			return null;
		}
		
		
	}
	
	public static Cliente findByPk(int clienteId) {
		
		sql = String.format("SELECT * FROM cliente WHERE id = '%d'", clienteId);

		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Cliente cliente = new Cliente();
			while(resultSet.next()) {
				
				cliente.setId(resultSet.getInt("id"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setRua(resultSet.getString("rua"));
				cliente.setBairro(resultSet.getString("bairro"));
				cliente.setCep(resultSet.getString("cep"));
				cliente.setCidade(resultSet.getString("cidade"));
				cliente.setEstado(resultSet.getString("estado"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getString("telefone"));
				
				
			};
			
			System.out.println("--Correct find By Pk clientes");
			return cliente;
			
		}catch(SQLException e) {
			System.out.println("--incorrect find By Pk clientes"+ e.getMessage());
			return null;
		}
	}
	
	public static void update(Cliente cliente) {
		
     sql = "UPDATE cliente SET cpf=?, nome=?, rua=?, bairro=?, cep=?, cidade=?, estado=?, email=?, telefone=? WHERE id=?" ;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cliente.getCpf());
			preparedStatement.setString(2, cliente.getNome());
			preparedStatement.setString(3, cliente.getRua());
			preparedStatement.setString(4, cliente.getBairro());
			preparedStatement.setString(5, cliente.getCep());
			preparedStatement.setString(6, cliente.getCidade());
			preparedStatement.setString(7, cliente.getEstado());
			preparedStatement.setString(8, cliente.getEmail());
			preparedStatement.setString(9, cliente.getTelefone());
			preparedStatement.setInt(10, cliente.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("--correct Update on database");
			
			
		}catch(SQLException e) {
			System.out.println("--incorrect Update on database. "+ e.getMessage());
		}
		
	}

}
