package entite;

import java.util.Vector;

import org.json.JSONArray;

import js.GetJson;

public class Tour {
	int idTour=0;
	int idPartie=0;
	String rang="";
	int idJoueur=0;
	public Tour() {}
	public Tour(String rang) {
		this.rang = rang;
	}
	public Tour(int idTour, int idPartie, String rang, int idJoueur) {
		this.idTour = idTour;
		this.idPartie = idPartie;
		this.rang = rang;
		this.idJoueur = idJoueur;
	}
	public int getIdTour() {
		return idTour;
	}
	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}
	public int getIdPartie() {
		return idPartie;
	}
	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}
	public String getRang() {
		return rang;
	}
	public void setRang(String rang) {
		this.rang = rang;
	}
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public Tour setTableauObjectToObject(Tour []elements) {
		Tour element=null;
		for(Tour elementTmp :elements) {
			element=elementTmp;
		}
		return element;
	}
	public Tour[] getJSON(JSONArray json) throws Exception {
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();	
		Vector<Object> objectVector=fonctionGeneraliser.find(this,json);
		return objectVector.toArray(new Tour[objectVector.size()]);
	}
	public Tour getTourAPartidPartie(int idParties) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/tour.php?numero=1&get=1&idPartie="+idParties);
		return setTableauObjectToObject(getJSON(json));
	}
	public boolean updateDeleteInserte(String url) {
		GetJson getJson=new GetJson();
		try {
			getJson.addDansLaBaseDeDonnee(url);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
	public void insertTour(int idParties,int idJoueur1,String rangs) {
		updateDeleteInserte("http://localhost/jeuScrabble/tour.php?numero=2&idPartie="+idParties+"&idJoueur="+idJoueur1+"&rang="+rangs);
	}
	public void updateTour(int idParties,int idJoueur1s) {
		updateDeleteInserte("http://localhost/jeuScrabble/tour.php?numero=3&idPartie="+idParties+"&idJoueur="+idJoueur1s);
	}
	public int getTours(int idParties) throws Exception {
		Tour tour=getTourAPartidPartie(idParties);
		return tour.getIdJoueur();
	}
	public boolean verification(int idParties) throws Exception {
		Tour tour=getTourAPartidPartie(idParties);
		if(tour==null) {
			return true;
		}
		return false;
	}
	
	public String getRangFirst(String rangs) throws Exception {
		String []splitString=rangs.split("|");
		if(splitString.length>0) {
			return splitString[0];
		}
		return null;
	}
	public String getOuiOrNon(int idJoueur1,int idJoueur2) throws Exception {
		if(idJoueur1==idJoueur2) {
			return "oui";
		}else {
			return "non";
		}
	}
	public Object[][] getRangTour(int idParties) throws Exception {
		Tour tours=getTourAPartidPartie(idParties);
		String []splitString=tours.getRang().split("|");int size=splitString.length;
		Object [][]objects=new Object[size][3];
		PartieDeJeu partieDeJeu=new PartieDeJeu();
		int a=1;
		for(int i=0;i<size;i++) {
			int idJoueurs=0;
			try {
				idJoueurs=Integer.parseInt(splitString[i]);
			} catch (Exception e) {
				idJoueurs=0;
			}
			if(idJoueurs!=0) {
				partieDeJeu=partieDeJeu.getPartieDeJeuAPartIdPartieAndIdJoueur(idParties,idJoueurs);	
				objects[i][0]=a;
				objects[i][1]=partieDeJeu.getNomJoueur();
				objects[i][2]=getOuiOrNon(idJoueurs, tours.getIdJoueur());a++;
			}
		}
		return objects;
	}
	public void insertionTour(int idParties,String rangs) throws Exception {
		boolean test=verification(idParties);String first=getRangFirst(rangs);
		if(test==true && first!=null) {
			insertTour(idParties,Integer.parseInt(first), rangs);
		}
	}
	public void setTours(int idParties,Parametre parametre) throws Exception {
		Tour tour=getTourAPartidPartie(idParties);
		String []tableau=(tour.getRang()).split("\\|");int size=tableau.length;
		int indice=0;
		for(int i=0;i<size;i++) {
			if(tableau[i].equals(""+tour.getIdJoueur())) {
				if(parametre.getNombreDeJoueur()==2) {
					indice=(i+1)%2;
				}else {
					indice=(i+1)%4;
				}
			}
		}
		updateTour(tour.getIdPartie(),Integer.parseInt(tableau[indice]));
	}
	
}
