import java.util.*;
import java.util.stream.*;

public class Advent0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iscemo = "shiny gold";
		ArrayList<String> scanVsehVrstic = new ArrayList<String>();
		ArrayList<String> kovcki = new ArrayList<String>();
		ArrayList<String> vsotaKovckov = new ArrayList<String>();
		
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			scanVsehVrstic.add(line);
		}
		int vsota = 1;
		
		
		
		// govorimo o vrstici kjer bo vsak kufer ki bo valid notr po vrsti!!
		
		
		String[] vseVrstice =  scanVsehVrstic.toArray(new String[scanVsehVrstic.size()]);
		
		//---------------------- skeniran ceu input file ------------------------// 
		
		//najdeKovcke(vseVrstice, iscemo, kovcki);
		//String[] rezultat =  kovcki.toArray(new String[kovcki.size()]);
		
		najdeOstaleKovcke(iscemo, vseVrstice, vsotaKovckov, vsota);
		String[] rezultat =  vsotaKovckov.toArray(new String[vsotaKovckov.size()]);
	
		for(int i = 0; i < rezultat.length; i++) {
			int clen = Integer.parseInt(rezultat[i]);
			vsota *= clen;
		}
		System.out.println(Arrays.toString(rezultat));
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
	
	//---------------------- konc prvega dela ------------------------//
	
	public static void najdeOstaleKovcke(String iscemo, String[] vseVrstice, ArrayList<String> vsotaKovckov, int vsota) {
		String[] poLinijah =  new String[7]; 
		String iskanaTorba[]= iscemo.split(" ");
		boolean[] validVrstica = new boolean[vseVrstice.length]; 
		String[] stevilke = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		int stIndeksa = 0;
		// int delnaVsota = 0;
		
		for(int i = 0; i < vseVrstice.length; i++) {
			String vrstica = vseVrstice[i];
			String besedeVrstice[]= vrstica.split(" ");

			if(besedeVrstice[0].equals(iskanaTorba[0])) {
				if(besedeVrstice[1].equals(iskanaTorba[1])) {
				
					for(int m = 2; m < besedeVrstice.length; m++) {
						for(int n = 0; n < stevilke.length; n++) {
							if(besedeVrstice[m].equals(stevilke[n])) {
								String stevilo = (besedeVrstice[m]);
								// System.out.println("to stevilo: " +  stevilo);
								vsotaKovckov.add(stevilo);
								// delnaVsota = Integer.parseInt(stevilo);
								// vsota += delnaVsota;
								poLinijah[stIndeksa] = besedeVrstice[m + 1] + " " + besedeVrstice[m + 2];
								stIndeksa++;
							}
						}
					}
				}
			}
		}
		System.out.println(Arrays.toString(poLinijah));

		if(poLinijah[0] == null) {
			return 1;
		}
		
		int novaVsota = kolikoKovckov(poLinijah, vseVrstice, vsotaKovckov, vsota);
		return novaVsota;
	}
	
	public static void kolikoKovckov(String[] poLinijah, String[] vseVrstice, ArrayList<String> vsotaKovckov, int vsota) {
		int delnaVsota = 0;
		int steviloKovckov = stetjeKovckov(poLinijah);
		
		for(int i = 0; i < steviloKovckov; i++) {
			String enKovcek = poLinijah[i];
			delnaVsota = najdeOstaleKovcke(enKovcek, vseVrstice, vsotaKovckov, vsota);
		}	
		
		for(int i = 0; i < steviloKovckov; i++) {
			int torbe = Integer.parseInt(vsotaKovckov.get(vsotaKovckov.size() - i));
			delnaVsota = delnaVsota * torbe;
		}
		
		for(int i = 0; i < steviloKovckov; i++) {
			vsotaKovckov.remove(vsotaKovckov.size() - i);
		}
	}
	
	
}