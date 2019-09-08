package entite;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
	boolean oneOrOff=false;
	int type=0;
	Clip clip;
	String nom;
	String active="Activer";
	boolean single=false;
	public Music() {}
	public Music(boolean oneOrOff, int type,String nom,boolean single) {
		this.oneOrOff = oneOrOff;
		this.type = type;
		this.nom = nom;
		this.single = single;
	}
	public boolean isOneOrOff() {
		return oneOrOff;
	}
	public void setOneOrOff(boolean oneOrOff) {
		this.oneOrOff = oneOrOff;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public boolean isSingle() {
		return single;
	}
	public void setSingle(boolean single) {
		this.single = single;
	}
	public void lancerMusic() {
		if(oneOrOff) {
			Langue langue=new Langue();
			String n=langue.splitChemin(""+getClass().getResource("../music/"+nom+".wav"));
			try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(n).getAbsoluteFile());
		        clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		        if(single) {
		        	clip.loop(Clip.LOOP_CONTINUOUSLY);
		        }
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
		}else {
			clipStop();
		}
	}
	public void clipStop() {
		if(clip!=null) {
			clip.stop();
		}
	}
}
