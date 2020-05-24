package uvsq21606235.Dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uvsq21606235.DAO.DAOGroupePersonnel;
import uvsq21606235.Personnes.GroupePersonnel;

public class DAOGroupePersonnelTest {

	@Test
    public void testAjout() {
		int i = 1;
        DAOGroupePersonnel daogp = new DAOGroupePersonnel();
        GroupePersonnel gp = new GroupePersonnel(i);
        daogp.ajout(gp);
        assertNotNull(daogp);
    }

    @Test
    public void testSuppression() {
    	int i = 1;
        DAOGroupePersonnel daogp = new DAOGroupePersonnel();
        GroupePersonnel gp = new GroupePersonnel(i);
        daogp.ajout(gp);
        daogp.supprimerElement(gp);
        assertNotNull(daogp);
    }
}
