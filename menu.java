import java.io.*;
import java.util.*;

public class menu
{
	private static User session;
	private static File user_f = new File("user.dat");
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to AlcTracker 0.1!");
		System.out.println("--------------------------");		
		
		//check for .dat user
		if(!user_f.exists() || user_f.isDirectory()) 
		{ 
			//Initialize new user
    		System.out.println("Get started by inputting your user data below:");
    		updateUser(true);
    		
		}
		else
		{
			initUser();
			int event = 0;
			while(event != 6)
			{
				event = mainQuery();
			
				if(event == 1) //liquor cabinet
				{
				
				}
				else if(event == 2) //beer fridge
				{
				
				}
				else if(event == 3) //Mixing Station
				{
				
				}
				else if(event == 4) //Alcohol Tracker
				{
				
				}
				else if(event == 5) //update user info
				{
					System.out.println("Input new user data below:");
					updateUser(false);
				}
			}
			//exit program safely by updating user.dat with info stored in User object: "session""
			
		}
		
		
	}
	
	static void initUser()
	{
	try
		{
			//Initialize user object
			//user.dat file format:
			/*
			first=<first.name>
			last=<last.name>
			weight=<weight_int>
			height=<ft'in"ints>
			total_drinks=<some_int>
			*/
			String first, last;
			int weight, height, total_drinks, delim;
			
			Scanner fScan = new Scanner(user_f);
			first = fScan.nextLine();
			delim = first.indexOf('=');
			first = first.substring(delim+1);
			last = fScan.nextLine();
			delim = last.indexOf('=');
			last = last.substring(delim+1);
			
			//get weight
			String w_read = fScan.nextLine();
			delim = w_read.indexOf('=');
			w_read = w_read.substring(delim+1);
			w_read = w_read.substring(0, w_read.length()-3); //-4?
			weight = Integer.parseInt(w_read);
			
			String h_read= fScan.nextLine();
			delim = h_read.indexOf('=');
			int ft, in, delim_f, delim_i, drinks;
			delim_f = h_read.indexOf(39); //'
			delim_i = h_read.indexOf(34); //"
			ft = Integer.parseInt(h_read.substring(delim+1,delim_f));
			in = Integer.parseInt(h_read.substring(delim_f+1, delim_i));
			String d_read = fScan.nextLine();
			delim = d_read.indexOf('=');
			d_read = d_read.substring(delim+1);
			drinks = Integer.parseInt(d_read);
			
			session.setFirst(first);
			session.setLast(last);
			session.setWeight(weight);
			session.setHeight(((ft*12) + in));
			session.setDrinks(drinks);
			
		} catch (IOException e) {
			System.err.println("Error reading user data");
		}
		
		System.out.println("");
	}
	
	static int mainQuery()
	{
	
		System.out.println("Main Menu:");
		System.out.println("----------\n");
		System.out.println("1) Enter Liquor Cabinet");
		System.out.println("2) Enter Beer Fridge");
		System.out.println("3) Enter Mixing Station");
		System.out.println("4) Enter Alcohol Tracker");
		System.out.println("5) Update User Info");
		System.out.println("6) Exit\n");				
	
		Scanner inScan = new Scanner(System.in);
		
		int response = inScan.nextInt();
		inScan.close();
		
		return response;
		
	}
	
	static void updateUser(boolean make)
	{
		Scanner inScan = new Scanner(System.in);
		
		String first, last;
		int ft, in, weight;
		
		System.out.print("First Name: ");
		first = inScan.nextLine();
		System.out.print("Last Name: ");
		last = inScan.nextLine();
		System.out.println("Height:");
		System.out.print("-ft: ");
		ft = inScan.nextInt();
		System.out.print("-in: ");
		in = inScan.nextInt();
		System.out.print("Weight(in lbs): ");
		weight = inScan.nextInt();
		
		if(make) session = new User(first, last, weight, ((ft*12) + in), 0); //sets initial drinks to 0
		else
		{
			session.setFirst(first);
			session.setLast(last);
			session.setWeight(weight);
			session.setHeight(((ft*12) + in));
		}
	}
}
