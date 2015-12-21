package promedios;
import java.util.*;

public class generarPromedios 
{
	public static void main(String[] args) 
	{
		Random r = new Random();
		System.out.println("Number of students: ");
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
		String[] lastName = {"Jenkins", "Parkinson", "Fanning", "Jones", "Johnson",
		        			 "Hodgson", "Reid", "O'Leary", "O'Connor", "Slater", 
		        			 "McDonald", "Burrow", "Perez", "Bradley", "Broadley",
		        			 "Smith", "Hansen", "Jensen", "Rooney", "Van Persie"};
		
		String[] firstName = {"Gary", "Mark", "James", "Richard", "Gabriel", 
		        			 "Michael", "Quentin", "Sarah", "Amy", "Sophie", 
		        			 "Ronald", "Pedro", "Christine", "Elizabeth", "Andrew",
		        			 "Christopher", "Craig", "Martin", "Harry", "Mary", 
		        			 "Anne", "Ann", "Natalie", "Cleopatra", "Natasha"};
		
		
		
		for (int i = 0; i < n; i++) 
		{
			System.out.println(lastName[r.nextInt(19)] +", " + firstName[r.nextInt(19)] + " " + 
					   	       (r.nextInt(49)+50) + " " + (r.nextInt(49)+50) + " " + (r.nextInt(49)+50) 
					           + " " + (r.nextInt(49)+50) + " " + (r.nextInt(49)+50));
		}
		
		
	}

}
