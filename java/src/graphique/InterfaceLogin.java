package graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entite.Joueur;

public class InterfaceLogin {
	private JTextField textField;
	JPanel panel=new JPanel();
	JFrame jFrame=new JFrame();
	public InterfaceLogin(JPanel panel) {
		this.panel=panel;
		Interface();
	}
	public InterfaceLogin(JPanel panel,JFrame jFrame) {
		this.panel=panel;
		this.jFrame=jFrame;
		Interface();
	}
	public void Interface() {
		this.panel.removeAll();
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.RED);
		lblLogin.setFont(new Font("Tekton Pro", Font.PLAIN, 60));
		lblLogin.setBounds(125, 30, 208, 56);
		this.panel.add(lblLogin);
		
		JLabel lblNomDuJoueur = new JLabel("Nom du joueur");
		lblNomDuJoueur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomDuJoueur.setForeground(Color.WHITE);
		lblNomDuJoueur.setBounds(10, 141, 151, 41);
		this.panel.add(lblNomDuJoueur);
		
		textField = new JTextField();
		textField.setBounds(159, 141, 250, 34);
		this.panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Inscription");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new InterfaceInscription(panel);
			}
		});
		btnNewButton.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		btnNewButton.setBounds(10, 238, 191, 41);
		this.panel.add(btnNewButton);
		
		JButton btnConnecter = new JButton("Connecter");
		btnConnecter.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		btnConnecter.setBounds(218, 238, 191, 41);
		
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setForeground(Color.RED);
		lblNewLabel1.setBounds(10, 302, 399, 14);
		this.panel.add(lblNewLabel1);
		btnConnecter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Joueur joueur=new Joueur();
				try {
					int resultat=joueur.login((String)textField.getText());
					Login.session.setIdJoueur(resultat);
					if(resultat==0) {
						lblNewLabel1.setText("Votre nom est non valider veuille recommencé");
					}else {
						FenetrePrincipale frame = new FenetrePrincipale();
						jFrame.setVisible(false);
						frame.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		this.panel.add(btnConnecter);
		this.panel.repaint();
		this.panel.revalidate();
	}
}
