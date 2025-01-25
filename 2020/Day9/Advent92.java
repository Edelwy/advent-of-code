import java.util.Arrays;
import java.util.Scanner;

public class Advent92 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] input = new long[1000];
        // long match = 23278925 indeks 514
        
        for(int i = 0; i < 1000; i++) { //1000
            input[i] = sc.nextLong();
        } //tukej mamo vse vrstice v inputu


        
        int koncna = 0;
        int zacetna = 0;

        while(koncna == 0) {
            koncna = sestevanje(zacetna, input);
            //System.out.println(zacetna);
            zacetna++;
        }
        
        System.out.println(zacetna - 1);
        System.out.println(koncna);
        //System.out.println(input[(zacetna - 1)]);
        //System.out.println(input[(koncna)]);

        long[] tabela = new long[17];
        for(int i = 0; i < 17; i++) tabela[i] = input[(zacetna - 1 + i)];
        //System.out.print(Arrays.toString(tabela));
        Arrays.sort(tabela);
        long vsota = tabela[0] + tabela[tabela.length - 1];
        System.out.println(vsota);
        System.out.println(tabela[0]);
        System.out.println(tabela[tabela.length - 1]);



    } 

    public static int sestevanje(int zacetna, long[] input) {
        long vsota = 0;
        for(int i = zacetna; i < 514; i++) { //514
            vsota = vsota + input[i];
            //System.out.println(input[i]);
            //System.out.println(vsota);
            if(vsota == 23278925) return i;
        }
        return 0;
    }
}
