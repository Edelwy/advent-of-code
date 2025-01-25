import java.util.*;

public class Advent32 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int right = 1;
		int down = 2;
		int korak = 0;
		int drevesa = 0; 
		int stZnakov = 31;
		int vrstica = 1;
		String znak = "#"; 
		
		while(sc.hasNextLine()) {
			
			String line = sc.nextLine();
			String enaLinija[]= line.split("");
			
			if((vrstica % down) == 0) {
				vrstica++;
				continue; 
			}
			
			if(znak.equals(enaLinija[korak]))
				drevesa++;
			
			korak = ((korak + right) % stZnakov);
			vrstica++;
		}
		System.out.print(drevesa); 
	}
}