package ActionButton;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

import entite.AideFonction2;
import entite.Boutton;
import entite.Points;
import entite.Tour;
import entite.ValeurAttribut;

public class MouseGlassListener extends MouseAdapter{

  JPopupMenu jPopupMenu=new JPopupMenu();
  JMenuItem jMenuItem=new JMenuItem("Changer");
  private MyGlassPane myGlass;
  private BufferedImage image;
  ValeurAttribut valeur;
  Boutton [][]bouttonsTmp;
  Boutton []bouttons;
  JLabel lblL;
  int indice=0;
  Tour tour;
  int idJoueur=0;
  JPanel panel;
  List<Boutton> joker;
  public MouseGlassListener(MyGlassPane glass,ValeurAttribut valeur,Boutton [][]bouttonsTmp,JLabel lblL,int indice,Boutton []bouttons,Tour tour,int idJoueur,JPanel panel,List<Boutton> joker){
    myGlass = glass;
    this.valeur=valeur;
    this.bouttonsTmp=bouttonsTmp;
    this.lblL=lblL;
    this.indice=indice;
    this.bouttons=bouttons;
    this.tour=tour;
    this.idJoueur=idJoueur;
    this.panel=panel;
    this.joker=joker;
  }
   @Override
	public void mouseClicked(MouseEvent e) {
		
	}
  public void mousePressed(MouseEvent event) {
	  
    //On récupère le composant pour en déduire sa position
    Component composant = event.getComponent();
    Point location = (Point)event.getPoint().clone();
      
    //Les méthodes ci-dessous permettent, dans l'ordre, 
    //de convertir un point en coordonnées d'écran
    //et de reconvertir ce point en coordonnées fenêtres
    SwingUtilities.convertPointToScreen(location, composant);
    SwingUtilities.convertPointFromScreen(location, myGlass);
        
    //Les instructions ci-dessous permettent de redessiner le composant
    image = new BufferedImage(composant.getWidth(), composant.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics g = image.getGraphics();
    composant.paint(g);
        
    //On passe les données qui vont bien à notre GlassPane
    myGlass.setLocation(location);
    myGlass.setImage(image);
      
    //On n'oublie pas de dire à notre GlassPane de s'afficher
    myGlass.setVisible(true);
  }
  @SuppressWarnings("static-access")
public void mouseReleased(MouseEvent event) {
	  if(tour.getIdJoueur()==idJoueur) {
		  if (valeur.getBouttons().size()==0) {
			lblL.setText("");
		  }
		  JOptionPane jop = new JOptionPane();
		  AideFonction2 aideFonction2=new AideFonction2();
		  Boutton bouttonTmp5=(Boutton)event.getSource();
		  bouttonTmp5.setIndiceX(valeur.getIndiceX());
		  bouttonTmp5.setIndiceY(valeur.getIndiceY());
		  bouttonTmp5.setImageVide(valeur.getImg());
		  if(bouttonTmp5.getNomImage().equals("0.jpg")) {
			  bouttonTmp5.setImage("0.jpg");
			  joker.add(bouttonTmp5);
			  Vector<AideFonction2> liste=aideFonction2.getLettreImage();int size=liste.size();
			  String []strings=new String[size];
			  for(int i=0;i<size;i++) {
				  strings[i]=liste.get(i).getImg();
			  }
			   String noms = (String)jop.showInputDialog(null,"Veuillez choisir le pion a changer","Jeu scrabble",JOptionPane.QUESTION_MESSAGE,null,strings, strings[0]);
			   lblL.setText(lblL.getText()+""+noms);String img=aideFonction2.getNumero(noms)+".jpg";
			   bouttonTmp5.setImage(img);
			   bouttonTmp5.setNom(""+aideFonction2.getNumero(noms));
			   bouttonsTmp[valeur.getIndiceX()][valeur.getIndiceY()].setImage(img);
			   valeur.setBoutton(bouttonTmp5);
		  }else {
			  valeur.setBoutton(bouttonTmp5);
			  Points points=new Points();
			  lblL.setText(lblL.getText()+""+points.chiffreToLettre(valeur.getBoutton().getNom()));
			  bouttonsTmp[valeur.getIndiceX()][valeur.getIndiceY()].setImage(valeur.getBoutton().getNomImage());
		  }
		  bouttonsTmp[valeur.getIndiceX()][valeur.getIndiceY()].setIndiceX(valeur.getIndiceX());
		  bouttonsTmp[valeur.getIndiceX()][valeur.getIndiceY()].setIndiceY(valeur.getIndiceY());
		  bouttonsTmp[valeur.getIndiceX()][valeur.getIndiceY()].repaint();
		  bouttonsTmp[valeur.getIndiceX()][valeur.getIndiceY()].revalidate();
	     //---------------------------------------------------------------------
	     //On implémente le transfert lorsqu'on relâche le bouton de souris
	     //Ceci afin de ne pas supplanter le fonctionnement du déplacement
	     JComponent lab = (JComponent)event.getSource();
	     TransferHandler handle = lab.getTransferHandler();
	     handle.exportAsDrag(lab, event, TransferHandler.COPY);
	     //--------------------------------------------------------------------- 
	     //On récupère le composant pour en déduire sa position
	     Component composant = event.getComponent();
	     Point location = (Point)event.getPoint().clone();
	     //Les méthodes ci-dessous permettent, dans l'ordre, 
	     //de convertir un point en coordonnées d'écran
	     //et de reconvertir ce point en coordonnées fenêtre
	     SwingUtilities.convertPointToScreen(location, composant);
	     SwingUtilities.convertPointFromScreen(location, myGlass); 
	    //On passe les données qui vont bien à notre GlassPane
	     myGlass.setLocation(location);
	     myGlass.setImage(null);
	     //On n'oublie pas de ne plus l'afficher
	     myGlass.setVisible(false);
	     this.bouttons[this.indice].setImage("");
	}
  }
  
}