package entite;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JPanel;

import org.json.JSONArray;

import js.GetJson;

public class Parametre {
	int idParametre=0;
	int idPartie=0;
	int nombreDeJoueur=4;
	double scoreMax=0;
	public Parametre() {}
	public Parametre(int idParametre, int idPartie, int nombreDeJoueur, double scoreMax) {
		this.idParametre = idParametre;
		this.idPartie = idPartie;
		this.nombreDeJoueur = nombreDeJoueur;
		this.scoreMax = scoreMax;
	}
	public int getIdParametre() {
		return idParametre;
	}
	public void setIdParametre(int idParametre) {
		this.idParametre = idParametre;
	}
	public int getIdPartie() {
		return idPartie;
	}
	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}
	public int getNombreDeJoueur() {
		return nombreDeJoueur;
	}
	public void setNombreDeJoueur(int nombreDeJoueur) {
		this.nombreDeJoueur = nombreDeJoueur;
	}
	public double getScoreMax() {
		return scoreMax;
	}
	public void setScoreMax(double scoreMax) {
		this.scoreMax = scoreMax;
	}
	public Parametre setTableauObjectToObject(Parametre []elements) {
		Parametre element=null;
		for(Parametre elementTmp :elements) {
			element=elementTmp;
		}
		return element;
	}
	public Parametre[] getJSON(JSONArray json) throws Exception {
		FonctionGeneraliser fonctionGeneraliser=new FonctionGeneraliser();	
		Vector<Object> objectVector=fonctionGeneraliser.find(this,json);
		return objectVector.toArray(new Parametre[objectVector.size()]);
	}
	public Parametre getParametreAPartidPartie(int idParties) throws Exception {
		GetJson getJson=new GetJson();
		JSONArray json=getJson.getJson("http://localhost/jeuScrabble/Parametre.php?numero=1&get=2&idPartie="+idParties);
		return setTableauObjectToObject(getJSON(json));
	}
	public void updateScore(int scores,int idParametres) throws Exception {
		GetJson getJson=new GetJson();
		getJson.addDansLaBaseDeDonnee("http://localhost/jeuScrabble/Parametre.php?numero=3&scoreMax="+scores+"&idParametre="+idParametres);	
	}
	public boolean verification(int idParties) throws Exception {
		Serveur serveur=new Serveur();
		Serveur []serveurs=serveur.getServeurAPartidPartie(idParties);
		Parametre parametre=getParametreAPartidPartie(idParties);
		int size=serveurs.length;
		if(size==parametre.getNombreDeJoueur()) {
			return true;
		}	
		return false;
	}
	public boolean verificationChevaler(Boutton []bouttons) throws Exception {
		int size=bouttons.length;
		boolean test=false;
		for(int i=0;i<size;i++) {
			if(bouttons[i].getNomImage().equals("")) {
				test=true;
			}
		}
		if(test==false) {
			return true;
		}else {
			return false;
		}
	}
	public void couleurPanel(JPanel panel,PartieDeJeu partieDeJeus) throws Exception {
		Chevaler chevaler=new Chevaler();
		Chevaler chevaler2=chevaler.getChevalerAPartidPartieAndIdJoueur(partieDeJeus.getIdPartie(),partieDeJeus.getIdJoueur());
		if(panel!=null) {
			panel.setBackground(Color.RED);
		}
		if(partieDeJeus!=null && chevaler2!=null) {
			if(chevaler2.getCouleur()==1) {
				panel.setBackground(Color.GREEN);
			}
		}
	}
	public void allCouleurPanel(JPanel panel1,JPanel panel2,JPanel panel3,JPanel panel4,PartieDeJeu []partieDeJeus,Parametre parametre) throws Exception {
		couleurPanel(panel1, partieDeJeus[0]);
		couleurPanel(panel2, partieDeJeus[1]);
		if(parametre.getNombreDeJoueur()==4 && partieDeJeus.length==4) {
			couleurPanel(panel3, partieDeJeus[2]);
			couleurPanel(panel4, partieDeJeus[3]);
		}
	}
	public boolean verficationSiCouleurSonTousVert(int idParties) throws Exception {
		Chevaler chevaler=new Chevaler();
		Chevaler []chevalers=chevaler.getChevalerAPartidPartie(idParties);
		int size=chevalers.length;
		for(int i=0;i<size;i++) {
			if(chevalers[i].getCouleur()==0) {
				return false;
			}
		}
		return true;
	}
	public Chevaler comparaisonDeuxPoints(Vector<Points> vector,Vector<Points> vector2,Chevaler idJoueur1,Chevaler idJoueur2) {
		Points fonctionPoints=new Points();
		fonctionPoints.trierPoint(vector);fonctionPoints.trierPoint(vector2);
		int size=vector.size();
		for(int i=0;i<size;i++) {
			if(vector.get(i).getNumero()>vector2.get(i).getNumero()) {
				return idJoueur1;
			}else if(vector.get(i).getNumero()<vector2.get(i).getNumero()) {
				return idJoueur2;
			}
		}
		return idJoueur1;
	}
	public Chevaler[] getRangTmp(Vector<Points> vector,Vector<Points> vector2,Chevaler idJoueur1,Chevaler idJoueur2) {
		Chevaler []resultat=new Chevaler[2];
		Chevaler tmp=comparaisonDeuxPoints(vector, vector2, idJoueur1, idJoueur2);
		if(tmp.getIdJoueur()==idJoueur1.getIdJoueur()) {
			resultat[0]=idJoueur1;
			resultat[1]=idJoueur2;
		}else {
			resultat[0]=idJoueur2;
			resultat[1]=idJoueur1;
		}
		return resultat;
	}
	public Vector<Chevaler> getRangTmp(Chevaler []chevalers) {
		Vector<Chevaler> resultat=new Vector<Chevaler>();int size=chevalers.length;
		for(int i=0;i<size;i++) {
			resultat.add(chevalers[i]);
		}
		return resultat;
	}
	
	public Vector<Chevaler> rang(Chevaler []chevalers,Chevaler chevaler,Parametre parametre) {
		Vector<Chevaler> vector=new Vector<Chevaler>();
		Chevaler[] tmp=getRangTmp(chevaler.changerStringEnVectorString(chevalers[0].getLettre()),chevaler.changerStringEnVectorString(chevalers[1].getLettre()),chevalers[0],chevalers[1]);
		if(parametre.getNombreDeJoueur()==2) {
			vector=getRangTmp(tmp);
			System.out.println("joueur ok");
			for(int i=0;i<vector.size();i++) {
				System.out.println("rang"+i+"="+vector.get(i).getIdJoueur());
			}
		}else{
			Chevaler []tmp2=getRangTmp(chevaler.changerStringEnVectorString(chevalers[2].getLettre()),chevaler.changerStringEnVectorString(chevalers[3].getLettre()),chevalers[2],chevalers[3]);
			Chevaler []tmp3=getRangTmp(chevaler.changerStringEnVectorString(tmp[0].getLettre()),chevaler.changerStringEnVectorString(tmp2[0].getLettre()),tmp[0],tmp2[0]);
			Chevaler []tmp4=getRangTmp(chevaler.changerStringEnVectorString(tmp[1].getLettre()),chevaler.changerStringEnVectorString(tmp2[1].getLettre()),tmp[1],tmp2[1]);
			vector.add(tmp3[0]);
			vector.add(tmp3[1]);
			vector.add(tmp4[0]);
			vector.add(tmp4[1]);
		}
		return vector;
	}
	
	public String getRang(int idParties) throws Exception {
		Chevaler chevaler=new Chevaler();
		Parametre fonctionParametre=new Parametre();
		Chevaler []chevalers=chevaler.getChevalerAPartidPartie(idParties);
		Parametre parametre=fonctionParametre.getParametreAPartidPartie(idParties);
		Vector<Chevaler> vector=rang(chevalers, chevaler, parametre);
		String rangs="";
		for(int i=0;i<vector.size();i++) {
			rangs=rangs+vector.get(i).getIdJoueur()+"|";
		}
		return rangs;
	}
	public void modificationParametre(String nom,String score,Parametre parametre,PartieDeJeu partieDeJeu) throws Exception {
		String noms="";int scores=0;
		if(score.equals("Illimiter")) {
			scores=10001;
		}else {
			scores=Integer.parseInt(score);
		}
		if(nom.equals("Nom") || nom.equals("")) {
			noms=partieDeJeu.getNomJoueur();
		}else {
			noms=nom;
		}
		Joueur joueur=new Joueur();
		joueur.updateNom(noms, partieDeJeu.getIdJoueur());
		updateScore(scores, parametre.getIdParametre());
	}
	public Parametre getNewParametre(Parametre parametre) throws Exception {
		if(parametre==null) {
			return new Parametre(0,0, 0,0);
		}else {
			return parametre;
		}
	}
	public boolean getTestLancerJeuSiJoueurComprisDansLaPartie(String nomParties,int idJoueurs) throws Exception {
		Partie partie=new Partie();
		partie=partie.getPartieAPartNomPartie(nomParties);
		PartieDeJeu partieDeJeu=new PartieDeJeu();
		partieDeJeu=partieDeJeu.getPartieDeJeuAPartIdPartieAndIdJoueur(partie.getIdPartie(), idJoueurs);
		if(partieDeJeu!=null) {
			return true;
		}
		return false;
	}
}
