import java.util.*;

public class Advent12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] tabela = new int[200];
		int vsota = 0;
		int rezultat = 0;
		
		for(int i = 0; i < 200; i++) {
			tabela[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 200; i++) {
			for(int j = 0; j < 200; j++) {
				for(int k = 0; k < 200; k++) {
					vsota = tabela[i] + tabela[j] + tabela[k];
				
					if(vsota == 2020) {
						rezultat = (tabela[i] * tabela[j] * tabela[k]);
					}
				}
			}
		}
		
		System.out.print(rezultat);
	}
}