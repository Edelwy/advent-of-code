import java.util.*;

public class Advent41 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] validation = new boolean[8];
		String[] pogoji = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid"};
		int vsota = 0; 
		validation[7] = true;
		String[] besede = new String[8];
		
		//  System.out.print(konecLine); testing shortcut
		
		while(sc.hasNextLine()) {
			for(int i = 0; i < 8; i++) {
				if(!sc.hasNextLine()) break; 
				
				String line = sc.nextLine();
				if(line.length() == 0) break;
			
				String poPresledkih[]= line.split("[: ]");
				for(int j = 0; j < pogoji.length; j++) {
					for(int k = 0; k < poPresledkih.length; k++) {
						
						String pogojnaBeseda = pogoji[j];
						String iskanaBeseda = poPresledkih[k];
						if(pogojnaBeseda.equals(iskanaBeseda)) {
							validation[j] = true;
							besede[j] = poPresledkih[k + 1];
							break;
						}
						
						
					System.out.println(Arrays.toString(besede));
					// System.out.println(iskanaBeseda);
					}
				}
				// System.out.println("a dela loop pls " + (i + 1));
			}
			
			if(areAllTrue(validation)) {
				vsota++;
			   /* for(int j = 0; j < pogoji.length; j++) {
					if(!check(j, poPresledkih)) {
						break;
					}
					vsota++;
				} */
			}
			
			for (int m = 0; m < validation.length - 1; m++) {
				validation[m] = false;
			}
		}
		
	System.out.print(vsota);
	}
	
	public static boolean areAllTrue(boolean[] validation) {
		for(int i = 0; i < validation.length; i++) {
			if(!validation[i]) return false; 
		}
		return true;
	}
	/*
	public static boolean check(int j, String[] poPresledkih, int[] intiger) {
		boolean checker = false;
		if(j == 0) checker = birthYear;
		if(j == 1) checker = issueYear;
		if(j == 2) checker = expirationYear;
		if(j == 3) checker = height;
		if(j == 4) checker = hairColour;
		if(j == 5) checker = eyeColour;
		if(j == 6) checker = passportID;
		
		return checker; 
	}
	
	public static boolean birthYear(String[] poPresledkih, int[] intiger) {
		int indeksLeta = intiger[0] + 1
		
	}
	
	public static boolean issueYear() {
	}
	
	public static boolean expirationYear() {
	}
	
	public static boolean height() {
	}
	
	public static boolean hairColour() {
	}
	
	public static boolean eyeColour() {
	}
	
	public static boolean passportID() {
	}
	*/
}