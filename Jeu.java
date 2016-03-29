import java.util.Scanner;


public class Jeu {
	
	private final int joueurMax = 5;
	Joueur[] listeJoueur = new Joueur[joueurMax];
	Manche manche;
	Plateau plateau;
	
	
	/*public void ajoutCarteJoueur(Joueur j, Manche m) {
		
		int nbAleatoireCarte = (int) (Math.random() * (14 + 1));
		int nbAleatoireCouleur = (int) (Math.random() * (3 + 1) + 1);
		
		if(m.getPioche().appartient(nbAleatoireCarte, nbAleatoireCouleur)){
			m.getPioche().Suppression(nbAleatoireCarte, nbAleatoireCouleur);
			j.addMain(nbAleatoireCarte, nbAleatoireCouleur);
		}else{
			ajoutCarteJoueur(j,m);
		}
	}*/
	
	public void ajoutCarteJoueur(Joueur j, Manche m) {
		
		int nbAleatoireCarte = (int) (Math.random() * (106 + 1) - 1);
		
		Carte courant = m.getPioche().getTete();
		
		Carte[] choix = new Carte[107];
			
			int i = 1;
			while (courant != null) {
				choix[i] = courant;
				courant = courant.getSuiv();
				i++;
			}
			
			while (choix[nbAleatoireCarte] == null) {
				nbAleatoireCarte = (int) (Math.random() * (106 + 1) - 1);
			}
				m.getPioche().Suppression(choix[nbAleatoireCarte].getVal(), choix[nbAleatoireCarte].getCouleur());
				j.addMain(choix[nbAleatoireCarte].getVal(), choix[nbAleatoireCarte].getCouleur());
			
		
	}
	
	
	public void initialisation() {
		

		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le nombre de joueur :");
		int nbJoueur = sc.nextInt();
		
		if (nbJoueur > 4 || nbJoueur < 1){
			System.out.println("C'est impossible d'avoir 0 ou plus de 4 joueurs differents.");
			initialisation();
		}else{
		for (int i = 0; i < nbJoueur; i++) {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Veuillez saisir le nom du joueur "+(i+1)+" :");
			String nomJoueur = sc1.nextLine();
			Joueur j = new Joueur(nomJoueur);
			this.listeJoueur[i] = j;
		}
		
		/*for (int i = 1; i <= nbJoueur; i++){
			System.out.println("Le nom du Joueur "+i+" est " +listeJoueur[i]);
		}*/
		}
		
		this.manche = new Manche();
		this.plateau = new Plateau();
		
		for(int i = 1; i <= 13; i++) {
			
			if (nbJoueur == 1){
				this.ajoutCarteJoueur(this.listeJoueur[0], this.manche);
			}
			
			if (nbJoueur == 2){
				this.ajoutCarteJoueur(this.listeJoueur[0], this.manche);
				this.ajoutCarteJoueur(this.listeJoueur[1], this.manche);
			}
			
			if (nbJoueur == 3){
				this.ajoutCarteJoueur(this.listeJoueur[0], this.manche);
				this.ajoutCarteJoueur(this.listeJoueur[1], this.manche);
				this.ajoutCarteJoueur(this.listeJoueur[2], this.manche);
			}
			
			if (nbJoueur == 4){
				this.ajoutCarteJoueur(this.listeJoueur[0], this.manche);
				this.ajoutCarteJoueur(this.listeJoueur[1], this.manche);
				this.ajoutCarteJoueur(this.listeJoueur[2], this.manche);
				this.ajoutCarteJoueur(this.listeJoueur[3], this.manche);
			}
			
			
		
		}
		
		
		
	}
	
	public void tourDUnJoueur(Joueur j) {
		
		System.out.println(j.getPseudo() +" : " +j.getMain());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Piocher:");
		System.out.println("2) Poser:");
		int choixJeu = sc.nextInt();
		
		
		if (choixJeu == 1) {
			j.piocher(manche.getPioche());
		}
		
		if (choixJeu == 2) {
			j.poserCarte(plateau);
		}
		
		
		System.out.println("------------------------------------------");
		
	}
	
	public void tourDeJeu() {
		
		
		
		int i = 0;
		while (this.listeJoueur[i] != null) {
			System.out.println("Plateau : "+this.plateau.getTuilesPosees());
			System.out.println("------------------------------------------");
			tourDUnJoueur(this.listeJoueur[i]);
			i++;
		}
		
		
		
	}
	
	public static void main (String[]Args) {
		
		
		Jeu game = new Jeu();
		
		game.initialisation();
		
		
		/*
		 * Manche man = new Manche();
		
		for(int i = 1; i <= 13; i++) {
			
			if (nbJoueur == 1){
				game.ajoutCarteJoueur(game.listeJoueur[1], man);
			}
			
			if (nbJoueur == 2){
				game.ajoutCarteJoueur(game.listeJoueur[1], man);
				game.ajoutCarteJoueur(game.listeJoueur[2], man);
			}
			
			if (nbJoueur == 3){
				game.ajoutCarteJoueur(game.listeJoueur[1], man);
				game.ajoutCarteJoueur(game.listeJoueur[2], man);
				game.ajoutCarteJoueur(game.listeJoueur[3], man);
			}
			
			if (nbJoueur == 4){
				game.ajoutCarteJoueur(game.listeJoueur[1], man);
				game.ajoutCarteJoueur(game.listeJoueur[2], man);
				game.ajoutCarteJoueur(game.listeJoueur[3], man);
				game.ajoutCarteJoueur(game.listeJoueur[4], man);
			}
		
		}*/
		
		
		
			/*int i = 0;
			while(game.listeJoueur[i] != null) {
			System.out.println(game.listeJoueur[i].getPseudo()+" : " +game.listeJoueur[i].getMain());
			i++;
			}
			System.out.println("Pioche : "+game.manche.getPioche());
			*/
			
			
			/*game.listeJoueur[0].poserCarte(game.plateau);
			
			System.out.println(game.listeJoueur[0].getPseudo()+" : " +game.listeJoueur[0].getMain());
			System.out.println("Plateau : "+game.plateau.getTuilesPosees());
		*/
		
			while(true) {
				game.tourDeJeu();
			}
		
		
		//fonction initialiser
		//Tour de jeu
			
			
			//if 1 == pioche
			//if 2 == poser
			
		
	}

}
