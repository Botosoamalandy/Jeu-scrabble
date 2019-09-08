package entite;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Vector;

import org.json.JSONArray;

public class FonctionGeneraliser {
	public String caseT(String mot) {
    	String lm="";
    	String reste=mot.substring(1);
    	char s=mot.charAt(0);
    	String m=""+s;
    	lm=m.toUpperCase()+reste;
    	return lm;
    }
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector<Object> find(Object object,JSONArray json) throws Exception{
		Vector<Object> resultat=new Vector<Object>();
		try {
			Field []field=object.getClass().getDeclaredFields();
			Class classe=object.getClass();
			for(int a=0;a<json.length();a++) {
				Object objectTemporaire=classe.newInstance();
				for(int i=0;i<field.length;i++) {
					Method methodeTemporaire=classe.getMethod("get"+caseT(field[i].getName()));
					Object objectInvokeTemporaire=methodeTemporaire.invoke(object);
					if(objectInvokeTemporaire instanceof Integer) {
						Method methode=classe.getMethod("set"+caseT(field[i].getName()),int.class);
						String valeur=json.getJSONObject(a).get(field[i].getName()).toString();
						methode.invoke(objectTemporaire,Integer.parseInt(valeur));
					}
					if(objectInvokeTemporaire instanceof String) {
						Method methode=classe.getMethod("set"+caseT(field[i].getName()),String.class);
						methode.invoke(objectTemporaire,json.getJSONObject(a).get(field[i].getName()).toString());
					}
					if(objectInvokeTemporaire instanceof Double) {
						Method methode=classe.getMethod("set"+caseT(field[i].getName()),double.class);
						String valeur=json.getJSONObject(a).get(field[i].getName()).toString();
						methode.invoke(objectTemporaire,Double.parseDouble(valeur));
					}
					if(objectInvokeTemporaire instanceof Dates) {
						Method methode=classe.getMethod("set"+caseT(field[i].getName()),String.class);
						methode.invoke(objectTemporaire,json.getJSONObject(a).get(field[i].getName()).toString());
					}
				}
				resultat.add(objectTemporaire);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultat;
	}
	public String separatorString(String valeur) {
		String []valeurTmp=valeur.split(" ");
		int size=valeurTmp.length;
		if(size>1) {
			String resultat=valeurTmp[0];
			for(int i=1;i<size;i++) {
				resultat=resultat+"_"+valeurTmp[i];
			}
			return resultat;
		}else {
			return valeur;
		}	
	}
	public String deleteSeparatorString(String valeur) {
		String []valeurTmp=valeur.split("_");
		int size=valeurTmp.length;
		if(size>1) {
			String resultat=valeurTmp[0];
			for(int i=1;i<size;i++) {
				resultat=resultat+" "+valeurTmp[i];
			}
			return resultat;
		}else {
			return valeur;
		}	
	}
	public String deleteSeparatorPoint(String valeur) {
		String []strings=valeur.split("-");
		return strings[0];
	}
}
