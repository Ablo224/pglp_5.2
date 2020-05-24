package uvsq21606235.Personnel;

import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import uvsq21606235.Personnes.Personnel;



public class PersonnelTest {
	

	@Test
	public void serialisationTest() {
	    ArrayList<String> num = new ArrayList<String>();
	    num.add("07-28-54-81-10");
    	num.add("09-10-15-00-00");
    	Personnel p1 = new Personnel.Builder("Ababa","Amoulanfé", "Animateur", LocalDate.of(2000, 12, 12),num,"911@gmail.com",1).build();       
    	p1.serialisation("essai.txt");
        File f = new File("essai.txt");
        f.deleteOnExit();
        assertNotNull(f);
      
	}
	
}
