package uvsq21606235.Personnel;

import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import uvsq21606235.Personnes.AffichageParGroupe;
import uvsq21606235.Personnes.GroupePersonnel;
import uvsq21606235.Personnes.Personnel;

public class AffichageParGroupeTest {

	@Test
	public void serialisationTest() {
		int i = 1;
		GroupePersonnel gp1 = new GroupePersonnel(i);
    	
    	ArrayList<String> num = new ArrayList<String>();
    	num.add("07-28-54-81-10");
    	num.add("09-10-15-00-00");
        Personnel p = new Personnel.Builder("Ababa","Amoulanfé", "Animateur", LocalDate.of(2000, 12, 12),num,"911@gmail.com",1).build();
      
        gp1.add(p);
        AffichageParGroupe parcours = new AffichageParGroupe();
        parcours.parcoursEnLargeur(gp1);
        parcours.serialisation("essai.txt");
        File f = new File("essai.txt");
        assertNotNull(f);
	}

}
