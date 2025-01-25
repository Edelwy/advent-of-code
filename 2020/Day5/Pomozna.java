import java.util.*;

public class Pomozna {
	public static void main(String[] args) {
		String[] tabelaVrst = {"L", "L", "R"};
		int search = 0;
		int spmVrst = 0;
		int zgmVrst = 7;
		int seat = 0;
		
		System.out.println(vrsta(tabelaVrst, search, spmVrst, zgmVrst, seat));
	}
		
	public static int vrsta(String[] tabelaVrst, int search, int spmVrst, int zgmVrst, int seat) {
		String L = "L";
		String R = "R";
		
		if(L.equals(tabelaVrst[search])) {
			zgmVrst = (zgmVrst + spmVrst) / 2;
			System.out.println("L " + zgmVrst + " " + spmVrst);
			if(search == 2) return zgmVrst;
			seat = vrsta(tabelaVrst, (search + 1), spmVrst, zgmVrst, seat);
			// System.out.println(seat);
		}
		
		if(R.equals(tabelaVrst[search])) {
			spmVrst = ((zgmVrst + spmVrst) / 2) + 1;
			System.out.println("R " + zgmVrst + " " + spmVrst);
			if(search == 2) return spmVrst;
			seat = vrsta(tabelaVrst, (search + 1), spmVrst, zgmVrst, seat);
			// System.out.println(seat);
		}
		return seat;
	}
}