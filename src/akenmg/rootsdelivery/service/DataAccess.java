package akenmg.rootsdelivery.service;

import java.util.ArrayList;
import java.util.List;

import akenmg.rootsdelivery.dao.DaoAdmin;
import akenmg.rootsdelivery.dao.DaoClient;
import akenmg.rootsdelivery.dao.DaoCommande;
import akenmg.rootsdelivery.dao.DaoPlat;
import akenmg.rootsdelivery.model.Admin;
import akenmg.rootsdelivery.model.Client;
import akenmg.rootsdelivery.model.Commande;
import akenmg.rootsdelivery.model.Plat;
import akenmg.rootsdelivery.model.view.AdminView;
import akenmg.rootsdelivery.model.view.ClientView;
import akenmg.rootsdelivery.model.view.CommandeView;
import akenmg.rootsdelivery.model.view.PlatView;

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
	
	public static List<AdminView> GetAllAdmin(){
		List<AdminView> admins = new ArrayList<AdminView>();
		for(Admin a : DaoAdmin.getAll()){
			admins.add(new AdminView(a));
		}
		return admins;
	}
	
	public static AdminView findAdmin(int id){
		AdminView admin = new AdminView( DaoAdmin.find(id) );
		return admin;
	}
	
	public static void UpdateAdmin(Admin admin){
		DaoAdmin.update(admin);
	}
	
	public static void CreateAdmin(Admin admin){
		DaoAdmin.create(admin);
	}
	public static void DeleteAdmin(int id){
		DaoAdmin.delete(id);
	}
	
	public static List<PlatView> getAllPlat(){
		List<PlatView> plats = new ArrayList<PlatView>();
		for(Plat p : DaoPlat.getAll()){
			plats.add(new PlatView(p));
		}
		return plats;
	}
	
	public static PlatView findPlat(int id){
		PlatView plat = new PlatView(DaoPlat.find(id));
		return plat;
	}
	
	public static void createPlat(Plat plat){
		DaoPlat.create(plat);
	}
	public static void deletePlat(int id){
		DaoPlat.delete(id);
	}
	public static void updatePlat(Plat plat){
		DaoPlat.update(plat);
	}
	
	public static List<CommandeView> getAllCommande(){
		List<CommandeView> commandes = new ArrayList<CommandeView>();
		for(Commande c : DaoCommande.getAll()){
			commandes.add(new CommandeView(c));
		}
		return commandes;
	}
	public static List<CommandeView> getAllCommande(boolean bool){
		List<CommandeView> commandes = new ArrayList<CommandeView>();
		for(Commande c : DaoCommande.getAll(bool)){
			commandes.add(new CommandeView(c));
		}
		return commandes;
	}
	
	public static Commande findCommande(int id){
		return DaoCommande.find(id);
	}
}
