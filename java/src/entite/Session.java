package entite;

public class Session {
	int idPartie=0;
	int idParametre=0;
	int idJoueur=0;
	int idSac=0;
	public Session() {}
	public Session(int idPartie, int idParametre, int idJoueur, int idSac) {
		this.idPartie = idPartie;
		this.idParametre = idParametre;
		this.idJoueur = idJoueur;
		this.idSac = idSac;
	}
	public int getIdPartie() {
		return idPartie;
	}
	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}
	public int getIdParametre() {
		return idParametre;
	}
	public void setIdParametre(int idParametre) {
		this.idParametre = idParametre;
	}
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public int getIdSac() {
		return idSac;
	}
	public void setIdSac(int idSac) {
		this.idSac = idSac;
	}
	
}
