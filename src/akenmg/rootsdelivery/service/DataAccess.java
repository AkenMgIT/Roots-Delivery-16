package akenmg.rootsdelivery.service;

import java.util.ArrayList;
import java.util.List;

import akenmg.rootsdelivery.dao.DaoClient;
import akenmg.rootsdelivery.model.Client;
import akenmg.rootsdelivery.model.view.ClientView;

public class DataAccess {
	public static List<Client> getAllClients(){
		return DaoClient.getAll();
	}
	public static List<ClientView> getAllClientsView(){
		List<ClientView> clients = new ArrayList<ClientView>() ;
		for(Client c : DaoClient.getAll()){
			clients.add(new ClientView(c));
		}
		return clients;
	}
	
	public static ClientView findClient(int id){
		ClientView v = new ClientView(DaoClient.find(id));
		return v;
	}
	
	public static void UpdateClient(Client c){
		DaoClient.update(c);
	}
	
	public static void CreateClient(Client c){
		DaoClient.create(c);
	}
	
	public static void DeleteClient(int id){
		DaoClient.delete(id);
	}
}
