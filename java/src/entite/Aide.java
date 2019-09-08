package entite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Aide {
	public Aide() {}
	public List<String> imageFondVide(){
		List<String> image=new ArrayList<String>();
		image.add("fond.jpg");
		for(int i=4;i<9;i++) {
			image.add("fond"+i+".jpg");
		}
		return image;
	}
	public int verticaleOuHorizontalOuQuelconque(ValeurAttribut valeur) {
		List<Boutton> bouttons=valeur.getBouttons();int size=bouttons.size();
		if(size>0) {
			boolean test=true,test2=true;
			int x=bouttons.get(0).getIndiceX(),
			y=bouttons.get(0).getIndiceY();
			for(int i=0;i<size;i++) {
				if(x!=bouttons.get(i).getIndiceX()) {
					test=false;
					break;
				}
			}
			for(int i=0;i<size;i++) {
				if(y!=bouttons.get(i).getIndiceY()) {
					test2=false;
					break;
				}
			}
			if(test==true && test2==true) {
				return 3;
			}else if(test==true) {
				return 1;
			}else if(test2==true){
				return 2;
			}else {
				return 0;
			}
		}
		return 0;
	}
	public List<Integer> creationTabEntier(List<Boutton> bouttons,int choix){
		int size=bouttons.size();
		List<Integer> newList=new ArrayList<Integer>();
		for(int i=0;i<size;i++) {
			if(choix==1) {
				newList.add(bouttons.get(i).getIndiceX());
			}else{
				newList.add(bouttons.get(i).getIndiceY());
			}
		}
		Collections.sort(newList);
		return newList;
	}
	public boolean completeMot(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		int  alignement=verticaleOuHorizontalOuQuelconque(valeur);
		List<Boutton> bouttons=valeur.getBouttons();int size=bouttons.size();
		List<String> listImage=imageFondVide();
		if(size>0) {
			if(alignement>0) {
				if(alignement==1) {//aligne X
					List<Integer> integers=creationTabEntier(bouttons,2);
					int yMin=integers.get(0),yMax=integers.get(integers.size()-1);
					int x=bouttons.get(0).getIndiceX();
					for(int i=yMin;i<yMax;i++) {
						if(listImage.contains(bouttonsTmp[x][i].getNomImage())) {
							return false;
						}
					}
				}else {// aligne y
					List<Integer> integers=creationTabEntier(bouttons,1);
					int xMin=integers.get(0),xMax=integers.get(integers.size()-1);
					int y=bouttons.get(0).getIndiceY();
					for(int i=xMin;i<xMax;i++) {
						if(listImage.contains(bouttonsTmp[i][y].getNomImage())) {
							return false;
						}
					}
				}
			}else {
				return false;
			}
		}
		return true;
	}
	public List<Boutton> getMotAvant(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		int  alignement=verticaleOuHorizontalOuQuelconque(valeur);
		List<String> listImage=imageFondVide();
		List<Boutton> bouttons=valeur.getBouttons();
		List<Boutton> resultat=new ArrayList<Boutton>();
		//String mot="";
		if(alignement==1) {//aligne X
			List<Integer> integers=creationTabEntier(bouttons,2);
			int yMin=integers.get(0);
			int x=bouttons.get(0).getIndiceX();
			int i=yMin-1;
			while(i>=0 && !listImage.contains(bouttonsTmp[x][i].getNomImage())) {
				//mot=bouttonsTmp[x][i].getNom()+mot;
				resultat.add(bouttonsTmp[x][i]);
				i--;
			}
		}else {// aligne y
			List<Integer> integers=creationTabEntier(bouttons,1);
			int xMin=integers.get(0);
			int y=bouttons.get(0).getIndiceY();
			int i=xMin-1;
			while(i>=0 && !listImage.contains(bouttonsTmp[i][y].getNomImage())) {
				//mot=bouttonsTmp[i][y].getNom()+mot;
				resultat.add(bouttonsTmp[i][y]);
				i--;
			}
		}
		
		return resultat;
	}
	public List<Boutton> getMotApres(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		int  alignement=verticaleOuHorizontalOuQuelconque(valeur);
		List<String> listImage=imageFondVide();
		List<Boutton> bouttons=valeur.getBouttons();
		List<Boutton> resultat=new ArrayList<Boutton>();
		//String mot="";
		if(alignement==1) {//aligne X
			List<Integer> integers=creationTabEntier(bouttons,2);
			int yMax=integers.get(integers.size()-1);
			int x=bouttons.get(0).getIndiceX();
			int i=yMax+1;
			while(i<15 && !listImage.contains(bouttonsTmp[x][i].getNomImage())) {
				//mot=mot+bouttonsTmp[x][i].getNom();
				resultat.add(bouttonsTmp[x][i]);
				i++;
			}
		}else {// aligne y
			List<Integer> integers=creationTabEntier(bouttons,1);
			int xMax=integers.get(integers.size()-1);
			int y=bouttons.get(0).getIndiceY();
			int i=xMax+1;
			while(i<15 && !listImage.contains(bouttonsTmp[i][y].getNomImage())) {
				//mot=mot+bouttonsTmp[i][y].getNom();
				resultat.add(bouttonsTmp[i][y]);
				i++;
			}
		}
		return resultat;
	}
	public List<Boutton> getMotComplet(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		int  alignement=verticaleOuHorizontalOuQuelconque(valeur);
		List<Boutton> bouttons=valeur.getBouttons();int size=bouttons.size();
		List<Boutton> resultat=new ArrayList<Boutton>();
		//String mot="";
		if(size>0) {
			if(alignement>0) {
				if(alignement==1) {//aligne X
					List<Integer> integers=creationTabEntier(bouttons,2);
					int yMin=integers.get(0),yMax=integers.get(integers.size()-1);
					int x=bouttons.get(0).getIndiceX();
					for(int i=yMin;i<=yMax;i++) {
						//mot=mot+bouttonsTmp[x][i].getNom();
						resultat.add(bouttonsTmp[x][i]);
						//System.out.println("imageVide="+bouttonsTmp[x][i].getImageVide());
					}
				}else {// aligne y
					List<Integer> integers=creationTabEntier(bouttons,1);
					int xMin=integers.get(0),xMax=integers.get(integers.size()-1);
					int y=bouttons.get(0).getIndiceY();
					for(int i=xMin;i<=xMax;i++) {
						//mot=mot+bouttonsTmp[i][y].getNom();
						resultat.add(bouttonsTmp[i][y]);
						//System.out.println("imageVide="+bouttonsTmp[i][y].getImageVide());
					}
				}
			}
		}
		return resultat;
	}
	//valeur >1
	
	public List<Boutton> getUnionMot(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		Boutton boutton=new Boutton();
		boutton.insertionImageVide(bouttonsTmp);
		List<Boutton> mot=getMotComplet(valeur, bouttonsTmp, bouttonss);
		List<Boutton> avant=getMotAvant(valeur, bouttonsTmp, bouttonss);
		List<Boutton> apres=getMotApres(valeur, bouttonsTmp, bouttonss);
		avant.addAll(mot);
		avant.addAll(apres);
		return avant;
	}
	public String getMotTmp(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss,List<Boutton> liste) {
		int size=liste.size();
		String motComplet="";
		for(int i=0;i<size;i++) {
			motComplet=motComplet+liste.get(i).getNom();
		}
		return motComplet;
	}
	public long getScoreMotTmp(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss,List<Boutton> liste) {
		PointsSpeciale pointsSpeciale=new PointsSpeciale();
		return pointsSpeciale.getScoreTmp(valeur,liste);
	}
	public Object [][] getMotEtScoreMot(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		List<Boutton> liste=getUnionMot(valeur, bouttonsTmp, bouttonss);
		Object [][]resultat=new Object[1][2];
		resultat[0][0]=getMotTmp(valeur, bouttonsTmp, bouttonss, liste);
		resultat[0][1]=getScoreMotTmp(valeur, bouttonsTmp, bouttonss, liste);
		return resultat;
	}
	//end
	public List<Boutton> getMotAvantUneSeuleVerticaleAvant(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		List<String> listImage=imageFondVide();
		List<Boutton> bouttons=valeur.getBouttons();
		List<Boutton> resultat=new ArrayList<Boutton>();
		//String mot="";
		int yMin=bouttons.get(bouttons.size()-1).getIndiceY();
		int x=bouttons.get(0).getIndiceX();
		int i=yMin-1;
		while(i>=0 && !listImage.contains(bouttonsTmp[x][i].getNomImage())) {
			//mot=bouttonsTmp[x][i].getNom()+mot;
			resultat.add(bouttonsTmp[x][i]);
			i--;
		}
		return resultat;
	}
	public List<Boutton> getMotApresUneSeuleVerticaleAvant(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		List<String> listImage=imageFondVide();
		List<Boutton> bouttons=valeur.getBouttons();
		List<Boutton> resultat=new ArrayList<Boutton>();
		//String mot="";
		int yMax=bouttons.get(bouttons.size()-1).getIndiceY();
		int x=bouttons.get(0).getIndiceX();
		int i=yMax+1;
		while(i<15 && !listImage.contains(bouttonsTmp[x][i].getNomImage())) {
			//mot=mot+bouttonsTmp[x][i].getNom();
			resultat.add(bouttonsTmp[x][i]);
			i++;
		}
		return resultat;
	}
	public List<Boutton> getMotAvantUneSeuleHorizontaleAvant(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		List<String> listImage=imageFondVide();
		List<Boutton> bouttons=valeur.getBouttons();
		List<Boutton> resultat=new ArrayList<Boutton>();
		//String mot="";
		int xMin=bouttons.get(bouttons.size()-1).getIndiceX();
		int y=bouttons.get(0).getIndiceY();
		int i=xMin-1;
		while(i>=0 && !listImage.contains(bouttonsTmp[i][y].getNomImage())) {
			//mot=bouttonsTmp[i][y].getNom()+mot;
			resultat.add(bouttonsTmp[i][y]);
			i--;
		}
		return resultat;
	}
	public List<Boutton> getMotApresUneSeuleHorizontaleAvant(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		List<String> listImage=imageFondVide();
		List<Boutton> bouttons=valeur.getBouttons();
		List<Boutton> resultat=new ArrayList<Boutton>();
		//String mot="";
		int xMax=bouttons.get(bouttons.size()-1).getIndiceX();
		int y=bouttons.get(0).getIndiceY();
		int i=xMax+1;
		while(i<15 && !listImage.contains(bouttonsTmp[i][y].getNomImage())) {
			//mot=mot+bouttonsTmp[i][y].getNom();
			resultat.add(bouttonsTmp[i][y]);
			i++;
		}
		return resultat;
	}
	public List<Boutton> getMotMilieux(Boutton bouttonss,Boutton [][]bouttonsTmp) {
		AideFonction2 aideFonction2=new AideFonction2();
		Boutton boutton=new Boutton(aideFonction2.getLettre(bouttonss.getNom()),aideFonction2.getLettre(bouttonss.getNom()),Color.white);
		boutton.setIndiceX(bouttonss.getIndiceX());boutton.setIndiceY(bouttonss.getIndiceX());boutton.setImageVide(bouttonsTmp[bouttonss.getIndiceX()][bouttonss.getIndiceX()].getImageVide());
		List<Boutton> bouttonTMp6=new ArrayList<Boutton>();bouttonTMp6.add(boutton);
		return bouttonTMp6;
	}
	public List<Boutton> listInverse(List<Boutton> list){
		List<Boutton> resultat=new ArrayList<Boutton>();int size=list.size();
		for(int i=size-1;i>=0;i--) {
			resultat.add(list.get(i));
		}
		return resultat;
	}
	//begin
	public List<Boutton> getUnionMotUneSeuleVerticale(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss,List<Boutton> milieux) {
		List<Boutton> avantVerticale=listInverse(getMotAvantUneSeuleVerticaleAvant(valeur, bouttonsTmp, bouttonss));
		List<Boutton> apresVerticale=getMotApresUneSeuleVerticaleAvant(valeur, bouttonsTmp, bouttonss);
		avantVerticale.addAll(milieux);
		avantVerticale.addAll(apresVerticale);
		return avantVerticale;
	}
	public List<Boutton> getUnionMotUneSeuleHorizontale(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss,List<Boutton> milieux) {
		List<Boutton> avantHorizontale=listInverse(getMotAvantUneSeuleHorizontaleAvant(valeur, bouttonsTmp, bouttonss));
		List<Boutton> apresHorizontale=getMotApresUneSeuleHorizontaleAvant(valeur, bouttonsTmp, bouttonss);
		avantHorizontale.addAll(milieux);
		avantHorizontale.addAll(apresHorizontale);
		return avantHorizontale;
	}
	public Object[][] getUnionMotUneSeule(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		List<Boutton> milieux=getMotMilieux(valeur.getBouttons().get(0),bouttonsTmp);
		List<Boutton> verticale=getUnionMotUneSeuleVerticale(valeur, bouttonsTmp, bouttonss, milieux);
		List<Boutton> horizontal=getUnionMotUneSeuleHorizontale(valeur, bouttonsTmp, bouttonss, milieux);
		Object [][]objects=new Object[2][2];
		objects[0][0]=getMotTmp(valeur, bouttonsTmp, bouttonss, verticale);
		objects[0][1]=getScoreMotTmp(valeur, bouttonsTmp, bouttonss, verticale);
		objects[1][0]=getMotTmp(valeur, bouttonsTmp, bouttonss, horizontal);
		objects[1][1]=getScoreMotTmp(valeur, bouttonsTmp, bouttonss, horizontal);
		return objects;
	}
	//eding
	public boolean verificationTmp(ValeurAttribut valeur,int x,int y) {
		List<Boutton> liste=valeur.getBouttons();int size=liste.size();
		for(int i=0;i<size;i++) {
			if(liste.get(i).getIndiceX()==x && liste.get(i).getIndiceY()==y) {
				return true;
			}
		}
		return false;
	}
	public boolean verifierSiContinue(ValeurAttribut valeur,Boutton [][]bouttonsTmp) {
		List<Boutton> liste=valeur.getBouttons();int size=liste.size();
		for(int i=0;i<size;i++) {
			int x=liste.get(i).getIndiceX(),y=liste.get(i).getIndiceY();
			if(x-1>0) {
				Boutton boutton=bouttonsTmp[x-1][y];
				if(!boutton.getText().equals("") && verificationTmp(valeur, x-1, y)==false) {
					return true;
				}
			}
			if(x+1<15) {
				Boutton boutton=bouttonsTmp[x+1][y];
				if(!boutton.getText().equals("") && verificationTmp(valeur, x+1, y)==false) {
					return true;
				}
			}			
			if(y-1>0) {
				Boutton boutton=bouttonsTmp[x][y-1];
				if(!boutton.getText().equals("") && verificationTmp(valeur, x, y-1)==false) {
					return true;
				}
			}
			if(y+1<15) {
				Boutton boutton=bouttonsTmp[x][y+1];
				if(!boutton.getText().equals("") && verificationTmp(valeur, x, y+1)==false) {
					return true;
				}
			}
		}
		return false;
	}
	public Vector<Integer> getMotVerifier(Object [][]objects,Langue langue,int langueMot){
		Vector<Integer> vector=new Vector<Integer>();int size=objects.length;
		for(int i=0;i<size;i++) {
			if(langue.verificationMot(langueMot,""+objects[i][0])) {
				vector.add(i);
			}
		}
		return vector;
	}
}
