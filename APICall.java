import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

public class APICall {
	private final String APIkeyBeer     = "28575e301f8291d27eaba5546c6cb0e4";
	private final String APIkeyCockTail = "1";
	private String urlBeer = ("http://api.brewerydb.com/v2/?name=");
	private String urlCockTail = ("http://www.thecocktaildb.com/api/json/v1/1/");
	
	public void sendGet(String s){
		//replaces spaces with "+"
		s.replace('32', "+");
		
		//appends the url for request
		str1 =(urlBeer + s);
		str2 =(urlCockTail + s);
		
		//CockTail
		//opens connection for CocktailAPI
		URL obj2 = new URL(str2);
		HttpURLConnection con = (HttpURLConnection) obj1.openConnection();
		
		//sets the request type
		con.setRequestMethod("GET");
		
		//adds request Header
		con.setRequestProperty("Authorization", APIkeyCockTail);
		
		//response Code
		int responseCode = con.getResponseCode();
		
		//creates the string returned
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//converts returned value into string
		String beer = response.toString();
		
		//sends string to Java object converter
		
		//Beer
		//opens connection for BeerAPI
		URL obj1 = new URL(str1);
		HttpURLConnection con = (HttpURLConnection) obj1.openConnection();
		
		//sets the request type
		con.setRequestMethod("GET");
		
		//adds request Header
		con.setRequestProperty("Authorization", APIkeyBeer);
		
		//response Code
		int responseCode = con.getResponseCode();
		
		//creates the string returned
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//converts returned value into string
		String beer = response.toString();
		
	}
}