package uvsq21606235.DAO;

import uvsq21606235.Personnes.GroupePersonnel;
import uvsq21606235.Personnes.Personnel;

/**
 * 
 * @author ablo
 *
 */

public interface AbstractDaoFactory {
	
		DAO<Personnel> createDaoPersonnel();

		DAO<GroupePersonnel> createDaoGroupePersonnel();

}
