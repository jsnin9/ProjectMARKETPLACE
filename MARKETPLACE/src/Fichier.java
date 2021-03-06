 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Fichier {
	
	public static void initFichier() {
		
		/*initialisation du fichiers des individus*/
		
		File fileIndividu = new File("fichierIndividu.txt");

		if (!fileIndividu.exists()) {
			
			try {
				
				fileIndividu.createNewFile();
					
					FileWriter writer = new FileWriter(fileIndividu);
					BufferedWriter bw = new BufferedWriter(writer);
					
					bw.write("identifiant;nom;prenom;adresse;telephone;email;pseudo;password;statut;type");
					bw.newLine();
					
					bw.close();
					writer.close();
				}
				
				catch(IOException e){
					
					System.out.println("erreur d'initialisation des fichiers");
				}
			}

		/*initialisation du fichiers des Produits*/
		
		File fileProduit = new File("fichierProduit.txt");

		if (!fileProduit.exists()) {
			
			try {
				
					fileProduit.createNewFile();
					
					FileWriter writer = new FileWriter(fileProduit);
					BufferedWriter bw = new BufferedWriter(writer);
					
					bw.write("identifiant;nom;prix;categorie;tempsEstimation;idVendeur;description");
					bw.newLine();
					
					bw.close();
					writer.close();
				}
				
				catch(IOException e){
					
					System.out.println("erreur d'initialisation des fichiers");
				}
			}
		
		
		/*initialisation du fichiers des Commandes*/
		
		File fileCommande = new File("fichierCommande.txt");

		if (!fileCommande.exists()) {
			
			try {
				
				fileCommande.createNewFile();
					
					FileWriter writer = new FileWriter(fileCommande);
					BufferedWriter bw = new BufferedWriter(writer);
					
					bw.write("identifiant;dateCommande;idClient;idLivreur;idProduitsTab;etatSolde;livree;livraison_maion;pret");
					bw.newLine();
					
					bw.close();
					writer.close();
				}
				
				catch(IOException e){
					
					System.out.println("erreur d'initialisation des fichiers");
				}
			}
		
		
		/*initialisation du fichiers des contrats*/
		
		File fileContrat = new File("fichierContrat.txt");
		
		if (!fileContrat.exists()) {
			
			try {

				fileContrat.createNewFile();
					
					FileWriter writer = new FileWriter(fileContrat);
					BufferedWriter bw = new BufferedWriter(writer);
					
					bw.write("identifiant;idVendeur;dateDebut;dateFin;etat");
					bw.newLine();
					
					bw.close();
					writer.close();
				}
				
				catch(IOException e){
					
					e.printStackTrace();
					System.out.println("erreur d'initialisation");
				}
			}
	
		
		
		
		/*mettre le reste*/
		
		
	}	
	
	

	
	
	
	
		
	public static void chargementIndividu() {  /*revoir cette methode*/
			
			File fileIndividu = new File("fichierIndividu.txt");
			
			try {
				FileReader reader = new FileReader(fileIndividu);
				BufferedReader bfr = new BufferedReader(reader);
				
				String line = bfr.readLine();
				
				
				
				while( (line = bfr.readLine() ) != null) {
					
					String[] tabIndividu = line.split(";");
					
					String identifiant = tabIndividu[0];
					String nom = tabIndividu[1];
					String prenom = tabIndividu[2];
					String adresse = tabIndividu[3];
					String telephone = tabIndividu[4];
					String email = tabIndividu[5];
					String pseudo = tabIndividu[6];
					String password = tabIndividu[7];
					String statut = tabIndividu[8];
					String type = tabIndividu[9];

					if (statut.equals("Vendeur")) {
					
						Vendeur v = new Vendeur(identifiant,nom,prenom, adresse, telephone, email, pseudo, password, "Vendeur" ,type);
						Vendeur.addVendeur(v);
					}
					
					if (statut.equals("Client")) {
						
						Client v = new Client(identifiant, nom ,prenom, adresse, telephone, email, pseudo, password, "Client" ,type);
						Client.addClient(v);
					}

				}
				bfr.close();
			}
			 catch (IOException e) {
				e.printStackTrace();
			}	
		}
	
	
	
	public static void chargementProduit() {   	/*revoir cette methode*/
			
			File file = new File("fichierProduit.txt");
			
			try {
				FileReader reader = new FileReader(file);
				BufferedReader bfr = new BufferedReader(reader);
				
				String line = bfr.readLine();
				
				
				while( (line = bfr.readLine() ) != null) {
					
					String[] tabProduit = line.split(";");
					
					String identifiant = tabProduit[0];
					String nom = tabProduit[1];
					float prix = Float.parseFloat(tabProduit[2]);
					String categorie = tabProduit[3];
					String estimation = tabProduit[4];
					String idVendeur = tabProduit[5];
					String description = tabProduit[6];
					
					Produit p;
					if(idVendeur.equals("null")) {
						
					p = new Produit(identifiant,nom, prix, categorie, null, null, null);
					Produit.addProduit(p);	
					
					}
					else {
						p = new Produit(identifiant,nom, prix, categorie, estimation, idVendeur, description);
						Produit.addProduit(p);	
					}
				}
				bfr.close();
				reader.close();
			}
			 catch (IOException e) {
				e.printStackTrace();
			}	
		}
	
	

	public static void chargementContrat() {  /*revoir*/
		
		File fileContrat = new File("fichierContrat.txt");
		
		try {
			FileReader reader = new FileReader(fileContrat);
			BufferedReader bfr = new BufferedReader(reader);
			
			String line = bfr.readLine();
			
			
			while( (line = bfr.readLine() ) != null) {
				
				String[] tabContrat = line.split(";");
				
				String identifiant = tabContrat[0];
				String idVendeur = tabContrat[1];
				String dateDebut = tabContrat[2];
				String dateFin = tabContrat[3];
				
				Contrat c = new Contrat(identifiant,idVendeur, dateDebut, dateFin);
				Contrat.addContrat(c);
			}
			bfr.close();
			reader.close();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	

	public static void chargementCommande() {
			
			File fileCommande = new File("fichierCommande.txt");
			
			try {
				FileReader reader = new FileReader(fileCommande);
				BufferedReader bfr = new BufferedReader(reader);
				
				String line = bfr.readLine();
				
			
				
				while( (line = bfr.readLine() ) != null) {
					
					String[] tabCommande = line.split(";");
					
					String identifiant = tabCommande[0];
					String date = tabCommande[1];
					String idClient = tabCommande[2];
					String idLivreur = tabCommande[3];
					
					String idProduitCar = tabCommande[4];
					idProduitCar = idProduitCar.replace("[","");
					idProduitCar = idProduitCar.replace("]","");
					String idProduitTab[] = idProduitCar.split(",");
					
					ArrayList<String> idProduit = new ArrayList<>();
					
					for(int i = 0; i < idProduitTab.length; i++) {
						idProduit.add(idProduitTab[i]);
					}
	
					
					Boolean etatSolde = Boolean.parseBoolean(tabCommande[5]);
					Boolean livree = Boolean.parseBoolean(tabCommande[6]);
					Boolean livraison_maison = Boolean.parseBoolean(tabCommande[7]);
					Boolean pret = Boolean.parseBoolean(tabCommande[8]);

					
					Commande p = new Commande(identifiant,date, idClient, idLivreur, idProduit, livree, etatSolde, livraison_maison, pret);
					Commande.addCommande(p);
					
				}
				bfr.close();
				reader.close();
			}
			 catch (IOException e) {
				e.printStackTrace();
			}	
		
			
	

	}
	

	public static void actualisation() {
		
		
			File fileIndividu = new File("fichierIndividu.txt");
			
			File fileCommande = new File("fichierCommande.txt");

			File fileProduit = new File("fichierProduit.txt");

			File fileContrat = new File("fichierContrat.txt");
			

			try {
				
				FileWriter writerIndividu = new FileWriter(fileIndividu);
				BufferedWriter bwi = new BufferedWriter(writerIndividu);
				
				bwi.write("identifiant;nom;prenom;adresse;telephone;email;pseudo;password;statut;type");
				bwi.newLine();
			
				for (int i = 0; i < Vendeur.getNbVendeur(); i++) {
					Vendeur v = Vendeur.getVendeur(i);
					bwi.write(v.getIdIndividu()+";"+v.getnom()+";"+v.getprenom() +";"+v.getadresse()+";"+v.gettelephone()+";"+v.getemail()+";"+v.getPseudo()+";"+v.getPassword()+";"+"Vendeur"+";"+v.getType());
					bwi.newLine();
				
				}
				
				for (int i = 0; i < Client.getNbClient(); i++) {
					Client c = Client.getClient(i);
					bwi.write(c.getIdIndividu()+";"+c.getnom()+";"+c.getprenom() +";"+c.getadresse()+";"+c.gettelephone()+";"+c.getemail()+";"+c.getPseudo()+";"+c.getPassword()+";"+"Client"+";"+c.getType());
					bwi.newLine();
				}
				
				/*for (int i = 0; i < Client.getNbClient(); i++) {
					Fichier.saisie(Client.getClient(i));
				}*/
				
				bwi.close();
				writerIndividu.close();
				
				
				
				FileWriter writerCommande = new FileWriter(fileCommande);
				BufferedWriter bwc = new BufferedWriter(writerCommande);
				
				bwc.write("identifiant;dateCommande;idClient;idLivreur;idProduitsTab;etatSolde;livree;livraison_maion;pret");
				bwc.newLine();
				
				for (int i = 0; i < Commande.getNbCommande(); i++) {
					Commande c = Commande.getCommande(i);
					bwc.write(c.getIdCommande()+";"+c.getDate() +";"+c.getIdClient()+";"+c.getIdLivreur()+";"+c.getTabIdProduit().toString()+";"+c.getetatSolde()+";"+c.getLivree()+";"+c.getLivree()+";"+c.getpret());
					bwc.newLine();
				}
				
				bwc.close();
				writerCommande.close();
				
				

				FileWriter writerProduit = new FileWriter(fileProduit);
				BufferedWriter bwp = new BufferedWriter(writerProduit);
				
				bwp.write("identifiant;nom;prix;categorie;tempsEstimation;idVendeur;description");
				bwp.newLine();
				
				for (int i = 0; i < Produit.getNbProduit(); i++) {
					Produit p = Produit.getProduit(i);
					bwp.write(p.getIdProduit()+";"+p.getNom() +";"+p.getPrix()+";"+p.getCategorie()+";"+p.getEstimation()+";"+p.getIdVendeur() +";"+p.getdescription());
					bwp.newLine();
					
				}
				
				bwp.close();
				writerProduit.close();
				
				
				
				FileWriter writerContrat = new FileWriter(fileContrat);
				BufferedWriter bwct = new BufferedWriter(writerContrat);
				
				bwct.write("identifiant;idVendeur;dateDebut;dateFin;etat");
				bwct.newLine();	
				
				for (int i = 0; i < Contrat.getNbContrat(); i++) {
					Contrat c  = Contrat.getContrat(i);
					bwct.write(c.getIdContrat()+";"+c.getIdVendeur()+";"+c.getDateDebut() +";"+c.getDateFin()+";"+c.getEtat());
					bwct.newLine();
				}
				
				bwct.close();
				writerContrat.close();
				

			
			}
			
			catch(IOException e) {
				System.out.println("erreur d'actualisation");
			}
	
		
	}
	
	
}
