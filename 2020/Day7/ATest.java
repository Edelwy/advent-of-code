import java.util.*;
import java.util.stream.*;

public class ATest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iscemo = "shiny gold";
		ArrayList<String> scanVsehVrstic = new ArrayList<String>();
		ArrayList<String> kovcki = new ArrayList<String>();
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			scanVsehVrstic.add(line);
		}
		
		
		
		// govorimo o vrstici kjer bo vsak kufer ki bo valid notr po vrsti!!
		
		
		String[] vseVrstice =  scanVsehVrstic.toArray(new String[scanVsehVrstic.size()]);
		
		//---------------------- skeniran ceu input file ------------------------// 
		
		najdeKovcke(vseVrstice, iscemo, kovcki);
		String[] rezultat =  kovcki.toArray(new String[kovcki.size()]);
		System.out.println(Arrays.toString(rezultat));
		
		int vsota = rezultat.length;
		
		for(int i = 0; i < rezultat.length; i++) {
			for(int j = i + 1; j < rezultat.length; j++) {
				if(rezultat[j].equals(rezultat[i])) {
					vsota = vsota - 1;
					break;
				}
			}
		}
		
		System.out.println(vsota);
		
		
	}
	
	public static void najdeKovcke(String[] vseVrstice, String iscemo, ArrayList<String> kovcki) {
		String[] poLinijah =  new String[50]; //aproximatly
		String iskanaTorba[]= iscemo.split(" ");
		// System.out.println("to je torba nasa: " +  Arrays.toString(iskanaTorba));
		int stIndeksa = 0;
		
		for(int i = 0; i < vseVrstice.length; i++) {
			String vrstica = vseVrstice[i];
			String besedeVrstice[]= vrstica.split(" ");
			
			for(int j = 2; j < besedeVrstice.length; j++) {
				if(besedeVrstice[j].equals(iskanaTorba[0])) {
					if(besedeVrstice[j + 1].equals(iskanaTorba[1])) {
						String kovcek = besedeVrstice[0] + " " + besedeVrstice[1];
						poLinijah[stIndeksa] = kovcek;
						stIndeksa++;
					}
				}
			}
		}
		
		// System.out.println("to je tabelca: " +  Arrays.toString(poLinijah));
		if(poLinijah[0] == null) {
			return;
		}
		
		razdelimoKovcke(poLinijah, vseVrstice, kovcki);
	}
	
	public static void razdelimoKovcke(String[] poLinijah, String[] vseVrstice, ArrayList<String> kovcki) {
		
		int steviloKovckov = stetjeKovckov(poLinijah);
		
		for(int i = 0; i < steviloKovckov; i++) {
			String enKovcek = poLinijah[i];
			kovcki.add(enKovcek);
			najdeKovcke(vseVrstice, enKovcek, kovcki); 
		}
		
		
	}
	
	public static int stetjeKovckov(String[] poLinijah) {
		int indeks = 0;
		for(int i = 0; i < poLinijah.length; i++) {
			if(poLinijah[i] == null) {
				indeks = i;
				break;
			}
		}
		
		String[] poLinijahBrezNull = new String[indeks];
		System.arraycopy(poLinijah, 0, poLinijahBrezNull, 0, indeks);
		int dolzinaTabele = poLinijahBrezNull.length;
		
		return dolzinaTabele;
	}
}