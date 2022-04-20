 
import java.util.ArrayList;
import java.util.Scanner;

public class Vendeur extends Membre {
	

	/*attributs non "satatic"*/
		
	private String idVendeur;
	
	
	
	/*Contructeur*/
	
	Vendeur(String nom, String prenom, String adresse, String telephone, String email, String pseudo, String password, String statut, String type ){
		
		super(nom,prenom, adresse, telephone,email,pseudo, password, statut, type);
		idVendeur = super.getIdIndividu();
	}
	
	
	/*surcharge*/
	
	Vendeur(String idft, String nom, String prenom, String adresse, String telephone, String email, String pseudo, String password, String statut, String type ){
		super(idft,nom,prenom, adresse, telephone,email,pseudo, password, statut, type);
		idVendeur = super.getIdIndividu();
	}

	
	/*attributs  "satatic"*/
	
	private static ArrayList<Vendeur> allVendeur = new ArrayList<Vendeur>();

	
	
	
	
	/*methodes non "static"*/
	
	public static int sidentifier(String psd, String pwd) {
		
		int p = 0;
		int test = 1;
		
		try {
			while (test == 1) {
				
				Vendeur v = Vendeur.getVendeur(p);
				
				if (v.getPseudo().equals(psd) && v.getPassword().equals(pwd)) {
					test = 0;
				}
				
				p++;
			}
			
		}
		catch(IndexOutOfBoundsException e) {
			
			System.out.println("\nAucun compte ne correspond à ces coordonnées");
		}
		
		return p-1;
    }
	
	
	
	void publierProduit() throws NosExceptions{
					
		try {

			Scanner sc = new Scanner(System.in);
					
			super.verif();  /*vérification de l'état de connexion du vendeur*/
			
			
			System.out.println("\nInitialisation de la publication");

			
			System.out.println("\nEntrez le nom du produit");
			String nom = sc.nextLine();
			NosExceptions.verifChamp(nom);

				
			System.out.println("Entrez le prix du produit");
			String prop  = sc.nextLine();
			NosExceptions.verifChamp(prop);
			float prix = Float.parseFloat(prop);

			
			System.out.println("Entrez la catégorie du produit");
			String categorie = sc.nextLine();
			NosExceptions.verifChamp(categorie);

			
			System.out.println("Entrez la déscription du produit");
			String description = sc.nextLine();
			NosExceptions.verifChamp(description);

			
			System.out.println("Entrez la durée de livraison du produit");
			String estimation = sc.nextLine(); 
			NosExceptions.verifChamp(estimation);

			
			Produit p = new Produit(nom, prix, categorie, estimation, idVendeur, description); /*création du produit*/
			Produit.addProduit(p);    /*publication du produit*/
			
			System.out.println("\nPublication réussi avec succès !");


		} catch(NosExceptions e) {
			
			System.out.println(e.getMessage());  /* on informe qu'il faut se connecter avant de publier un produit*/
			
		}
	}
	
	
	
	float suivreVente() {
		
		int ca = 0;  /*chiffre d'affaires*/
		
		try {
			
			this.verif();   /* verification de l'etat de connexion*/
		
			for (int i = 0; i < Produit.getNbProduit(); i++) {
				
				Produit p = Produit.getProduit(i);
				
				if ((p.getIdVendeur() == idVendeur) && p.getVendu()==true) {               /*on recherche les produits publiés par le vendeur*/
						System.out.println("   "+i+")"+p.getNom()+"  :  "+p.getPrix());    /*et on les affiche*/
						ca += p.getPrix();
				}
			}
		}
		catch(NosExceptions e) {
					System.out.println(e.getMessage());         /* on informe qu'il faut se connecter avant de publier un produit*/
		}
		return ca;	
	}
	
	
	/*methode "static"*/
	
	public static void addVendeur(Vendeur v) {
		allVendeur.add(v);
	}
	
	

	public static int getNbVendeur() {
		return allVendeur.size();
	}
	
	
	
	public static Vendeur getVendeur(int indice) {
		return allVendeur.get(indice);
	}
	

	/*possibilité de generer un contrat pour devenir vendeur sur la plateforme*/
	
	public static void faireUnContrat() throws NosExceptions {    
		
		
		try {
			
		Scanner sc = new Scanner(System.in);

		System.out.println("\nDébut de la crétion du compte vendeur");

		
		System.out.println("\nEntrez le nom du vendeur");
		String nom = sc.nextLine();
		NosExceptions.verifChamp(nom);
		
		System.out.println("Entrez le prénom du vendeur");
		String prenom = sc.nextLine();
		NosExceptions.verifChamp(prenom);

		
		System.out.println("Entrez l'adresse du vendeur");
		String adresse = sc.nextLine();
		NosExceptions.verifChamp(adresse);

		
		System.out.println("Entrez le numero du vendeur");
		String telephone = sc.nextLine();
		NosExceptions.verifChamp(telephone);

		
		System.out.println("Entrez l'email du vendeur");
		String email = sc.nextLine();
		NosExceptions.verifChamp(email);

		
		System.out.println("Quel type de vendeur souhaitez vous être?\nParituclier ---> 1\nProfessionel --->2");
		
		String type = sc.nextLine();
		NosExceptions.verifChamp(type);
		
		int choix = Integer.parseInt(type);
		if(choix == 1) {
			type = "Particulier";
		}
		else {
			type = "Professionel";
		}

		
		System.out.println("Entrez le pseudo du vendeur");
		String pseudo = sc.nextLine();
		NosExceptions.verifChamp(pseudo);

		
		System.out.println("Entrez le password du vendeur");
		String password = sc.nextLine();
		NosExceptions.verifChamp(password);

		
		Vendeur v = new Vendeur(nom, prenom, adresse, telephone, email, pseudo, password, "Vendeur", type);  /*création de son compte vendeur*/
		Vendeur.addVendeur(v); 
		
		System.out.println("\nVotre compte a bien été créé!");
		
		
		System.out.println("\n\nPassons à la formalisation du contrat-vendeur");


		System.out.println("\nEntrez la date de début du contrat");
		String dateDebut = sc.nextLine();
		NosExceptions.verifChamp(dateDebut);

		
		System.out.println("\nEntrez la date de fin du contrat");
		String dateFin = sc.nextLine();
		NosExceptions.verifChamp(dateFin);		

				
		Contrat c = new Contrat(v.getIdIndividu(), dateDebut, dateFin);
		Contrat.addContrat(c);
		NosExceptions.verifChamp(nom);

		
		System.out.println("\nVotre contrat a bien été rempli!");

		}
		
		catch(NosExceptions e) {
			System.out.println(e.getMessage());
		}

	}
	
	
	/*
	
	public static  Vendeur seConnecter(String psd, String pwd) {
		
		for (int i = 0; i < Vendeur.getNbVendeur(); i++) {
			
			Vendeur v = Vendeur.getVendeur(i);
			
			if((psd == v.getPseudo()) && (pwd == v.getPassword())) {
				v.setEtatConnexion(true);
				return v;	
			}
			else {
				 
			}
		}
		
		*/
		
		/*
    	if ((pseudo == psd) && (password == pwd)) {
    		etatConnexion = true;
    	}
    	else {
    		System.out.println("Coordonnées incorrect! Ressayer pour vous connecter!");
    	}
    	*/	
	
}
	
	

