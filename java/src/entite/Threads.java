package entite;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ActionButton.MyGlassPane;
import graphique.InterfaceGamerOver;

public class Threads extends Thread {
	Plateau plateau;
	Boutton boutton=new Boutton();
	MotTrouver motTrouver=new MotTrouver();
	ValeurAttribut valeur;
	int idPartie=0;
	Boutton [][]bouttons;
	//Rang
	JPanel panel_9=new JPanel();
	JPanel panel_12=new JPanel();
	JPanel panel_10=new JPanel();
	JPanel panel_11=new JPanel();
	PartieDeJeu []partieDeJeus;
	Parametre parametre=new Parametre();
	boolean testRang=false;
	boolean jeu=false;
	Boutton []bouttonsTmp;
	JPanel panel;
	JPanel panelPrincipale;
	MyGlassPane glass;
	JLabel lblL;
	Tour tour;
	int idJoueur=0;
	JButton btnOk;
	Object [][]mottrouverJoueur,
	mottrouverToutLesJoueur;
	JButton btnNewButton;
	JButton btnChanger;
	JButton btnPass;
	JTable table;
	int scoreJoueur;
	JLabel lblScore;
	PartieDeJeu partieDeJeu;
	String nomPartie;
	boolean test=false;
	JButton btnNewButton_1;
	Music music;
	JFrame frame;
	JTable table_1;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;
	public Threads() {}
	public Threads(Plateau plateau, ValeurAttribut valeur, int idPartie, Boutton[][] bouttons,boolean jeu,Boutton []bouttonsTmp,JPanel panel,MyGlassPane glass,JLabel lblL,Tour tour,int idJoueur,JButton btnOk,Object [][]mottrouverJoueur,Object [][]mottrouverToutLesJoueur,JButton btnNewButton,JButton btnChanger,JButton btnPass,JTable table,int scoreJoueur,JLabel lblScore,JPanel panelPrincipale,Music music,JFrame frame,JTable table_1) {
		this.plateau = plateau;
		this.valeur = valeur;
		this.idPartie = idPartie;
		this.bouttons = bouttons;
		this.jeu = jeu;
		this.bouttonsTmp = bouttonsTmp;
		this.panel = panel;
		this.glass = glass;
		this.lblL = lblL;
		this.tour = tour;
		this.idJoueur = idJoueur;
		this.btnOk = btnOk;
		this.mottrouverJoueur=mottrouverJoueur;
		this.mottrouverToutLesJoueur=mottrouverToutLesJoueur;
		this.btnNewButton=btnNewButton;
		this.btnChanger=btnChanger;
		this.btnPass=btnPass;
		this.table=table;
		this.scoreJoueur=scoreJoueur;
		this.lblScore=lblScore;
		this.panelPrincipale=panelPrincipale;
		this.music=music;
		this.frame=frame;
		this.table_1=table_1;
	}
	public Threads(JPanel panel_9, JPanel panel_12, JPanel panel_10, JPanel panel_11, PartieDeJeu[] partieDeJeus,Parametre parametre,int idPartie,boolean testRang) {
		this.panel_9 = panel_9;
		this.panel_12 = panel_12;
		this.panel_10 = panel_10;
		this.panel_11 = panel_11;
		this.partieDeJeus = partieDeJeus;
		this.parametre = parametre;
		this.idPartie = idPartie;
		this.testRang = testRang;
	}
	@SuppressWarnings("rawtypes")
	public Threads(JTable table,PartieDeJeu partieDeJeu,String nomPartie,boolean test,int idJoueur,JButton btnNewButton_1,JComboBox comboBox) {
		this.table=table;
		this.partieDeJeu=partieDeJeu;
		this.nomPartie=nomPartie;
		this.test=test;
		this.idJoueur=idJoueur;
		this.btnNewButton_1=btnNewButton_1;
		this.comboBox=comboBox;
	}
	@Override
	public void run() {
		Tour fonctionTour=new Tour();
		Parametre parametre=new Parametre();
		Partie newPartie=new Partie();
		while (test) {
			try {
				table.repaint();
				table.revalidate();
				nomPartie=(String)comboBox.getSelectedItem();
				Object[][] objects =partieDeJeu.setTableauToObject(partieDeJeu.getPartieDeJeuAPartNomPartie(nomPartie));
				table.setModel(new DefaultTableModel(objects,new String[] {"Nom du partie","Nom joueur","Date"}));
				if(parametre.getTestLancerJeuSiJoueurComprisDansLaPartie(nomPartie, idJoueur)) {
					btnNewButton_1.setEnabled(true);
				}else {
					btnNewButton_1.setEnabled(false);
				}
				btnNewButton_1.repaint();
				btnNewButton_1.revalidate();
				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		while (testRang) {
			try {
				parametre.allCouleurPanel(panel_9, panel_12,panel_10,panel_11, partieDeJeus, parametre);
				boolean testTmp=parametre.verficationSiCouleurSonTousVert(idPartie);
				if(testTmp==true) {
					String rang=parametre.getRang(idPartie);
					fonctionTour.insertionTour(idPartie, rang);
					testRang=false;
				}
				sleep(2500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		while(jeu) {
			try {
				newPartie=newPartie.setTableauObjectToObject(newPartie.getPartieAPartIdPartie(idPartie));
				if(newPartie.getFin()==0) {
					this.plateau.updatePlateau(this.valeur,this.idPartie);
					this.plateau.actualisationPlateau(this.bouttons,this.idPartie);
					boutton.insertionImageVide(bouttons);
					tour.setIdJoueur(fonctionTour.getTourAPartidPartie(idPartie).getIdJoueur());
					scoreJoueur=motTrouver.getScore(idPartie, idJoueur);
					lblScore.setText("Score  : "+scoreJoueur);
					if(tour.getIdJoueur()==idJoueur) {
						btnOk.setEnabled(true);
						btnNewButton.setEnabled(true);
						btnChanger.setEnabled(true);
						btnPass.setEnabled(true);
					}else {
						btnOk.setEnabled(false);
						btnNewButton.setEnabled(false);
						btnChanger.setEnabled(false);
						btnPass.setEnabled(false);
					}
					table_1.setModel(new DefaultTableModel(tour.getRangTour(idPartie),new String[] {"Tour de jeu", "Nom joueur", "tour actuel"}));
					Object [][]mottrouverToutLesJoueurs=motTrouver.getMotTrouverToObject(idPartie, idJoueur,2);
					table.setModel(new DefaultTableModel(mottrouverToutLesJoueurs,new String[] {"Nom du joueur", "Mots trouv\u00E9es", "Points "}));
				}else {
					jeu=false;
					new InterfaceGamerOver(panelPrincipale, idPartie,music,frame);
				}
				sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	
}
