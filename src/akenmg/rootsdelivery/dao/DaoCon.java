package akenmg.rootsdelivery.dao;

import java.sql.*;
import java.util.Properties;

import akenmg.rootsdelivery.util.*;

public class DaoCon {
	public static Connection getCon() throws SQLException {
        Connection con = null;
        Properties prop = null;
        String driver = "";
        String url = "";
        String user = "";
        String password = "";
        try {
//        	prop = PropertiesUtil.readProperties();
//        	driver = prop.getProperty("driver");
//        	url = prop.getProperty("url");
//        	user = prop.getProperty("user");
//        	password = prop.getProperty("password");
        	driver = "org.postgresql.Driver";
        	url = "jdbc:postgresql://localhost:5432/Roots-Delivery-Bd";
        	user = "postgres";
        	password = "123456";
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
	public static void close(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void close(PreparedStatement preparedStatement){
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void close(ResultSet rs){
    	try {
    		if (rs != null) {
    			rs.close();
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void close(Connection con,PreparedStatement preparedStatement){
    	DaoCon.close(preparedStatement);
    	DaoCon.close(con);
    }
    
    public static void close(Connection con,PreparedStatement preparedStatement, ResultSet rs){
    	DaoCon.close(rs);
    	DaoCon.close(preparedStatement);
    	DaoCon.close(con);
    }
    
    public static void testconn() {
        Connection con = null;
        try {
            con = DaoCon.getCon();
            System.out.println("DaoConnexion : OPEN : Success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DaoConnexion : OPEN : Fail");
        } finally {
        	DaoCon.close(con);
        	System.out.println("DaoConnexion : CLOSE : SUCCESS");
        }
    }
}
