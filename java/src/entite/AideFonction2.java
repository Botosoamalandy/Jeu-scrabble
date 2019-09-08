package entite;

import java.util.Vector;

public class AideFonction2 {
	String img="";
	int numero=0;
	public AideFonction2() {}
	public AideFonction2(String img, int numero) {
		this.img = img;
		this.numero = numero;
	}
	public Vector<AideFonction2> getLettreImage() {
		Vector<AideFonction2> aideFonction2s=new Vector<AideFonction2>();
		aideFonction2s.add(new AideFonction2("A",1));
		aideFonction2s.add(new AideFonction2("B",2));
		aideFonction2s.add(new AideFonction2("C",3));
		aideFonction2s.add(new AideFonction2("D",4));
		aideFonction2s.add(new AideFonction2("E",5));
		aideFonction2s.add(new AideFonction2("F",6));
		aideFonction2s.add(new AideFonction2("G",7));
		aideFonction2s.add(new AideFonction2("H",8));
		aideFonction2s.add(new AideFonction2("I",9));
		aideFonction2s.add(new AideFonction2("J",10));
		aideFonction2s.add(new AideFonction2("K",11));
		aideFonction2s.add(new AideFonction2("L",12));
		aideFonction2s.add(new AideFonction2("M",13));
		aideFonction2s.add(new AideFonction2("N",14));
		aideFonction2s.add(new AideFonction2("O",15));
		aideFonction2s.add(new AideFonction2("P",16));
		aideFonction2s.add(new AideFonction2("Q",17));
		aideFonction2s.add(new AideFonction2("R",18));
		aideFonction2s.add(new AideFonction2("S",19));
		aideFonction2s.add(new AideFonction2("T",20));
		aideFonction2s.add(new AideFonction2("U",21));
		aideFonction2s.add(new AideFonction2("V",22));
		aideFonction2s.add(new AideFonction2("W",23));
		aideFonction2s.add(new AideFonction2("X",24));
		aideFonction2s.add(new AideFonction2("Y",25));
		aideFonction2s.add(new AideFonction2("Z",26));
		aideFonction2s.add(new AideFonction2("0",0));
		return aideFonction2s;
	}
	public String getLettre(String string) {
		Vector<AideFonction2> aideFonction2s=getLettreImage();
		int size=aideFonction2s.size();
		for(int i=0;i<size;i++) {
			if(string.equals(""+aideFonction2s.get(i).getNumero())) {
				return aideFonction2s.get(i).getImg();
			}
		}
		return "";
	}
	public int getNumero(String string) {
		Vector<AideFonction2> aideFonction2s=getLettreImage();
		int size=aideFonction2s.size();
		for(int i=0;i<size;i++) {
			if(string.equals(""+aideFonction2s.get(i).getImg())) {
				return aideFonction2s.get(i).getNumero();
			}
		}
		return -1;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
