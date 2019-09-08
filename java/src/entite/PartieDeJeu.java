package entite;

import java.util.Vector;

import org.json.JSONArray;

import js.GetJson;

public class PartieDeJeu{
	int idPartie=0;
	String nomPartie="";
	Dates datePartie=new Dates();
	int idServeur=0;
	int serveur=0;
	int idJoueur=0;
	String nomJoueur="";
	String description="";
	int rand=0;
	int tour=0;
	double score=0;
	String chevaler="";
	public PartieDeJeu() {}
	public PartieDeJeu(int idPartie, String nomPartie, Dates datePartie,int idServeur, int serveur, int idJoueur, String nomJoueur, String description, int rand,int tour, double score, String chevaler) {
		this.idServeur = idServeur;
		this.serveur = serveur;
		this.idJoueur = idJoueur;
		this.nomJoueur = nomJoueur;
		this.description = description;
		this.rand = rand;
		this.tour = tour;
		this.score = score;
		this.chevaler = chevaler;
	}
	public int getIdPartie() {
		return idPartie;
	}
	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}
	public String getNomPartie() {
		return nomPartie;
	}
	public void setNomPartie(String nomPartie) {
		this.nomPartie = nomPartie;
	}
	public Dates getDatePartie() {
		return datePartie;
	}
	public void setDatePartie(String datePartie) {
		this.datePartie.setDates(datePartie);
	}
	public int getIdServeur() {
		return idServeur;
	}
	public void setIdServeur(int idServeur) {
		this.idServeur = idServeur;
	}
	public int getServeur() {
		return serveur;
	}
	public void setServeur(int serveur) {
		this.serveur = serveur;
	}
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public String getNomJoueur() {
		return nomJoueur;
	}
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRand() {
		return rand;
	}
	public void setRand(int rand) {
		this.rand = rand;
	}
	public int getTour() {
		return tour;
	}
	public void setTour(int tour) {
		this.tour = tour;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getChevaler() {
		return chevaler;
	}
	public void setChevaler(String chevaler) {
		this.chevaler = chevaler;
	}
	public PartieDeJeu setTableauObjectToObject(PartieDeJeu []elements) {
		PartieDeJeu element=null;
		for(PartieDeJeu elementTmp :elements) {
			element=elementTmp;
		}
		return element;
	}
	public PartieDeJeu[] getPartieDeJeusAPartJSON(JSONArray json) throws Exception {
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();	
		Vector<Object> objectVector=fonctionGeneraliser.find(this,json);
		return objectVector.toArray(new PartieDeJeu[objectVector.size()]);
	}
	public PartieDeJeu[] getPartieDeJeu() throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/PartieDeJeu.php?get=1");
		return getPartieDeJeusAPartJSON(json);
	}
	public PartieDeJeu[] getPartieDeJeuAPartNomPartie(String nomParties) throws Exception {
		GetJson getJson=new GetJson();
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();
		String nomPatriesTmp=fonctionGeneraliser.deleteSeparatorPoint(nomParties);
		String nomPatriesTmp2=fonctionGeneraliser.separatorString(nomPatriesTmp);
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/PartieDeJeu.php?get=2&nomPartie="+nomPatriesTmp2);
		return getPartieDeJeusAPartJSON(json);
	}
	public PartieDeJeu[] getPartieDeJeuAPartIdPartie(int idParties) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/PartieDeJeu.php?&get=3&idPartie="+idParties);
		return getPartieDeJeusAPartJSON(json);
	}
	public PartieDeJeu getPartieDeJeuAPartIdPartieAndIdJoueur(int idParties,int idJoueurs) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/PartieDeJeu.php?&get=4&idPartie="+idParties+"&idJoueur="+idJoueurs);
		return setTableauObjectToObject(getPartieDeJeusAPartJSON(json));
	}
	public PartieDeJeu[] getPartieDeJeuAPartIdJoueur(int idJoueurs) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/PartieDeJeu.php?&get=5&idJoueur="+idJoueurs);
		return getPartieDeJeusAPartJSON(json);
	}
	public PartieDeJeu getPartieDeJeuRecent() throws Exception {
		PartieDeJeu []partieDeJeus=getPartieDeJeu();
		if(partieDeJeus.length>0) {
			return partieDeJeus[partieDeJeus.length-1];
		}
		return null;
	}
	public PartieDeJeu getPartieDeJeuRecent(int idJoueurs) throws Exception {
		PartieDeJeu []partieDeJeu=getPartieDeJeuAPartIdJoueur(idJoueurs);
		if(partieDeJeu.length>0) {
			return partieDeJeu[partieDeJeu.length-1];
		}else {
			Dates dates=new Dates();
			return new PartieDeJeu(0, "",dates, 0,0,0,"","",0,0,0,"");
		}
	}
	public Object[][] setTableauToObject(PartieDeJeu []partieDeJeus){
		int size=partieDeJeus.length;
		Object [][]objects=new Object[size][3];
		for(int i=0;i<size;i++) {
			objects[i][0]=partieDeJeus[i].getNomPartie();
			objects[i][1]=partieDeJeus[i].getNomJoueur();
			objects[i][2]=partieDeJeus[i].getDatePartie().getDates();
		}
		return objects;
	}
}
