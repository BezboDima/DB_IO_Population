package labproject9.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class PopulationAggregator {

	public static void main(String[] args) throws FileNotFoundException {
		
		File input = new File("C:\\Users\\Dmitry\\eclipse-workspace\\CS176L_IO\\src\\labproject9\\io\\populations.txt");
		PrintWriter output = new PrintWriter("C:\\Users\\Dmitry\\eclipse-workspace\\CS176L_IO\\src\\labproject9\\io\\output.txt");
		
		Scanner in = new Scanner(input);
		in.useLocale(Locale.US);
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int total = 0;
		double count = 0.0;
		double avg = 0.0;
		String leastPcity = "";
		String mostPcity = "";
		while (in.hasNextLine()) {
			String lineP = in.nextLine();
	
			int i = 0;
			while(!Character.isDigit(lineP.charAt(i))) {
				i++;
			}
			String city = lineP.substring(0,i);
			String popul = lineP.substring(i);
			
			int population = Integer.parseInt(popul);
			city.trim();
			
			if (population < min) {
				min = population;
				leastPcity = city;
			}
			
			if (population > max) {
				max = population;
				mostPcity = city;
			}
			
			total += population;
			
			count ++;
		}
		mostPcity.trim();
		leastPcity.trim();
		
		output.println("Most Populated: " + mostPcity + " - " + max);
		output.println("Least Populated: " + leastPcity + " - " + min );
		output.printf("Total Population: %d \n", total);
		output.printf("Average Population: %.2f \n", total/count);
		
		output.close();

	}
}
