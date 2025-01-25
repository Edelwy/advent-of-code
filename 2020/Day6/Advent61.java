import java.util.*;

public class Advent61 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		boolean[] yes = new boolean[26];
		char[] abeceda = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'y', 'x', 'z'};
		int vsota = 0; 
		
		// System.out.print(konecLine); testing shortcut
		// if(!sc.hasNextLine()) break;
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.length() == 0) {
				vsota = numberYes(yes, vsota);
				// System.out.println(vsota);
				Arrays.fill(yes, false);
				continue;
			}
			
			char onePerson[] = line.toCharArray(); //tprej array char vsak slot en yes
			
			
			for(int da = 0; da < onePerson.length; da++) {
				for(int crka = 0; crka < abeceda.length; crka++) {
					if(onePerson[da] == abeceda[crka]) {
						yes[crka] = true;
						break;
					}
				}
			}
			// System.out.println(Arrays.toString(yes));
		}
		System.out.println(vsota);
	}
	
	public static int numberYes(boolean[] yes, int vsota) {
		for(int crka = 0; crka < yes.length; crka++) {
			if(yes[crka] == true) vsota++;
		}
		return vsota;
	}
}