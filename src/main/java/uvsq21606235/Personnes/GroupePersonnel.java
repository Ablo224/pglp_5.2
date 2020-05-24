package uvsq21606235.Personnes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class GroupePersonnel implements PersonnelInterface, Iterable<PersonnelInterface> , Serializable{
	

	private static final long serialVersionUID = -4193177096991161758L;

	private ArrayList<PersonnelInterface> lePersonnel;
	
	//id élément composite
	private int id;
	

	
	public  GroupePersonnel(int id) {
		this.id = id;
		lePersonnel= new ArrayList<PersonnelInterface>();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void affichage() {
		for (PersonnelInterface p : lePersonnel) {
			p.affichage();
		}
	}
	
	/**
	 * ajout d'une personne
	 */
	
	public GroupePersonnel add(PersonnelInterface p) {
		if (!lePersonnel.contains(p)) {
			lePersonnel.add(p);
		}
		return this;
	}
	
	/**
	 * suppression d'une personne de la liste
	 */
	public GroupePersonnel delete(PersonnelInterface p) {
		if(lePersonnel.contains(p)) {
			lePersonnel.remove(p);
		}
		return this;
	}
	
	/**
	 * obtention de l'identifiant
	 */
//	public int getIdUnique() {
//		return this.idUnique;
//	}

	@Override
	public Iterator<PersonnelInterface> iterator() {
		// TODO Auto-generated method stub
		return lePersonnel.iterator();
	}
	
	
	
	/**
     * serialisation vers le fichier voulu.
     * @param path nom du fichier vers lequel serializer
     */
    public void serialisation(String chemin) {
        ObjectOutputStream writer = null;
        try {
            FileOutputStream file = new FileOutputStream(chemin);
            writer = new ObjectOutputStream(file);
            writer.writeObject(this);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println("Echec de serialisation ");
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
    
    public void reset() {
        lePersonnel.clear();
    }

}
