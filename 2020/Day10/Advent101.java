import java.util.*;

public class Advent101 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int indeks = 1;
        int[] input = new int[96]; //tukej kolikor je vrstic change if necessary pri nas 96, 33 za test//
        input[0] = 0;
        long opcije = 7; //specificno zato da se znebimo nicle prns

        while(sc.hasNextInt()) { 
            input[indeks] = sc.nextInt();
            indeks++;
        } //tukej mamo vse vrstice v inputu//

        Arrays.sort(input);
        for(int i = 0; i < input.length - 1; i++)
        input[i] = input[i + 1];
        input[95] = input[94] + 3; //PAZI DA SPREMENIS//


        System.out.println(Arrays.toString(input));
        for(int i = 0; i < input.length - 1; i++) {
            if(((input[i + 1] - input[i]) == 3)) {
                for(int j = i + 1; j < input.length - 1; j++) {
                    if((input[j + 1] - input[j]) == 3) {
                        if((i + 1) == j) break;
                        System.out.println("to je zacetni: " + input[i + 1]);
                        System.out.println("to je koncni: " + input[j]);
                        opcije = opcije * jebenaRekurzija((i + 1), j, input);
                        System.out.println("rezultat: " + opcije);
                        break;
                    }
                }
            }
        }

        System.out.println(opcije);
    }  

    public static long jebenaRekurzija( int zacetni, int koncni, int[] input){
        int rezultat = 0; 
        long vsotaRekurzije = 0;
        //System.out.println("to je zacetni: " + input[zacetni]);
        if(input[zacetni] == input[koncni]) return 1;

        for(int i = zacetni + 1; i <= koncni; i++) {
            rezultat = input[i] - input[zacetni];
            //System.out.println("to je novi zacetni: " + input[i]);
            // System.out.println("rezultat: " + rezultat);
            if(rezultat > 3) break;
            vsotaRekurzije += jebenaRekurzija(i, koncni, input);
            //System.out.println("vsota: " + vsotaRekurzije);
        }
        return vsotaRekurzije;
    }
}
