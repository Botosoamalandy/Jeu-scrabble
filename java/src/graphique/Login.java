package graphique;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import entite.Session;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	static Session session=new Session();
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Login() throws Exception {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 366);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 419, 327);
		contentPane.add(panel);
		panel.setLayout(null);
		new InterfaceLogin(panel,this);		
	}
}
