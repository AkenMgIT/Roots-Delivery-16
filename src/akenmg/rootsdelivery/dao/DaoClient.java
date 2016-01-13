package akenmg.rootsdelivery.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import akenmg.rootsdelivery.model.Client;

public class DaoClient {

	private static final String createQuery = "insert into CLIENTS (NOMCLIENT, PRENOMCLIENT, NUMEROCLIENT, EMAILCLIENT, MDPCLIENT) values (?, ?, ?, ?, ?)";
	private static final String findQuery = "SELECT * FROM CLIENTS WHERE IDCLIENT = ?";
	private static final String deleteQuery = "DELETE FROM CLIENTS WHERE IDCLIENT = ?";
	private static final String updateQuery = "UPDATE CLIENTS SET NOMCLIENT=?,PRENOMCLIENT=?,NUMEROCLIENT=?,EMAILCLIENT=?,MDPCLIENT=? WHERE IDCLIENT=?";
	private static final String getAllQuery = "SELECT * FROM CLIENTS";
	
	public static void create(Client obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(createQuery);
			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setString(2, obj.getPrenom());
			preparedStatement.setString(3, obj.getNumero());
			preparedStatement.setString(4, obj.getEmail());
			preparedStatement.setString(5, obj.getMdp());
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(dbConnection!=null)
					dbConnection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public static Client find(int id) {
		Client client = null;
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(findQuery);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				client = mapRes(rs);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(dbConnection!=null)
					dbConnection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return client;
	}

	public static void delete(int id) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(dbConnection!=null)
					dbConnection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

	public static void update(Client obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(updateQuery);
			preparedStatement.setString(1, obj.getNom());
			preparedStatement.setString(2, obj.getPrenom());
			preparedStatement.setString(3, obj.getNumero());
			preparedStatement.setString(4, obj.getEmail());
			preparedStatement.setString(5, obj.getMdp());
			preparedStatement.setInt(6, obj.getId());
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(dbConnection!=null)
					dbConnection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

	public static List<Client> getAll() {
		List<Client> clients = new ArrayList<Client>();
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(getAllQuery);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				clients.add(mapRes(rs));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(dbConnection!=null)
					dbConnection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return clients;
	}

	private static Client mapRes(ResultSet rs) {
		Client client = new Client();
		try{
			client.setId(rs.getInt("IDCLIENT"));
			client.setNom(rs.getString("NOMCLIENT"));
			client.setPrenom(rs.getString("PRENOMCLIENT"));
			client.setNumero(rs.getString("NUMEROCLIENT"));
			client.setEmail(rs.getString("EMAILCLIENT"));
			client.setMdp(rs.getString("MDPCLIENT"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return client;
	}
}	
