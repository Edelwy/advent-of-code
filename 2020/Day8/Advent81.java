import java.util.*;

public class Advent81 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int accumulator = 0;
		String acc = "acc";
		String jmp = "jmp";
		String nop = "nop";
		int i = 0;
		int start = 0;
		int testna = 0;
		int testnaPrej = 0;
		ArrayList<String> vrsticeList = new ArrayList<String>();
		ArrayList<String> indeksi = new ArrayList<String>();
		int indeksVrstice = 0;
		boolean konec = true;
		
		int[] tabelaJumps = new int[300];
		// int[] tabelaNoops = new int[300];
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			vrsticeList.add(line);
			indeksVrstice++;
		}
		
		String[] vrstice = vrsticeList.toArray(new String[vrsticeList.size()]);
		tabelaJumps = najdi(vrstice, jmp, tabelaJumps);
		// testna[] = najdi(vrstice, nop, int[] tabelaNoops);
		
		while(i < vrstice.length) {
			
			String[] besede = vrstice[i].split(" ");
			//System.out.println("to je vrstica: " +  Arrays.toString(besede));
			
			if(besede[0].equals(acc)) {
				accumulator = accumulatorMethod(accumulator, besede, i);
				i++;
			}
			
			else if(besede[0].equals(jmp)) {
				i = jump(accumulator, besede, i);
			}
			
			else if(besede[0].equals(nop)) i++;
			//System.out.println(accumulator);
			
			// System.out.println(i);
			/* String value = String.valueOf(i);
			indeksi.add(value);
			
			for(int k = 0; k < indeksi.size(); k++) {
				for(int m = 0; m < indeksi.size(); m++) {
					String prvi = indeksi.get(k);
					String drugi = indeksi.get(m);
					if(k != m) {
						if(prvi.equals(drugi))  konec = false;
					}
				}
			}
			
			
			if(!konec) {
				testna = tabelaJumps[start + 1];
				testnaPrej = tabelaJumps[start];
				vrstice = change(testna, testnaPrej, vrstice, jmp);
				start++;
				i = 0;
				
				indeksi.clear();
				if(testna == 0) break;
		
			}
			konec = true; */
		}
		
		System.out.print(accumulator);
	}
	
	public static int accumulatorMethod(int accumulator, String[] besede, int i) {
		int stevilo = Integer.parseInt(besede[1]);
		accumulator += stevilo;
		return accumulator;
	}
	
	public static int jump(int accumulator, String[] besede, int i) {
		int stevilo = Integer.parseInt(besede[1]);
		i = i + stevilo;
		//System.out.println(stevilo);
		return i;
	}
	
	public static String[] change(int testna, int testnaPrej, String[] vrstice, String either) {
		String[] besede = vrstice[testna].split(" ");
		// System.out.println("to je vrstica: " + Arrays.toString(besede));
		besede[0] = "nop";
		String novaVrstica = besede[0]  + " " +  besede[1];
		//System.out.println(novaVrstica);
		vrstice[testna] = novaVrstica;
		
		String[] besede2 = vrstice[testnaPrej].split(" ");
		// System.out.println("to je vrstica prej: " + Arrays.toString(besede2));
		besede2[0] = "jmp";
		String novaVrstica2 = besede2[0] + " " + besede2[1];
		//System.out.println(novaVrstica2);
		vrstice[testnaPrej] = novaVrstica2;
		
		System.out.println("to so vrstice: " + Arrays.toString(vrstice));
		
		return vrstice;
	}
	
	public static int[] najdi(String[] vrstice, String either, int[] tabela) {
		int indeks = 0;
		for(int i = 0; i < vrstice.length; i++) {
			String[] besede = vrstice[i].split(" ");
			if(besede[0].equals(either)) {
				tabela[indeks] = i;
				indeks++;
			}
		// System.out.println("to so skoki: " +  Arrays.toString(tabela));
		}
		return tabela;
	}
}






















