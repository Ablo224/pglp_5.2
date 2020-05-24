package uvsq21606235.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.commons.SerialVersionUIDAdder;

import uvsq21606235.Personnes.AffichageParGroupe;
import uvsq21606235.Personnes.PersonnelInterface;

public class DAOAffichageParGroupe implements DAO<AffichageParGroupe>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6648822257585967560L;
	
	private ArrayList<AffichageParGroupe> listDAO;
	
	public DAOAffichageParGroupe() {
		listDAO = new ArrayList<AffichageParGroupe>();
	}

	@Override
	public void ajout(AffichageParGroupe Object) {
		// TODO Auto-generated method stub
		if(!listDAO.contains(Object))
			listDAO.add(Object);
	}



	@Override
	public void supprimerElement(AffichageParGroupe Object) {
		// TODO Auto-generated method stub
		listDAO.remove(Object);
	}

	@Override
	public void miseAjour(AffichageParGroupe object, Map<String, Object> param) {
		// TODO Auto-generated method stub
	}

	@Override
	public AffichageParGroupe obtenirElement(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
