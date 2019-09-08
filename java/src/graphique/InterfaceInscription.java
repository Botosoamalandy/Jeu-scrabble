package graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entite.Joueur;

public class InterfaceInscription {
	private JTextField textField;
	public InterfaceInscription(JPanel panel) {
		panel.removeAll();
		JLabel lblInscription = new JLabel("Inscription ");
		lblInscription.setForeground(Color.RED);
		lblInscription.setFont(new Font("Tekton Pro", Font.PLAIN, 60));
		lblInscription.setBounds(66, 23, 289, 46);
		panel.add(lblInscription);
		
		JLabel lblNewLabel = new JLabel("Nom du joueur");
		lblNewLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(37, 99, 134, 32);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(181, 99, 163, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		lblDescription.setBounds(37, 168, 134, 32);
		panel.add(lblDescription);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(181, 173, 163, 52);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("s'inscrir");
		btnNewButton.setFont(new Font("Tekton Pro", Font.PLAIN, 40));
		btnNewButton.setBounds(66, 257, 278, 46);
		
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setForeground(Color.RED);
		lblNewLabel1.setBounds(10, 302, 399, 14);
		panel.add(lblNewLabel1);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Joueur joueur=new Joueur();
				try {
					boolean insererOuPas=joueur.inscription((String)textField.getText(),(String)textArea.getText());
					if(insererOuPas==true) {
						new InterfaceLogin(panel);
					}else {
						lblNewLabel1.setText("Le champ est vide ou ce nom existe déja. Veuille trouver une autre nom ");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		panel.add(btnNewButton);
		panel.repaint();
		panel.revalidate();
	}

}
