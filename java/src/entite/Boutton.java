package entite;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import ActionButton.MouseGlassListener;
import ActionButton.MouseGlassMotionListener;
import ActionButton.MyGlassPane;

@SuppressWarnings("serial")
public class Boutton extends JButton {
	String nom="";
	String text="";
	Color couleur;
	String nomImage="";
	String nomAncientImage="";
	int indiceX=0,indiceY=0;
	String imageVide="";
	public Boutton() {
		this.setBackground(Color.WHITE);
	}
	public Boutton(String nom,String text, Color couleur) {
		this.setBackground(couleur);
		this.setText(text);
		this.setName(nom);
		this.nom = nom;
		this.text = text;
		this.couleur = couleur;
	}
	public Boutton(String nom, String nomImage, String nomAncientImage, int indiceX, int indiceY, String imageVide) {
		this.nom = nom;
		this.nomImage = nomImage;
		this.nomAncientImage = nomAncientImage;
		this.indiceX = indiceX;
		this.indiceY = indiceY;
		this.imageVide = imageVide;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	public void setPosition(int p1,int p2,int p3,int p4) {
		this.setBounds(p1,p2,p3,p4);
	}
	public void setImage(String nomImages) {
		try {
			this.setIcon(new ImageIcon(getClass().getResource("../img/"+nomImages)));
			this.nomImage=nomImages;
		} catch (Exception e) {
			System.out.println("nomImages="+nomImages+" chemin=../img/"+nomImages);
		}
		
		
	}
	public void setImageTmp(String nomImages) {
		this.nomImage=nomImages;
	}
	public String getNomImage() {
		return this.nomImage;
	}
	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}
	public String getNomAncientImage() {
		return nomAncientImage;
	}
	public void setNomAncientImage(String nomAncientImage) {
		this.nomAncientImage = nomAncientImage;
	}
	public int getIndiceX() {
		return indiceX;
	}
	public void setIndiceX(int indiceX) {
		this.indiceX = indiceX;
	}
	public int getIndiceY() {
		return indiceY;
	}
	public void setIndiceY(int indiceY) {
		this.indiceY = indiceY;
	}
	public String getImageVide() {
		return imageVide;
	}
	public void setImageVide(String imageVide) {
		this.imageVide = imageVide;
	}
	public void insertionImageVide(Boutton [][]bouttons) {
		for(int i=0;i<bouttons.length;i++) {
			for(int a=0;a<bouttons[0].length;a++) {
				bouttons[i][a].setImageVide("fond.jpg");
			}
		}
		bouttons[0][0].setImageVide("fond6.jpg");
		bouttons[0][7].setImageVide("fond6.jpg");
		bouttons[0][14].setImageVide("fond6.jpg");
		bouttons[7][0].setImageVide("fond6.jpg");
		bouttons[7][14].setImageVide("fond6.jpg");
		bouttons[14][0].setImageVide("fond6.jpg");
		bouttons[14][7].setImageVide("fond6.jpg");
		bouttons[14][14].setImageVide("fond6.jpg");
		bouttons[7][7].setImageVide("fond8.jpg");
		for(int i=0;i<4;i++) {
			bouttons[1+i][1+i].setImageVide("fond7.jpg");
			bouttons[10+i][10+i].setImageVide("fond7.jpg");
			bouttons[10+i][4-i].setImageVide("fond7.jpg");
			bouttons[4-i][10+i].setImageVide("fond7.jpg");
		}
		int m=1,n=5;
		for(int i=0;i<4;i++) {
			bouttons[5][m].setImageVide("fond4.jpg");
			bouttons[9][m].setImageVide("fond4.jpg");m=m+4;
			if(i<2) {
				bouttons[1][n].setImageVide("fond4.jpg");
				bouttons[13][n].setImageVide("fond4.jpg");n=n+4;
			}
		}
		bouttons[0][3].setImageVide("fond4.jpg");
		for(int i=0;i<2;i++) {
			bouttons[6+i][2+i].setImageVide("fond5.jpg");
			bouttons[6+i][12-i].setImageVide("fond5.jpg");
			bouttons[2+i][6+i].setImageVide("fond5.jpg");
			bouttons[12-i][6+i].setImageVide("fond5.jpg");
		}
		for(int i=0;i<2;i++) {
			bouttons[8][2+(i*4)].setImageVide("fond5.jpg");
			bouttons[8][8+(i*4)].setImageVide("fond5.jpg");
			bouttons[2+(i*4)][8].setImageVide("fond5.jpg");
			bouttons[8+(i*4)][8].setImageVide("fond5.jpg");
		}
		bouttons[6][6].setImageVide("fond5.jpg");
		for(int i=0;i<2;i++) {
			bouttons[14][3+(i*8)].setImageVide("fond5.jpg");
			bouttons[0][3+(i*8)].setImageVide("fond5.jpg");
			bouttons[3+(i*8)][0].setImageVide("fond5.jpg");
			bouttons[3+(i*8)][14].setImageVide("fond5.jpg");
		}
	}
	public void insertionDesCouleurDansLeJeu(Boutton [][]bouttons) {
		bouttons[0][0].setImage("fond6.jpg");
		bouttons[0][7].setImage("fond6.jpg");
		bouttons[0][14].setImage("fond6.jpg");
		bouttons[7][0].setImage("fond6.jpg");
		bouttons[7][14].setImage("fond6.jpg");
		bouttons[14][0].setImage("fond6.jpg");
		bouttons[14][7].setImage("fond6.jpg");
		bouttons[14][14].setImage("fond6.jpg");
		bouttons[7][7].setImage("fond8.jpg");

		bouttons[0][0].setImageVide("fond6.jpg");
		bouttons[0][7].setImageVide("fond6.jpg");
		bouttons[0][14].setImageVide("fond6.jpg");
		bouttons[7][0].setImageVide("fond6.jpg");
		bouttons[7][14].setImageVide("fond6.jpg");
		bouttons[14][0].setImageVide("fond6.jpg");
		bouttons[14][7].setImageVide("fond6.jpg");
		bouttons[14][14].setImageVide("fond6.jpg");
		bouttons[7][7].setImageVide("fond8.jpg");
		for(int i=0;i<4;i++) {
			bouttons[1+i][1+i].setImage("fond7.jpg");
			bouttons[10+i][10+i].setImage("fond7.jpg");
			bouttons[10+i][4-i].setImage("fond7.jpg");
			bouttons[4-i][10+i].setImage("fond7.jpg");

			bouttons[1+i][1+i].setImageVide("fond7.jpg");
			bouttons[10+i][10+i].setImageVide("fond7.jpg");
			bouttons[10+i][4-i].setImageVide("fond7.jpg");
			bouttons[4-i][10+i].setImageVide("fond7.jpg");
		}
		int m=1,n=5;
		for(int i=0;i<4;i++) {
			bouttons[5][m].setImage("fond4.jpg");
			bouttons[9][m].setImage("fond4.jpg");
			bouttons[5][m].setImageVide("fond4.jpg");
			bouttons[9][m].setImageVide("fond4.jpg");m=m+4;
			if(i<2) {
				bouttons[1][n].setImage("fond4.jpg");
				bouttons[13][n].setImage("fond4.jpg");
				bouttons[1][n].setImageVide("fond4.jpg");
				bouttons[13][n].setImageVide("fond4.jpg");n=n+4;
			}
		}
		bouttons[0][3].setImage("fond4.jpg");
		bouttons[0][3].setImageVide("fond4.jpg");
		for(int i=0;i<2;i++) {
			bouttons[6+i][2+i].setImage("fond5.jpg");
			bouttons[6+i][12-i].setImage("fond5.jpg");
			bouttons[2+i][6+i].setImage("fond5.jpg");
			bouttons[12-i][6+i].setImage("fond5.jpg");

			bouttons[6+i][2+i].setImageVide("fond5.jpg");
			bouttons[6+i][12-i].setImageVide("fond5.jpg");
			bouttons[2+i][6+i].setImageVide("fond5.jpg");
			bouttons[12-i][6+i].setImageVide("fond5.jpg");
		}
		for(int i=0;i<2;i++) {
			bouttons[8][2+(i*4)].setImage("fond5.jpg");
			bouttons[8][8+(i*4)].setImage("fond5.jpg");
			bouttons[2+(i*4)][8].setImage("fond5.jpg");
			bouttons[8+(i*4)][8].setImage("fond5.jpg");

			bouttons[8][2+(i*4)].setImageVide("fond5.jpg");
			bouttons[8][8+(i*4)].setImageVide("fond5.jpg");
			bouttons[2+(i*4)][8].setImageVide("fond5.jpg");
			bouttons[8+(i*4)][8].setImageVide("fond5.jpg");
		}
		bouttons[6][6].setImage("fond5.jpg");
		bouttons[6][6].setImageVide("fond5.jpg");
		for(int i=0;i<2;i++) {
			bouttons[14][3+(i*8)].setImage("fond5.jpg");
			bouttons[0][3+(i*8)].setImage("fond5.jpg");
			bouttons[3+(i*8)][0].setImage("fond5.jpg");
			bouttons[3+(i*8)][14].setImage("fond5.jpg");

			bouttons[14][3+(i*8)].setImageVide("fond5.jpg");
			bouttons[0][3+(i*8)].setImageVide("fond5.jpg");
			bouttons[3+(i*8)][0].setImageVide("fond5.jpg");
			bouttons[3+(i*8)][14].setImageVide("fond5.jpg");
		}
	}
	public void AncienImage(Boutton [][]bouttons) {
		bouttons[0][0].setNomAncientImage("fond6.jpg");
		bouttons[0][7].setNomAncientImage("fond6.jpg");
		bouttons[0][14].setNomAncientImage("fond6.jpg");
		bouttons[7][0].setNomAncientImage("fond6.jpg");
		bouttons[7][14].setNomAncientImage("fond6.jpg");
		bouttons[14][0].setNomAncientImage("fond6.jpg");
		bouttons[14][7].setNomAncientImage("fond6.jpg");
		bouttons[14][14].setNomAncientImage("fond6.jpg");
		bouttons[7][7].setNomAncientImage("fond8.jpg");
		for(int i=0;i<4;i++) {
			bouttons[1+i][1+i].setNomAncientImage("fond7.jpg");
			bouttons[10+i][10+i].setNomAncientImage("fond7.jpg");
			bouttons[10+i][4-i].setNomAncientImage("fond7.jpg");
			bouttons[4-i][10+i].setNomAncientImage("fond7.jpg");
		}
		int m=1,n=5;
		for(int i=0;i<4;i++) {
			bouttons[5][m].setNomAncientImage("fond4.jpg");
			bouttons[9][m].setNomAncientImage("fond4.jpg");m=m+4;
			if(i<2) {
				bouttons[1][n].setNomAncientImage("fond4.jpg");
				bouttons[13][n].setNomAncientImage("fond4.jpg");n=n+4;
			}
		}
		bouttons[0][3].setNomAncientImage("fond4.jpg");
		for(int i=0;i<2;i++) {
			bouttons[6+i][2+i].setNomAncientImage("fond5.jpg");
			bouttons[6+i][12-i].setNomAncientImage("fond5.jpg");
			bouttons[2+i][6+i].setNomAncientImage("fond5.jpg");
			bouttons[12-i][6+i].setNomAncientImage("fond5.jpg");
		}
		for(int i=0;i<2;i++) {
			bouttons[8][2+(i*4)].setNomAncientImage("fond5.jpg");
			bouttons[8][8+(i*4)].setNomAncientImage("fond5.jpg");
			bouttons[2+(i*4)][8].setNomAncientImage("fond5.jpg");
			bouttons[8+(i*4)][8].setNomAncientImage("fond5.jpg");
		}
		bouttons[6][6].setNomAncientImage("fond5.jpg");
		for(int i=0;i<2;i++) {
			bouttons[14][3+(i*8)].setNomAncientImage("fond5.jpg");
			bouttons[0][3+(i*8)].setNomAncientImage("fond5.jpg");
			bouttons[3+(i*8)][0].setNomAncientImage("fond5.jpg");
			bouttons[3+(i*8)][14].setNomAncientImage("fond5.jpg");
		}
	}
	public void initialisation(Boutton []bouttons,JPanel panel) {
		int position=0;
		for(int i=0;i<bouttons.length;i++) {
			bouttons[i]=new Boutton("a"+i,"",Color.orange);
			bouttons[i].setPosition(position, 0,50,50);
			bouttons[i].setNomImage("");
			position=position+122;
			panel.add(bouttons[i]);
		}
	}
	public void Reinitialisation(Boutton []bouttons,JPanel panel) {
		Boutton []bouttons2=new Boutton[bouttons.length];
		panel.removeAll();
		for(int i=0;i<bouttons2.length;i++) {
			bouttons2[i]=bouttons[i];
			panel.add(bouttons2[i]);
		}
		panel.repaint();
		panel.revalidate();
	}
	public void initialisationSimpleDuBoutton(Boutton [][]bouttons) {
		for(int i=0;i<bouttons.length;i++) {
			for(int a=0;a<bouttons[0].length;a++) {
				bouttons[i][a]=new Boutton("a"+i,"",Color.gray);
				bouttons[i][a].setImage("fond.jpg");
				bouttons[i][a].setNomAncientImage("fond.jpg");
			}
		}
		insertionDesCouleurDansLeJeu(bouttons);
		AncienImage(bouttons);
	}
	public void initialisationJeu(Boutton [][]bouttons,JPanel panel,ValeurAttribut valeur) {
		panel.setLayout(new GridLayout(15,15));
		for(int i=0;i<bouttons.length;i++) {
			for(int a=0;a<bouttons[0].length;a++) {
				bouttons[i][a]=new Boutton("a"+i,"",Color.gray);
				bouttons[i][a].setImage("fond.jpg");
				bouttons[i][a].setNomAncientImage("fond.jpg");
				bouttons[i][a].setImageVide("fond.jpg");
				bouttons[i][a].setFont(new Font("Tahoma", Font.PLAIN,10));
				bouttons[i][a].setPosition(40*i, 40*a,40,40);
				int indice1=i,indice2=a;
				bouttons[i][a].addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
					}
					
					@Override
					public void mousePressed(MouseEvent arg0) {
					}
					
					@Override
					public void mouseExited(MouseEvent arg0) {
						if(bouttons[indice1][indice2].getNomImage().equals("fond2.jpg")) {
							bouttons[indice1][indice2].setImage(bouttons[indice1][indice2].getNomAncientImage());
							bouttons[indice1][indice2].repaint();
							bouttons[indice1][indice2].revalidate();
						}
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {//rehefa miditra ao le souris
						changementImage(bouttons[indice1][indice2], indice1, indice2, valeur);
					}
					
					@Override
					public void mouseClicked(MouseEvent arg0) {
					}
				});
				panel.add(bouttons[i][a]);
			}
		}
		insertionDesCouleurDansLeJeu(bouttons);
		AncienImage(bouttons);
		insertionImageVide(bouttons);
	}
	public void changementImage(Boutton boutton,int indice1,int indice2,ValeurAttribut valeur) {
		if(boutton.getNomImage().equals("fond.jpg") || boutton.getNomImage().equals("fond4.jpg") || boutton.getNomImage().equals("fond5.jpg") || boutton.getNomImage().equals("fond6.jpg") || boutton.getNomImage().equals("fond7.jpg") || boutton.getNomImage().equals("fond8.jpg")) {
			valeur.setImg(boutton.getNomImage());
			boutton.setImage("fond2.jpg");
			valeur.setIndiceX(indice1);
			valeur.setIndiceY(indice2);
			boutton.repaint();
			boutton.revalidate();
		}
	}
	public void initialisationPrincipaleChevalet(Boutton []bouttons,Sac sac,JPanel panel,int idJoueurs,MyGlassPane glass,ValeurAttribut valeur,Boutton [][]bouttonsTmp,JLabel lblL,Tour tour,int idJoueur,JPanel panelPrincipales,List<Boutton> joker) throws Exception {
		panel.removeAll();
		panel.repaint();
		panel.revalidate();
		System.out.println("idPartie="+sac.getIdPartie());
		Vector<Points> points=sac.ajoutDansChevalet(sac.getIdPartie(), idJoueurs);
		int position=0;
		for(int i=0;i<points.size();i++) {
			bouttons[i]=new Boutton(""+points.get(i).getNumero(),"",Color.orange);
			bouttons[i].setImage(points.get(i).getNumero()+".jpg");
			bouttons[i].setPosition(position, 0,40,44);
			position=position+42;
			bouttons[i].addMouseListener(new MouseGlassListener(glass,valeur,bouttonsTmp,lblL,i,bouttons,tour,idJoueur,panelPrincipales,joker));
			bouttons[i].addMouseMotionListener(new MouseGlassMotionListener(glass)); 
			bouttons[i].setTransferHandler(new TransferHandler("text"));
			panel.add(bouttons[i]);
		}
		panel.repaint();
		panel.revalidate();
	}	
	public void updateChevaler(Boutton []bouttons,int idParties,int idJoueurs,Sac sac) throws Exception {
		Vector<String> vector=new Vector<String>();int size=bouttons.length;
		Chevaler chevaler=new Chevaler();
		AideFonction2 aideFonction2=new AideFonction2();
		for(int i=0;i<size;i++) {
			if(!bouttons[i].getNomImage().equals("")) {
				vector.add(aideFonction2.getLettre(bouttons[i].getNom()));
			}
		}
		int size2=vector.size();
		Vector<String> strings=sac.getPartieSac(sac, 7-size2);int size3=strings.size();
		if(size2<7 && strings!=null) {
			for(int i=0;i<size3;i++) {
				vector.add(strings.get(i));
			}
			if(vector.size()==7) {
				chevaler.updateChevalerTmp2(idParties, idJoueurs, vector);
			}
		}
	}
	public List<Boutton> changerValuerAPartJoker(ValeurAttribut valeur,List<Boutton> joker){
		List<Boutton> liste=valeur.getBouttons();int size=joker.size(),size2=liste.size();
		if(size>0) {
			for(int i=0;i<size;i++) {
				for(int a=0;a<size2;a++) {
					if(joker.get(i).getIndiceX()==liste.get(a).getIndiceX() && joker.get(i).getIndiceY()==liste.get(a).getIndiceY()) {
						liste.get(a).setImage("0.jpg");
						liste.get(a).setNom("0");
					}
				}
			}
			joker.removeAll(joker);
			return liste;
		}else {
			return liste;
		}
	}
	public void bouttonRetour(Boutton []bouttons,Sac sac,JPanel panel,JPanel panel2,int idJoueurs,Boutton [][]bouttonsTmp,JLabel lblL,ValeurAttribut valeur,MyGlassPane glass,int idParties,Tour tour,JPanel panelPrincipale,List<Boutton> joker) throws Exception {
		Plateau plateau=new Plateau();
		Vector<Boutton> vector=new Vector<Boutton>();int size=bouttons.length;
		int mp=0;
		for(int i=0;i<size;i++) {
			if(!bouttons[i].getNomImage().equals("")) {
				vector.add(bouttons[i]);mp=mp+1;
			}
		}
		List<Boutton> list=changerValuerAPartJoker(valeur, joker);int size2=list.size();
		for(int i=0;i<size2;i++) {
			Boutton boutton=list.get(i);
			boutton.setImageTmp(list.get(i).getNom()+".jpg");
			vector.add(boutton);
		}
		lblL.setText("");
		plateau.updatePlateauRetour(valeur, idParties);
		valeur.removeAllBoutton();
		panel.removeAll();
		int position=0;
		for(int i=0;i<bouttons.length;i++) {
			bouttons[i]=new Boutton(""+vector.get(i).getNom(),"",Color.orange);
			bouttons[i].setImage(vector.get(i).getNom()+".jpg");
			bouttons[i].setPosition(position, 0,40,44);
			position=position+42;
			bouttons[i].addMouseListener(new MouseGlassListener(glass,valeur,bouttonsTmp,lblL,i,bouttons,tour,idJoueurs,panelPrincipale,joker));
			bouttons[i].addMouseMotionListener(new MouseGlassMotionListener(glass)); 
			bouttons[i].setTransferHandler(new TransferHandler("text"));
			panel.add(bouttons[i]);
		}
		panel2.repaint();
		panel2.revalidate();
		panel.repaint();
		panel.revalidate();
	}
	@SuppressWarnings("static-access")
	public void changerPionChevaler(Boutton []bouttons,Sac sac,int idJoueurs) throws Exception {
		int size=bouttons.length;
		String []strings=new String[size];
		AideFonction2 aideFonction2=new AideFonction2();
		for(int i=0;i<size;i++) {
			strings[i]=aideFonction2.getLettre(bouttons[i].getNom());
		}
		if(size>0) {
			JOptionPane jop = new JOptionPane();
		    String noms = (String)jop.showInputDialog(null,"Veuillez choisir le pion a changer","Jeu scrabble",JOptionPane.QUESTION_MESSAGE,null,strings, strings[0]);
		    sac.changerChevalerEtSacTmp(sac, idJoueurs, noms, bouttons);
		}
	}
}
