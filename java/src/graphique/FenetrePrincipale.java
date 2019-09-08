package graphique;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ActionButton.ActionListenerCreationPartie;
import entite.Music;

import javax.swing.JMenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class FenetrePrincipale extends JFrame {

	private JPanel contentPane;
	Music music=new Music(true,1,"music1",true);

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public FenetrePrincipale() throws Exception {
		setTitle("Jeu scrabble");
		setBounds(100, 100, 1172, 787);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPartie = new JMenu("Partie");
		menuBar.add(mnPartie);
		
		JMenuItem mntmNouvel = new JMenuItem("Nouvel");
		mnPartie.add(mntmNouvel);
		
		JMenu mnConnexion = new JMenu("Connexion");
		menuBar.add(mnConnexion);
		
		JMenuItem mntmConnecter = new JMenuItem("Connecter");
		mnConnexion.add(mntmConnecter);
		
		JMenu mnParamtre = new JMenu("Param\u00E9tre");
		menuBar.add(mnParamtre);
		
		
		JMenuItem mntmParamtre = new JMenuItem("Param\u00E9tre");
		
		mnParamtre.add(mntmParamtre);
		
		JMenu mnPropos = new JMenu("\u00C2 propos");
		menuBar.add(mnPropos);
		
		JMenuItem mntmProposDu = new JMenuItem("\u00C2 propos du jeu");
		
		mnPropos.add(mntmProposDu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1146, 727);
		contentPane.add(panel);
		panel.setLayout(null);
		new CreationPartie(panel,music,this);
		JFrame fr=this;
		//listener
		mntmProposDu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					music.clipStop();
					music.setNom("para");
					music.lancerMusic();
					new Propos(panel);
				} catch (Exception e) {
					e.printStackTrace();
					music.clipStop();
				}
			}
		});
		mntmParamtre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					music.clipStop();
					music.setNom("para");
					music.lancerMusic();
					new InterfaceParametres(panel, music);
				} catch (Exception e) {
					e.printStackTrace();
					music.clipStop();
				}
			}
		});
		mntmConnecter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					music.clipStop();
					music.setNom("music1");
					music.lancerMusic();
					panel.removeAll();
					new InterfaceConnection(panel,Login.session.getIdJoueur(),fr,music);
					panel.repaint();
					panel.revalidate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mntmNouvel.addActionListener(new ActionListenerCreationPartie(panel, music,this));	
		
	}
}
