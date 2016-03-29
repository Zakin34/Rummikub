import java.util.Scanner;


public class Joueur {
	
	
	private String pseudo;
	private Paquet main;
	int taille = 13;
	
	public Joueur(String nom) {
		
		this.pseudo = nom;
		this.main = new Paquet();
		
		
	}
	
	/*
	void retirerMain(int valeur, int couleur){
		boolean possede = true;
		
		int i = 1;
		while(this.main[1][i] != valeur) {
			i++;
		}
		
		int j = i;
		while(this.main[2][j] != couleur) {
			j++;
		}
		
		if (valeur == 14 && this.main[3][j] == 0) {
			j = j+1;
			if (this.main[3][j] == 0) {
				System.out.println("Le joueur ne possède pas cette carte !");
				possede = false;
			}
			
		}else{
			if (this.main[3][j] == 0){
				j = j+4;
				
				if(this.main[3][j] == 0) {
					System.out.println("Le joueur ne possède pas cette carte !");
					possede = false;
				}
			}
		}
		if (possede == true) {
			this.main[3][j] = 0;
		}
}*/
	
	public void addMain(int valeur, int couleur){
		this.main.AjoutenFin(valeur, couleur);
	}
	
	public Paquet getMain() {
		return this.main;
		
	}
	
	public String toString() {
		String s = "";
		s = s + this.pseudo;
		return s;
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
		
	public void piocher(Paquet pioche) {
		
		int nbAleatoireCarte = (int) (Math.random() * (14 + 1));
		int nbAleatoireCouleur = (int) (Math.random() * (3 + 1) + 1);
		
		if(pioche.appartient(nbAleatoireCarte, nbAleatoireCouleur)){
			pioche.Suppression(nbAleatoireCarte, nbAleatoireCouleur);
			this.addMain(nbAleatoireCarte, nbAleatoireCouleur);
		}else{
			piocher(pioche);
		}
		
	}
		
	public Carte[] tableauChoix() {
		
		Carte courant = this.getMain().getTete();
		Carte[] choix = new Carte[32];
		
		int i = 1;
		while (courant != null) {
			choix[i] = courant;
			courant = courant.getSuiv();
			i++;
		}
		
		return choix;
		
	}
	
	public void poserCarte (Plateau p) {

		Carte[] choix = tableauChoix();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le nombre de carte à poser :");
		int nbCarte = sc.nextInt();
		
		for (int i = 1; i <= nbCarte; i++) {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Veuillez saisir la place de la carte dans votre main :");
			int Carte = sc.nextInt();
		
			Carte posee = choix[Carte];
		
			this.getMain().Suppression(posee.getVal(), posee.getCouleur());
			p.getTuilesPosees().AjoutenFin(posee.getVal(), posee.getCouleur());
		
		}
		
		
	}
	
	
	
		
	
}