package entite;

import java.util.Vector;

import org.json.JSONArray;

import js.GetJson;

public class Serveur {
	int idServeur=0;
	int idPartie=0;
	int idJoueur=0;
	int serveur=0;
	public Serveur() {}
	public Serveur(int idServeur, int idPartie, int idJoueur, int serveur) {
		this.idServeur = idServeur;
		this.idPartie = idPartie;
		this.idJoueur = idJoueur;
		this.serveur = serveur;
	}
	public int getIdServeur() {
		return idServeur;
	}
	public void setIdServeur(int idServeur) {
		this.idServeur = idServeur;
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
	public int getServeur() {
		return serveur;
	}
	public void setServeur(int serveur) {
		this.serveur = serveur;
	}
	public Serveur[] getPartieDeJeusAPartJSON(JSONArray json) throws Exception {
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();	
		Vector<Object> objectVector=fonctionGeneraliser.find(this,json);
		return objectVector.toArray(new Serveur[objectVector.size()]);
	}
	public Serveur[] getServeurAPartidPartie(int idParties) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/Serveur.php?numero=1&get=2&idPartie="+idParties);
		return getPartieDeJeusAPartJSON(json);
	}
	public boolean verificationInsertion(int idParties,int idJoueurs,Parametre parametre) throws Exception {
		Serveur []serveurs=getServeurAPartidPartie(idParties);
		int size=serveurs.length;int nbr=parametre.getNombreDeJoueur();
		if(nbr==4 && size==4 || nbr==2 && size==2) {
			return true;
		}
		for(int i=0;i<size;i++) {
			if(serveurs[i].getIdJoueur()==idJoueurs && serveurs[i].getIdPartie()==idParties) {
				return true;
			}
		}
		return false;
	}
	public boolean insertionServeur(String nomParties,int idJoueurs) throws Exception {
		Partie partie=new Partie();
		GetJson getJson=new GetJson();
		Parametre parametre=new Parametre();
		Partie partie2=partie.getPartieAPartNomPartie(nomParties);
		parametre=parametre.getParametreAPartidPartie(partie2.getIdPartie());
		if(verificationInsertion(partie2.getIdPartie(), idJoueurs,parametre)==false) {
			getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Serveur.php?numero=2&idPartie="+partie2.getIdPartie()+"&idJoueur="+idJoueurs+"&serveur=2");
			return true;
		}else {
			return false;
		}
	}
	
}
