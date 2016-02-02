package akenmg.rootsdelivery.model;

public class Plat {
	protected int id;
	protected String titre;
	protected String description;
	protected int prix;
	protected String img;
	
	public Plat() {
		super();
	}
	
	public Plat(int id, String titre, String description, int prix, String img) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.img = img;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getImg() {
//		if(img==null){
//			return "N/A";
//		}
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}
