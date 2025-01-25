import java.util.*;

public class Advent21 {
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
			
			int min = Integer.parseInt(tabela2[0]);
			int max = Integer.parseInt(tabela2[1]);
			
			String pogojnaCrka = tabela3[0];
			
			int vsotaPogoja = 0;
			
			for(int j = 0; j < tabela4.length; j++) {
				String crkaGesla = tabela4[j];
				if(pogojnaCrka.equals(crkaGesla))
				 vsotaPogoja++;
			}
			
			if((vsotaPogoja >= min) && (vsotaPogoja <= max))
				vsotaPravilihGesel++;
		}
		
		System.out.println(vsotaPravilihGesel);
	}
}
				
		