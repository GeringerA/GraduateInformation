import java.util.*;
import java.io.*;

/**
*takes a txt file command line argument and scans the file for graduate type data
*constructs an array of name, degree, and year
*promptsuser for how they would like to view the data
*then goes through methods based on what theyve chosen
*@author Adam Geringer
*/
public class GraduateInformation {

	/**Display statistics as shown above
	*@param graduates array of graduates
	*/
	public static void displayStatistics(Graduate[] graduates) {
		int totalGraduates = graduates.length;
		int totalBS = 0;
		int totalMS = 0;
		int totalPhD = 0;
		int total60 = 0;
		int total70 = 0;
		int total80 = 0;
		int total90 = 0;
		int total00 = 0;
		int total10 = 0;

		for (int i = 0; i < graduates.length; i++) {
	   		if (graduates[i].getDegree().equals("B.S.")) {
				totalBS ++;
			} else if (graduates[i].getDegree().equals("M.S.")) {
				totalMS ++;
			} else if (graduates[i].getDegree().equals("Ph.D.")) {
				totalPhD ++;
			}

			if (1960 <= graduates[i].getYear() && graduates[i].getYear() <= 1969) {
				total60 ++;
			} else if (1970 <= graduates[i].getYear() && graduates[i].getYear() <= 1979) {
				total70 ++;
			} else if (1980 <= graduates[i].getYear() && graduates[i].getYear() <= 1989) {
				total80 ++;
			} else if (1990 <= graduates[i].getYear() && graduates[i].getYear() <= 1999) {
				total90 ++;
			} else if (2000 <= graduates[i].getYear() && graduates[i].getYear() <= 2009) {
				total00 ++;
			} else if (2010 <= graduates[i].getYear() && graduates[i].getYear() <= 2019) {
				total10 ++;
			}
		}

		System.out.println("Number of graduates: " + totalGraduates);
		System.out.println("By degree");
		System.out.println("   B.S.:  " + totalBS);
		System.out.println("   M.S.:  " + totalMS);
		System.out.println("   Ph.D.: " + totalPhD);
		System.out.println("By year");
		System.out.println("   1960-69: " + total60);
		System.out.println("   1970-79: " + total70);
		System.out.println("   1980-89: " + total80);
		System.out.println("   1990-99: " + total90);
		System.out.println("   2000-09: " + total00);
		System.out.println("   2010-19: " + total10);
	}

	/*
	*@param graduates array of graduates
	*/
	public static void listAll(Graduate[] graduates) {
		System.out.println("\nAll Graduates:");
		for (int i = 0; i < graduates.length; i++) {
		    System.out.println("Name: " + graduates[i].getName() + 
                       "\tDegree: " + graduates[i].getDegree() + 
                       "\tYear: " + graduates[i].getYear());
		}
	}
	/**
	*checks to see if the degOption is a valid string option
	*@param degOption string of input
	*@return whether it is a valid option	
	*/
	public static boolean validDegOption(String degOption) {
		if (degOption.equals("B.S.")) {
			return true;
		} else if (degOption.equals("M.S.")) {
			return true;
		} else if (degOption.equals("Ph.D.")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	*
	*@param console asks user for the degree to display
	*
	*/
	public static void listByDegree(Scanner console, Graduate[] graduates) {
		System.out.print("Which degree?\n 	B.S.\n 	M.S.\n 	Ph.D.\n option: ");
		String degOption = console.next();
		do {
			if (degOption.equals("B.S.")) {
				System.out.println("\nGraduates with B.S degree:");
				for (int i = 0; i < graduates.length; i++) {
		   			if (graduates[i].getDegree().equals("B.S.")) {
						System.out.println("Name: " + graduates[i].getName() + 
				                   "\tDegree: " + graduates[i].getDegree() + 
				                   "\tYear: " + graduates[i].getYear());  
					}
				}
			} else if (degOption.equals("M.S.")) {
				System.out.println("\nGraduates with M.S. degree:");
				for (int i = 0; i < graduates.length; i++) {
		   			if (graduates[i].getDegree().equals("M.S.")) {
						System.out.println("Name: " + graduates[i].getName() + 
				                   "\tDegree: " + graduates[i].getDegree() + 
				                   "\tYear: " + graduates[i].getYear());  
					}
				}
			} else if (degOption.equals("Ph.D.")) {
				System.out.println("\nGraduates with Ph.D. degree:");
				for (int i = 0; i < graduates.length; i++) {
		   			if (graduates[i].getDegree().equals("Ph.D.")) {
						System.out.println("Name: " + graduates[i].getName() + 
				                   "\tDegree: " + graduates[i].getDegree() + 
				                   "\tYear: " + graduates[i].getYear());  
					}
				}
			}else{
						System.out.println("Invalid option");	
					
			
			} 	
		} while (validDegOption(degOption) == false);

	}

	/**
	* lists graduats by the year given through console
	*@param console asks user for input
	*@param graduates array of graduates
	*/
	public static void listByYear(Scanner console, Graduate[] graduates) {
		int yearOption = 0;
		System.out.println("What year would you like to view?");
		while (!(console.hasNextInt())) {
			System.out.println("Invalid year \n What year would you like to view?");
			console.next();
		}
		yearOption = console.nextInt();
		int count = 0;
		while (yearOption <= 1959 || yearOption >= 2020) {
			System.out.println("Invalid year \nWhat year would you like to view?");
			if (!(console.hasNextInt())) {
				yearOption = 0;
				console.nextLine();
				System.out.println("Invalid year \n What year would you like to view?");
			}
			yearOption = console.nextInt();	
		}	
		System.out.println("\nGraduates from " + yearOption);
		for (int i = 0; i < graduates.length; i++) {
   			if (graduates[i].getYear() == yearOption) {
			    System.out.println("Name: " + graduates[i].getName() + 
	                       "\tDegree: " + graduates[i].getDegree() + 
	                       "\tYear: " + graduates[i].getYear());  
				count++;
			}
		}

		if (count == 0) {
			System.out.println("None");
		}
		
	}

	/**
	*
	*@param option the option the user gives in the main method	
	*@return boolean whether the option is valid
	*/	
	public static boolean inputValid(String option) {
		if (option.equals("s") || option.equals("S")) {
			return true;
		} else if (option.equals("l") || option.equals("L")) {
			return true;
		} else if (option.equals("d") || option.equals("D")) {
			return true;
		} else if (option.equals("y") || option.equals("Y")) {
			return true;
		} else if (option.equals("q") || option.equals("Q")) {
			return true;
		} else {
			return false;
		}
	}
	/**
	* Main method
	*@param args arguments for the program to run
	*/

	public static void main(String[] args) {
		int lines = 0;
		String x = args[0];
		try {
			File filename = new File(x);
			Scanner listCount = new Scanner(filename);
			while (listCount.hasNext()) {
				listCount.nextLine();
				lines += 1;
			}
			Scanner entries = new Scanner(filename);
			Graduate[] graduates = new Graduate[lines];
			for (int i = 0; i < lines; i++) {
				String line = entries.nextLine();
				Scanner lineScan = new Scanner(line);
				String name = lineScan.next();
				String degree = lineScan.next();
				int year = lineScan.nextInt();
				graduates[i] = new Graduate(name, degree, year);
			}
			Scanner console = new Scanner(System.in);
			System.out.println("Graduate Information - Please enter an option below.");
			System.out.println("");
			System.out.println("S - Display statistics");
			System.out.println("L - List all graduates");
			System.out.println("D - List graduates by degree");
			System.out.println("Y - List graduates by year");
			System.out.println("Q - Quit the program");
			System.out.println("");
			System.out.println("");
			System.out.print("Option:	");
			String option = console.next();
			if (option.equals("s")) {
				option = "S";
			} else if (option.equals("l")) {
				option = "L";
			} else if (option.equals("d")) {
				option = "D";
			} else if (option.equals("y")) {
				option = "Y";
			} else if (option.equals("q")) {
				option = "Q";
			} else {
				option = option;
			}
			while (inputValid(option) == false) {
				System.out.println("\n \n \n Invalid input, try again \n \n \n");
				System.out.println("Graduate Information - Please enter an option below.");
				System.out.println("");
				System.out.println("S - Display statistics");
				System.out.println("L - List all graduates");
				System.out.println("D - List graduates by degree");
				System.out.println("Y - List graduates by year");
				System.out.println("Q - Quit the program");
				System.out.println("");
				System.out.println("");
				System.out.print("Option:	");
				option = console.next();
				if (option.equals("s")) {
					option = "S";
				} else if (option.equals("l")) {
					option = "L";
				} else if (option.equals("d")) {
					option = "D";
				} else if (option.equals("y")) {
					option = "Y";
				} else if (option.equals("q")) {
					option = "Q";
				} 
			} 

			if (option.equals("S")) {
				displayStatistics(graduates);
			} else if (option.equals("L")) {
				listAll(graduates);
			} else if (option.equals("D")) {
				listByDegree(console, graduates);
			} else if (option.equals("Y")) {
				listByYear(console, graduates);
			} else if (option.equals("Q")) {
				System.out.println("Goodbye!");
			} else {
				System.out.println("Something went wrong :(((((((");
			}
		} catch (FileNotFoundException e){
			System.out.println("File not found, try rerunning the program");
		}
	}
}
