package graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entite.GameOver;
import entite.Music;

public class InterfaceGamerOver {
	GameOver gameOver=new GameOver();
	private JTextField txtPartieTermin;
	private JTable table_1;
	private JScrollPane scrollPane;
	public InterfaceGamerOver(JPanel panel,int idPartie,Music music,JFrame frame) throws Exception {
		//UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		panel.removeAll();
		panel.setBounds(0, 0, 1156, 727);
		panel.setBackground(new Color(10,99,55));
		panel.setLayout(null);
		gameOver=gameOver.getGamerOverFirst(idPartie);
		txtPartieTermin = new JTextField();
		txtPartieTermin.setText("Partie termin\u00E9");
		txtPartieTermin.setHorizontalAlignment(SwingConstants.CENTER);
		txtPartieTermin.setForeground(new Color(225,232,2));
		txtPartieTermin.setFont(new Font("Tahoma", Font.PLAIN, 80));
		txtPartieTermin.setColumns(10);
		txtPartieTermin.setBackground(new Color(10,99,55));
		txtPartieTermin.setBounds(10, 11, 1136, 94);
		panel.add(txtPartieTermin);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 346, 1136, 247);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setShowGrid(false);
		scrollPane.setViewportView(table_1);
		table_1.setFont(new Font("Tekton Pro", Font.PLAIN, 32));
		table_1.setBackground(new Color(124,210,241));
		table_1.setModel(new DefaultTableModel(gameOver.getGamerOverObject(idPartie),new String[] {"Rang", "Nom du joueur", "Score"}));
		table_1.setRowHeight(50);
		
		JButton btnNewButton = new JButton("Creer une nouvelle partie");
		btnNewButton.setForeground(new Color(10,99,55));
		btnNewButton.setBackground(new Color(246,239,170));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnNewButton.setBounds(10, 629, 1136, 63);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new CreationPartie(panel,music,frame);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		});
		
		JLabel lblNomDeLa = new JLabel("Nom de la partie : "+gameOver.getNomPartie());
		lblNomDeLa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNomDeLa.setForeground(Color.WHITE);
		lblNomDeLa.setBounds(10, 129, 1136, 47);
		panel.add(lblNomDeLa);
		
		JLabel lblGagnantJoueur = new JLabel("Gagnant : "+gameOver.getNomJoueur());
		lblGagnantJoueur.setForeground(Color.WHITE);
		lblGagnantJoueur.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblGagnantJoueur.setBounds(10, 193, 1136, 47);
		panel.add(lblGagnantJoueur);
		
		JLabel lblScore = new JLabel("Score : "+gameOver.getScore());
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblScore.setBounds(10, 251, 1136, 47);
		panel.add(lblScore);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(68);

		panel.repaint();
		panel.revalidate();
	}
}
