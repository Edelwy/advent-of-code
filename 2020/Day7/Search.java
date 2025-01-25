
public class Search {
	private String[][] iskanaTorba;
	
	public Search(String[][] tabela) {
		this.iskanaTorba = tabela;
	}
	
	public void izracun(Search tabela) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> scanVsehVrstic = new ArrayList<String>();
		String[][] vseValidTorbe = new String[600][2]; 
		int vsota = 0;
		
		String[] novaIskanaTorba = new String[2];
		System.arraycopy(this.iskanaTorba, 0, novaIskanaTorba, 0, 2);
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			scanVsehVrstic.add(line);
		}
		
		String[] vseVrstice =  scanVsehVrstic.toArray(new String[scanVsehVrstic.size()]);
	
		int stIndeksa = 0;
		for(int i = 0; i < vseVrstice.length; i++) {
			String vrstica = vseVrstice[i];
			String besedeVrstice[]= vrstica.split(" ");
			
			
			for(int j = 2; j < besedeVrstice.length; j++) {
				if(besedeVrstice[j].equals(this.iskanaTorba[0])) {
					if(besedeVrstice[j + 1].equals(this.iskanaTorba[1])) {
						novaIskanaTorba[0] = besedeVrstice[0];
						novaIskanaTorba[1] = besedeVrstice[1];
						vseValidTorbe[stIndeksa][0] = novaIskanaTorba[0];
						vseValidTorbe[stIndeksa][1] = novaIskanaTorba[1];
						stIndeksa++;
						//System.out.printf("To je %d vrstica in %d beseda %n", i, j);
					}
				}
			}
			//System.out.println(Arrays.toString(novaIskanaTorba));
			//System.out.println(Arrays.toString(iskanaTorba));
			//for(int m = 0; m < vseValidTorbe.length; m++) System.out.println(Arrays.toString(vseValidTorbe[m]));
		}
		
		int indeks = 0;
		for(int i = 0; i < vseValidTorbe.length; i++) {
			if(vseValidTorbe[i][0] == null) {
				indeks = i;
				break;
			}
		}
		
		String[][] novaVseValidTorbe = new String[indeks][2];
		System.arraycopy(vseValidTorbe, 0, novaVseValidTorbe, 0, indeks);
		
		
		for(int m = 0; m < novaVseValidTorbe.length; m++) System.out.println(Arrays.toString(novaVseValidTorbe[m]));
		
		vsota = novaVseValidTorbe.length;
	}
}