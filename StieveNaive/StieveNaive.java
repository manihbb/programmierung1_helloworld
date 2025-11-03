public class StieveNaive {
    public static void main(String[] args) {
        int n = 25;
        // Schritt 1: Liste aller Zahlen von 2 bis n
        boolean[] numbers = new boolean[n + 1];  // Index = Zahl
        for (int i = 2; i <= n; i++) {
            numbers[i] = true;  // alle als "potenziell prim" markieren
        }

        // Schritt 2: Für jede Zahl p von 2 bis n
        for (int p = 2; p <= n; p++) {
            if (numbers[p]) {  // p ist noch nicht gestrichen → Primzahl
                // Alle Vielfachen von p (außer p selbst) streichen
                for (int multiple = p * 2; multiple <= n; multiple += p) {
                    numbers[multiple] = false;
                }
            }
        }

        // Ausgabe der Primzahlen
        System.out.print("Primzahlen bis " + n + ": ");
        for (int i = 2; i <= n; i++) {
            if (numbers[i]) {
                System.out.print(i + " ");
            }
        }
    }
}