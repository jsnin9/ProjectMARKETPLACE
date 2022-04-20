 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Contrat {
	

	/*attributs non static*/
	
	
	private String idContrat;
	private String idVendeur;
	private String dateDebut;
	private String dateFin;
	private Boolean etat; 
	
	/*constructeur*/
	
	Contrat(String idv, String db, String df ){
		idContrat = "cnt"+id;
		
		idVendeur = idv;
		dateDebut = db;
		dateFin = df;
		etat = true;
		
		id++;	
	}
	
	
	/*surcharge*/
	
	Contrat(String idft, String idv, String db, String df ){
		idContrat = idft;
		
		idVendeur = idv;
		dateDebut = db;
		dateFin = df;
		etat = true;
		
		id++;	
	}
	

	
	/*attributs statics*/
	
	private static int id = 0;
	
	private static ArrayList<Contrat> allContrat = new ArrayList<>();
	
	private static float commission = 1/5;
	
	private static String condition ="Veuillez vendre dans le respect!\nVendez bien";
	
	/*methode non static*/
	
	
	
	public String getIdContrat() {
		return idContrat;
	}
	
	public String getIdVendeur() {
		return idVendeur;
	}
	
	
	public String getDateDebut() {
		return dateDebut;
	}
	
	
	public String getDateFin() {
		return dateFin;
	}
	
	public Boolean getEtat() {
		return etat;
	}
	
	public void setEtat(Boolean t) {
		etat = t;
	}
	
	
	
	/*methodes statics*/

	public static void addContrat(Contrat c) {
		allContrat.add(c);
	}
	
	public static int getNbContrat() {  
		return allContrat.size();
	}
	
	
	public static Contrat getContrat(int indice) { 
		return allContrat.get(indice);
	}
	
	public static float getCommission() {
		return commission;
	}
	
	
	public static String getCondition() {
		return condition;	
	}


	
	
	

	
		
	
	
	
	
	
	

	

}
