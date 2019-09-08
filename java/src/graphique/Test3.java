package graphique;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ActionButton.MyGlassPane;
import entite.Boutton;
import entite.ValeurAttribut;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Test3 extends JFrame {

	private JPanel contentPane;
	Boutton boutton=new Boutton();
	Boutton [][]bouttons=new Boutton[15][15];
	Boutton []bouttonChevaler=new Boutton[7];
	MyGlassPane glass = new MyGlassPane();
	ValeurAttribut valeur =new ValeurAttribut();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test3 frame = new Test3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1172, 787);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1156, 727);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 696, 609);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(44, 0, 600, 600);
		panel_1.add(panel_4);
		//boutton.initialisationJeu(bouttons, panel_4,valeur);
		panel_4.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 608, 1146, 119);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Boutton> list=valeur.getBouttons();
				for(int i=0;i<list.size();i++) {
					System.out.println("nom"+i+"="+list.get(i).getNom());
				}
			}
		});
		btnNewButton.setBounds(453, 0, 134, 44);
		panel_2.add(btnNewButton);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(453, 64, 134, 44);
		panel_2.add(btnOk);
		
		JButton btnMelanger = new JButton("Melanger");
		btnMelanger.setBounds(751, 64, 134, 44);
		panel_2.add(btnMelanger);
		
		JButton btnPass = new JButton("Pass\u00E9");
		btnPass.setBounds(610, 64, 134, 44);
		panel_2.add(btnPass);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(74,10,9));
		panel_5.setBounds(10, 0, 433, 44);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblL = new JLabel("");
		lblL.setHorizontalAlignment(SwingConstants.CENTER);
		lblL.setFont(new Font("Tahoma", Font.PLAIN, 59));
		lblL.setForeground(new Color(255, 210, 2));
		lblL.setBackground(Color.WHITE);
		lblL.setBounds(10, 0, 421, 44);
		panel_5.add(lblL);
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(8, 64, 433, 44);
		panel_2.add(panel_6);
		
		JButton btnChanger = new JButton("Changer");
		btnChanger.setBounds(610, 0, 134, 44);
		panel_2.add(btnChanger);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(695, 0, 451, 609);
		panel.add(panel_3);
		panel_3.setLayout(null);
		setGlassPane(glass);
	}
}
