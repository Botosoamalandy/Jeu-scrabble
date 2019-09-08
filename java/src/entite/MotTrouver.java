package entite;

import java.util.Vector;
import org.json.JSONArray;
import js.GetJson;

public class MotTrouver {
	int idMotTrouver=0;
	int idPartie=0;
	int idJoueur=0;
	String mot="";
	int point=0;
	public MotTrouver() {}
	public MotTrouver(int idMotTrouver, int idPartie, int idJoueur, String mot, int point) {
		this.idMotTrouver = idMotTrouver;
		this.idPartie = idPartie;
		this.idJoueur = idJoueur;
		this.mot = mot;
		this.point = point;
	}
	public int getIdMotTrouver() {
		return idMotTrouver;
	}
	public void setIdMotTrouver(int idMotTrouver) {
		this.idMotTrouver = idMotTrouver;
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
	public String getMot() {
		return mot;
	}
	public void setMot(String mot) {
		this.mot = mot;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public MotTrouver[] getJSON(JSONArray json) throws Exception {
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();	
		Vector<Object> objectVector=fonctionGeneraliser.find(this,json);
		return objectVector.toArray(new MotTrouver[objectVector.size()]);
	}
	public MotTrouver[] getMotTrouverAPartidPartie(int idParties) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/MotTrouver.php?numero=1&get=1&idPartie="+idParties);
		return getJSON(json);
	}
	public MotTrouver[] getMotTrouverAPartidPartieAndIdJoueur(int idParties,int idJoueurs) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/MotTrouver.php?numero=1&get=2&idPartie="+idParties+"&idJoueur="+idJoueurs);
		return getJSON(json);
	}
	public boolean insertion(int idParties,int idJoueurs,String mots,int points) throws Exception {
		GetJson getJson=new GetJson();
		try {
			getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/MotTrouver.php?numero=2&idPartie="+idParties+"&idJoueur="+idJoueurs+"&mot="+mots+"&point="+points);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public int getScore(int idParties,int idJoueurs) throws Exception {
		int total=0;
		MotTrouver []motTrouvers=getMotTrouverAPartidPartieAndIdJoueur(idParties, idJoueurs);int size=motTrouvers.length;
		for(int i=0;i<size;i++) {
			total=total+motTrouvers[i].getPoint();
		}
		return total;
	}
	public Object[][] getMotTrouverToObject(int idParties,int idJoueurs,int code) throws Exception{
		if(code==1) {
			MotTrouver []motTrouvers=getMotTrouverAPartidPartieAndIdJoueur(idParties,idJoueurs);int size=motTrouvers.length;
			Object [][]objects=new Object[motTrouvers.length][2];
			for(int i=0;i<size;i++) {
				objects[i][0]=motTrouvers[i].getMot();
				objects[i][1]=motTrouvers[i].getPoint();
			}
			return objects;
		}else {
			MotTrouver []motTrouvers=getMotTrouverAPartidPartie(idParties);int size=motTrouvers.length;
			PartieDeJeu partieDeJeu=new PartieDeJeu();
			Object [][]objects=new Object[motTrouvers.length][3];
			for(int i=0;i<size;i++) {
				PartieDeJeu partieDeJeus=partieDeJeu.getPartieDeJeuAPartIdPartieAndIdJoueur(idParties,motTrouvers[i].getIdJoueur());
				objects[i][0]=partieDeJeus.getNomJoueur();
				objects[i][1]=motTrouvers[i].getMot();
				objects[i][2]=motTrouvers[i].getPoint();
			}
			return objects;
		}
	}
	public void insertionMotTrouver(int idParties,int idJoueurs,String mots,long scores) throws Exception {	
		int scoress=(int) scores;
		insertion(idParties, idJoueurs,mots,scoress);
	}
}
