package uvsq21606235.bdd;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class TestBdd {

	@Before
	public void testCreateDeletetable() throws SQLException {
		Bdd bd = new Bdd();
		bd.deleteTables();
	}
	
	@Before
	public void testCreationPersonnel()throws SQLException {
		Bdd bd = new Bdd();
		bd.creatPersonnel();
	}
	
	@Before
	public void testCreationGroupePersonnel() throws SQLException {
		Bdd bd = new Bdd();
		bd.creatGroupePersonnel();
	}
	
	@Test
	public void testCreationNumero() throws SQLException {
		Bdd bd = new Bdd();
		bd.creatNumero();
	}
	
	@Test
	public void testCreationRelation() throws SQLException {
		Bdd bd = new Bdd();
		bd.creatRelation();
	}

}
