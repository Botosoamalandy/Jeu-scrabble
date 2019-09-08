package graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ActionButton.MyGlassPane;
import entite.Aide;
import entite.AideFonction;
import entite.Boutton;
import entite.FonctionGeneraliser;
import entite.Langue;
import entite.MotTrouver;
import entite.Music;
import entite.Parametre;
import entite.Partie;
import entite.PartieDeJeu;
import entite.Plateau;
import entite.PointsSpeciale;
import entite.Sac;
import entite.Threads;
import entite.Tour;
import entite.ValeurAttribut;

public class InterfaceJeu {
	
	AideFonction aideFonction=new AideFonction();
	MotTrouver motTrouver=new MotTrouver();
	Langue langue=new Langue();
	Tour fonctionTour=new Tour();
	Partie partie=new Partie();
	Sac sac=new Sac();
	Plateau plateau=new Plateau();
	Boutton boutton=new Boutton();
	Boutton [][]bouttons=new Boutton[15][15];
	Boutton []bouttonChevaler=new Boutton[7];
	MyGlassPane glass = new MyGlassPane();
	ValeurAttribut valeur =new ValeurAttribut();
	PartieDeJeu fonctionDeJeu=new PartieDeJeu();
	PointsSpeciale pointsSpeciale=new PointsSpeciale();
	FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();
	List<Boutton> joker=new ArrayList<Boutton>();
	Parametre parametre=new Parametre();
	Tour tour=new Tour();
	int scoreJoueur=0;
	private JTable table;
	private JTable table2;
	private JTable table_1;
	public InterfaceJeu(JPanel panel,JFrame frames,Music music) throws Exception {
		panel.removeAll();
		int idPartie=Login.session.getIdPartie(),
		idJoueur=Login.session.getIdJoueur();
		//debut
		sac.reinitialiserSac(idPartie);
		sac=sac.getSacAPartidPartie(idPartie);
		tour=fonctionTour.getTourAPartidPartie(idPartie);
		parametre=parametre.getParametreAPartidPartie(idPartie);
		PartieDeJeu partieDeJeu=fonctionDeJeu.getPartieDeJeuAPartIdPartieAndIdJoueur(idPartie, idJoueur);
		scoreJoueur=motTrouver.getScore(idPartie, idJoueur);
		
		panel.setBounds(0, 0, 1156, 727);
		panel.setBackground(new Color(166,119,5));
		panel.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 696, 609);
		panel_1.setBackground(new Color(233,161,0));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(44, 0, 600, 600);
		panel_1.add(panel_4);
		boutton.initialisationJeu(bouttons, panel_4,valeur);
		panel_4.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 608, 1156, 119);
		panel_2.setBackground(new Color(10,99,55));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		
		btnNewButton.setBounds(567, 64, 134, 44);
		panel_2.add(btnNewButton);
		
		JButton btnOk = new JButton("Ok");
		
		btnOk.setBounds(423, 64, 134, 44);
		panel_2.add(btnOk);
		
		JButton btnPass = new JButton("Pass\u00E9");
		btnPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					tour.setTours(idPartie,parametre);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnPass.setBounds(855, 64, 134, 44);
		panel_2.add(btnPass);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(10,99,55));
		panel_5.setBounds(10, 0, 979, 44);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblL = new JLabel("");
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setFont(new Font("Tahoma", Font.PLAIN, 59));
		lblL.setForeground(new Color(255, 210, 2));
		lblL.setBackground(Color.WHITE);
		lblL.setBounds(10, 0, 959, 44);
		panel_5.add(lblL);
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(8, 64, 405, 44);
		panel_2.add(panel_6);
		boutton.initialisationPrincipaleChevalet(bouttonChevaler, sac, panel_6, idJoueur,glass,valeur,bouttons,lblL,tour,idJoueur,panel,joker);
		
		JButton btnChanger = new JButton("Changer");
		btnChanger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    try {
					boutton.changerPionChevaler(bouttonChevaler,sac,idJoueur);
					tour.setTours(idPartie,parametre);
					boutton.initialisationPrincipaleChevalet(bouttonChevaler, sac, panel_6, idJoueur,glass,valeur,bouttons,lblL,tour,idJoueur,panel,joker);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnChanger.setBounds(711, 64, 134, 44);
		panel_2.add(btnChanger);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boutton.bouttonRetour(bouttonChevaler, sac, panel_6,panel_4, idJoueur, bouttons, lblL, valeur, glass, idPartie,tour,panel,joker);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				music.setSingle(false);
				try {
					boolean test=aideFonction.completeMot(valeur, bouttons, bouttonChevaler);
					boolean test2=partie.getPremierCoup(idPartie,aideFonction.verifierSiContinue(valeur, bouttons), valeur);
					Aide aide=new Aide();
					if(test && test2) {
						String motTrouvers="";boolean test6=false;
						if(valeur.getBouttons().size()>1) {
							Object [][]resultat=aide.getMotEtScoreMot(valeur, bouttons, bouttonChevaler);
							motTrouvers=""+resultat[0][0];
							System.out.println("mot: "+resultat[0][0]+" score:"+resultat[0][1]);
							lblL.setText(motTrouvers);
							lblL.repaint();
							lblL.revalidate();
							if(langue.verificationMot(1, motTrouvers)) {
								motTrouver.insertionMotTrouver(idPartie, idJoueur,""+resultat[0][0],(long)resultat[0][1]);
								tour.setTours(idPartie,parametre);
								btnOk.setEnabled(false);
								btnOk.repaint();
								btnOk.revalidate();
								test6=true;
							}
						}else if(valeur.getBouttons().size()==1){
							Object [][]resultat=aide.getUnionMotUneSeule(valeur, bouttons, bouttonChevaler);
							motTrouvers=resultat[0][0]+" "+resultat[1][0];
							System.out.println("mot: "+resultat[0][0]+" score:"+resultat[0][1]);
							System.out.println("mot1: "+resultat[1][0]+" score1:"+resultat[1][1]);
							lblL.setText(motTrouvers);
							Vector<Integer> vector=aide.getMotVerifier(resultat, langue, 1);int size20=vector.size();
							if(size20>0) {
								String motTmp="";
								for(int i=0;i<size20;i++) {
									motTmp=motTmp+" "+resultat[vector.get(i)][0];
									long score=(long)resultat[vector.get(i)][1];String mots=""+resultat[vector.get(i)][0];
									motTrouver.insertionMotTrouver(idPartie, idJoueur,mots,score);
								}
								lblL.setText(motTmp);
								tour.setTours(idPartie,parametre);
								btnOk.setEnabled(false);
								btnOk.repaint();
								btnOk.revalidate();
								test6=true;
							}
							lblL.repaint();
							lblL.revalidate();
						}
						if(test6) {
							boutton.updateChevaler(bouttonChevaler,idPartie,idJoueur,sac);
							valeur.removeAllBoutton();
							Object [][]mottrouverJoueurs=motTrouver.getMotTrouverToObject(idPartie, idJoueur, 1);
							table.setModel(new DefaultTableModel(mottrouverJoueurs,new String[] {"Les mots trouv\u00E9es", "Points "}));
							boutton.initialisationPrincipaleChevalet(bouttonChevaler, sac, panel_6, idJoueur,glass,valeur,bouttons,lblL,tour,idJoueur,panel,joker);
							music.lancerMusic();
						}else {
							boutton.bouttonRetour(bouttonChevaler, sac, panel_6,panel_4, idJoueur, bouttons, lblL, valeur, glass, idPartie,tour,panel,joker);
							definirMusic(music,"echec");
						}
						
					}else {
						boutton.bouttonRetour(bouttonChevaler, sac, panel_6,panel_4, idJoueur, bouttons, lblL, valeur, glass, idPartie,tour,panel,joker);
						definirMusic(music,"echec");
					}
				}catch (Exception e) {
					e.printStackTrace();
					try {boutton.bouttonRetour(bouttonChevaler, sac, panel_6,panel_4, idJoueur, bouttons, lblL, valeur, glass, idPartie,tour,panel,joker);} catch (Exception e1) {e1.printStackTrace();}
					definirMusic(music,"echec");
				}
			}
		});
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(233,161,0));
		panel_3.setBounds(695, 0, 461, 609);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 23, 441, 35);
		panel_3.add(scrollPane_1);
		
		JLabel lblNom = new JLabel("Nom : "+partieDeJeu.getNomJoueur());
		scrollPane_1.setViewportView(lblNom);
		lblNom.setBackground(Color.WHITE);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 441, 35);
		panel_3.add(scrollPane);
		
		JLabel lblDescription = new JLabel("Description : "+partieDeJeu.getDescription());
		lblDescription.setBackground(Color.WHITE);
		scrollPane.setViewportView(lblDescription);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNomDuPartie = new JLabel("Nom du partie : "+fonctionGeneraliser.deleteSeparatorString(partieDeJeu.getNomPartie()));
		lblNomDuPartie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomDuPartie.setBounds(10, 115, 441, 33);
		panel_3.add(lblNomDuPartie);
		
		JLabel lblScore = new JLabel("Score  : "+scoreJoueur);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblScore.setBounds(10, 159, 441, 33);
		panel_3.add(lblScore);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 280, 441, 122);
		panel_3.add(scrollPane_2);
		
		Object [][]mottrouverJoueur=motTrouver.getMotTrouverToObject(idPartie, idJoueur, 1);
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setForeground(Color.WHITE);
		scrollPane_2.setViewportView(table);
		table.setBackground(new Color(166,119,5));
		table.setModel(new DefaultTableModel(mottrouverJoueur,new String[] {"Les mots trouv\u00E9es", "Points "}));
		table.getColumnModel().getColumn(0).setPreferredWidth(372);
		table.getColumnModel().getColumn(1).setPreferredWidth(247);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 413, 441, 185);
		panel_3.add(scrollPane_3);
		
		Object [][]mottrouverToutLesJoueur=motTrouver.getMotTrouverToObject(idPartie, idJoueur,2);
		table2 = new JTable();
		table2.setShowHorizontalLines(false);
		table2.setShowVerticalLines(false);
		table2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table2.setForeground(Color.WHITE);
		table2.setBackground(new Color(166,119,5));
		table2.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane_3.setViewportView(table2);
		table2.setModel(new DefaultTableModel(mottrouverToutLesJoueur,new String[] {"Nom du joueur", "Mots trouv\u00E9es", "Points "}));
		frames.setGlassPane(glass);
		JButton btnTerminerLeJeu = new JButton("Terminer ");
		btnTerminerLeJeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					partie.updateFinPartie(idPartie);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnTerminerLeJeu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTerminerLeJeu.setBounds(998, 0, 148, 108);
		panel_2.add(btnTerminerLeJeu);
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 192, 441, 77);
		panel_3.add(scrollPane_4);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(166,119,5));
		table_1.setShowGrid(false);
		scrollPane_4.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), "Malandy", null},
				{null, null, null},
				{new Integer(2), "Marivelo", null},
				{null, null, null},
			},
			new String[] {
				"Tour de jeu", "Nom joueur", "tour actuel"
			}
		));

		Threads threads=new Threads(plateau, valeur, idPartie, bouttons,true,bouttonChevaler,panel_6,glass,lblL,tour,idJoueur,btnOk,mottrouverJoueur,mottrouverToutLesJoueur,btnNewButton,btnChanger,btnPass,table2,scoreJoueur,lblScore,panel,music,frames,table_1);
		threads.start();

		//fin
		panel.repaint();
		panel.revalidate();
	}
	public void definirMusic(Music musics,String nom) {
		musics.clipStop();
		musics.setNom(nom);
		musics.lancerMusic();
	}

}
