import java.util.*;

public class Advent31 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int korak = 0;
		int drevesa = 0;
		int vrstica = 1;
		int loop = 0; //mamo 3 loops 
		String znak = "#"; 
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			String enaLinija[]= line.split("");
			
			
			if(znak.equals(enaLinija[korak]))
				drevesa++;
			
			korak = korak + 3;
			vrstica++;
			
			if((vrstica == 12) && (loop == 0)) {
				korak = 2; 
				vrstica = 1;
				loop++; //loop od tle naprej je 1
			} else if((vrstica == 11) && (loop == 1)) {
				korak = 1;
				vrstica = 1;
				loop++;
			} else if((vrstica == 11) && (loop == 2)) {
				korak = 0;
				vrstica = 1;
				loop = 0;
			}	 
		}
		System.out.print(drevesa); 
	}
}