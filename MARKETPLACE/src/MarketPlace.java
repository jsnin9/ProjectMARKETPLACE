import java.util.Scanner;

public class MarketPlace {
	
	private static int id = 0;
	
	private int idMarketPlace;
	private String nomMarketPlace;
	
	MarketPlace(String nom) {
		idMarketPlace = id;
		nomMarketPlace = nom;
		id++;
	}
	
	
	public int getidMarketPlace() {
		return idMarketPlace;
	}
	
	public String getNom() {
		return nomMarketPlace;
	}
	
	public void resilierContrat(Contrat c) {
		c.setEtat(false);
	}
	
	void publierProduit() throws NosExceptions{
		
		try {

			Scanner sc = new Scanner(System.in);
				
			
			
			System.out.println("\nInitialisation de la publication");

			
			System.out.println("\nEntrez le nom du produit");
			String nom = sc.nextLine();
			NosExceptions.verifChamp(nom);

				
			System.out.println("Entrez le prix du produit");
			String prop  = sc.nextLine();
			NosExceptions.verifChamp(prop);
			float prix = Float.parseFloat(prop);

			
			System.out.println("Entrez la cat�gorie du produit");
			String categorie = sc.nextLine();
			NosExceptions.verifChamp(categorie);

			
			System.out.println("Entrez la d�scription du produit");
			String description = sc.nextLine();
			NosExceptions.verifChamp(description);

			
			System.out.println("Entrez la dur�e de livraison du produit");
			String estimation = sc.nextLine(); 
			NosExceptions.verifChamp(estimation);

			
			Produit p = new Produit(nom, prix, categorie, estimation, null, description); /*cr�ation du produit*/
			Produit.addProduit(p);    /*publication du produit*/
			
			System.out.println("\nPublication r�ussi avec succ�s !");


		} catch(NosExceptions e) {
			
			System.out.println(e.getMessage());  /* on informe qu'il faut se connecter avant de publier un produit*/
			
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	

