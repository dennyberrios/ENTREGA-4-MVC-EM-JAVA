package dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import db.MySqlConnection;
    import model.Hospedagem;

	public class HospedagemDao implements HospedagemCRUD {
		
		private static Connection connection = MySqlConnection.createConnection();
		private static String sql;
		
		public static void create(Hospedagem hospedagem) {
			sql = "INSERT INTO hospedagem VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, hospedagem.getNomeHotel());
				preparedStatement.setString(2, hospedagem.getEndereco());
				preparedStatement.setString(3, hospedagem.getEstado());
				preparedStatement.setString(4, hospedagem.getValor());
				preparedStatement.setString(5, hospedagem.getCheckIn());
				preparedStatement.setString(6, hospedagem.getCheckOut());
				preparedStatement.setString(7, hospedagem.getTelefoneHotel());
				
				
				preparedStatement.executeUpdate();
				
				System.out.println("--correct insert on database");
				
				
			}catch(SQLException e) {
				System.out.println("--incorrect insert on database. "+ e.getMessage());
			}
		}
		
		public static void delete(int hospedagemId) {
			
			sql = "DELETE FROM hospedagem WHERE id = ?";
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setInt(1, hospedagemId);
				preparedStatement.executeUpdate();
				
				System.out.println("--correct delete on hospedagem");
				
			}catch(SQLException e) {
				
				System.out.println("--incorrect delete on hospedagem. "+ e.getMessage());
				
			}
			
		};
		
		public static List<Hospedagem> find(String pesquisa){
			
			sql = String.format("SELECT * FROM hospedagem WHERE nomeHotel LIKE '%s%%' OR estado LIKE '%s%%'", pesquisa, pesquisa);
			List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				
				while(resultSet.next()) {
					Hospedagem hospedagem = new Hospedagem();
					hospedagem.setId(resultSet.getInt("id"));
					hospedagem.setNomeHotel(resultSet.getString("nomeHotel"));
					hospedagem.setEndereco(resultSet.getString("endereco"));
					hospedagem.setEstado(resultSet.getString("estado"));
					hospedagem.setValor(resultSet.getString("valor"));
					hospedagem.setCheckIn(resultSet.getString("checkIn"));
					hospedagem.setCheckOut(resultSet.getString("checkOut"));
					hospedagem.setTelefoneHotel(resultSet.getString("telefoneHotel"));
					
					hospedagens.add(hospedagem);
					
				};
				
				System.out.println("--Correct find Hospedagens");
				return hospedagens;
				
			}catch(SQLException e) {
				System.out.println("--incorrect find Hospedagenes. "+ e.getMessage());
				return null;
			}
			
			
		}
		
		public static Hospedagem findByPk(int hospedagemId) {
			
			sql = String.format("SELECT * FROM hospedagem WHERE id = '%d'", hospedagemId);

			
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				Hospedagem hospedagem = new Hospedagem();
				while(resultSet.next()) {

					hospedagem.setId(resultSet.getInt("id"));
					hospedagem.setNomeHotel(resultSet.getString("nomeHotel"));
					hospedagem.setEndereco(resultSet.getString("endereco"));
					hospedagem.setEstado(resultSet.getString("estado"));
					hospedagem.setValor(resultSet.getString("valor"));
					hospedagem.setCheckIn(resultSet.getString("checkIn"));
					hospedagem.setCheckOut(resultSet.getString("checkOut"));
					hospedagem.setTelefoneHotel(resultSet.getString("telefoneHotel"));
					
					
				};
				
				System.out.println("--Correct find By Pk Hospedagens");
				return hospedagem;
				
			}catch(SQLException e) {
				System.out.println("--incorrect find By Pk Hospedagens. "+ e.getMessage());
				return null;
			}
		}
		
		
		public static void update(Hospedagem hospedagem) {
			
	        sql = "UPDATE hospedagem SET nomeHotel=?, endereco=?, estado=?, valor=?, checkIn=?, checkOut=?, telefoneHotel=? WHERE id=?" ;
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, hospedagem.getNomeHotel());
				preparedStatement.setString(2, hospedagem.getEndereco());
				preparedStatement.setString(3, hospedagem.getEstado());
				preparedStatement.setString(4, hospedagem.getValor());
				preparedStatement.setString(5, hospedagem.getCheckIn());
				preparedStatement.setString(6, hospedagem.getCheckOut());
				preparedStatement.setString(7, hospedagem.getTelefoneHotel());
				preparedStatement.setInt(8, hospedagem.getId());
				
				preparedStatement.executeUpdate();
				
				System.out.println("--correct Update on database");
				
				
			}catch(SQLException e) {
				System.out.println("--incorrect Update on database. "+ e.getMessage());
			}
			
		}

	}


