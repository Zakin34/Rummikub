import java.util.Scanner;
import java.util.Random;


public class Manche {
	
	
	private int numManche;
	private Paquet pioche;
	

	
	public int getNumManche() {
		return numManche;
	}


	public void setNumManche(int numManche) {
		this.numManche = numManche;
	}


	public Paquet getPioche() {
		return pioche;
	}


	public void setPioche(Paquet pioche) {
		this.pioche = pioche;
	}


	public Manche() {
		
		this.pioche = new Paquet();
		
		int i = 1;
		while (i <= 13) {
			for(int z = 1; z <= 2; z++){
				int j = 1;
				while (j <= 4){
					this.pioche.AjoutenFin(i, j);
					j++;
				}
			}
			i++;	
		}
			
			this.pioche.AjoutenFin(14, 0);
			this.pioche.AjoutenFin(14, 0);
			
			
			
	
		
	}
	
	
	
	
	
	

	
	
}
