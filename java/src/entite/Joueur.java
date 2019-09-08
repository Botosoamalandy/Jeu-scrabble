package entite;

import java.util.Vector;

import org.json.JSONArray;

import js.GetJson;

public class Joueur {
	int idJoueur=0;
	String nomJoueur="";
	String description="";
	int rand=0;
	int tour=0;
	double score=0;
	String chevaler="";
	public Joueur() {}
	public Joueur(int idJoueur, String nomJoueur, String description, int rand, int tour, double score,String chevaler) {
		this.idJoueur = idJoueur;
		this.nomJoueur = nomJoueur;
		this.description = description;
		this.rand = rand;
		this.tour = tour;
		this.score = score;
		this.chevaler = chevaler;
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
	public Joueur[] getJoueur() throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/Joueur.php?numero=1&get=1");
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();	
		Vector<Object> objectVector=fonctionGeneraliser.find(this,json);
		return objectVector.toArray(new Joueur[objectVector.size()]);
	}
	public int login(String nomJoueurDansInterface) throws Exception {
		Joueur []joueurs=getJoueur();
		int size=joueurs.length;
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();
		String nomJoueurSansEspace=fonctionGeneraliser.separatorString(nomJoueurDansInterface);
		for(int i=0;i<size;i++) {
			if(nomJoueurSansEspace.equals(joueurs[i].getNomJoueur())){
				return joueurs[i].getIdJoueur();
			}
		}
		return 0;
	}
	public boolean inscription(String nomJoueurs,String descriptions) throws Exception {
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();
		String nomJoueurSansEspace=fonctionGeneraliser.separatorString(nomJoueurs),
		descriptionSansEspace=fonctionGeneraliser.separatorString(descriptions);
		int verifierNomDansBase=login(nomJoueurSansEspace);
		if(verifierNomDansBase!=0 && verifierNomDansBase>0 || nomJoueurs.equals("")){
			return false;
		}else {
			GetJson getJson=new GetJson();
			if(descriptionSansEspace.equals("")) {
				descriptionSansEspace="Description_vide";
			}
			getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Joueur.php?numero=2&nomJoueur="+nomJoueurSansEspace+"&description="+descriptionSansEspace);
			return true;
		}
	}
	public void updateNom(String nomJoueurs,int idJoueurs) throws Exception {
		GetJson getJson=new GetJson();
		getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Joueur.php?numero=4&nomJoueur="+nomJoueurs+"&idJoueur="+idJoueurs);	
	}
}
