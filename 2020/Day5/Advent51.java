import java.util.*;

public class Advent51 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] sedezID = new int[872];
		int indeks = 0;
		// ArrayList<String> list = new ArrayList<String>();
		// list.add(ID);
		// String[] sedezi =  list.toArray(new String[list.size()]);
		
		while(sc.hasNextLine()) {
			String ID = sc.nextLine();	
			String sedezi[]= ID.split("");
			// System.out.println(Arrays.toString(sedezi));
			
			String[] tabelaVrst = new String[7];
			System.arraycopy(sedezi, 0, tabelaVrst, 0, 7);
			
			String[] tabelaSedezev = new String[3];
			System.arraycopy(sedezi, 7, tabelaSedezev, 0, 3);
			
			int search = 0;
			int spmVrst = 0;
			int zgmVrst = 127;
			int spmSedezov = 0;
			int zgmSedezov = 7;
			int seat = 0;
			
			int row = vrsta(tabelaVrst, search, spmVrst, zgmVrst, seat);
			int column = kolumna(tabelaSedezev, search, spmSedezov, zgmSedezov, seat);
			sedezID[indeks] = (row * 8) + column;
			indeks++;
			
			System.out.println(row);
			System.out.println(column);
			
		}
		Arrays.sort(sedezID);
		System.out.println(sedezID[871]);
	}
	
	
	public static int vrsta(String[] tabelaVrst, int search, int spmVrst, int zgmVrst, int seat) {
		String F = "F";
		String B = "B";
		
		if(F.equals(tabelaVrst[search])) {
			zgmVrst = (zgmVrst + spmVrst) / 2;
			// System.out.println("F " + zgmVrst + " " + spmVrst);
			if(search == 6) return zgmVrst;
			seat = vrsta(tabelaVrst, (search + 1), spmVrst, zgmVrst, seat);
			// System.out.println(seat);
		}
		
		if(B.equals(tabelaVrst[search])) {
			spmVrst = ((zgmVrst + spmVrst) / 2) + 1;
			// System.out.println("B " + zgmVrst + " " + spmVrst);
			if(search == 6) return spmVrst;
			seat = vrsta(tabelaVrst, (search + 1), spmVrst, zgmVrst, seat);
			// System.out.println(seat);
		}
		return seat;
	}
	
	public static int kolumna(String[] tabelaSedezev, int search, int spmSedezov, int zgmSedezov, int seat) {
		String L = "L";
		String R = "R";
		
		if(L.equals(tabelaSedezev[search])) {
			zgmSedezov = (zgmSedezov + spmSedezov) / 2;
			// System.out.println("L krog " + zgmSedezov + " " + spmSedezov);
			if(search == 2) return zgmSedezov;
			seat = kolumna(tabelaSedezev, (search + 1), spmSedezov, zgmSedezov, seat);
			// System.out.println(seat);
		}
		
		if(R.equals(tabelaSedezev[search])) {
			spmSedezov = ((zgmSedezov + spmSedezov) / 2) + 1;
			// System.out.println("R krog" + zgmSedezov + " " + spmSedezov);
			if(search == 2) return spmSedezov;
			seat = kolumna(tabelaSedezev, (search + 1), spmSedezov, zgmSedezov, seat);
			// System.out.println(seat);
		}
		return seat;
	}
	
	
}