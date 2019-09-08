package graphique;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Propos {
	public Propos(JPanel panel) {
		panel.removeAll();
		panel.setBounds(0, 0, 1156, 727);
		panel.setBackground(new Color(233,161,0));
		panel.setLayout(null);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Propos.class.getResource("/img/propos.png")));
		label.setBounds(245, 11, 680, 689);
		panel.add(label);
		panel.repaint();
		panel.revalidate();
	}
}
