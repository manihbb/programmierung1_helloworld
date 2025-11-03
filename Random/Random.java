public class Random {
    static void main() {
        double [] zufallszahlen = new double[50];

        printArray(zufallszahlen);

        for (int i = 0, i < zufallszahlen.length, i++) {
            zufallszahlen[i] = Math.random();
        }

        printArray(zufallszahlen);

        
    }
}