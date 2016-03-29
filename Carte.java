public class Carte { 
	
	private int val; 
	private int couleur;
	private Carte suivant;

	/** Constructeur vide */
	public Carte () { 
		suivant = null; // utile ?
	}

	/** Constructeur 
	 *  @param x est la valeur de la cellule creee
	 *  @param m est le Carte qu'on accroche en suivant de this
	 */
	public Carte (int x, int coul, Carte m) { 
		val = x;
		couleur = coul;
		suivant = m;
	}

	public int getVal() {
		return this.val;
	}
	
	public int getCouleur() {
		return this.couleur;
	}

	public void setVal(int v) {
		this.val = v;
	}
	
	public void setCouleur(int v) {
		this.couleur = v;
	}

	public Carte getSuiv () {
		return this.suivant;
	}

	public void setSuiv (Carte m) {
		this.suivant = m;
	}

	public String toString () {
		String s = "";
		s = s +"("+ Integer.toString(this.val) + "," + Integer.toString(this.couleur)+")";
		return s;
	}

}