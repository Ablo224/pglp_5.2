package uvsq21606235.DAO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import uvsq21606235.Personnes.Personnel;

public class DAOPersonnel implements DAO<Personnel>, Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -859798817909999159L;
	
    private ArrayList<Personnel> listDAO;
    
   ;
    
    public DAOPersonnel(int id) {
        listDAO = new ArrayList<Personnel>();
    }
    
      
    /**
     * ajout d'un élément dans la liste DAO
     */
	@Override
	public void ajout(Personnel Object) {
		// TODO Auto-generated method stub
		if(!listDAO.contains(Object))
			listDAO.add(Object);
		
	}

	


	@Override
	public void supprimerElement(Personnel Object) {
		// TODO Auto-generated method stub
		listDAO.remove(Object);
	}


	@Override
	public void miseAjour(Personnel object, Map<String, Object> param) {
		// TODO Auto-generated method stub
		if (listDAO.remove(object)) {
            String nom = "";
            if (param.containsKey("nom")) {
                nom = (String) param.get("nom");
            } else {
                nom = object.getNom();
            }
            String prenom = "";
            if (param.containsKey("prenom")) {
                prenom = (String) param.get("prenom");
            } else {
                prenom = object.getPrenom();
            }
            String fonction = "";
            if (param.containsKey("fonction")) {
                prenom = (String) param.get("fonction");
            } else {
                prenom = object.getEmail();
            }
            String email = "";
            if (param.containsKey("email")) {
                prenom = (String) param.get("email");
            } else {
                prenom = object.getEmail();
            }
            LocalDate dateNaissance;
            if (param.containsKey("dateNaissance")) {
                dateNaissance = (LocalDate) param.get("dateNaissance");
            } else {
                dateNaissance = object.getDateNaissance();
            }
            int id = object.getId();
            if (param.containsKey("id")) {
                id = (int) param.get("id");
            } else {
                nom = object.getNom();
            }
            ArrayList<String> numero;
            if (param.containsKey("numero")) {
                ArrayList<String> tp;
                tp = (ArrayList<String>) param.get("numero");
                numero = (ArrayList<String>) tp.clone();
            } else {
                numero = object.getNumero();
            }
            Personnel p = new Personnel.Builder(nom, prenom,fonction, dateNaissance, numero,email,id).build();
            listDAO.add(p);
        }
		
	}


	@Override
	public Personnel obtenirElement(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
