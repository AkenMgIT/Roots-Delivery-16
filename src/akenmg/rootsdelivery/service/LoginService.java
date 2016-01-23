package akenmg.rootsdelivery.service;

import java.util.ArrayList;
import java.util.List;

import akenmg.rootsdelivery.dao.DaoAdmin;
import akenmg.rootsdelivery.dao.DaoClient;
import akenmg.rootsdelivery.model.*;

public class LoginService {
	private List<Admin> admins;
	private List<Client> clients;
	
	public LoginService(){
//		admins = new ArrayList<Admin>();
//		clients = new ArrayList<Client>();
		admins = null;
		clients = null;
	}
	
	public boolean loginAdmin(String login,String mdp){
		admins = DaoAdmin.getAll();
		for(Admin a : admins){
			if(a.getLogin().equals(login)){
				if(a.getMdp().equals(mdp)){
					return true;
				}
			}
		}
		return false;
	}
	
	public Admin findAdmin(String login){
		Admin a = null;
		for(Admin admin : admins){
			if(admin.getLogin().equals(login)){
				a = admin;
			}
		}
		return a ;
	}
	
	public boolean loginClient(String email,String mdp){
		clients = DaoClient.getAll();
		for(Client c : clients){
			if(c.getEmail().equals(email)){
				if(c.getMdp().equals(mdp)){
					return true;
				}
			}
		}
		return false;
	}
	
	public Client findClient(String email){
		Client c = null;
		for(Client client : clients){
			if(client.getEmail().equals(email)){
				c = client;
			}
		}
		return c;
	}
}
