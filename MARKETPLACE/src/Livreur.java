import java.util.ArrayList;

public class Livreur extends Individu {
	
	
	/* attribut non static*/

	
	private String idLivreur;
	
	private ArrayList<String> idCommandeTab;
	

	/*constructeur*/
	
	Livreur(String nom, String prenom, String adresse, String telephone, String email) {
		super(nom, prenom, adresse, telephone, email);
		
		idCommandeTab = new ArrayList<String>();
		idLivreur = super.getIdIndividu();

		}
	
	/*surcharge*/
	
	Livreur(String idf, String nom, String prenom, String adresse, String telephone, String email) {
		super(nom, prenom, adresse, telephone, email);
		
		idCommandeTab = new ArrayList<String>();
		idLivreur = idf;

		}
	
	
	/*methode non static*/
	
	public ArrayList<String> getVilleidClient() {  /* pour avoir la liste des villles où il doit livrer*/
		
		ArrayList<String> idClient = new ArrayList<>();
		
		for (int i = 0; i < idCommandeTab.size(); i++) {
			
			int c = 0;
			int test = 1;
			
			while ((c < Client.getNbClient()) && (test == 1)) {
				
				if (Client.getClient(c).getIdClient().equals(idCommandeTab.get(c))) {
					
					test = 0;
					System.out.println(Client.getClient(c).getadresse());
					idClient.add((Client.getClient(c).getIdClient()));	
					test = 0;
				}
				
				c++;
			}
		}
		return idClient;
	}


	/*attribut static*/
	
	private static ArrayList<Livreur> allLivreur;
	
	
		
	
	
	
	
	
	
	
	/*methode static*/
	
	
	public static int getNbLivreur() {
		return allLivreur.size()	;
	}
	
	public static void addLivreur(Livreur l) {
		allLivreur.add(l);
	}
	
	
	
	
		
	

}
