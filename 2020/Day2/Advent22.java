import java.util.*;

public class Advent22 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stGesel = 1000;
		int vsotaPravilihGesel = 0;
		
		for(int i = 0; i < stGesel; i++) {
			String line = sc.nextLine();
			
			String tabela1[]= line.split(" ");
			
			String prviDel = tabela1[0];
			String drugiDel = tabela1[1];
			String tretjiDel = tabela1[2];
			
			String tabela2[]= prviDel.split("-");
			String tabela3[]= drugiDel.split("");
			String tabela4[]= tretjiDel.split("");
			
			int pozicija1 = (Integer.parseInt(tabela2[0]) - 1);
			int pozicija2 = (Integer.parseInt(tabela2[1]) - 1);
			
			String pogojnaCrka = tabela3[0];
			
			String crkaGesla1 = tabela4[pozicija1];
			String crkaGesla2 = tabela4[pozicija2];
			
			if((!(pogojnaCrka.equals(crkaGesla1)) && (pogojnaCrka.equals(crkaGesla2))) || ((pogojnaCrka.equals(crkaGesla1)) && !(pogojnaCrka.equals(crkaGesla2))))
				vsotaPravilihGesel++;
		}
		
		System.out.println(vsotaPravilihGesel);
	}
}
				
		