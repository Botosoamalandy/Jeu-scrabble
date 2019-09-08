package graphique;

public class Affichage {

	public static void main(String[] args) throws Exception {
		try {
			Login frame = new Login();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
