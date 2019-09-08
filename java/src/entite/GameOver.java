package entite;

import java.util.ArrayList;
import java.util.List;

public class GameOver {
	int idPartie=0;
	int idJoueur=0;
	String nomPartie="";
	String nomJoueur="";
	int classement=0;
	int score=0;
	boolean gagne=false;
	public GameOver() {}
	public GameOver(int idPartie, int idJoueur, String nomPartie, String nomJoueur, int classement, int score,boolean gagne) {
		this.idPartie = idPartie;
		this.idJoueur = idJoueur;
		this.nomPartie = nomPartie;
		this.nomJoueur = nomJoueur;
		this.classement = classement;
		this.score = score;
		this.gagne = gagne;
	}
	public int getIdPartie() {
		return idPartie;
	}
	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public String getNomPartie() {
		return nomPartie;
	}
	public void setNomPartie(String nomPartie) {
		this.nomPartie = nomPartie;
	}
	public String getNomJoueur() {
		return nomJoueur;
	}
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	public int getClassement() {
		return classement;
	}
	public void setClassement(int classement) {
		this.classement = classement;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isGagne() {
		return gagne;
	}
	public void setGagne(boolean gagne) {
		this.gagne = gagne;
	}
	public List<GameOver> getGamerOver(int idParties) throws Exception {
		Partie partie=new Partie();
		Serveur serveur=new Serveur();
		Parametre parametre=new Parametre();
		MotTrouver motTrouver=new MotTrouver();
		parametre=parametre.getParametreAPartidPartie(idParties);
		partie=partie.setTableauObjectToObject(partie.getPartieAPartIdPartie(idParties));
		Serveur []serveurs=serveur.getServeurAPartidPartie(idParties);int size=serveurs.length;
		
		List<GameOver> gameOvers=new ArrayList<GameOver>();;
		if(partie!=null && parametre!=null && size>0 && parametre.getNombreDeJoueur()==size) {
			for(int i=0;i<size;i++) {
				PartieDeJeu partieDeJeu=new PartieDeJeu();
				partieDeJeu=partieDeJeu.getPartieDeJeuAPartIdPartieAndIdJoueur(idParties, serveurs[i].getIdJoueur());
				gameOvers.add(new GameOver(idParties, serveurs[i].getIdJoueur(),partie.getNomPartie(),partieDeJeu.getNomJoueur(),i,motTrouver.getScore(idParties,serveurs[i].getIdJoueur()),false));
			}
			return gameOvers;
		}
		return null;
	}
	public void getClassementGameOvers(List<GameOver> sacs) {
		int size=sacs.size();
		int test=1;
		GameOver m;
		while(test!=0) {
			test=0;
			for(int i=0;i<size-1;i++) {
				if(sacs.get(i).getScore()<=sacs.get(i+1).getScore()) {
					m=sacs.get(i+1);
					sacs.set(i+1,sacs.get(i));
					sacs.set(i,m);
					test++;
				}
			}
		}
	}
	public Object[][] getGamerOverObject(int idParties) throws Exception {
		List<GameOver> gameOvers=getGamerOver(idParties);int size=gameOvers.size();
		getClassementGameOvers(gameOvers);
		Object [][]objects=new Object[size+size][4];
		for(int i=0;i<size;i++) {
			gameOvers.get(i).setClassement(i+1);
			objects[i][0]=gameOvers.get(i).getClassement();
			objects[i][1]=gameOvers.get(i).getNomJoueur();
			objects[i][2]=gameOvers.get(i).getScore() ;
		}
		return objects;
	}
	public GameOver getGamerOverFirst(int idParties) throws Exception {
		List<GameOver> gameOvers=getGamerOver(idParties);
		getClassementGameOvers(gameOvers);
		if(gameOvers.size()>0) {
			return gameOvers.get(0);
		}
		return new GameOver(0,0,"","",0,0,false);
	}
	
}
