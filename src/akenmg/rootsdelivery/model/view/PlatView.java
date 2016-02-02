package akenmg.rootsdelivery.model.view;

import akenmg.rootsdelivery.model.Plat;

public class PlatView extends Plat{

	public PlatView(Plat p){
		this.setId(p.getId());
		this.setDescription(p.getDescription());
		this.setImg(p.getImg());
		this.setPrix(p.getPrix());
		this.setTitre(p.getTitre());
	}
	
	public String getImg() {
		if(img==null){
			return "N/A";
		}
		if(img.isEmpty()){
			return "N/A";
		}
		return img;
	}
	
	public String getDescription(boolean limit,int size) {
		if(limit){
			String desc = this.getDescription();
			String str = desc;
			if(desc.length()>size){
				str = desc.substring(0, size);
			}else{
				return desc;
			}
			str += "...";
			return str;
		}else{
			return description;
		}
	}
	
}
