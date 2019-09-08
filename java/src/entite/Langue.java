package entite;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Langue {
	List<String> francais=new ArrayList<String>();
	List<String> anglais=new ArrayList<String>();
	public Langue() {
		String cheminFrancais=splitChemin(""+getClass().getResource("../langue/liste_francais.txt"));
		String cheminAnglais=splitChemin(""+getClass().getResource("../langue/anglais.txt"));
		try { 
			BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(cheminFrancais))); 
			BufferedReader br2 = new BufferedReader(new InputStreamReader( new FileInputStream(cheminAnglais))); 
			String ligne = "",ligne2="";
			while ((ligne = br.readLine()) != null) {
				francais.add(ligne);
			} br.close();
			while ((ligne2 = br2.readLine()) != null) {
				anglais.add(ligne2);
			} br2.close();
		} 
		catch (Exception e){
			e.printStackTrace();
		}
	}
	public List<String> getFrancais() {
		return francais;
	}
	public void setFrancais(List<String> francais) {
		this.francais = francais;
	}
	public List<String> getAnglais() {
		return anglais;
	}
	public void setAnglais(List<String> anglais) {
		this.anglais = anglais;
	}
	public String splitChemin(String chemin) {
		String []h=chemin.split("file:/");
		if(h.length>1) {
			String []h2=h[1].split("%20");int size=h2.length;
			if(size>1) {
				String resultat="";
				for(int i=0;i<size;i++) {
					resultat=resultat+h2[i]+" ";
				}
				return resultat;
			}else {
				return h2[0];
			}
		}else {
			return h[0];
		}
	}
	public boolean verificationMot(int langue,String mots) {
		String mot=mots.toLowerCase();
		System.out.println("mot minuscule="+mot);
		if(langue==1) {
			return francais.contains(mot);
		}else {
			return anglais.contains(mot);
		}
	}
}
