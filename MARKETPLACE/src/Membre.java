 
public abstract class  Membre extends Individu {
	
	
	    private String pseudo;
	    private String password;
	    private Boolean etatConnexion;
	    private String statut;
	    private String type;

	    Membre(String nom, String prenom, String adresse, String telephone, String email, String pseudo, String password, String statut, String type){

	        super(nom, prenom, adresse, telephone, email);
	        this.pseudo = pseudo;
	        this.password = password;
	        this.etatConnexion = false;
	        this.statut = statut;
	        this.type = type;
	    }
	    
	    
	    /*surcharge*/
	    
	    Membre(String idft, String nom, String prenom, String adresse, String telephone, String email, String pseudo, String password, String statut, String type){

	        super(idft,nom, prenom, adresse, telephone, email);
	        this.pseudo = pseudo;
	        this.password = password;
	        this.etatConnexion = false;
	        this.statut = statut;
	        this.type = type;
	    }
	    

		public String getPseudo() {
	    	return pseudo;
	    }
	    
	    
	    public Boolean getEtatConnexion() {
	    	return etatConnexion;
	    }
	    
	    
	    public String getPassword() {
	    	return password;
	    }
	    
	    
	    public String getStatut() {
	    	return statut;
	    }
	    
	    public void seConnecter() {
	    	etatConnexion = true;
	    }
	    
	    
	    public String getType() {
	    	return type;
	    }
	    
	  /*  
	    public void seConnecter(String psd, String pwd) {
	    	if ((pseudo.equals(psd)) && (password.equals(pwd))) {
	    		etatConnexion = true;
	    	}
	    	else {
	    		System.out.println("Coordonnées incorrect! Ressayer pour vous connecter!");
	    	}
	    }*/
	    
	    void verif() throws NosExceptions{
			if (getEtatConnexion() == false) {
				throw new NosExceptions("Veuillez vous connectez avant tout!");
			}
		}
	    
	      
}
