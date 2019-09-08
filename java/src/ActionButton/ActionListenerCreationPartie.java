package ActionButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entite.Music;
import graphique.CreationPartie;

public class ActionListenerCreationPartie implements ActionListener{
	JPanel panel;
	Music music;
	JFrame frame;
	public ActionListenerCreationPartie(JPanel panel, Music music, JFrame frame) {
		this.panel = panel;
		this.music = music;
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			new CreationPartie(panel,music,frame);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
