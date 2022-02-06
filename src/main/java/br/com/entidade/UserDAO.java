package br.com.entidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.database.Conexao;



public class UserDAO {
	
	public UserDAO() {
		
	}
	
	public void addUser(User newUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("insert into users (nome,email,telefone,pais) values (?,?,?,?)");
			preStat.setString(1, newUser.getNome());
			preStat.setString(2, newUser.getEmail());
			preStat.setString(3, newUser.getTelefone());
			preStat.setString(4, newUser.getPais());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	
	
	
	public ArrayList<User> getListUser(){
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<User> lista = new ArrayList<User>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from users");
			ResultSet resultSet = preStat.executeQuery();			
			
			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String email = resultSet.getString("email");
				String telefone = resultSet.getString("telefone");
				String pais = resultSet.getString("pais");
				User user = new User(nome, pais,email,telefone);
				user.setId(id2);
				lista.add(user);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public void removeUser(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("delete from users where id = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateUser(User updateUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		
		try {
			PreparedStatement preStat = connection.prepareStatement("update users set nome = ?, email = ?, telefone = ?, pais = ? where id = ?");
			preStat.setString(1, updateUser.getNome());
			preStat.setString(2, updateUser.getEmail());
			preStat.setString(3, updateUser.getTelefone());
			preStat.setString(4, updateUser.getPais());
			preStat.setInt(5, updateUser.getId());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public User buscarUser(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		User user = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from users where id = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();			
			while ( resultSet.next()) {
				Integer ida =  resultSet.getInt("id");
				String nome =  resultSet.getString("nome");
				String email =  resultSet.getString("email");
				String telefone =  resultSet.getString("telefone");
				String pais =  resultSet.getString("pais");
				user = new User(nome, pais,email,telefone);
				user.setId(ida);
				
			}
			 resultSet.close();
			 preStat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
}
