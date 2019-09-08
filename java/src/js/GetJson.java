package js;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray ;
import org.json.JSONException;

/**
 *
 * @author Matthieu
 */
public class GetJson {

    /**
     * @param args the command line arguments
     */
  private String readAll(Reader rd) throws IOException {
	  
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }    
    
    
    public JSONArray readJsonFromUrl(String url) throws IOException, JSONException {//Fonction manatsofoka JSON zvy zm Url mba ho lasa JSONOBJECT
      InputStream is = new URL(url).openStream();
      try {
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        JSONArray json = new JSONArray(jsonText);
        return json;
      } finally {
        is.close();
      }
    }        
    @SuppressWarnings("unused")
	public void ajoutJoueurDansServeur(String nom,String idPartie) throws IOException, JSONException {//Fonction manatsofoka JSON zvy zm Url mba ho lasa JSONOBJECT
        InputStream is = new URL("http://localhost/scrabble/Serveur.php?nomJoueur="+nom+"&idPartie="+idPartie+"&numero=1").openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
        //  JSONArray json = new JSONArray(jsonText);
        } finally {
          is.close();
        }
      }
    public void addDansLaBaseDeDonnee(String lien) throws IOException, JSONException {//Fonction manatsofoka JSON zvy zm Url mba ho lasa JSONOBJECT
        InputStream is = new URL(lien).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          readAll(rd);
        } finally {
          is.close();
        }
      }
      public JSONArray getJson(String lien) throws Exception{
    	  InputStream is = new URL(lien).openStream();
          try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
          } finally {
            is.close();
          } 
      }
}
