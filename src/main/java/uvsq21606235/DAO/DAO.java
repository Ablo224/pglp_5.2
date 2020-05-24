package uvsq21606235.DAO;

import java.util.Map;

import uvsq21606235.Personnes.GroupePersonnel;

public interface DAO<T> {
	
	/**
	 * ajouter un élément
	 */
	void ajout(T Object);
	
	/**
	 * obtentio d'un élément
	 */
	T  obtenirElement(int id);
	
	/**
	 * supprimer un élément
	 */
	void supprimerElement(T Object);
	
	/**
	 * mise à jour
	 */
	void miseAjour(T object, Map<String, Object> param);

	
	
}
