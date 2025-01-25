import java.util.*;

public class Advent111 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] mapaChar = new char[93][97]; //change if necessary//
        char[][] novaMapa = new char[93][97]; //change if necessary//
        int indeks = 0;
        boolean konec = true;
        int sestevekStolov = 0;

        for(int i = 0; i < novaMapa.length; i++) {
            for(int j = 0; j < novaMapa[0].length; j++) {
                novaMapa[i][j] = '.';
            }
        }

        
        while(sc.hasNextLine()) { 
            mapaChar[indeks] = sc.nextLine().toCharArray();
            indeks++;
        } // okej kle prebere dont touch this also pazi robove//

        //while(konec)
        while(konec)
        for(int c = 0; c < 100; c++) {
            for(int j = 0; j < mapaChar.length; j++) {
                for(int i = 0; i < mapaChar[0].length; i++) {
                    int vsotaPolnih = 0;
                    int vsotaPraznih = 0;

                    if((j != 0) && (j != mapaChar.length - 1) && (i != 0) && (i != mapaChar[j].length - 1)) {
                        //za vse primere ki niso robni//
                        if(mapaChar[j][i] == 'L') {
                            if((mapaChar[j - 1][i - 1] == 'L') || (mapaChar[j - 1][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j - 1][i] == 'L') || (mapaChar[j - 1][i] == '.'))vsotaPraznih++;
                            if((mapaChar[j - 1][i + 1] == 'L') || (mapaChar[j - 1][i + 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j][i - 1] == 'L') || (mapaChar[j][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j][i + 1] == 'L') || (mapaChar[j][i + 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i - 1] == 'L') || (mapaChar[j + 1][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i] == 'L') || (mapaChar[j + 1][i] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i + 1] == 'L') || (mapaChar[j + 1][i + 1] == '.')) vsotaPraznih++;
                        }

                        if(mapaChar[j][i] == '#') {
                            if(mapaChar[j - 1][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j - 1][i] == '#') vsotaPolnih++;
                            if(mapaChar[j - 1][i + 1] == '#') vsotaPolnih++;
                            if(mapaChar[j][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j][i + 1] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i + 1] == '#') vsotaPolnih++;
                        }

                        if((mapaChar[j][i] == 'L') && (vsotaPraznih == 8)) novaMapa[j][i] = '#';
                        if((mapaChar[j][i] == 'L') && (vsotaPraznih != 8)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih > 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih <= 3)) novaMapa[j][i] = '#';
                    }
                    
                    else if((j == 0) && (i != 0) && (i != mapaChar[j].length - 1)) {
                        //za primer ko je v zgornji vrstici in ne na robu!//
                        if(mapaChar[j][i] == 'L') 
                            if((mapaChar[j][i - 1] == 'L') || (mapaChar[j][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j][i + 1] == 'L') || (mapaChar[j][i + 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i - 1] == 'L') || (mapaChar[j + 1][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i] == 'L') || (mapaChar[j + 1][i] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i + 1] == 'L') || (mapaChar[j + 1][i + 1] == '.')) vsotaPraznih++;

                        if(mapaChar[j][i] == '#') {
                            if(mapaChar[j][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j][i + 1] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i + 1] == '#') vsotaPolnih++;
                        }

                        if((mapaChar[j][i] == 'L') && (vsotaPraznih == 5)) novaMapa[j][i] = '#';
                        if((mapaChar[j][i] == 'L') && (vsotaPraznih != 5)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih > 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih <= 3)) novaMapa[j][i] = '#';
                    }

                    else if((j == mapaChar.length - 1) && (i != 0) && (i != mapaChar[j].length - 1)) {
                        //za primer ko je v spodnji vrstici in ne na robu!//
                        if(mapaChar[j][i] == 'L') {
                            if((mapaChar[j - 1][i - 1] == 'L') || (mapaChar[j - 1][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j - 1][i] == 'L') || (mapaChar[j - 1][i] == '.'))vsotaPraznih++;
                            if((mapaChar[j - 1][i + 1] == 'L') || (mapaChar[j - 1][i + 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j][i - 1] == 'L') || (mapaChar[j][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j][i + 1] == 'L') || (mapaChar[j][i + 1] == '.')) vsotaPraznih++;
                        }

                        if(mapaChar[j][i] == '#') {
                            if(mapaChar[j - 1][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j - 1][i] == '#') vsotaPolnih++;
                            if(mapaChar[j - 1][i + 1] == '#') vsotaPolnih++;
                            if(mapaChar[j][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j][i + 1] == '#') vsotaPolnih++;
                        }

                        if((mapaChar[j][i] == 'L') && (vsotaPraznih == 5)) novaMapa[j][i] = '#';
                        if((mapaChar[j][i] == 'L') && (vsotaPraznih != 5)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih > 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih <= 3)) novaMapa[j][i] = '#';
                    }

                    else if((j != 0) && (j != mapaChar.length - 1) && (i == 0)) {
                        //ne v zgornji in spodnji ampak v prvem stoplcu//
                        if(mapaChar[j][i] == 'L') {
                            if((mapaChar[j - 1][i] == 'L') || (mapaChar[j - 1][i] == '.'))vsotaPraznih++;
                            if((mapaChar[j - 1][i + 1] == 'L') || (mapaChar[j - 1][i + 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j][i + 1] == 'L') || (mapaChar[j][i + 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i] == 'L') || (mapaChar[j + 1][i] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i + 1] == 'L') || (mapaChar[j + 1][i + 1] == '.')) vsotaPraznih++;
                        }

                        if(mapaChar[j][i] == '#') {
                            if(mapaChar[j - 1][i] == '#') vsotaPolnih++;
                            if(mapaChar[j - 1][i + 1] == '#') vsotaPolnih++;
                            if(mapaChar[j][i + 1] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i + 1] == '#') vsotaPolnih++;
                        }

                        if((mapaChar[j][i] == 'L') && (vsotaPraznih == 5)) novaMapa[j][i] = '#';
                        if((mapaChar[j][i] == 'L') && (vsotaPraznih != 5)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih > 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih <= 3)) novaMapa[j][i] = '#';

                    }

                    else if((j != 0) && (j != mapaChar.length - 1) && (i == mapaChar[j].length - 1)) {
                        //ne zgoraj in spodaj ampak na desnem robu//
                        if(mapaChar[j][i] == 'L') {
                            if((mapaChar[j - 1][i - 1] == 'L') || (mapaChar[j - 1][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j - 1][i] == 'L') || (mapaChar[j - 1][i] == '.'))vsotaPraznih++;
                            if((mapaChar[j][i - 1] == 'L') || (mapaChar[j][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i - 1] == 'L') || (mapaChar[j + 1][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i] == 'L') || (mapaChar[j + 1][i] == '.')) vsotaPraznih++;
                        }

                        if(mapaChar[j][i] == '#') {
                            if(mapaChar[j - 1][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j - 1][i] == '#') vsotaPolnih++;
                            if(mapaChar[j][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i] == '#') vsotaPolnih++;
                        }

                        if((mapaChar[j][i] == 'L') && (vsotaPraznih == 5)) novaMapa[j][i] = '#';
                        if((mapaChar[j][i] == 'L') && (vsotaPraznih != 5)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih > 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih <= 3)) novaMapa[j][i] = '#';
                    }

                    else if((j == 0) && (i == 0)) {
                        //zgornji levi rob//
                        if(mapaChar[j][i] == 'L') {
                            if((mapaChar[j][i + 1] == 'L') || (mapaChar[j][i + 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i] == 'L') || (mapaChar[j + 1][i] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i + 1] == 'L') || (mapaChar[j + 1][i + 1] == '.')) vsotaPraznih++;
                        }

                        if(mapaChar[j][i] == '#') {
                            if(mapaChar[j][i + 1] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i + 1] == '#') vsotaPolnih++;
                        }

                        if((mapaChar[j][i] == 'L') && (vsotaPraznih == 3)) novaMapa[j][i] = '#';
                        if((mapaChar[j][i] == 'L') && (vsotaPraznih != 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih > 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih <= 3)) novaMapa[j][i] = '#';
                    }

                    else if((j == 0) && (i == mapaChar[j].length - 1)) {
                        //zgornji desni rob//
                        if(mapaChar[j][i] == 'L') {
                            if((mapaChar[j][i - 1] == 'L') || (mapaChar[j][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i - 1] == 'L') || (mapaChar[j + 1][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j + 1][i] == 'L') || (mapaChar[j + 1][i] == '.')) vsotaPraznih++;
                        }

                        if(mapaChar[j][i] == '#') {
                            if(mapaChar[j][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j + 1][i] == '#') vsotaPolnih++;
                        }

                        if((mapaChar[j][i] == 'L') && (vsotaPraznih == 3)) novaMapa[j][i] = '#';
                        if((mapaChar[j][i] == 'L') && (vsotaPraznih != 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih > 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih <= 3)) novaMapa[j][i] = '#';
                    }

                    else if((j == mapaChar.length - 1) && (i == 0)) {
                        //spodnji levi kot//
                        if(mapaChar[j][i] == 'L') {
                            if((mapaChar[j - 1][i] == 'L') || (mapaChar[j - 1][i] == '.'))vsotaPraznih++;
                            if((mapaChar[j - 1][i + 1] == 'L') || (mapaChar[j - 1][i + 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j][i + 1] == 'L') || (mapaChar[j][i + 1] == '.')) vsotaPraznih++;
                        }

                        if(mapaChar[j][i] == '#') {
                            if(mapaChar[j - 1][i] == '#') vsotaPolnih++;
                            if(mapaChar[j - 1][i + 1] == '#') vsotaPolnih++;
                            if(mapaChar[j][i + 1] == '#') vsotaPolnih++;
                        }

                        if((mapaChar[j][i] == 'L') && (vsotaPraznih == 3)) novaMapa[j][i] = '#';
                        if((mapaChar[j][i] == 'L') && (vsotaPraznih != 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih > 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih <= 3)) novaMapa[j][i] = '#';
                    }

                    else if((j == mapaChar.length - 1) && (i == mapaChar[j].length - 1)) {
                        //spodnji desni rob//
                        if(mapaChar[j][i] == 'L') {
                            if((mapaChar[j - 1][i - 1] == 'L') || (mapaChar[j - 1][i - 1] == '.')) vsotaPraznih++;
                            if((mapaChar[j - 1][i] == 'L') || (mapaChar[j - 1][i] == '.'))vsotaPraznih++;
                            if((mapaChar[j][i - 1] == 'L') || (mapaChar[j][i - 1] == '.')) vsotaPraznih++;
                        }

                        if(mapaChar[j][i] == '#') {
                            if(mapaChar[j - 1][i - 1] == '#') vsotaPolnih++;
                            if(mapaChar[j - 1][i] == '#') vsotaPolnih++;
                            if(mapaChar[j][i - 1] == '#') vsotaPolnih++;
                        }

                        if((mapaChar[j][i] == 'L') && (vsotaPraznih == 3)) novaMapa[j][i] = '#';
                        if((mapaChar[j][i] == 'L') && (vsotaPraznih != 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih > 3)) novaMapa[j][i] = 'L';
                        if((mapaChar[j][i] == '#') && (vsotaPolnih <= 3)) novaMapa[j][i] = '#';
                    }
                    
                }
            }
            
            for(int a = 0; a < mapaChar.length; a++) {
                for(int b = 0; b < mapaChar[0].length; b++) {
                    if(mapaChar[a][b] == novaMapa[a][b])
                    sestevekStolov++;
                }
            }
            //System.out.println(sestevekStolov);

            /*just testing shit//
            System.out.println(" ");
            for(int i = 0; i < mapaChar.length; i++)
            System.out.println(Arrays.toString(novaMapa[i]));

            /*System.out.println(" ");
            System.out.println("--------------------------------");

            for(int i = 0; i < mapaChar.length; i++)
            System.out.println(Arrays.toString(mapaChar[i]));
            //just testing shit out*/

            if(sestevekStolov == (mapaChar.length * mapaChar[0].length)) konec = false; //spremeni na  93 * 97 = 9021
            mapaChar = tabelaCopy(novaMapa);
            sestevekStolov = 0;
        }

        for(int a = 0; a < mapaChar.length; a++) {
            for(int b = 0; b < mapaChar[0].length; b++) {
                if(mapaChar[a][b] == '#')
                sestevekStolov++;
            }
        }
        System.out.println(sestevekStolov);
        /* for(int i = 0; i < mapaChar.length; i++)
        System.out.println(Arrays.toString(mapaChar[i])); */
    }

    public static char[][] tabelaCopy(char[][] novaMapa) {
        final char[][] kopija = new char[novaMapa.length][];

        for (int i = 0; i < novaMapa.length; i++) {
            kopija[i] = Arrays.copyOf(novaMapa[i], novaMapa[i].length);
        }
        
        return kopija;
    }
}
