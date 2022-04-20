 
public abstract class Individu {
	
	private static int id = 0;
	
	private String idIndividu;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	
	Individu(String nom, String prenom, String adresse, String telephone, String email) {
		
		this.idIndividu = "indv"+id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		id++;
	}
	
	/*surcharge*/
	
	Individu(String idft, String nom, String prenom, String adresse, String telephone, String email) {
			
			this.idIndividu = idft;
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.telephone = telephone;
			this.email = email;
			id++;
		}
	
	

    public String getnom(){
        return nom;
    }
	
    public String getprenom(){
        return prenom;

    }
	
    public String getadresse(){
        return adresse;
        
    }
	
    public String gettelephone(){
        return telephone;
        
    }

    public String getemail(){
        return email;
        
    }

    public void setadresse(String a){
        adresse = a;
    }

    public void settelephone( String t){
        telephone = t;
    }

    public void setemail(String e){
        email = e;
    }
    
    public String getIdIndividu() {
    	return idIndividu;
    }
}

