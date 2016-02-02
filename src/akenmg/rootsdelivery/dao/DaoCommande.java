package akenmg.rootsdelivery.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import akenmg.rootsdelivery.model.Commande;
import akenmg.rootsdelivery.model.PlaCom;
import akenmg.rootsdelivery.model.Plat;

public class DaoCommande {
	private static final String createQuery = "insert into COMMANDES (IDCLIENT, ADRESSECOMMANDE, TIMECOMMANDE, ETATCOMMANDE) values (?, ?, ?, ?)";
	private static final String findQuery = "SELECT * FROM COMMANDES WHERE IDCOMMANDE = ?";
	private static final String deleteQuery = "DELETE FROM COMMANDES WHERE IDCOMMANDE = ?";
//	private static final String updateQuery = "UPDATE COMMANDES SET IDCLIENT=?,ADRESSECOMMANDE=?,TIMECOMMANDE=?,ETATCOMMANDE=? WHERE IDCOMMANDE=?";
	private static final String updateQuery = "UPDATE COMMANDES SET ETATCOMMANDE=? WHERE IDCOMMANDE=?";
	private static final String getAllQuery = "SELECT * FROM COMMANDES ORDER BY TIMECOMMANDE ASC";
	
	public static void create(Commande obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(createQuery,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, obj.getClient().getId());
			preparedStatement.setString(2, obj.getAdresse());
			preparedStatement.setTimestamp(3, new java.sql.Timestamp(obj.getDate().getTime()) );
			preparedStatement.setString(4, obj.getEtat().toString() );
//			preparedStatement.executeUpdate();
			
			int affectedRows = preparedStatement.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
//	            	System.out.println("ID of the last commande = "+generatedKeys.getLong(1));
	            	obj.setId(generatedKeys.getInt(1));
	            	for(PlaCom p : obj.getPlacoms()){
	            		p.setCommande(obj);
	            		DaoPlaCom.create(p);
	            	}
	            }
	            else {
	                throw new SQLException("Creating command failed, no ID obtained.");
	            }
	        }
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DaoCon.close(dbConnection, preparedStatement);
		}
	}

	public static Commande find(int id) {
		Commande commande = null;
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(findQuery);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				commande = mapRes(rs);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DaoCon.close(dbConnection,preparedStatement,rs);
		}
		return commande;
	}
	
	public static Commande find(int id,boolean withList) {
		if(!withList){
			return DaoCommande.find(id);
		}else{
			Commande commande = null;
			Connection dbConnection = null ;
			PreparedStatement preparedStatement = null;
			ResultSet rs = null;
			try{
				dbConnection = DaoCon.getCon();
				preparedStatement = dbConnection.prepareStatement(findQuery);
				preparedStatement.setInt(1, id);
				rs = preparedStatement.executeQuery();
				while (rs.next()) {
					commande = mapRes(rs,withList);
				}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DaoCon.close(dbConnection,preparedStatement,rs);
			}
			return commande;
		}
	}

	public static void delete(int id) {
		DaoPlaCom.delete(id);
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
			DaoCon.close(dbConnection, preparedStatement);
		}
	}

//	public static void update(Commande obj) {
//		Connection dbConnection = null ;
//		PreparedStatement preparedStatement = null;
//		try{
//			dbConnection = DaoCon.getCon();
//			preparedStatement = dbConnection.prepareStatement(updateQuery);
//			preparedStatement.setInt(1, obj.getClient().getId());
//			preparedStatement.setString(2, obj.getAdresse());
//			preparedStatement.setDate(3, new java.sql.Date(obj.getDate().getTime()));
//			preparedStatement.setString(4, obj.getEtat().toString());
//			preparedStatement.setInt(5, obj.getId());
//			preparedStatement.executeUpdate();
//		}catch (Exception e){
//			e.printStackTrace();
//		}finally{
//			DaoCon.close(dbConnection, preparedStatement);
//		}
//	}
	public static void update(Commande obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(updateQuery);
			preparedStatement.setString(1, obj.getEtat().toString());
			preparedStatement.setInt(2, obj.getId());
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DaoCon.close(dbConnection, preparedStatement);
		}
	}

	public static List<Commande> getAll() {
		List<Commande> commandes = new ArrayList<Commande>();
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(getAllQuery);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				commandes.add(mapRes(rs));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DaoCon.close(dbConnection, preparedStatement, rs);
		}
		return commandes;
	}
	public static List<Commande> getAll(boolean bool) {
		List<Commande> commandes = new ArrayList<Commande>();
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(getAllQuery);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				commandes.add(mapRes(rs,bool));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DaoCon.close(dbConnection, preparedStatement, rs);
		}
		return commandes;
	}

	private static Commande mapRes(ResultSet rs) {
		Commande commande = new Commande();
		try{
			commande.setId(rs.getInt("IDCOMMANDE"));
			commande.setClient(DaoClient.find(rs.getInt("IDCLIENT")));
			commande.setAdresse(rs.getString("ADRESSECOMMANDE"));
			commande.setDate(rs.getTimestamp("TIMECOMMANDE"));
			commande.setEtat(Commande.stringToEnum(rs.getString("ETATCOMMANDE")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return commande;
	}
	private static Commande mapRes(ResultSet rs,boolean withList) {
		if(!withList){
			return mapRes(rs);
		}else{
			Commande commande = new Commande();
			try{
				commande.setId(rs.getInt("IDCOMMANDE"));
				commande.setClient(DaoClient.find(rs.getInt("IDCLIENT")));
				commande.setAdresse(rs.getString("ADRESSECOMMANDE"));
				commande.setDate(rs.getTimestamp("TIMECOMMANDE"));
				commande.setEtat(Commande.stringToEnum(rs.getString("ETATCOMMANDE")));
				commande.setPlacoms(DaoPlaCom.findByCommande(commande.getId()));
			}catch(Exception e){
				e.printStackTrace();
			}
			return commande;
		}
	}
	
}
