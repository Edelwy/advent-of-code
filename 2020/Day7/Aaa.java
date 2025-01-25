import java.util.*;

public class Aaa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String iscemo = "shiny gold";
		ArrayList<String> scanVsehVrstic = new ArrayList<String>();
		ArrayList<String> vsotaKovckov = new ArrayList<String>();
		int vsota = 0;
		int dejanskoStevilo = 1;
		
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			scanVsehVrstic.add(line);
		}


		String[] vseVrstice =  scanVsehVrstic.toArray(new String[scanVsehVrstic.size()]);
		vsota = najdeOstaleKovcke(vseVrstice, iscemo, vsota, dejanskoStevilo, vsotaKovckov);
		System.out.print(vsota);
		
	}
	
	public static int najdeOstaleKovcke(String[] vseVrstice, String iscemo,int vsota, int dejanskoStevilo, ArrayList<String> vsotaKovckov) {
			
		for(int i = 0; i < vseVrstice.length; i++) {
			String vrstica = vseVrstice[i];
			String besedeVrstice[]= vrstica.split(" ");
			String iskanaTorba[]= iscemo.split(" ");
			String[] stevilke = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
			
			if(besedeVrstice[0].equals(iskanaTorba[0])) {
				if(besedeVrstice[1].equals(iskanaTorba[1])) {
					
					for(int m = 2; m < besedeVrstice.length; m++) {
						for(int n = 0; n < stevilke.length; n++) {
							
							if(besedeVrstice[m].equals(stevilke[n])) {
								String stevilo = (besedeVrstice[m]);
								dejanskoStevilo = Integer.parseInt(stevilo);
								String steviloPredTem = vsotaKovckov.get(vsotaKovckov.size());
								int dejanskoSteviloPredTem = Integer.parseInt(steviloPredTem);
								vsotaKovckov.add(stevilo);
								iscemo = besedeVrstice[m + 1] + " " + besedeVrstice[m + 2];
								vsota += dejanskoSteviloPredTem * najdeOstaleKovcke(vseVrstice, iscemo, vsota, dejanskoStevilo, vsotaKovckov);
							}
						}
					}
				}
			} else return dejanskoStevilo;
		}
		return dejanskoStevilo;
	}
}