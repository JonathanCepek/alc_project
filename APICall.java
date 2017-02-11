import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;

public class APICall {
	private final String APIkeyBeer     = "28575e301f8291d27eaba5546c6cb0e4";
	private final String APIkeyCockTail = "1";
	private String urlBeer = ("http://api.brewerydb.com/v2/beers?name=");
	private String urlCockTail = ("http://www.thecocktaildb.com/api/json/v1/1/search.php?s=");
	
	
	//Test the get
	public static void main(String[] args){
		APICall http = new APICall();
		System.out.println("Testing 1 - Send Http GET request with 'Vodka'");
		String temp = "";
		temp = http.sendGet("vodka");
		System.out.println("String: " + temp);
		
		System.out.println("Testing 2 - Send Http GET request with '1908'");
		String temp2 = "";
		temp2 = http.sendGet("1908");
		System.out.println("String: " + temp2);
		
		System.out.println("Testing 3 - Send Http GET request with garbage");
		String temp3 = "";
		temp3 = http.sendGet("ASDDFGFDSSDGFGFDD");
		System.out.println("String: " + temp3);
		
	}
	
	public String sendGet(String s){
		//replaces spaces with "+"
		s.replace(" ","+");
		
		//Strings
		String str2 =(urlBeer + s);
		String str  =(urlCockTail + s);
		String cockTail = "";
		String beer = "";
		int check2 = 0;
		
		//CockTail
		try{
		//opens connection for CocktailAPI
		URL obj1 = new URL(str);
		
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
		cockTail = response.toString();
		
		//checks if cocktail was valid
		String check = "null";
		check2 = cockTail.indexOf(check);
		
		//sends string to Java object converter
		
		
		//Catches exceptions
		} catch (Exception e)
		{
			System.err.println("Error connecting to Database");
		}
		if(check2 != 10)
		return cockTail;
		
		if(check2 == 10){
		//Beer
		try{
		//opens connection for BeerAPI
		URL obj2 = new URL(str2);
		HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();
		
		//sets the request type
		con2.setRequestMethod("GET");
		
		//adds request Header
		con2.setRequestProperty("Authorization", APIkeyBeer);
		
		//response Code
		int responseCode2 = con2.getResponseCode();
		
		//creates the string returned
		BufferedReader in2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
		String inputLine2;
		StringBuffer response2 = new StringBuffer();
		
		while ((inputLine2 = in2.readLine()) != null) {
			response2.append(inputLine2);
		}
		in2.close();
		
		//converts returned value into string
		beer = response2.toString();
		
		//gives string to converter
		
		} catch (Exception e)
		{
			System.err.println("Error connecting to Database");
		}
		
		return beer;
		}else{return "Did not run Beer API";}
		
	}
}