public class Wurf {
    static void main() {
        //double zufallszahl = Math.random();
        //System.out.println("Wert der Zufallszahl: " + zufallszahl);

        //double richtigeBreite = zufallszahl * 6;
        //System.out.println(richtigeBreite);

        //int ohneNachkomma = (int)richtigeBreite;
        //System.out.println(ohneNachkomma);

        //int wuerfelaufgen = ohneNachkomma + 1;
        //System.out.println(wuerfelaufgen)
       int wuerfel;
        do {
            wuerfel = (int)(Math.random() * 6) + 1; // Generate random number from 1 to 6
            System.out.println(wuerfel);
        } while (wuerfel != 6);
    }
}
