package js;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;

public class ma {

	public static void main(String[] args) throws JSONException, IOException {
		// TODO Auto-generated method stub
		GetJson n=new GetJson();
		JSONArray aa=n.readJsonFromUrl("http://localhost/ss.php");
		for(int i=0 ; i<aa.length() ; i++){
	        String id= aa.getJSONObject(i).get("nom_client").toString();
	        System.out.println(id);
		}
	}

}
