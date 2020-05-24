package uvsq21606235.bdd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bdd {
	
		private  Connection conn = null;
	
	 
	  /**
	   * connexion à la bdd
	   * @return
	   */
	  public  Connection getConnection() {
		  Connection conn = null;
	    try {
	      conn = DriverManager.getConnection("jdbc:derby:PERSO;create=true");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return conn;
	  }

	 
	  public void creatGroupePersonnel() throws SQLException {
//		  	try{
		  		Connection conn = this.getConnection();
		  		Statement state = conn.createStatement();
		  		DatabaseMetaData databaseMetadata = conn.getMetaData();
		  		ResultSet resultSet = databaseMetadata.getTables(null, null, "GroupePersonnel", null);
		  		if (resultSet.next()) {
		  			state.addBatch("DROP TABLE GroupePersonnel");
		  			System.out.println("table supprimé");
		  		}
		  		state.addBatch("CREATE TABLE GroupePersonnel ("
		            + "idG int  PRIMARY KEY NOT NULL , "
		            + " nomG varchar(40) NOT NULL "
		            + ")");
			     state.executeBatch();
			     System.out.println("Groupe Personnel créé avec succès");
			     
	  }
	  
	  public void creatPersonnel() throws SQLException {
//		  	try{
		  		Connection conn = this.getConnection();
		  		Statement state = conn.createStatement();
		  		DatabaseMetaData databaseMetadata = conn.getMetaData();
		  		ResultSet resultSet = databaseMetadata.getTables(null, null, "Personnel", null);
		  		if (resultSet.next()) {
		  			state.addBatch("DROP TABLE Personnel");
		  			System.out.println("table supprimé");
		  		}
		        state.addBatch("CREATE TABLE Personnel ("
			            + "nom VARCHAR(100) NOT NULL ,"
			            + "prenom VARCHAR(100) NOT NULL,"
			            + "fonction VARCHAR(100) NOT NULL,"
			            + "email VARCHAR(100) NOT NULL,"
			            + "dateNaissance date NOT NULL,"
			            + "idP int not null primary key"
			            + ")");
		        state.executeBatch();
			     System.out.println("Personnel créé avec succès");
			     
	  }
	  
	  public void creatNumero() throws SQLException {
//		  	try{
		  		Connection conn = this.getConnection();
		  		Statement state = conn.createStatement();
		  		DatabaseMetaData databaseMetadata = conn.getMetaData();
		  		ResultSet resultSet = databaseMetadata.getTables(null, null, "Numero", null);
		  		if (resultSet.next()) {
		  			state.addBatch("DROP TABLE Numero");
		  			System.out.println("table supprimé");
		  		}
			    state.addBatch("CREATE TABLE Numero ("
			            + "idP int NOT NULL  primary key,"
			            + "numero VARCHAR(30) NOT NULL,"
			            + "foreign key (idP) references Personnel(idP)"
			            + ")");
			     state.executeBatch();
			     System.out.println("Numéro créé avec succès");
			     
	  }
	  
	  public void creatRelation() throws SQLException {
//		  	try{
		  		Connection conn = this.getConnection();
		  		Statement state = conn.createStatement();
		  		DatabaseMetaData databaseMetadata = conn.getMetaData();
		  		ResultSet resultSet = databaseMetadata.getTables(null, null, "Realation_P_G", null);
		  		if (resultSet.next()) {
		  			state.addBatch("DROP TABLE Realation_P_G");
		  			System.out.println("table supprimé");
		  		}
			    state.addBatch("CREATE TABLE Realation_P_G ("
			            + "idP int not null ,"
			            + "idG int not null ,"
			            + "primary key (idP,idG),"
			            + "foreign key (idP) references Personnel (idP),"
			            + "foreign key (idG) references GroupePersonnel (idG)"
			            + ")");
			    state.executeBatch();
			     System.out.println("Rélation créé avec succès");
			     
	  }
	  
	  /**
	   * suppression des tables existantes
	   */
	  public  void deleteTables() {

			Statement stat = null;
	        try {
	        	Connection conn = this.getConnection();
	            stat = conn.createStatement();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
	            stat.execute("drop table Realation_P_G");
	        } catch (SQLException e) {
	        }
	        try {
	            stat.execute("drop table Numero");
	        } catch (SQLException e) {
	        }
	        try {
	            stat.execute("drop table Personnel");
	        } catch (SQLException e) {
	        }
	        try {
	            stat.execute("drop table GroupePersonnel");
	        } catch (SQLException e) {
	        }
	     
	    }

}
