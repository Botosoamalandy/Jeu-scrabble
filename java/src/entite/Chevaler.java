package entite;

import java.util.Vector;

import org.json.JSONArray;

import js.GetJson;

public class Chevaler {
	int idChevalet=0;
	int idPartie=0;
	String lettre="";
	int couleur=0;
	int idJoueur=0;
	public Chevaler() {}
	public Chevaler(int idChevalet, int idPartie, String lettre,int couleur,int idJoueur) {
		this.idChevalet = idChevalet;
		this.idPartie = idPartie;
		this.lettre = lettre;
		this.couleur = couleur;
		this.idJoueur = idJoueur;
	}
	public int getIdChevalet() {
		return idChevalet;
	}
	public void setIdChevalet(int idChevalet) {
		this.idChevalet = idChevalet;
	}
	public int getIdPartie() {
		return idPartie;
	}
	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}
	public String getLettre() {
		return lettre;
	}
	public void setLettre(String lettre) {
		this.lettre = lettre;
	}
	public int getCouleur() {
		return couleur;
	}
	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public Chevaler setTableauObjectToObject(Chevaler []elements) {
		Chevaler element=null;
		for(Chevaler elementTmp :elements) {
			element=elementTmp;
		}
		return element;
	}
	public Chevaler[] getJSON(JSONArray json) throws Exception {
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();	
		Vector<Object> objectVector=fonctionGeneraliser.find(this,json);
		return objectVector.toArray(new Chevaler[objectVector.size()]);
	}
	public Chevaler[] getChevalerAPartidPartie(int idParties) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/Chevaler.php?numero=1&get=2&idPartie="+idParties);
		return getJSON(json);
	}
	public Chevaler getChevalerAPartidPartieAndIdJoueur(int idParties,int idJoueurs) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/Chevaler.php?numero=1&get=3&idPartie="+idParties+"&idJoueur="+idJoueurs);
		return setTableauObjectToObject(getJSON(json));
	}
	public boolean insertionChevaler(int idParties,int idJoueurs) throws Exception {
		GetJson getJson=new GetJson();
		getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Chevaler.php?numero=2&idPartie="+idParties+"&idJoueur="+idJoueurs);
		return false;
	}
	public void insertionChevalerInitiale(int idParties) throws Exception {
		PartieDeJeu fonctionPartieDeJeu=new PartieDeJeu();
		PartieDeJeu []partieDeJeus=fonctionPartieDeJeu.getPartieDeJeuAPartIdPartie(idParties);
		int size=partieDeJeus.length;
		for(int i=0;i<size;i++) {
			Chevaler chevaler=getChevalerAPartidPartieAndIdJoueur(idParties, partieDeJeus[i].getIdJoueur());
			if(chevaler==null) {
				insertionChevaler(idParties,partieDeJeus[i].getIdJoueur());
			}
		}
	}
	
	public String bouttonToLettre(Boutton []bouttons) {
		int size=bouttons.length;
		String resultat="";
		for(int i=0;i<size;i++) {
			resultat=resultat+bouttons[i].getNom();
		}
		return resultat;
	}
	public boolean verificationLettre(String string) {
		int size=string.length();
		if(size==7) {
			return true;
		}else {
			return false;
		}
	}
	public boolean updateChevaler(int idParties,int idJoueurs,Boutton []bouttons,int couleurs) throws Exception {
		GetJson getJson=new GetJson();
		String lettres=bouttonToLettre(bouttons);
		if(verificationLettre(lettres)) {
			getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Chevaler.php?numero=3&idPartie="+idParties+"&idJoueur="+idJoueurs+"&lettre="+lettres+"&couleur="+couleurs);
			return true;
		}else {
			return false;
		}
	}
	public boolean updateChevalerTmp(int idParties,int idJoueurs,String lettres,int couleurs) throws Exception {
		GetJson getJson=new GetJson();
		if(verificationLettre(lettres)) {
			getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Chevaler.php?numero=3&idPartie="+idParties+"&idJoueur="+idJoueurs+"&lettre="+lettres+"&couleur="+couleurs);
			return true;
		}else {
			return false;
		}
	}
	public boolean updateChevalerTmp2(int idParties,int idJoueurs,Vector<String> vector) throws Exception {
		try {
			int size=vector.size();
			String lettres="";
			for(int i=0;i<size;i++) {
				lettres=lettres+vector.get(i);
			}
			updateChevalerTmp(idParties, idJoueurs, lettres, 1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public Vector<String> changerLettreEnVectorString(String valeur) {
		int size=valeur.length();
		Vector<String> vector=new Vector<String>();
		for(int i=0;i<size;i++) {
			vector.add(""+valeur.charAt(i));
		}
		return vector;
	}
	public Vector<Points> changerStringEnVectorString(String valeur) {
		Points points=new Points();
		return points.vectorStringToPoints(changerLettreEnVectorString(valeur));
	}
}
