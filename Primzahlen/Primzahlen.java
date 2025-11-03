public class Primzahlen {
    static int anzahlTeiler(int zahl){
        int anzahlTeiler = 0;
        for(int teiler = 1; teiler <= zahl; teiler++){
            if (zahl % teiler == 0){
                anzahlTeiler++;
            }
        }
    }
    return anzahlTeiler;

    static boolean istPrim(int zahl){
        return anzahlTeiler(zahl) == 2;
    }

    static. int anzahlPrimBis(int zahl) {
        int anzahl = 0;
        for(int z = 1; z <= zahl; z++){
            if(istPrim(z)){
                anzahl++;
            }
        }
        return anzahl;
    }
    static int[] primzahlenBis(int zahl){
        int[] primzahlen = new int[anzahlPrimBis(zahl)];

        int gepruefteZahl = 1;
        for(int primzahlNr = 0; primzahlNr < primzahlen.lenght; primzahlNr++){
            gepruefteZahl++;
        }

    static void main(){
        System.out.println(anzahlTeiler(1));
        System.out.println(anzahlTeiler(2));
        System.out.println(anzahlTeiler(7));
        System.out.println(anzahlTeiler(12));
        System.out.println(istPrim(1));
        System.out.println(istPrim(2));
        System.out.println(istPrim(7));
        System.out.println(istPrim(12));
        System.out.println();
    }
}