public class Paquet {  
	
	private Carte tete; 

/** Constructeur d'une Paquet vide
 */
public Paquet () { 
tete = null; 
}

/** Constructeur d'une Paquet a partir d'un Carte
 */
public Paquet (Carte m) {
tete = m;
}

	/** Constructeur d'une Paquet a un seul element
 	*/
	public Paquet (int x, int couleur) { 
		Carte m = new Carte(x, couleur, null);
		tete = m; 
	}

/**
 * Prerequis: aucun
 * construit une Paquet completement disjointe de la Paquet l 
 */
public Paquet (Paquet l) { // constructeur par recopie profonde
this(); 
if (! l.estVide()) {
    Carte ln = new Carte ();
    this.tete = ln;

    Carte lv = l.tete;
    while (lv.getSuiv() != null) {
	ln.setVal (lv.getVal()); // copie de la valeur
	ln.setSuiv (new Carte()); // creation et accrochage du Carte (encore vide) suivant
	ln = ln.getSuiv();
	lv = lv.getSuiv();
    }
    ln.setVal (lv.getVal());
    ln.setSuiv(null);
}
} 

/** @param tabPaquet est un tableau contenant les elements de la Paquet
 * Pre-requis : aucun
 */
public Paquet (int[] tabPaquet) {
this(); 
if (tabPaquet.length > 0) {
    Carte ln = new Carte ();
    this.tete = ln;
    for (int i = 0 ; i < (tabPaquet.length - 1) ; i++) {
	ln.setVal (tabPaquet[i]); // copie de la valeur
	ln.setSuiv (new Carte()); // creation et accrochage du Carte (encore vide) suivant
	ln = ln.getSuiv();
    }
    ln.setVal (tabPaquet[tabPaquet.length - 1]);
    ln.setSuiv(null);
}
}

public boolean estVide() {
	return (tete == null) ;
}
 
public Carte getTete () {
	return tete;
}

/* Pre-requis : this contient au moins un Carte */
public int valTete () { 
	return tete.getVal();
}

public void setTete (Carte m) {
m.setSuiv(tete);
this.tete = m;
}

public void ajoutTete (int val, int couleur) {
		Carte m = new Carte(val, couleur, this.tete);
		this.tete = m;
	}

boolean appartient (int val, int couleur) {
	Carte courant = this.tete;
		while (courant != null && courant.getVal() != val) {
			courant = courant.getSuiv(); 
		}
		while (courant != null && courant.getCouleur() != couleur) {
			courant = courant.getSuiv(); 
		}
		return courant != null;
}

public String toString() {
	String s = "(";
	Carte courant = this.tete;

	while (courant != null) {
		s = s + ("["+courant.getVal())+","+courant.getCouleur()+"]" + ((courant.getSuiv() != null)?", ":"");
		courant = courant.getSuiv();
	}
	return s + ")";
}




public int dernier(){
	
	
	Carte courant = this.tete ;
	if (!this.estVide()){
		while (courant.getSuiv() != null)
		courant = courant.getSuiv() ;
		return(courant.getVal());}
	else 
		return (000000);
	
		
	
	
		
}



public int Occurences(int n){
	Carte courant = this.tete ;
	int cpt = 0 ; 
	while (courant != null){
		if ( courant.getVal()==n)
			cpt ++ ; 
		courant = courant.getSuiv() ; 
		
	}
	return(cpt); 
}



public void AjoutenFin(int n, int couleur) {
		if (this.estVide())
			this.ajoutTete(n, couleur);
		else {
			Carte courant = this.tete ; 
			Carte fin = new Carte() ;
			fin.setVal(n);
			fin.setCouleur(couleur);
				while ( courant.getSuiv() != null )
					courant=courant.getSuiv() ;  
				courant.setSuiv(fin) ; 
		}
	}
	
	
	
public void AjoutAbsent(int n , int couleur){
	if (this.appartient(n, couleur)== false )
		this.AjoutenFin(n, couleur);
	
	
}



public Paquet Suppression(int n, int couleur){
	
	Carte courant = this.tete ; 
	
	if (courant.getVal()==n && courant.getCouleur() == couleur){
		this.tete=courant.getSuiv();
	}else {
		while (courant.getSuiv().getVal()!= n){
			courant=courant.getSuiv() ; 
		}
		while (courant.getSuiv().getCouleur()!= couleur){
			courant=courant.getSuiv() ; 
		}
			if ( courant.getSuiv().getSuiv() != null){
				
				courant.setSuiv(courant.getSuiv().getSuiv());
			
			}else {
				courant.setSuiv(null) ; 
			}
	}
		return (this);
		
		
		
	}

	
}
