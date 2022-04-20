
import java.util.ArrayList;

public class Commande {
	
	/*attributs non static*/
	
	private static int id = 0;
	
	private static ArrayList<Commande> allCommande = new ArrayList<Commande>();  /* tableau de toutes les commandes*/
	
	
	/*attributs statics*/

	private String idCommande;
	private String dateCommande;
	private String idClient;
	private ArrayList<String> idProduit; 
	private Boolean pret;
	private Boolean etatSolde;
	private Boolean livraison_maison;
	private Boolean livree;
	private String idLivreur;
	
	/*constructeur*/	

	Commande(String dc, String idc, String idl, ArrayList<String> idProduits, Boolean lv, Boolean etSl, Boolean lm, Boolean pt) {
		
		idCommande = "com"+ id;
		dateCommande = dc;
		idClient = idc;
		pret= lm;
		etatSolde = etSl;
		livraison_maison = lm;
		livree = lv;
		idLivreur = idl;
		
		idProduit = new ArrayList<String>();
		
		for(int i = 0; i < idProduits.size(); i++) {
			idProduit.add(idProduits.get(i));
		}
		
		id ++;
		
	}
	
	
	/*surcharge*/
	
	Commande(String idft, String dc, String idc, String idl, ArrayList<String> idProduits, Boolean lv, Boolean etSl, Boolean lm, Boolean pt) {
		
		idCommande = idft;
		dateCommande = dc;
		idClient = idc;
		pret= lm;
		etatSolde = etSl;
		livraison_maison = lm;
		livree = lv;
		idLivreur = idl;
		
		idProduit = new ArrayList<String>();
		
		for(int i = 0; i < idProduits.size(); i++) {
			idProduit.add(idProduits.get(i));
		}
		
		id++;
		
	}
	
	/*methode non static*/
	
	
	public String getIdCommande() {
		return idCommande; 
	}
	
	public String getIdLivreur() {
		return idLivreur;
	}
	
	
	public Boolean 	getmodeLivraison() {
		return livraison_maison;
	}
	
	
	public Boolean 	getetatSolde() {
		return etatSolde;
	}
	
	
	public Boolean 	getpret() {
		return pret;
	}
	
	
	public void setEtatSolde(Boolean t) {
		etatSolde = t;
	}
	
	
	public Boolean getLivree() {
		return livree;
	}
	
	
	public String getDate() {
		return dateCommande;
	}
	
	
	public String getIdClient() {
		return idClient;
	}
	
	
	public String getIdProduit(){
		return idProduit.toString();
	}
	
	
	public ArrayList<String> getTabIdProduit(){
		return idProduit;
	}
	
	
	/*methodes statics*/

	
	public static void addCommande(Commande p) {
		allCommande.add(p);
	}
	
	
	public static int getNbCommande() {  
		return allCommande.size();
	}
	
	
	public static Commande getCommande(int indice) { 
		return allCommande.get(indice);
	}
	
	
	public static void remplacer(int i, Commande com) {
		allCommande.set(i, com);
	}
	
}


