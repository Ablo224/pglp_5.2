package uvsq21606235.Dao;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import uvsq21606235.DAO.DAOPersonnel;
import uvsq21606235.Personnes.Personnel;

public class DAOPersonnelTest {

	@Test
    public void testAjout() {
        DAOPersonnel p1 = new DAOPersonnel(1);
        ArrayList<String> num = new ArrayList<String>();
        num.add("07-28-54-81-10");
    	num.add("09-10-15-00-00");
    	Personnel p2 = new Personnel.Builder("Ababa","Amoulanfé", "Animateur", LocalDate.of(2000, 12, 12),num,"911@gmail.com",1).build();  
        p1.ajout(p2);
        assertNotNull(p1);
    }
	
	@Test
    public void testSuppression() {
        DAOPersonnel p1 = new DAOPersonnel(1);
        ArrayList<String> num = new ArrayList<String>();
        num.add("07-28-54-81-10");
    	num.add("09-10-15-00-00");
    	Personnel p2 = new Personnel.Builder("Ababa","Amoulanfé", "Animateur", LocalDate.of(2000, 12, 12),num,"911@gmail.com",1).build();  
        p1.ajout(p2);
        p1.supprimerElement(p2);
        assertNull(p1.obtenirElement(1));
    }
}
