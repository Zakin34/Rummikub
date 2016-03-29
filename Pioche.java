
public class Pioche {

	
	private int[][] paquet;

	
	//Constructeur par defaut
	public Pioche() {
		
		this.paquet = new int[107][107];
		int i = 1;
		int j = 1;
		int k = 1;
		
		while (i <= 13) {
			
			for(int z = 1; z <= 2; z++){
				
				j = 1;
				
				while (j <= 4) {
						
					paquet[1][k] = i;
					paquet[2][k] = j;
					paquet[3][k] = 1;
					j++;
					k++;
				}
			}
			i++;
			
		}
		
		
		paquet[1][105] = 14;
		paquet[2][105] = 0;
		paquet[3][105] = 1;
		paquet[1][106] = 14;
		paquet[2][106] = 0;
		paquet[3][106] = 1; 
		
	}

	
	
	
	//Méthodes
	void retirerPioche(int valeur, int couleur){
		
			
			int i = 1;
			while(this.paquet[1][i] != valeur) {
				i++;
			}
			
			int j = i;
			while(this.paquet[2][j] != couleur) {
				j++;
			}
			
			if (valeur == 14 && this.paquet[3][j] == 0) {
				j = j+1;
			
			}else{
				if (this.paquet[3][j] == 0){
					j = j+4;
				}
			}
			
			this.paquet[3][j] = 0;
	}
	
	/*void addPioche(int valeur, int couleur){
		
		
		int i = 1;
		while(this.paquet[1][i] != valeur) {
			i++;
		}
		
		int j = i;
		while(this.paquet[2][j] != couleur) {
			j++;
		}
		
		if (valeur == 14 && this.paquet[3][j] == 0) {
			j = j+1;
		
		}else{
			if (this.paquet[3][j] == 0){
				j = j+4;
			}
		}
		
		this.paquet[3][j] = 1;
}*/

	
	
	//Fonctions
	Couleur estCouleur(int valeur, int couleur) {
	
		if (couleur == 0 && valeur != 14){
			System.out.println("Le jeu est truqu� ! Valeur de la carte : " + valeur + ", couleur : "+ Couleur.Joker);
		}else if (valeur == 14) {
			return Couleur.Joker;
		}else{
			for(Couleur coul : Couleur.values()){
				if(couleur == coul.ordinal()){
					return coul;
				}
			}
		}	
		return null;
	}
	
	public static void main (String Args[]) {
		
		
		Pioche p = new Pioche();
		
		System.out.println(p.estCouleur(11, 3));
		
		p.retirerPioche(11,3);
		p.retirerPioche(11,3);
		
		p.retirerPioche(12,3);
		p.retirerPioche(12,3);
		
		p.retirerPioche(13,3);
		p.retirerPioche(13,3);
	
		p.retirerPioche(14,0);
		p.retirerPioche(14,0);
		
		
		/*for(int i = 1; i <= 106; i ++) {
			System.out.println("Num: "+p.paquet[1][i] + "| Couleur: " + p.paquet[2][i]+ "| Dispo: " + p.paquet[3][i]);
		}*/
		
		
	}
	
	
}
