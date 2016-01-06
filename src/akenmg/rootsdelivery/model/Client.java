package akenmg.rootsdelivery.model;

public class Client {
	private int id ; 
	private String nom;
	private String prenom;
	private String numero;
	private String email;
	private String mdp;
	
	public Client(int id, String nom, String prenom, String numero,
			String email, String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.email = email;
		this.mdp = mdp;
	}
	
	public Client() {
		super();
	}

	public String toString(){
		String result = "";
		result+="id: "+id+"\n";
		result+="nom: "+nom+"\n";
		result+="prenom: "+prenom+"\n";
		result+="numero: "+numero+"\n";
		result+="email: "+email+"\n";
		result+="mdp: "+mdp+"\n";
		
		return result;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
