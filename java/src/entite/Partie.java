package entite;

import java.util.Vector;
import org.json.JSONArray;
import js.GetJson;

public class Partie {
	int idPartie=0;
	String nomPartie="";
	Dates datePartie=new Dates();
	int premierCoup=0;
	int fin=0;
	public Partie() {}
	public Partie(int idPartie, String nomPartie, Dates datePartie,int premierCoup,int fin) {
		this.idPartie = idPartie;
		this.nomPartie = nomPartie;
		this.datePartie = datePartie;
		this.premierCoup = premierCoup;
		this.fin = fin;
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
	public int getPremierCoup() {
		return premierCoup;
	}
	public void setPremierCoup(int premierCoup) {
		this.premierCoup = premierCoup;
	}
	public int getFin() {
		return fin;
	}
	public void setFin(int fin) {
		this.fin = fin;
	}
	public Partie setTableauObjectToObject(Partie []elements) {
		Partie element=null;
		for(Partie elementTmp :elements) {
			element=elementTmp;
		}
		return element;
	}
	public Partie[] getPartie() throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/Partie.php?numero=1&get=1");
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();	
		Vector<Object> objectVector=fonctionGeneraliser.find(this, json);
		return objectVector.toArray(new Partie[objectVector.size()]);
	}
	public Partie[] getPartieAPartIdPartie(int idParties) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/Partie.php?numero=1&get=3&idPartie="+idParties);
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();	
		Vector<Object> objectVector=fonctionGeneraliser.find(this, json);
		return objectVector.toArray(new Partie[objectVector.size()]);
	}
	public Partie getPartieAPartNomPartie(String nomParties) throws Exception {
		GetJson getJson=new GetJson();
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();
		String nomPatriesTmp=fonctionGeneraliser.deleteSeparatorPoint(nomParties);
		String nomPartieSansEspace=fonctionGeneraliser.separatorString(nomPatriesTmp);
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/Partie.php?numero=1&get=2&nomPartie="+nomPartieSansEspace);
		Vector<Object> objectVector=fonctionGeneraliser.find(this, json);
		return setTableauObjectToObject(objectVector.toArray(new Partie[objectVector.size()]));
	}
	public boolean verificationInsertion(String nomPartieSansEspace) throws Exception {
		Partie []parties=getPartie();
		int size=parties.length;
		for(int i=0;i<size;i++) {
			if(nomPartieSansEspace.equals(parties[i].getNomPartie())) {
				return true;
			}
		}
		return false;
	}
	public void updatePartie(int idParties) {
		GetJson getJson=new GetJson();
		try {
			getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Partie.php?numero=3&idPartie="+idParties);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateFinPartie(int idParties) {
		GetJson getJson=new GetJson();
		try {
			getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Partie.php?numero=4&idPartie="+idParties);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean creerPartie(String nomParties,String nombreDeJoueur,String scoreMaximale,int idJoueurs) throws Exception {
		GetJson getJson=new GetJson();
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();
		String nomPartieSansEspace=fonctionGeneraliser.separatorString(nomParties);
		boolean verificationDoublantDansBase=verificationInsertion(nomPartieSansEspace);
		try {
			if(verificationDoublantDansBase==false) {
				//insertion partie
				getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Partie.php?numero=2&nomPartie="+nomPartieSansEspace);
				Partie partie=getPartieAPartNomPartie(nomPartieSansEspace);
				//insertion sac
				Sac sac=new Sac();
				Sac sacs=sac.getContenuSacOriginale(partie.getIdPartie());
				getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Sac.php?numero=2&idPartie="+sacs.getIdPartie()+"&lettre="+sacs.getLettre());
				//insertion parametre
				if(scoreMaximale.equals("Illimiter")) {
					scoreMaximale="1001";
				}
				getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Parametre.php?numero=2&idPartie="+partie.getIdPartie()+"&nombreDeJoueur="+nombreDeJoueur+"&scoreMax="+scoreMaximale);
				//insertion serveur
				getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Serveur.php?numero=2&idPartie="+partie.getIdPartie()+"&idJoueur="+idJoueurs+"&serveur=1");
				return true;
			}
		}catch (Exception e) {
			return false;
		}
		return false;		
	}
	public boolean getPremierCoup(int idParties,boolean resultat, ValeurAttribut valeur) throws Exception {
		Partie partie=setTableauObjectToObject(getPartieAPartIdPartie(idParties));
		int size=valeur.getBouttons().size();
		if(partie.getPremierCoup()==0) {
			if(size>0) {
				updatePartie(idParties);
				return true;
			}else {
				return false;
			}
		}else {
			return resultat;
		}
	}	
}
