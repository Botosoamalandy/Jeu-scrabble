package entite;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.json.JSONArray;

import js.GetJson;

public class Plateau {
	int idPlateau=0;
	int idPartie=0;
	int indiceX=0;
	int indiceY=0;
	String lettre="";
	String image="";
	String ancienImage="";
	public Plateau() {}
	public Plateau(int idPlateau, int idPartie, int indiceX, int indiceY, String lettre, String image,String ancienImage) {
		this.idPlateau = idPlateau;
		this.idPartie = idPartie;
		this.indiceX = indiceX;
		this.indiceY = indiceY;
		this.lettre = lettre;
		this.image = image;
		this.ancienImage = ancienImage;
	}
	public int getIdPlateau() {
		return idPlateau;
	}
	public void setIdPlateau(int idPlateau) {
		this.idPlateau = idPlateau;
	}
	public int getIdPartie() {
		return idPartie;
	}
	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}
	public int getIndiceX() {
		return indiceX;
	}
	public void setIndiceX(int indiceX) {
		this.indiceX = indiceX;
	}
	public int getIndiceY() {
		return indiceY;
	}
	public void setIndiceY(int indiceY) {
		this.indiceY = indiceY;
	}
	public String getLettre() {
		return lettre;
	}
	public void setLettre(String lettre) {
		this.lettre = lettre;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAncienImage() {
		return ancienImage;
	}
	public void setAncienImage(String ancienImage) {
		this.ancienImage = ancienImage;
	}
	public Plateau setTableauObjectToObject(Plateau []elements) {
		Plateau element=null;
		for(Plateau elementTmp :elements) {
			element=elementTmp;
		}
		return element;
	}
	public Plateau[] getJSON(JSONArray json) throws Exception {
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();	
		Vector<Object> objectVector=fonctionGeneraliser.find(this,json);
		return objectVector.toArray(new Plateau[objectVector.size()]);
	}
	public Plateau[] getPlateauAPartidPartie(int idParties) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/Plateau.php?numero=1&get=2&idPartie="+idParties);
		return getJSON(json);
	}
	public Plateau getOnePlateauAPartidPartie(int idParties) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/Plateau.php?numero=1&get=3&idPartie="+idParties);
		return setTableauObjectToObject(getJSON(json));
	}
	public List<Plateau> changeTableauButtonToTableauPlateau(Boutton [][]bouttons,int idParties) {
		int size1=15;
		List<Plateau> plateaus=new ArrayList<Plateau>();
		int p=0;
		for(int i=0;i<size1;i++) {
			for(int a=0;a<size1;a++) {
				plateaus.add(new Plateau(p,idParties,i,a,bouttons[i][a].getText(),bouttons[i][a].getNomImage(),bouttons[i][a].getNomAncientImage()));
			}
		}
		return plateaus;
	}
	public boolean insertionDansBase(Plateau plateau) {
		GetJson getJson=new GetJson();
		try {
			getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Plateau.php?numero=2&idPartie="+plateau.getIdPartie()+"&indiceX="+plateau.getIndiceX()+"&indiceY="+plateau.getIndiceY()+"&lettre="+plateau.getLettre()+"&image="+plateau.getImage()+"&ancienImage="+plateau.getAncienImage());
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
	public boolean updateDansBase(Plateau plateau) {
		GetJson getJson=new GetJson();
		try {
			getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/PLateau.php?numero=3&idPartie="+plateau.getIdPartie()+"&indiceX="+plateau.getIndiceX()+"&indiceY="+plateau.getIndiceY()+"&lettre="+plateau.getLettre()+"&image="+plateau.getImage()+"&ancienImage="+plateau.getAncienImage());
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}	
	public void insertionPlateau(Boutton [][]bouttons,int idParties) {
		List<Plateau> plateaus=changeTableauButtonToTableauPlateau(bouttons,idParties);
		int size=plateaus.size();
		for(int i=0;i<size;i++) {
			insertionDansBase(plateaus.get(i));
		}
	}
	
	public boolean verficationInsertion(int idParties) throws Exception {
		Plateau plateau=getOnePlateauAPartidPartie(idParties);
		if(plateau==null) {
			return true;
		}else {
			return false;
		}
	}
	public void insertionPlateauInitiale(int idParties) throws Exception {
		boolean verification=verficationInsertion(idParties);
		if(verification==true) {
			Boutton boutton=new Boutton();
			Boutton [][]bouttons=new Boutton[15][15];
			boutton.initialisationSimpleDuBoutton(bouttons);
			insertionPlateau(bouttons, idParties);
		}
	}
	public void plateauToBoutton(Plateau []plateaus,Boutton [][]bouttons){
		int size2=plateaus.length;
		for(int e=0;e<size2;e++) {
			int i=plateaus[e].getIndiceX(),a=plateaus[e].getIndiceY();
			bouttons[i][a].setImage(plateaus[e].getImage());
			bouttons[i][a].setNomAncientImage(plateaus[e].getAncienImage());
			bouttons[i][a].setText(plateaus[e].getLettre());
			bouttons[i][a].setNom(plateaus[e].getLettre());
		}
	}
	public void actualisationPlateau(Boutton [][]bouttons,int idParties) throws Exception {
		Plateau []plateaus=getPlateauAPartidPartie(idParties);
		plateauToBoutton(plateaus, bouttons);
	}
	public Plateau creationBoutton(Boutton bouttons,int idParties,int choix) throws Exception {
		Points points=new Points();
		String lettres=points.chiffreToLettre(bouttons.getNom());
		if(choix==1) {
			return new Plateau(1, idParties, bouttons.getIndiceX(), bouttons.getIndiceY(),lettres,bouttons.getNom()+".jpg",bouttons.getNom()+".jpg");
		}else {
			return new Plateau(1, idParties, bouttons.getIndiceX(), bouttons.getIndiceY(),"",bouttons.getImageVide(),bouttons.getImageVide());
		}
	}
	public void updatePlateau(ValeurAttribut valeur,int idParties) throws Exception {
		List<Boutton> list=valeur.getBouttons();
		int size2=list.size();
		for(int e=0;e<size2;e++) {
			updateDansBase(creationBoutton(list.get(e),idParties,1));
		}
	}
	public void updatePlateauRetour(ValeurAttribut valeur,int idParties) throws Exception {
		List<Boutton> list=valeur.getBouttons();
		int size2=list.size();
		for(int e=0;e<size2;e++) {
			updateDansBase(creationBoutton(list.get(e),idParties,2));
		}
	}
	public boolean premierCoup(int idParties,boolean resulatat) throws Exception {
		Plateau []plateaus=getPlateauAPartidPartie(idParties);
		int size2=plateaus.length;
		for(int e=0;e<size2;e++) {
			if(!plateaus[e].getLettre().equals("")) {
				return resulatat;
			}
		}
		return true;
	}
	
}
