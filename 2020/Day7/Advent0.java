import java.util.*;
import java.util.stream.*;

public class Advent0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iscemo = "shiny gold";
		ArrayList<String> scanVsehVrstic = new ArrayList<String>();
		ArrayList<String> kovcki = new ArrayList<String>();
		ArrayList<String> vsotaKovckov = new ArrayList<String>();
		ArrayList<String> vsotaKonec = new ArrayList<String>();
		
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			scanVsehVrstic.add(line);
		}
		
		int vsota = 0;
		int delnaVsota = 1;
		int odstevek = 0;
		int indeksRekurzije = 0;
		int seEnIndeks = 0;
		
		
		
		// govorimo o vrstici kjer bo vsak kufer ki bo valid notr po vrsti!!
		
		
		String[] vseVrstice =  scanVsehVrstic.toArray(new String[scanVsehVrstic.size()]);
		
		//---------------------- skeniran ceu input file ------------------------// 
		
		//najdeKovcke(vseVrstice, iscemo, kovcki);
		//String[] rezultat =  kovcki.toArray(new String[kovcki.size()]);
		
		vsota = najdeOstaleKovcke(iscemo, vseVrstice, vsotaKovckov, vsota, delnaVsota, odstevek, indeksRekurzije, vsotaKonec, seEnIndeks);
		String[] rezultat =  vsotaKovckov.toArray(new String[vsotaKovckov.size()]);
	
		
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
	
	public static int najdeOstaleKovcke(String iscemo, String[] vseVrstice, ArrayList<String> vsotaKovckov, int vsota, int delnaVsota, int odstevek, int indeksRekurzije, ArrayList<String> vsotaKonec, int seEnIndeks) {
		String[] poLinijah =  new String[15]; 
		String iskanaTorba[]= iscemo.split(" ");
		boolean[] validVrstica = new boolean[vseVrstice.length]; 
		String[] stevilke = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		int stIndeksa = 0;
		
		for(int i = 0; i < vseVrstice.length; i++) {
			String vrstica = vseVrstice[i];
			String besedeVrstice[]= vrstica.split(" ");

			if(besedeVrstice[0].equals(iskanaTorba[0])) {
				if(besedeVrstice[1].equals(iskanaTorba[1])) {
				
					for(int m = 2; m < besedeVrstice.length; m++) {
						for(int n = 0; n < stevilke.length; n++) {
							if(besedeVrstice[m].equals(stevilke[n])) {
								String stevilo = (besedeVrstice[m]);
								vsotaKovckov.add(stevilo);
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
			String[] rezultat =  vsotaKovckov.toArray(new String[vsotaKovckov.size()]);
			System.out.println(Arrays.toString(rezultat));
			delnaVsota = Integer.parseInt(vsotaKovckov.get(vsotaKovckov.size() - odstevek));
			return delnaVsota;
		}
		
		delnaVsota = kolikoKovckov(poLinijah, vseVrstice, vsotaKovckov, vsota, delnaVsota, odstevek, indeksRekurzije, vsotaKonec, seEnIndeks);
		
		return delnaVsota;
	}
	
	public static int kolikoKovckov(String[] poLinijah, String[] vseVrstice, ArrayList<String> vsotaKovckov, int vsota, int delnaVsota, int odstevek, int indeksRekurzije, ArrayList<String> vsotaKonec, int seEnIndeks) {
		int clen = 0;
		int steviloKovckov = stetjeKovckov(poLinijah);
		String linije = String.valueOf(steviloKovckov); 
		vsotaKonec.add(linije);
		System.out.println("steviloKovckov " + steviloKovckov);
		
		clen = Integer.parseInt(vsotaKovckov.get(indeksRekurzije));
		
		
		for(int i = 0; i < steviloKovckov; i++) {
			
			odstevek = steviloKovckov - i;
			String enKovcek = poLinijah[i];
			vsota += clen * najdeOstaleKovcke(enKovcek, vseVrstice, vsotaKovckov, vsota, delnaVsota, odstevek, indeksRekurzije, vsotaKonec, seEnIndeks);
			indeksRekurzije++;
			
			System.out.println("vsota potem kroga " + (i) + " " + vsota);
			
				/* if(i == steviloKovckov - 1) {
					indeksRekurzije = indeksRekurzije - 1;
					if(indeksRekurzije == -1) return vsota;
					
					int novoStevilo = Integer.parseInt(vsotaKonec.get(indeksRekurzije));
					for(int j = seEnIndeks; j < clen; j++) {
						odstevek = steviloKovckov - i;
						String novKovcek = poLinijah[i];
						vsota += clen * najdeOstaleKovcke(novKovcek, vseVrstice, vsotaKovckov, vsota, delnaVsota, odstevek, indeksRekurzije, vsotaKonec, seEnIndeks);
						return vsota;
					}
				} */
			
			//String[] rezultat =  vsotaKonec.toArray(new String[vsotaKonec.size()]);
			//System.out.println(Arrays.toString(rezultat));
		}
		seEnIndeks++;
		return vsota;
	}
	
	
}