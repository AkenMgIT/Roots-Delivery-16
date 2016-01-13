package akenmg.rootsdelivery.service;

import java.util.List;

import akenmg.rootsdelivery.dao.DaoAdmin;
import akenmg.rootsdelivery.model.Admin;

public class LoginService {
	public static boolean loginAdmin(String login,String mdp){
		List<Admin> admins = DaoAdmin.getAll();
		for(Admin a : admins){
			if(a.getLogin().equals(login)){
				if(a.getMdp().equals(mdp)){
					return true;
				}
			}
		}
		return false;
	}
	
	public static Admin findAdmin(String login){
		Admin a = null;
		List<Admin> admins = DaoAdmin.getAll();
		for(Admin admin : admins){
			if(admin.getLogin().equals(login)){
				a = admin;
			}
		}
		return a ;
	}
}
