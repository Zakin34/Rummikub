import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;

 
public class Fenetre extends JFrame {
	
	private JLabel title = new JLabel("Rummikub");
	
	private JButton launch = new JButton("Commencer une partie !");
	private JButton close = new JButton("Fermer le jeu");
	private JButton score = new JButton("Scores");
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu test1 = new JMenu("Options");
	private JMenuItem item1 = new JMenuItem("Nouvelle partie");
	private JMenuItem item2 = new JMenuItem("Recommencer");
	private JMenuItem item3 = new JMenuItem("Abandonner");
	 
	private JMenu test2= new JMenu("Scores");
	private JMenuItem item21 = new JMenuItem("Consulter");


	 
  public Fenetre(){      
	  
	  this.setTitle("Rummikub");
	  this.setSize(500, 300);
	  this.setLocationRelativeTo(null);    
	  
	  //Initialisation des menus    
	  this.test1.add(item1); 
	  this.test1.addSeparator();
	  this.test1.add(item2);
	  this.test1.addSeparator();
	  this.test1.add(item3);
	  this.test2.add(item21);

	  //Ajout à la barre des menus
	  this.menuBar.add(test1);
	  this.menuBar.add(test2);
	  this.setJMenuBar(menuBar);
	    

	  JPanel containerGen = new JPanel();
	  containerGen.setLayout(new GridLayout(2,1));
    
	  JPanel container = new JPanel();
	  container.add(title);
    
	  JPanel box = new JPanel();
	  GridLayout gl = new GridLayout();
	  gl.setColumns(1);
	  gl.setRows(3);
	  gl.setHgap(10); 
	  gl.setVgap(10); 
	  box.setLayout(gl);
	  box.add(launch);
	  box.add(score);
	  box.add(close);

    
	  containerGen.add(container);
	  containerGen.add(box);

	  this.getContentPane().setBackground(Color.GRAY);
	  this.getContentPane().add(containerGen);
          
	  this.setVisible(true);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  }       
  
  public static void main (String Args[]) {
	  
	  Fenetre Fen = new Fenetre();
	  
  }
}