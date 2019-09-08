package graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entite.Music;
import entite.Parametre;
import entite.PartieDeJeu;

public class InterfaceParametres {
	Parametre parametre=new Parametre();
	PartieDeJeu partieDeJeu=new PartieDeJeu();
	private JTextField txtNom;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public InterfaceParametres(JPanel panel,Music music) throws Exception {
		panel.removeAll();
		int idPartie=Login.session.getIdPartie(),idJoueur=Login.session.getIdJoueur();
		partieDeJeu=partieDeJeu.getPartieDeJeuRecent(idJoueur);
		parametre=parametre.getNewParametre(parametre.getParametreAPartidPartie(partieDeJeu.getIdPartie()));
		panel.setBackground(new Color(233,161,0));
		panel.setBounds(0, 0, 1156, 727);
		panel.setLayout(null);
		
		JLabel lblParametre = new JLabel("Param\u00E9tre");
		lblParametre.setForeground(Color.WHITE);
		lblParametre.setFont(new Font("Tekton Pro", Font.PLAIN, 50));
		lblParametre.setHorizontalAlignment(SwingConstants.CENTER);
		lblParametre.setBounds(303, 27, 457, 56);
		panel.add(lblParametre);
		
		JLabel lblNomDuPartie = new JLabel("Nom du joueur : "+partieDeJeu.getNomJoueur());
		lblNomDuPartie.setForeground(Color.WHITE);
		lblNomDuPartie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomDuPartie.setBounds(33, 113, 416, 33);
		panel.add(lblNomDuPartie);
		
		JLabel label = new JLabel("Nom du partie : "+partieDeJeu.getNomPartie());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(33, 158, 416, 33);
		panel.add(label);
		
		JLabel lblDescriptionScrabble = new JLabel("Description : "+partieDeJeu.getDescription());
		lblDescriptionScrabble.setForeground(Color.WHITE);
		lblDescriptionScrabble.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescriptionScrabble.setBounds(33, 209, 416, 33);
		panel.add(lblDescriptionScrabble);
		
		JLabel lblNombreDeJoueur = new JLabel("Nombre de joueur: "+parametre.getNombreDeJoueur());
		lblNombreDeJoueur.setForeground(Color.WHITE);
		lblNombreDeJoueur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombreDeJoueur.setBounds(33, 253, 416, 33);
		panel.add(lblNombreDeJoueur);
		
		JLabel lblScoreMaximale = new JLabel("Score maximale : "+parametre.getScoreMax());
		lblScoreMaximale.setForeground(Color.WHITE);
		lblScoreMaximale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblScoreMaximale.setBounds(33, 297, 416, 33);
		panel.add(lblScoreMaximale);
		
		txtNom = new JTextField();
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNom.setHorizontalAlignment(SwingConstants.CENTER);
		txtNom.setText("Nom");
		txtNom.setBounds(459, 114, 267, 30);
		panel.add(txtNom);
		txtNom.setColumns(10);
		String []score=new String[11];
		for(int i=0;i<10;i++) {
			score[i]=""+((i+1)*100);
		}
		score[10]="Illimiter";
		JComboBox comboBoxScore = new JComboBox(score);
		comboBoxScore.setToolTipText("");
		comboBoxScore.setBounds(459, 307, 267, 20);
		panel.add(comboBoxScore);
		
		JButton btnNewButton = new JButton("Sauvegarder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					parametre.modificationParametre((String)txtNom.getText(),(String)comboBoxScore.getSelectedItem(), parametre, partieDeJeu);
					parametre=parametre.getParametreAPartidPartie(idPartie);
					partieDeJeu=partieDeJeu.getPartieDeJeuAPartIdPartieAndIdJoueur(idPartie, idJoueur);
					lblNomDuPartie.setText("Nom du joueur : "+partieDeJeu.getNomJoueur());
					lblScoreMaximale.setText("Score maximale : "+parametre.getScoreMax());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		btnNewButton.setBounds(459, 345, 267, 44);
		panel.add(btnNewButton);
		
		JLabel lblSon = new JLabel("Son :");
		lblSon.setForeground(Color.WHITE);
		lblSon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSon.setBounds(33, 350, 69, 33);
		panel.add(lblSon);
		
		JButton btnActiv = new JButton(music.getActive());
		btnActiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnActiv.getText().equals("Activer")) {
					music.setActive("Desactiver");
					btnActiv.setText("Desactiver");
					music.clipStop();
					music.setOneOrOff(false);
				}else {
					music.setActive("Activer");
					btnActiv.setText("Activer");
					music.setOneOrOff(true);
					music.lancerMusic();
				}
				
			}
		});
		btnActiv.setBounds(111, 350, 89, 33);
		panel.add(btnActiv);
		
		JLabel lblIlYA = new JLabel("");
		lblIlYA.setForeground(Color.RED);
		lblIlYA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIlYA.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlYA.setToolTipText("");
		lblIlYA.setBounds(416, 400, 377, 20);
		panel.add(lblIlYA);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(InterfaceParametres.class.getResource("/img/img20.png")));
		label_1.setBounds(739, 113, 407, 276);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(InterfaceParametres.class.getResource("/img/img21.png")));
		label_2.setBounds(10, 406, 1136, 310);
		panel.add(label_2);
		panel.repaint();
		panel.revalidate();
	}

}
