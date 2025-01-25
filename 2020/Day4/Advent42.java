import java.util.*;

public class Advent42 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] validation = new boolean[8];
		String[] pogoji = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid"};
		int vsota = 0; 
		validation[7] = true;
		String[] besede = new String[8];
		
		//  System.out.print(konecLine); testing shortcut
		
		while(sc.hasNextLine()) {
			int delnaVsota = 0;
			
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
						
						
					// System.out.println(Arrays.toString(besede));
					// System.out.println(iskanaBeseda);
					}
				}
			}
			
			if(areAllTrue(validation)) {
			    for(int j = 0; j < pogoji.length; j++) 
					if(check(j, besede)) delnaVsota++;
			}
			
			if(delnaVsota == 7) vsota++;
			
			for (int m = 0; m < validation.length - 1; m++) {
				validation[m] = false;
			}
			delnaVsota = 0;
		}
		
	System.out.print(vsota);
	}
	
	public static boolean areAllTrue(boolean[] validation) {
		for(int i = 0; i < validation.length; i++) {
			if(!validation[i]) return false; 
		}
		return true;
	}
	
	public static boolean check(int j, String[] besede) {
		boolean checker = false;
		if(j == 0) checker = birthYear(besede);
		if(j == 1) checker = issueYear(besede);
		if(j == 2) checker = expirationYear(besede);
		if(j == 3) checker = height(besede);
		if(j == 4) checker = hairColour(besede);
		if(j == 5) checker = eyeColour(besede);
		if(j == 6) checker = passportID(besede);
		
		return checker; 
	}
	
	public static boolean birthYear(String[] besede) {
		// System.out.println("v loop 0");
		int leto = Integer.parseInt(besede[0]);
		if((1919 < leto) && (leto < 2003)) return true;
		return false;
	}
	
	public static boolean issueYear(String[] besede) {
		// System.out.println("v loop 1");
		int leto = Integer.parseInt(besede[1]);
		if((2009 < leto) && (leto < 2021)) return true;
		return false;
	}
	
	public static boolean expirationYear(String[] besede) {
		// System.out.println("v loop 2");
		int leto = Integer.parseInt(besede[2]);
		if((leto > 2019) && (leto < 2031)) return true;
		return false;
	}
	
	public static boolean height(String[] besede) {
		// System.out.println("v loop 3");
		String character[]= besede[3].split("");
		String cm = "c";
		String in = "i";
		if((character.length == 5) && (cm.equals(character[3]))) {
			int visina = (Integer.parseInt(character[0]) * 100) + (Integer.parseInt(character[1]) * 10) + Integer.parseInt(character[2]);
			if((149 < visina) && (visina < 194)) return true;
			return false;
		}
		
		if((character.length == 4)&& (in.equals(character[2]))) {
			int visina = (Integer.parseInt(character[0]) * 10) + Integer.parseInt(character[1]);
			if((58 < visina) && (visina < 77)) return true;
		}
		return false;
	}
	
	public static boolean hairColour(String[] besede) {
		// System.out.println("v loop 4");
		char barva[] = besede[4].toCharArray();
		if(barva.length != 7) return false;
		if(barva[0] != '#') return false;
		char pogoji[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		
		for(int i = 1; i < 7; i++) {
			for(int j = 0; j < pogoji.length; j++) {
				if(barva[i] == pogoji[j]) break;
				if(barva[i] != pogoji[j]) continue;	
			// System.out.println(barva[i] + " " + pogoji[j]);
			return false;
			}
		}
		return true;
	}
	
	public static boolean eyeColour(String[] besede) {
		// System.out.println("v loop 5");
		String barvaLas = besede[5];
		boolean test = false;
		if(barvaLas.equals("amb") || barvaLas.equals("blu") || barvaLas.equals("brn") || barvaLas.equals("gry") || barvaLas.equals("grn") || barvaLas.equals("hzl") || barvaLas.equals("oth")) {
		
			return true;
		}
		return false;
	}
	
	public static boolean passportID(String[] besede) {
		// System.out.println("v loop 6");
		char pasportNo[] = besede[6].toCharArray();
		char pogoji[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		if(pasportNo.length != 9) return false;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < pogoji.length; j++) {
				if(pasportNo[i] == pogoji[j]) break;
				if(pasportNo[i] != pogoji[j]) continue;
			return false;
			}
		}
		return true;
	}
	
}