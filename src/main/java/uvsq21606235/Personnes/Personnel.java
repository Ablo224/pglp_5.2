package uvsq21606235.Personnes;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public final class Personnel implements PersonnelInterface, Serializable {
	
	
	private static final long serialVersionUID = -4537205130421349371L;
	
	
	/**
	 * clé primaire du personnel
	 */
	 private int id;

	/**
	 * le nom de la personne
	 */
	private String Nom;
	
	/**
	 * prenom de la personne
	 */
	private String Prenom;
	
	/**
	 * la fonction de la personne
	 */
	private String Fonction;
	
	/**
	 * la date de naissance de la personne
	 */
	private LocalDate dateNaissance;
	
	/**
	 * liste des numéro de la personne
	 */
	private ArrayList<String> Numero;
	
	/**
	 * email qui sert d'identifiant
	 * @author ablo
	 *
	 */
	private String email;
	
	/**
	 * retourne l'email de la personne
	 * @return
	 */
	public String getEmail() {
		return this.email;
	}
	
	public int getId() {
		return this.id;
	}
	
	
	
	public static class Builder{
			
			private int id;
			
			/**
			 * le nom de la personne
			 */
			private String Nom;
			
			/**
			 * prenom de la personne
			 */
			private String Prenom;
			
			/**
			 * la fonction de la personne
			 */
			private String Fonction;
			
			/**
			 * la date de naissance de la personne
			 */
			private LocalDate dateNaissance;
			
			/**
			 * liste des numéro de la personne
			 */		
			private ArrayList<String> Numero;	
			
			/**
			 * email qui sert d'identifiant
			 * @author ablo
			 *
			 */
			private String email;
			
			public Builder(String Nom, String Prenom, String Fonction, LocalDate dateNaissance,ArrayList<String> numero,String email, int id) {
			
				this.Nom = Nom;
				this.Prenom = Prenom;
				this.Fonction = Fonction;
				this.dateNaissance = dateNaissance;
				this.Numero = numero;
				this.email = email;
				this.id  = id;
			}
			
			
			/**
			 * ajout d'un numéro à la liste des numéros de la personne
			 * @param Numero
			 * @return
			 */
			public Builder Numero(String Numero) {
				this.Numero.add(Numero);
				return this	;
			}
			
			/**
			 * methode pour construire une var personnel avec builder
			 */
			public Personnel build() {
				return new Personnel(this);
			}
		}
	
	/**
	 * écriture du flux dans un fichier
	 * @param path
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
	
	public static Personnel deserialisation(String chemin) {
        ObjectInputStream reader = null;
        Personnel p = null;
        try {
            FileInputStream file = new FileInputStream(chemin);
            reader = new ObjectInputStream(file);
            p = (Personnel) reader.readObject();
        } catch (IOException e) {
        	 System.err.println("Echec de déserialisation ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return p;
    }
	
	public Personnel(Builder builder) {
		this.id = builder.id;
		this.Nom = builder.Nom;
		this.Prenom = builder.Prenom;
		this.dateNaissance = builder.dateNaissance;
		this.Numero = builder.Numero;
		this.Fonction = builder.Fonction;
		this.email = email;
	}
	
	public void affichage() {
		System.out.println("Id : "+id);
		System.out.println("Nom : "+Nom);
		System.out.println("Prenom : "+Prenom);
		System.out.println("Fonction : "+Fonction);
		System.out.println("Email: "+ email);
		System.out.println("Date de Naissance : "+dateNaissance);
		for(String num : this.Numero) {
			System.out.println(num + " ");
		}
	}

	public String getNom() {
		// TODO Auto-generated method stub
		return this.Nom;
	}
	
	public String getPrenom() {
		// TODO Auto-generated method stub
		return this.Prenom;
	}
	public String getFonction() {
		// TODO Auto-generated method stub
		return this.Fonction;
	}
	
	public LocalDate getDateNaissance() {
		// TODO Auto-generated method stub
		return this.dateNaissance;
	}
	
	public ArrayList<String> getNumero() {
		// TODO Auto-generated method stub
		return (ArrayList<String>) Numero.clone();
	}
	

	
//	@Override
//	public void affichageLargeur() {	
//	}

}
