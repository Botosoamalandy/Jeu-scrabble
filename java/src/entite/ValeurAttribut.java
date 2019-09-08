package entite;

import java.util.ArrayList;
import java.util.List;

public class ValeurAttribut {
	Boutton boutton=new Boutton();
	int indiceX=0;
	int indiceY=0;
	String img="";
	List<Boutton> bouttons=new ArrayList<Boutton>();
	public ValeurAttribut() {}
	public ValeurAttribut(Boutton boutton) {
		this.boutton = boutton;
	}
	public Boutton getBoutton() {
		return boutton;
	}
	public void setBoutton(Boutton boutton) {
		this.boutton = boutton;
		
		this.bouttons.add(new Boutton(boutton.getNom(),boutton.getNomImage(),boutton.getNomAncientImage(),boutton.getIndiceX(),boutton.getIndiceY(),boutton.getImageVide()));
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
	public List<Boutton> getBouttons() {
		return bouttons;
	}
	
	public void setBouttons(List<Boutton> bouttons) {
		this.bouttons = bouttons;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public void removeAllBoutton() {
		this.bouttons.removeAll(bouttons);
	}
}
