 
public class NosExceptions extends Exception{
	
	public NosExceptions(String s) {
		super(s);
	}
	
	
	
	public static void verifChamp(String s) throws NosExceptions{
		if (s == "") {
			throw new NosExceptions("Un champs n'a pas été rempli\nVotre enregistrement ne sera pas pris en compte\nVeuillez reprendre svp");
		}
	}
	


}
