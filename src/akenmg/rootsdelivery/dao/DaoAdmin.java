package akenmg.rootsdelivery.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import akenmg.rootsdelivery.model.Admin;

public class DaoAdmin {
	private static final String createQuery = "INSERT INTO ADMINS (LOGINADMIN, MDPADMIN) values (?, ?)";
	private static final String findQuery = "SELECT * FROM ADMINS WHERE IDADMIN = ?";
	private static final String deleteQuery = "DELETE FROM ADMINS WHERE IDADMIN = ?";
	private static final String updateQuery = "UPDATE ADMINS SET LOGINADMIN=?,MDPADMIN=? WHERE IDADMIN=?";
	private static final String getAllQuery = "SELECT * FROM ADMINS ORDER BY IDADMIN";
	
	public static void create(Admin obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(createQuery);
			preparedStatement.setString(1, obj.getLogin());
			preparedStatement.setString(2, obj.getMdp());
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
	
	public static Admin find(int id) {
		Admin admin = null;
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(findQuery);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				admin = mapRes(rs);
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
		return admin;
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

	public static void update(Admin obj) {
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(updateQuery);
			preparedStatement.setString(1, obj.getLogin());
			preparedStatement.setString(2, obj.getMdp());
			preparedStatement.setInt(3, obj.getId());
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

	public static List<Admin> getAll() {
		List<Admin> admins = new ArrayList<Admin>();
		Connection dbConnection = null ;
		PreparedStatement preparedStatement = null;
		try{
			dbConnection = DaoCon.getCon();
			preparedStatement = dbConnection.prepareStatement(getAllQuery);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				admins.add(mapRes(rs));
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
		return admins;
	}

	private static Admin mapRes(ResultSet rs) {
		Admin admin = new Admin();
		try{
			admin.setId(rs.getInt("IDADMIN"));
			admin.setLogin(rs.getString("LOGINADMIN"));
			admin.setMdp(rs.getString("MDPADMIN"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return admin;
	}
}
