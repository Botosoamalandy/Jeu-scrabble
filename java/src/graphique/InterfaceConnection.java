package graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entite.Chevaler;
import entite.FonctionGeneraliser;
import entite.Music;
import entite.Partie;
import entite.PartieDeJeu;
import entite.Plateau;
import entite.Serveur;
import entite.Threads;

public class InterfaceConnection {
	private JTable table;
	String nomParties="";
	Threads threads;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public InterfaceConnection(JPanel panel,int idJoueur,JFrame frame,Music music) throws Exception {
		panel.removeAll();
		panel.setBackground(new Color(166,119,5));
		panel.setBounds(0, 0, 1156, 727);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(233,161,0));
		panel_1.setBounds(10, 11, 1136, 705);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblConnectUne = new JLabel("Connect\u00E9 \u00E0 une partie");
		lblConnectUne.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblConnectUne.setBounds(364, 11, 420, 49);
		panel_1.add(lblConnectUne);
		
		JLabel lblLesPartiesDisponobles = new JLabel("Les  parties disponobles");
		lblLesPartiesDisponobles.setForeground(Color.WHITE);
		lblLesPartiesDisponobles.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLesPartiesDisponobles.setBounds(107, 71, 231, 36);
		panel_1.add(lblLesPartiesDisponobles);
		
		
		Partie partie=new Partie();
		Partie []parties=partie.getPartie();
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();
		int size=parties.length;
		String []combo=new String[size];
		for(int i=0;i<size;i++) {combo[i]=""+fonctionGeneraliser.deleteSeparatorString(parties[i].getNomPartie())+"-"+parties[i].getDatePartie().getDates();}
		JComboBox comboBox = new JComboBox(combo);
		comboBox.setBounds(364, 83, 420, 20);
		panel_1.add(comboBox);
		
		
		
		JButton btnNewButton = new JButton("Connecter");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(818, 76, 146, 23);
		panel_1.add(btnNewButton);
		
		PartieDeJeu partieDeJeu=new PartieDeJeu();
		Object [][]objects=partieDeJeu.setTableauToObject(partieDeJeu.getPartieDeJeu());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 131, 1126, 151);
		panel_1.add(scrollPane);
		table = new JTable();
		table.setBackground(new Color(204,170,133));
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		table.setModel(new DefaultTableModel(objects,new String[] {"Nom du partie","Nom joueur","Date"}));
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				 Object[][] objects;
				try {
					objects =partieDeJeu.setTableauToObject(partieDeJeu.getPartieDeJeuAPartNomPartie((String)comboBox.getSelectedItem()));
					table.setModel(new DefaultTableModel(objects,new String[] {"Nom du partie","Nom joueur","Date"}));
					nomParties=(String)comboBox.getSelectedItem();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		nomParties=(String)comboBox.getSelectedItem();
		JButton btnNewButton_1 = new JButton("Lancer le jeu\r\n");
		btnNewButton_1.setBackground(new Color(170,105,4));
		btnNewButton_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 40));
		btnNewButton_1.setBounds(10, 304, 1116, 60);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Plateau plateau=new Plateau();
				Chevaler chevaler=new Chevaler();
				try {
					PartieDeJeu []partieDeJeuTmp4=partieDeJeu.getPartieDeJeuAPartNomPartie((String)comboBox.getSelectedItem());
					if(partieDeJeuTmp4.length>=1) {
						Login.session.setIdPartie(partieDeJeuTmp4[0].getIdPartie());
						plateau.insertionPlateauInitiale(Login.session.getIdPartie());
						chevaler.insertionChevalerInitiale(Login.session.getIdPartie());
						System.out.println("idJoueur="+Login.session.getIdJoueur()+" idPartie="+Login.session.getIdPartie());
						new InterfaceChercherRang(panel,frame,music);
						threads.setTest(false);
					}					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(364, 106, 420, 14);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Test.class.getResource("/img/gold2.jpg")));
		label.setBounds(10, 375, 1116, 319);
		panel_1.add(label);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Serveur serveur=new Serveur();
				 Object[][] objects;
				try {
					boolean insertion=serveur.insertionServeur((String)comboBox.getSelectedItem(),idJoueur);
					if(insertion==false) {
						lblNewLabel.setText("Le nombre de joueur est complet ou vous etez déjà connecté");
					}else {
						objects =partieDeJeu.setTableauToObject(partieDeJeu.getPartieDeJeuAPartNomPartie((String)comboBox.getSelectedItem()));
						table.setModel(new DefaultTableModel(objects,new String[] {"Nom du partie","Nom partie","Date"}));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		panel.repaint();
		panel.revalidate();
		threads=new Threads(table, partieDeJeu, nomParties,true,idJoueur,btnNewButton_1,comboBox);
		threads.start();
	}
}
