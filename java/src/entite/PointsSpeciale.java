package entite;

import java.util.List;

public class PointsSpeciale {
	int points=0;
	int pointsAllLetters=0;
	boolean oneLetter=false;
	boolean allLetters=false;
	public PointsSpeciale() {}
	public PointsSpeciale(int points, int pointsAllLetters, boolean oneLetter, boolean allLetters) {
		this.points = points;
		this.pointsAllLetters = pointsAllLetters;
		this.oneLetter = oneLetter;
		this.allLetters = allLetters;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getPointsAllLetters() {
		return pointsAllLetters;
	}
	public void setPointsAllLetters(int pointsAllLetters) {
		this.pointsAllLetters = pointsAllLetters;
	}
	public boolean isOneLetter() {
		return oneLetter;
	}
	public void setOneLetter(boolean oneLetter) {
		this.oneLetter = oneLetter;
	}
	public boolean isAllLetters() {
		return allLetters;
	}
	public void setAllLetters(boolean allLetters) {
		this.allLetters = allLetters;
	}
	public PointsSpeciale getPointsSpeciale(Boutton boutton) {
		Points fonctionPoints=new Points();
		Points point=fonctionPoints.find(boutton.getNom());
		System.out.println("nom=="+boutton.getNom()+" image vide="+boutton.getImageVide());
		if(boutton.getImageVide().equals("fond4.jpg")) {//blue marine
			return new PointsSpeciale(point.getPoints(), 3, true,false);
		}else if(boutton.getImageVide().equals("fond5.jpg")) {//blue ciel
			return new PointsSpeciale(point.getPoints(), 2,true,false);
		}else if(boutton.getImageVide().equals("fond6.jpg")) {//rouge
			return new PointsSpeciale(point.getPoints(), 3,false,true);
		}else if(boutton.getImageVide().equals("fond7.jpg")) {//rose
			return new PointsSpeciale(point.getPoints(), 2,false,true);
		}else if(boutton.getImageVide().equals("fond8.jpg")) {//etoile
			return new PointsSpeciale(point.getPoints(),5,false,true);
		}else {
			return new PointsSpeciale(point.getPoints(),1, true, false);
		}
	}
	public int getScoreTmp(ValeurAttribut valeur,List<Boutton> list) {
		int size=list.size();
		int totale=0;
		int size2=valeur.getBouttons().size();
		if(size2<7) {
			int fois=1;int score=0;
			for(int i=0;i<size;i++) {
				PointsSpeciale pointsSpeciale=getPointsSpeciale(list.get(i));
				System.out.println("pointsSpeciale="+pointsSpeciale.getPoints()+" Pointletters="+pointsSpeciale.getPointsAllLetters());
				if(pointsSpeciale.isAllLetters()) {
					fois=fois+pointsSpeciale.getPointsAllLetters();
					int a=pointsSpeciale.getPoints();
					score=score+a;
				}
				if(pointsSpeciale.isOneLetter()) {
					int a=(pointsSpeciale.getPoints()*pointsSpeciale.getPointsAllLetters());
					score=score+a;
				}
			}
			totale=fois*score;
			System.out.println("fois="+fois+" score="+score+" fois="+fois);
		}else if(size2==7){
			totale=70;
		}
		return totale;
	}
	
}
