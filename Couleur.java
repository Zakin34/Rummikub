
public enum Couleur {
	
	Joker("Joker"),
	Rouge("Rouge"),
	Vert("Vert"),
	Bleu("Bleu"),
	Noir("Noir");

	
		private String name = "";
	   
	  //Constructeur
	  Couleur(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
		  
	    return "La carte est de couleur " + name;
	  }
	
}
