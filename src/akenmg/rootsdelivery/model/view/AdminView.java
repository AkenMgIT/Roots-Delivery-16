package akenmg.rootsdelivery.model.view;

import akenmg.rootsdelivery.model.Admin;

public class AdminView extends Admin{
	public AdminView(Admin admin){
		this.setId(admin.getId());
		this.setLogin(admin.getLogin());
		this.setMdp(admin.getMdp());
	}
}
