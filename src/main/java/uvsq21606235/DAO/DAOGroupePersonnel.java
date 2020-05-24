package uvsq21606235.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import uvsq21606235.Personnes.GroupePersonnel;
import uvsq21606235.Personnes.PersonnelInterface;

public class DAOGroupePersonnel implements DAO<GroupePersonnel>, Serializable{

	
	private static final long serialVersionUID = -6198144658607662218L;
	
	private ArrayList<GroupePersonnel> listDAO;
	
	public  DAOGroupePersonnel() {
		// TODO Auto-generated constructor stub
		listDAO = new ArrayList<GroupePersonnel>();
	}


	@Override
	public void ajout(GroupePersonnel Object) {
		// TODO Auto-generated method stub
		if(!listDAO.contains(Object))
			listDAO.add(Object);
	}

	@Override
	public GroupePersonnel obtenirElement(int id) {
		for (GroupePersonnel g : listDAO) {
            if (g.getId() == id) {
                return g;
            }
        }
		return null;
	}

	@Override
	public void supprimerElement(GroupePersonnel Object) {
		// TODO Auto-generated method stub
		listDAO.remove(Object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void miseAjour(GroupePersonnel object, Map<String, Object> param) {
	        if (listDAO.contains(object)) {
	            if (param.containsKey("personnels")) {
	                ArrayList<PersonnelInterface> update =
	                (ArrayList<PersonnelInterface>)
	                param.get("personnels");
	                object.reset();
	                for (PersonnelInterface ip : update) {
	                    object.add(ip);
	                }
	            }
	        }
		
	}

	

}
