package entite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AideFonction {
	public AideFonction() {}
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
	public String getMotAvant(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		int  alignement=verticaleOuHorizontalOuQuelconque(valeur);
		List<String> listImage=imageFondVide();
		List<Boutton> bouttons=valeur.getBouttons();
		String mot="";
		if(alignement==1) {//aligne X
			List<Integer> integers=creationTabEntier(bouttons,2);
			int yMin=integers.get(0);
			int x=bouttons.get(0).getIndiceX();
			int i=yMin-1;
			while(i>=0 && !listImage.contains(bouttonsTmp[x][i].getNomImage())) {
				mot=bouttonsTmp[x][i].getNom()+mot;
				i--;
			}
		}else {// aligne y
			List<Integer> integers=creationTabEntier(bouttons,1);
			int xMin=integers.get(0);
			int y=bouttons.get(0).getIndiceY();
			int i=xMin-1;
			while(i>=0 && !listImage.contains(bouttonsTmp[i][y].getNomImage())) {
				mot=bouttonsTmp[i][y].getNom()+mot;
				i--;
			}
		}
		return mot;
	}
	public String getMotApres(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		int  alignement=verticaleOuHorizontalOuQuelconque(valeur);
		List<String> listImage=imageFondVide();
		List<Boutton> bouttons=valeur.getBouttons();
		String mot="";
		if(alignement==1) {//aligne X
			List<Integer> integers=creationTabEntier(bouttons,2);
			int yMax=integers.get(integers.size()-1);
			int x=bouttons.get(0).getIndiceX();
			int i=yMax+1;
			while(i<15 && !listImage.contains(bouttonsTmp[x][i].getNomImage())) {
				mot=mot+bouttonsTmp[x][i].getNom();
				i++;
			}
		}else {// aligne y
			List<Integer> integers=creationTabEntier(bouttons,1);
			int xMax=integers.get(integers.size()-1);
			int y=bouttons.get(0).getIndiceY();
			int i=xMax+1;
			while(i<15 && !listImage.contains(bouttonsTmp[i][y].getNomImage())) {
				mot=mot+bouttonsTmp[i][y].getNom();
				i++;
			}
		}
		return mot;
	}
	public String getMotComplet(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		int  alignement=verticaleOuHorizontalOuQuelconque(valeur);
		List<Boutton> bouttons=valeur.getBouttons();int size=bouttons.size();
		String mot="";
		if(size>0) {
			if(alignement>0) {
				if(alignement==1) {//aligne X
					List<Integer> integers=creationTabEntier(bouttons,2);
					int yMin=integers.get(0),yMax=integers.get(integers.size()-1);
					int x=bouttons.get(0).getIndiceX();
					for(int i=yMin;i<=yMax;i++) {
						mot=mot+bouttonsTmp[x][i].getNom();
					}
				}else {// aligne y
					List<Integer> integers=creationTabEntier(bouttons,1);
					int xMin=integers.get(0),xMax=integers.get(integers.size()-1);
					int y=bouttons.get(0).getIndiceY();
					for(int i=xMin;i<=xMax;i++) {
						mot=mot+bouttonsTmp[i][y].getNom();
					}
				}
			}
		}
		return mot;
	}
	//valeur >1
	
	public String getMotAvantUneSeuleVerticaleAvant(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		List<String> listImage=imageFondVide();
		List<Boutton> bouttons=valeur.getBouttons();
		String mot="";
		int yMin=bouttons.get(bouttons.size()-1).getIndiceY();
		int x=bouttons.get(0).getIndiceX();
		int i=yMin-1;
		while(i>=0 && !listImage.contains(bouttonsTmp[x][i].getNomImage())) {
			mot=bouttonsTmp[x][i].getNom()+mot;
			i--;
		}
		return mot;
	}
	public String getMotApresUneSeuleVerticaleAvant(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		List<String> listImage=imageFondVide();
		List<Boutton> bouttons=valeur.getBouttons();
		String mot="";
		int yMax=bouttons.get(bouttons.size()-1).getIndiceY();
		int x=bouttons.get(0).getIndiceX();
		int i=yMax+1;
		while(i<15 && !listImage.contains(bouttonsTmp[x][i].getNomImage())) {
			mot=mot+bouttonsTmp[x][i].getNom();
			i++;
		}
		return mot;
	}
	public String getMotAvantUneSeuleHorizontaleAvant(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		List<String> listImage=imageFondVide();
		List<Boutton> bouttons=valeur.getBouttons();
		String mot="";
		int xMin=bouttons.get(bouttons.size()-1).getIndiceX();
		int y=bouttons.get(0).getIndiceY();
		int i=xMin-1;
		while(i>=0 && !listImage.contains(bouttonsTmp[i][y].getNomImage())) {
			mot=bouttonsTmp[i][y].getNom()+mot;
			i--;
		}
		return mot;
	}
	public String getMotApresUneSeuleHorizontaleAvant(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		List<String> listImage=imageFondVide();
		List<Boutton> bouttons=valeur.getBouttons();
		String mot="";
		int xMax=bouttons.get(bouttons.size()-1).getIndiceX();
		int y=bouttons.get(0).getIndiceY();
		int i=xMax+1;
		while(i<15 && !listImage.contains(bouttonsTmp[i][y].getNomImage())) {
			mot=mot+bouttonsTmp[i][y].getNom();
			i++;
		}
		return mot;
	}
	public String getMotUneSeule(ValeurAttribut valeur,Boutton [][]bouttonsTmp,Boutton []bouttonss) {
		
		Points points=new Points();
		String mot=points.chiffreToLettre(valeur.getBouttons().get(0).getNom());
		String avantVerticale=getMotAvantUneSeuleVerticaleAvant(valeur, bouttonsTmp, bouttonss);
		String apresVerticale=getMotApresUneSeuleVerticaleAvant(valeur, bouttonsTmp, bouttonss);
		String avantHorizontale=getMotAvantUneSeuleHorizontaleAvant(valeur, bouttonsTmp, bouttonss);
		String apresHorizontale=getMotApresUneSeuleHorizontaleAvant(valeur, bouttonsTmp, bouttonss);
		String string1=""+avantVerticale+mot+apresVerticale,string2=""+avantHorizontale+mot+apresHorizontale;
		return string1+" "+string2;
	}
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
}
