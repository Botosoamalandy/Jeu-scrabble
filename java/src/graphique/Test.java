package graphique;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import entite.Partie;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Test() throws Exception {
		setTitle("Jeu scrabble");
		setBounds(100, 100, 1172, 787);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPartie = new JMenu("Partie");
		menuBar.add(mnPartie);
		
		JMenu mnConnexion = new JMenu("Connexion");
		menuBar.add(mnConnexion);
		
		JMenuItem mntmConnecter = new JMenuItem("Connecter");
		mnConnexion.add(mntmConnecter);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(166,119,5));
		panel.setBounds(0, 0, 1146, 727);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(233,161,0));
		panel_1.setBounds(10, 11, 1126, 385);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCreerUnePartie = new JLabel("Creer une partie");
		lblCreerUnePartie.setForeground(Color.WHITE);
		lblCreerUnePartie.setFont(new Font("Tekton Pro", Font.ITALIC, 50));
		lblCreerUnePartie.setBounds(84, 11, 336, 50);
		panel_1.add(lblCreerUnePartie);
		
		JLabel lblNewLabel = new JLabel("Titre de la partie ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tekton Pro", Font.ITALIC, 20));
		lblNewLabel.setBounds(84, 72, 162, 30);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(245, 76, 175, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Creer");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(245, 200, 175, 30);
		panel_1.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Test.class.getResource("/img/gold6.jpg")));
		label.setBounds(84, 241, 958, 133);
		panel_1.add(label);
		
		JLabel lblNombreDeJoueur = new JLabel("Nombre de joueur");
		lblNombreDeJoueur.setForeground(Color.WHITE);
		lblNombreDeJoueur.setFont(new Font("Tekton Pro", Font.ITALIC, 20));
		lblNombreDeJoueur.setBounds(84, 113, 162, 30);
		panel_1.add(lblNombreDeJoueur);
		
		JLabel lblScoreMaximale = new JLabel("Score maximale");
		lblScoreMaximale.setForeground(Color.WHITE);
		lblScoreMaximale.setFont(new Font("Tekton Pro", Font.ITALIC, 20));
		lblScoreMaximale.setBounds(84, 156, 162, 30);
		panel_1.add(lblScoreMaximale);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "4"}));
		comboBox.setBounds(245, 119, 175, 20);
		panel_1.add(comboBox);
		
		String []scoreMax=new String[200];
		scoreMax[0]="Illimiter";
		for(int i=1;i<200;i++) {scoreMax[i]=""+(i+1);}
		JComboBox comboBox_1 = new JComboBox(scoreMax);
		comboBox_1.setBounds(245, 154, 175, 20);
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(85, 233, 335, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Test.class.getResource("/img/gold3.jpg")));
		label_1.setBounds(430, 24, 601, 204);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(233,161,0));
		panel_2.setBounds(10, 396, 1126, 320);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Test.class.getResource("/img/gold5.jpg")));
		label_2.setBounds(10, 11, 1106, 298);
		panel_2.add(label_2);
		//listener
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Partie partie=new Partie();
				try {
					partie.creerPartie((String)textField.getText(),(String)comboBox.getSelectedItem(),(String)comboBox_1.getSelectedItem(),Login.session.getIdJoueur());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		mntmConnecter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}
}
