import java.util.*;
import java.util.stream.*;

public class Testing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> scanVsehVrstic = new ArrayList<String>();
		String[] iskanaTorba = {"shiny", "gold"};
		String[][] vseValidTorbe = new String[5][2]; //600!!!
		String[] vseOpcije = new String[594];
		int vsota = 0;
		
		String[] novaIskanaTorba = new String[2];
		System.arraycopy(iskanaTorba, 0, novaIskanaTorba, 0, 2);
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			scanVsehVrstic.add(line);
		}
		
		String[] vseVrstice =  scanVsehVrstic.toArray(new String[scanVsehVrstic.size()]);
		
		vsota =  search(iskanaTorba, vseValidTorbe, vseVrstice, novaIskanaTorba, vsota);
		
		System.out.println(vsota);
		
	}
	
	public static int search(String[] iskanaTorba, String[][] vseValidTorbe, String[] vseVrstice, String[] novaIskanaTorba, int vsota) {
		int stIndeksa = 0;
		
		
		for(int i = 0; i < vseVrstice.length; i++) {
			String vrstica = vseVrstice[i];
			String besedeVrstice[]= vrstica.split(" ");
			
			
			for(int j = 2; j < besedeVrstice.length; j++) {
				if(besedeVrstice[j].equals(iskanaTorba[0])) {
					if(besedeVrstice[j + 1].equals(iskanaTorba[1])) {
						novaIskanaTorba[0] = besedeVrstice[0];
						novaIskanaTorba[1] = besedeVrstice[1];
						vseValidTorbe[stIndeksa][0] = novaIskanaTorba[0];
						vseValidTorbe[stIndeksa][1] = novaIskanaTorba[1];
						stIndeksa++;
					}
				}
			}
			
			System.out.println("to je na novo iskana torba: " +  Arrays.toString(novaIskanaTorba));
			System.out.println("to je iskana torba: " + Arrays.toString(iskanaTorba));
			
		}
		
		vseValidTorbe = shorten(vseValidTorbe);
		for(int m = 0; m < vseValidTorbe.length; m++) System.out.println(Arrays.toString(vseValidTorbe[m]));
		
		int dolzina = vseValidTorbe.length;
		vseValidTorbe = lengthen(vseValidTorbe);
		
	    for(int k = 0; k < dolzina; k++) {
			if(vseValidTorbe[k][0] == null) continue;
			String[] novaTabela = vseValidTorbe[k];
			System.out.println(Arrays.toString(novaTabela));
			vsota += search(novaTabela, vseValidTorbe, vseVrstice, novaIskanaTorba, vsota);
		 }
			
		return vsota; 
		
	}
	
	public static String[][] shorten(String[][] vseValidTorbe) {
		int indeks = 0;
		for(int i = 0; i < vseValidTorbe.length; i++) {
			if(vseValidTorbe[i][0] == null) {
				indeks = i;
				break;
			}
		}
		
		String[][] novaVseValidTorbe = new String[indeks][2];
		System.arraycopy(vseValidTorbe, 0, novaVseValidTorbe, 0, indeks);
		
		return novaVseValidTorbe;
	}
	
	public static String[][] lengthen(String[][] vseValidTorbe) {
		
		String[][] pomozneTorbe = new String[10][2];
		System.arraycopy(vseValidTorbe, 0, pomozneTorbe, 0, vseValidTorbe.length);
		
		return pomozneTorbe;
	}
}