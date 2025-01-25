import java.util.Scanner;

public class Advent91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] input = new long[1000];
        
        for(int i = 0; i < 1000; i++) {
            input[i] = sc.nextLong();
        } //tukej mamo vse vrstice v inputu
        
        boolean izjema = false;
        boolean vmesna = false;
        int vrstica = 25;
        do{
            izjema = false;
            vmesna = false;

            for(int i = (vrstica - 25); i < vrstica; i++) {
                for(int j = (vrstica - 25); j < vrstica; j++) {
                    if((input[i] + input[j]) == input[vrstica]) {
                        vmesna = true;
                        break;

                    }
                }
            }
            // System.out.println(vmesna);
            izjema = vmesna;
            if(!izjema) System.out.print(input[vrstica]);
            vrstica++;
        } 
        while(izjema);
        
    } 
}
