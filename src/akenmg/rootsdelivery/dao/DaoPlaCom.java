package akenmg.rootsdelivery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import akenmg.rootsdelivery.model.*;

public class DaoPlaCom {
	private static final String createQuery = "insert into COM_PLA (IDPLAT, IDCOMMANDE, QTE) values (?,?,?)";
//	private static final String findQuery = "SELECT * FROM PLATS WHERE IDPLAT = ?";
	private static final String findByCommandeQuery = "SELECT * FROM COM_PLA WHERE IDCOMMANDE = ?";
	private static final String deleteQuery = "DELETE FROM COM_PLA WHERE IDCOMMANDE = ?";
//	private static final String updateQuery = "UPDATE PLATS SET TITREPLAT=?,DESCRIPTIONPLAT=?,PRIXPLAT=?,IMGPLAT=? WHERE IDPLAT=?";
//	private static final String getAllQuery = "SELECT * FROM COM_PLA";
	
	public static void create(PlaCom obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(createQuery);
			preparedStatement.setInt(1, obj.getPlat().getId());
			preparedStatement.setInt(2, obj.getCommande().getId());
			preparedStatement.setInt(3, obj.getQuantite());
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DaoCon.close(dbConnection, preparedStatement);
		}
	}

//	public static Plat find(int id) {
//		Plat plat = null;
//		Connection dbConnection = null ;
//		PreparedStatement preparedStatement = null;
//		try{
//			dbConnection = DaoCon.getCon();
//			preparedStatement = dbConnection.prepareStatement(findQuery);
//			preparedStatement.setInt(1, id);
//			ResultSet rs = preparedStatement.executeQuery();
//			while (rs.next()) {
//				plat = mapRes(rs);
//			}
//		}catch (Exception e){
//			e.printStackTrace();
//		}finally{
//			DaoCon.close(dbConnection,preparedStatement,rs);
//		}
//		return plat;
//	}
	
	public static List<PlaCom> findByCommande(int id) {
	List<PlaCom> placoms = new ArrayList<PlaCom>();
	Connection dbConnection = null ;
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;
	try{
		dbConnection = DaoCon.getCon();
		preparedStatement = dbConnection.prepareStatement(findByCommandeQuery);
		preparedStatement.setInt(1, id);
		rs = preparedStatement.executeQuery();
		while (rs.next()) {
			placoms.add(mapRes(rs));
		}
	}catch (Exception e){
		e.printStackTrace();
	}finally{
		DaoCon.close(dbConnection, preparedStatement, rs);
	}
	return placoms;
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
			DaoCon.close(dbConnection, preparedStatement);
		}
	}

//	public static void update(Plat obj) {
//		Connection dbConnection = null ;
//		PreparedStatement preparedStatement = null;
//		try{
//			dbConnection = DaoCon.getCon();
//			preparedStatement = dbConnection.prepareStatement(updateQuery);
//			preparedStatement.setString(1, obj.getTitre());
//			preparedStatement.setString(2, obj.getDescription());
//			preparedStatement.setInt(3, obj.getPrix());
//			preparedStatement.setString(4, obj.getImg());
//			preparedStatement.setInt(5, obj.getId());
//			preparedStatement.executeUpdate();
//		}catch (Exception e){
//			e.printStackTrace();
//		}finally{
//			DaoCon.close(dbConnection, preparedStatement);
//		}
//		
//	}

//	public static List<Plat> getAll() {
//		List<Plat> plats = new ArrayList<Plat>();
//		Connection dbConnection = null ;
//		PreparedStatement preparedStatement = null;
//		try{
//			dbConnection = DaoCon.getCon();
//			preparedStatement = dbConnection.prepareStatement(getAllQuery);
//			ResultSet rs = preparedStatement.executeQuery();
//			while (rs.next()) {
//				plats.add(mapRes(rs));
//			}
//		}catch (Exception e){
//			e.printStackTrace();
//		}finally{
//			DaoCon.close(dbConnection, preparedStatement, rs);
//		}
//		return plats;
//	}

	private static PlaCom mapRes(ResultSet rs) {
		PlaCom plaCom = new PlaCom();
		try{
			plaCom.setPlat(DaoPlat.find(rs.getInt("IDPLAT")));
			plaCom.setCommande(DaoCommande.find(rs.getInt("IDCOMMANDE")));
			plaCom.setQuantite(rs.getInt("QTE"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return plaCom;
	}
}
