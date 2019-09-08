package entite;

import java.util.Collections;
import java.util.Vector;

public class Points {
	String lettre="";
	int points=0;
	int numero=0;
	public Points() {}
	public Points(String lettre, int points,int numero) {
		this.lettre = lettre;
		this.points = points;
		this.numero = numero;
	}
	public String getLettre() {
		return lettre;
	}
	public void setLettre(String lettre) {
		this.lettre = lettre;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void trierPoint(Vector<Points> sacs) {
		int size=sacs.size();
		int test=1;
		Points m;
		while(test!=0) {
			test=0;
			for(int i=0;i<size-1;i++) {
				if(sacs.get(i).getNumero()>sacs.get(i+1).getNumero()) {
					m=sacs.get(i+1);
					sacs.set(i+1,sacs.get(i));
					sacs.set(i,m);
					test++;
				}
			}
		}
	}
	public String chiffreToLettre(String chiffres) {
		Vector<Points> vector=getContenuSacOriginaleVector();
		int n=vector.size();
		for(int i=0;i<n;i++) {
			if(chiffres.equals(""+vector.get(i).getNumero())) {
				return vector.get(i).getLettre();
			}
		}
		return null;
	}
	public String lettreToChiffre(String lettres) {
		Vector<Points> vector=getContenuSacOriginaleVector();
		int n=vector.size();
		for(int i=0;i<n;i++) {
			if(lettres.equals(""+vector.get(i).getLettre())) {
				return ""+vector.get(i).getNumero();
			}
		}
		return null;
	}
	public Vector<Points> getContenuSacOriginaleVector() {
		Vector<Points> sacs=new Vector<Points>();
		int n=15;
		sacs.add(new Points("J",8,10));
		sacs.add(new Points("Q",8,17));
		sacs.add(new Points("K",10,11));
		sacs.add(new Points("W",10,23));
		sacs.add(new Points("X",10,24));
		sacs.add(new Points("Y",10,25));
		sacs.add(new Points("Z",10,26));
		for(int i=0;i<n;i++) {
			if(i<2) {
				sacs.add(new Points("G",2,7));
				sacs.add(new Points("B",3,2));
				sacs.add(new Points("C",3,3));
				sacs.add(new Points("P",3,16));
				sacs.add(new Points("F",4,6));
				sacs.add(new Points("H",4,8));
				sacs.add(new Points("V",4,22));
			}if(i<3) {
				sacs.add(new Points("D",2,4));
				sacs.add(new Points("M",2,13));
			}
			if(i<5) {
				sacs.add(new Points("L",1,12));
			}
			if(i<6) {
				sacs.add(new Points("N",1,14));
				sacs.add(new Points("O",1,15));
				sacs.add(new Points("R",1,18));
				sacs.add(new Points("S",1,19));
				sacs.add(new Points("T",1,20));
				sacs.add(new Points("U",1,21));
			}
			if(i<8) {
				sacs.add(new Points("I",1,9));
			}if(i<9) {
				sacs.add(new Points("A",1,1));
			}
			sacs.add(new Points("E",1,5));
		}
		sacs.add(new Points("0",0,0));
		sacs.add(new Points("0",0,0));
		trierPoint(sacs);
		return sacs;
	}
	public void melangePoints(Vector<Points> points){
		for(int i =0; i<5;i++){
	         Collections.shuffle(points);
	         Collections.shuffle(points);
	     }
	}
	public Vector<Points> vectorStringToPoints(Vector<String>  vector){
		Vector<Points> pointsTmp=getContenuSacOriginaleVector();
		Vector<Points> resultat=new Vector<Points>();
		int size1=vector.size(),size2=pointsTmp.size();;
		for(int i=0;i<size1;i++) {
			boolean test=false;
			for(int a=0;a<size2;a++) {
				if(vector.get(i).equals(pointsTmp.get(a).getLettre()) && test==false) {
					resultat.add(new Points(pointsTmp.get(a).getLettre(),pointsTmp.get(a).getPoints(),pointsTmp.get(a).getNumero()));
					test=true;
				}
			}
		}
		trierPoint(resultat);
		melangePoints(resultat);
		return resultat;
	}
	public int getPointsAPartLettres(String valeur){
			Points points=find(valeur);
		return points.getPoints();
	}
	public Points find(String lettre) {
		Vector<Points> vector=getContenuSacOriginaleVector();
		int size1=vector.size();
		for(int i=0;i<size1;i++) {
			if(lettre.equals(vector.get(i).getLettre())) {
				return vector.get(i);
			}
		}
		return null;
	}
	public Vector<Points> creationPoints(Sac sac){
		Vector<String> vector=sac.getContenuSacTmp(sac);
		return vectorStringToPoints(vector);
	}
	public Vector<Points> bouttonToPoints(Boutton []bouttons) {
		Vector<Points> pointsTmp=new Vector<Points>();int size=bouttons.length;
		AideFonction2 aideFonction2=new AideFonction2();
		for(int i=0;i<size;i++) {
			if(!bouttons[i].getNomImage().equals("")) {
				String lettres=aideFonction2.getLettre(bouttons[i].getNom());
				pointsTmp.add(find(lettres));
			}
		}
		return pointsTmp;
	}
}
