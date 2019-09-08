package entite;

import java.util.Vector;

import org.json.JSONArray;

import js.GetJson;

public class Sac {
	int idSac=0;
	int idPartie=0;
	String lettre="";
	public Sac() {}
	public Sac(int idSac, int idPartie, String lettre) {
		this.idSac = idSac;
		this.idPartie = idPartie;
		this.lettre = lettre;
	}
	public int getIdSac() {
		return idSac;
	}
	public void setIdSac(int idSac) {
		this.idSac = idSac;
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
	public Sac getContenuSacOriginale(int idParties) {
		Points points=new Points();
		Vector<Points> vector=points.getContenuSacOriginaleVector();
		int size=vector.size();
		String sacOriginale=""+vector.get(0).getLettre();
		for(int i=1;i<size;i++) {
			sacOriginale=sacOriginale+","+vector.get(i).getLettre();
		}
		Sac sac=new Sac(1, idParties, sacOriginale);
		return sac;
	}
	public boolean updateDansBaseSac(int idParties,String lettres) {
		GetJson getJson=new GetJson();
		try {
			getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Sac.php?numero=3&idPartie="+idParties+"&lettre="+lettres);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
	public boolean reinitialiserSac(int idParties) {
		Sac sac=getContenuSacOriginale(idParties);
		GetJson getJson=new GetJson();
		try {
			getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Sac.php?numero=3&idPartie="+idParties+"&lettre="+sac.getLettre());
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
	public Vector<String> getVector(String []sac) {
		Vector<String> vector=new Vector<String>();
		for(int i=0;i<sac.length;i++) {
			vector.add(sac[i]);
		}
		return vector;
	}
	public Object[] getContenuSacObject(Sac sacs) {
		return sacs.getLettre().split(",");
	}
	public Sac setTableauObjectToObject(Sac []elements) {
		Sac element=null;
		for(Sac elementTmp :elements) {
			element=elementTmp;
		}
		return element;
	}
	public Sac[] getJSON(JSONArray json) throws Exception {
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();	
		Vector<Object> objectVector=fonctionGeneraliser.find(this,json);
		return objectVector.toArray(new Sac[objectVector.size()]);
	}
	public Sac getSacAPartidPartie(int idParties) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/Sac.php?numero=1&get=2&idPartie="+idParties);
		return setTableauObjectToObject(getJSON(json));
	}
	public Vector<String> getContenuSacTmp(Sac sacs) {
		return getVector(sacs.getLettre().split(","));
	}
	public Vector<Points> getContenuSac(int idParties) throws Exception {
		Points points=new Points();
		Sac sacs=getSacAPartidPartie(idParties);
		return points.creationPoints(sacs);
	}
	public String vectorToString(Vector<Points> vector) throws Exception {
		String lettres="";
		int size=vector.size();
		if(size>0) {
			lettres=""+vector.get(0).getLettre();
			for(int i=0;i<size;i++) {
				lettres=lettres+","+vector.get(i).getLettre();
			}
		}
		return lettres;
	}
	public void ajout(Boutton []bouttons,Vector<Points> points) {
		int size=points.size(),size2=bouttons.length;
		if(size>0) {
			for(int i=0;i<size2;i++) {
				if(bouttons[i].getNomImage().equals("")) {
					bouttons[i].setNom(points.get(0).getLettre());
					bouttons[i].setText(points.get(0).getLettre());
					bouttons[i].setImage(""+points.get(0).getNumero()+".jpg");
					points.remove(0);
					break;
				}
			}
		}
	} 
	public Vector<Points> ajoutDansChevalet(int idParties,int idJoueurs) throws Exception {
		Chevaler chevaler=new Chevaler();
		Chevaler chevaler2=chevaler.getChevalerAPartidPartieAndIdJoueur(idParties, idJoueurs);
		return chevaler.changerStringEnVectorString(chevaler2.getLettre());
	} 
	public Vector<String> getPartieSac(Sac sac,int nombre){
		Points fonctionPoints=new Points();
		Vector<Points> vector=fonctionPoints.creationPoints(sac);
		if(vector.size()>=nombre && nombre!=0) {
			Vector<String> strings=new Vector<String>();
			for(int i=0;i<nombre;i++) {
				strings.add(vector.get(i).getLettre());
				vector.remove(i);
			}
			updateDansBaseSac(sac.getIdPartie(), "A");
			return strings;
		}
		return null;
	}
	public void changerChevalerEtSacTmp(Sac sac,int idJoueurs,String lettres,Boutton []bouttons) throws Exception {
		Points fonctionPoints=new Points();
		AideFonction2 aideFonction2=new AideFonction2();
		Vector<Points> points=fonctionPoints.creationPoints(sac);
		fonctionPoints.melangePoints(points);
		int size=points.size(),size2=bouttons.length;
		if(size>0) {
			Points newPoints=points.get(0);
			points.remove(0);
			points.add(fonctionPoints.find(lettres));
			String newLettre=vectorToString(points);
			updateDansBaseSac(sac.getIdPartie(),newLettre);
			String chevalerLettre="";
			boolean test=false;
			for(int i=0;i<size2;i++) {
				if(bouttons[i].getNom().equals(""+aideFonction2.getNumero(lettres)) && test==false) {
					chevalerLettre=chevalerLettre+newPoints.getLettre();
					test=true;
				}else {
					chevalerLettre=chevalerLettre+aideFonction2.getLettre(bouttons[i].getNom());
				}
			}
			System.out.println("chevalerLettre="+chevalerLettre);
			Chevaler chevaler=new Chevaler();
			chevaler.updateChevalerTmp(sac.getIdPartie(), idJoueurs, chevalerLettre, 1);
		}
	}
	
}
