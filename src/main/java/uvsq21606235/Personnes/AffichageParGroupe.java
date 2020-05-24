package uvsq21606235.Personnes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;

public class AffichageParGroupe implements Iterable<PersonnelInterface>, Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 154586232235698548L;
	
	private ArrayDeque<PersonnelInterface> g = new ArrayDeque<PersonnelInterface>();
	
	
	public Iterator<PersonnelInterface> iterator() {
		return g.iterator();
	}
	
	public void parcoursEnLargeur(PersonnelInterface ip) {
		/**
		 * implémentation
		 */
		
	}
	
	public void serialisation(String chemin) {
        ObjectOutputStream writer = null;
        try {
            FileOutputStream fichier = new FileOutputStream(chemin);
            writer = new ObjectOutputStream(fichier);
            writer.writeObject(this);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println("Echec de serialisation ");
            e.getStackTrace();
        }
        try {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
	
	/**
	 * affiche le parcours .
	 */
	public void affichage() {
		GroupePersonnel tmp;
		/**
		 * affichage d'un parcours
		 */
		for (PersonnelInterface p : g) {
			if (p.getClass() == GroupePersonnel.class) {
				tmp = (GroupePersonnel) p;
				//System.out.println(tmp.getIdUnique());
			} else {
				p.affichage();
			}
		}
	}
}

