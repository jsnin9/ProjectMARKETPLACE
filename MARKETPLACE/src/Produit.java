 
import java.util.ArrayList;
import java.util.Collections;

public class Produit {
	
	/*attributs non static*/
	
	private String idProduit;
	private String nom;
	private float prix;
	private String categorie;
	private String description;
	private int disponibilite;
	private String estimationdatedestinationLivraison;
	private String type;
	private String idVendeur;
	private Boolean vendu;

	/*contructeur*/
	
	Produit(String nom, float prix, String categorie, String EstimationdatedestinationLivraison, String idv, String description){

		this.idProduit = "prd"+id;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		this.description = description;
		this.estimationdatedestinationLivraison = EstimationdatedestinationLivraison;
		this.idVendeur = idv;
		this.vendu = false;
		id++;
	}
	
	
	
	/*surcharge*/
	
	Produit(String idft, String nom, float prix, String categorie, String EstimationdatedestinationLivraison, String idv, String description){
		
		
		this.idProduit = idft;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		this.description = description;
		this.estimationdatedestinationLivraison = EstimationdatedestinationLivraison;
		this.idVendeur = idv;
		this.vendu = false;
		id++;
	}
	
	
	/*attributs statics*/
	
	public static int id=0;
	
	private static ArrayList<Produit> allProduit = new ArrayList<>();
	

	/*methodes non static*/
	
	
	public String getNom() {
		return nom;
	}
	
	public float getPrix() {
		return prix;
	}
	
	public void setPrix(int x) {
		prix = x;	
	}
	
	public int getDisponibilite() {
		return disponibilite;
	}
	

	
	public void setDisponibilite(int y) {
		disponibilite = y;
		
	}
	
	
	public String getType() {
		return type;
	}
	
	public String getCategorie() {
		return categorie;
	}


	public String getdescription() {
		return description;
	}
	
	public String getIdProduit() {
		return idProduit;
	}
	
	public String getIdVendeur() {
		return idVendeur;
	}
	
	public String getEstimation() {
		return estimationdatedestinationLivraison;
	}

	
	public Boolean getVendu() {
		return vendu;
	}

	
	public void setVendu(Boolean t) {
		vendu = t;
	}
	
	
	
	public static void addProduit(Produit p) {
		allProduit.add(p);
	}
	
	public static int getNbProduit() {
		return allProduit.size();
	}
	
	
	public static Produit getProduit(int indice) {
		return allProduit.get(indice);
	}
	
	
	
	/*methode static*/
	
	
	public static ArrayList<Produit> triTableau(ArrayList<Produit> tabPrd){  /*methode qui permet au client de classer les produit voulu par ordre decroissant de prix*/
		
		int n = tabPrd.size();
		int j = n;
		
		ArrayList<Float> tabPrix = new ArrayList<Float>();
		
		for (int i = 0; i < n ; i++) {
			
			tabPrix.add((tabPrd.get(i).getPrix()));
		}
		
		Collections.sort(tabPrix);
		
		ArrayList<Produit> newTabPrd = new ArrayList<Produit>();
		
		for (int i = 0; i < n; i++) {
						
				int test = 1;
				
				int p = 0;
				
				while ((p < j) && (test==1)) {
					
					Produit pext = tabPrd.get(p);
					
					if (pext.getPrix() == tabPrix.get(i)) {
						
						newTabPrd.add(pext);
						
						j = j-1;
						
						test = 0;
						
						tabPrd.remove(p);
					}
					
					p++;
				}		
		}
	
		return newTabPrd;	
	}
	
	
	
	
	public static void AfficherProduitDisponible() {  /*dresser la liste de tous les produits disponible(non vendu)*/
		
		Produit p;
		
		for (int i = 1; i <= getNbProduit(); i++) {
			
			p = getProduit(i-1);
		
			if (p.getVendu() == false)
				
				System.out.println("--->  "+i+") "+p.getNom()+" : "+p.getPrix()+" euros");
		}
	}
	
	
	public static void remplacer(int indice, Produit p) {
		allProduit.set(indice, p);
	}




}
