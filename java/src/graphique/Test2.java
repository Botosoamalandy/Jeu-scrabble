package graphique;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entite.Boutton;
import entite.Chevaler;
import entite.Parametre;
import entite.PartieDeJeu;
import entite.Points;
import entite.Sac;
import entite.Threads;

import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Test2 extends JFrame {

	private JPanel contentPane;
	int idPartie=8;
	int idJoueur=5;
	Parametre fonctionParametre=new Parametre();
	Boutton boutton=new Boutton();
	Boutton []bouttons=new Boutton[7];
	Sac sac=new Sac();
	Vector<Points> points=new Vector<Points>();
	Chevaler chevaler=new Chevaler();
	/**
	 * Launch the application.
	 * @throws Exception 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test2 frame = new Test2();
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
	public Test2() throws Exception {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		Parametre parametre=fonctionParametre.getParametreAPartidPartie(idPartie);
		this.points=sac.getContenuSac(idPartie);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1172, 787);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(166,119,5));
		panel.setBounds(0, 0, 901, 737);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(233,161,0));
		panel_2.setBounds(10, 11, 881, 509);
		panel.add(panel_2);
		panel_2.setLayout(null);
		//affichage
		JPanel panel_4 = new JPanel();
		JPanel panel_9 = new JPanel();
		JPanel panel_5 = new JPanel();
		JPanel panel_12 = new JPanel();
		JPanel panel_7 = new JPanel();
		JPanel panel_10 = new JPanel();
		JPanel panel_6 = new JPanel();
		JPanel panel_11 = new JPanel();
		
		PartieDeJeu partieDeJeu=new PartieDeJeu();
		PartieDeJeu []partieDeJeus=partieDeJeu.getPartieDeJeuAPartIdPartie(idPartie);
		if(parametre.getNombreDeJoueur()==2) {
			//joueur 1
			
			panel_4.setBounds(10, 11, 786, 67);
			panel_2.add(panel_4);
			panel_4.setLayout(null);
			//panel conf
			panel_9.setBounds(21, 39, 21, 17);
			panel_4.add(panel_9);
			JLabel lblJoueurPrs = new JLabel(""+partieDeJeus[0].getNomJoueur());
			lblJoueurPrs.setBounds(52, 11, 520, 45);
			panel_4.add(lblJoueurPrs);
			lblJoueurPrs.setHorizontalAlignment(SwingConstants.CENTER);
			lblJoueurPrs.setFont(new Font("Tahoma", Font.PLAIN, 40));
			
			//joueur 2
			
			panel_5.setBounds(85, 161, 786, 67);
			panel_2.add(panel_5);
			panel_5.setLayout(null);
			//panel conf
			
			panel_12.setBounds(680, 39, 21, 17);
			panel_5.add(panel_12);
			
			JLabel lblJoueurPrs_1 = new JLabel(""+partieDeJeus[1].getNomJoueur());
			lblJoueurPrs_1.setBounds(52, 11, 519, 45);
			panel_5.add(lblJoueurPrs_1);
			lblJoueurPrs_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblJoueurPrs_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}else {
			//joueur 1
			panel_4.setBounds(10, 11, 786, 67);
			panel_2.add(panel_4);
			panel_4.setLayout(null);
			//panel conf
			panel_9.setBounds(21, 39, 21, 17);
			panel_4.add(panel_9);
			parametre.couleurPanel(panel_9, partieDeJeus[0]);
			JLabel lblJoueurPrs = new JLabel(""+partieDeJeus[0].getNomJoueur());
			lblJoueurPrs.setBounds(52, 11, 520, 45);
			panel_4.add(lblJoueurPrs);
			lblJoueurPrs.setHorizontalAlignment(SwingConstants.CENTER);
			lblJoueurPrs.setFont(new Font("Tahoma", Font.PLAIN, 40));
			
			
			//joueur 2
			panel_5.setBounds(85, 161, 786, 67);
			panel_2.add(panel_5);
			panel_5.setLayout(null);
			//panel conf
			panel_12.setBounds(680, 39, 21, 17);
			panel_5.add(panel_12);
			
			JLabel lblJoueurPrs_1 = new JLabel(""+partieDeJeus[1].getNomJoueur());
			lblJoueurPrs_1.setBounds(52, 11, 519, 45);
			panel_5.add(lblJoueurPrs_1);
			lblJoueurPrs_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblJoueurPrs_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
			
			//joueur 3
			
			panel_7.setBounds(85, 303, 786, 67);
			panel_2.add(panel_7);
			panel_7.setLayout(null);
			//panel conf
			
			panel_10.setBounds(755, 39, 21, 17);
			panel_7.add(panel_10);
			
			JLabel lblJoueur = new JLabel(""+partieDeJeus[2].getNomJoueur());
			lblJoueur.setBounds(0, 0, 745, 67);
			panel_7.add(lblJoueur);
			lblJoueur.setHorizontalAlignment(SwingConstants.CENTER);
			lblJoueur.setFont(new Font("Tahoma", Font.PLAIN, 40));
			
			//joueur 4
			
			panel_6.setBounds(10, 431, 786, 67);
			panel_2.add(panel_6);
			panel_6.setLayout(null);
			//panel conf
			
			panel_11.setBackground(Color.RED);
			panel_11.setBounds(10, 39, 21, 17);
			panel_6.add(panel_11);
			JLabel lblJoueur_1 = new JLabel(""+partieDeJeus[3].getNomJoueur());
			lblJoueur_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
			lblJoueur_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblJoueur_1.setBounds(37, 11, 728, 45);
			panel_6.add(lblJoueur_1);
		}
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(233,161,0));
		panel_3.setBounds(10, 530, 881, 186);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnSac = new JButton("Ajouter");
		
		btnSac.setFont(new Font("Tekton Pro", Font.PLAIN, 44));
		btnSac.setBounds(10, 77, 365, 85);
		panel_3.add(btnSac);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 11, 861, 55);
		panel_3.add(panel_8);
		panel_8.setLayout(null);
		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(166,119,5));
		panel_1.setBounds(900, 0, 266, 737);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		PartieDeJeu partieDeJeu2=partieDeJeu.getPartieDeJeuAPartIdPartieAndIdJoueur(idPartie, idJoueur);
		JLabel lblJoueur_2 = new JLabel("Joueur");
		lblJoueur_2.setForeground(Color.WHITE);
		lblJoueur_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblJoueur_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoueur_2.setBounds(10, 11, 226, 46);
		panel_1.add(lblJoueur_2);
		
		JLabel lblNom = new JLabel("Nom : "+partieDeJeu2.getNomJoueur());
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNom.setBounds(10, 84, 226, 51);
		panel_1.add(lblNom);
		
		JLabel lblPartieScrabble = new JLabel("Partie : "+partieDeJeu2.getNomPartie());
		lblPartieScrabble.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPartieScrabble.setBounds(10, 137, 226, 51);
		panel_1.add(lblPartieScrabble);
		
		JLabel lblDate = new JLabel("Date : "+partieDeJeu2.getDatePartie().getDates());
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(10, 187, 226, 51);
		panel_1.add(lblDate);
		
		JButton btnJouer = new JButton("Jouer");
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnJouer.setFont(new Font("Tekton Pro", Font.PLAIN, 30));
		btnJouer.setBounds(0, 638, 236, 46);
		panel_1.add(btnJouer);
		boutton.initialisation(bouttons, panel_8);
		
		JButton btnVerifier = new JButton("Valider");
		btnVerifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean test=false;
				try {
					test = parametre.verificationChevaler(bouttons);
					if(test) {
						chevaler.updateChevaler(idPartie,idJoueur, bouttons, 1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnVerifier.setFont(new Font("Tekton Pro", Font.PLAIN, 35));
		btnVerifier.setBounds(495, 77, 365, 85);
		panel_3.add(btnVerifier);
		
		//listener
		btnSac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sac.ajout(bouttons, points);
				boutton.Reinitialisation(bouttons, panel_8);
			}
		});
		// vert
		//1=blue
		//2=green
		//3=red
		//4=rose
		Threads threads=new Threads(panel_9, panel_12, panel_10, panel_11, partieDeJeus, parametre,idPartie, true);
		threads.start(); 
	}
}
