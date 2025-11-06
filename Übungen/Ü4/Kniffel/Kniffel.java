import java.util.Arrays;

/**
 * Lösung für die Kniffel-Aufgabe.
 * Alle 13 Kategorien sind implementiert.
 * Das Array 'dice' wird immer als 5-elementig und aufsteigend sortiert
 * vorausgesetzt.
 */
public class Kniffel {

    // --- OBERER BLOCK (1er bis 6er) ---

    /**
     * Hilfsmethode, um die Summe einer bestimmten Augenzahl zu berechnen.
     * Verhindert Code-Wiederholung für Einser bis Sechser.
     *
     * @param dice         Das sortierte Würfel-Array
     * @param targetNumber Die Augenzahl, die gezählt werden soll (1-6)
     * @return Die Summe der Würfel, die 'targetNumber' zeigen
     */
    static int sumSpecificNumber(int[] dice, int targetNumber) {
        int sum = 0;
        for (int die : dice) {
            if (die == targetNumber) {
                // Wichtig: 'targetNumber' (z.B. 2) addieren, nicht 1
                sum += targetNumber;
            }
        }
        return sum;
    }

    /**
     * Einser
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return die Summe der Augenzahlen aller Würfel, die eine 1 zeigen
     */
    static int aces(int[] dice) {
        return sumSpecificNumber(dice, 1);
    }

    /**
     * Zweier
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return die Summe der Augenzahlen aller Würfel, die eine 2 zeigen
     */
    static int twos(int[] dice) {
        return sumSpecificNumber(dice, 2);
    }

    /**
     * Dreier
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return die Summe der Augenzahlen aller Würfel, die eine 3 zeigen
     */
    static int threes(int[] dice) {
        return sumSpecificNumber(dice, 3);
    }

    /**
     * Vierer
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return die Summe der Augenzahlen aller Würfel, die eine 4 zeigen
     */
    static int fours(int[] dice) {
        return sumSpecificNumber(dice, 4);
    }

    /**
     * Fünfer
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return die Summe der Augenzahlen aller Würfel, die eine 5 zeigen
     */
    static int fives(int[] dice) {
        return sumSpecificNumber(dice, 5);
    }

    /**
     * Sechser
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return die Summe der Augenzahlen aller Würfel, die eine 6 zeigen
     */
    static int sixes(int[] dice) {
        return sumSpecificNumber(dice, 6);
    }

    // --- UNTERER BLOCK (Paschs, Straßen, etc.) ---

    /**
     * Hilfsmethode, um die Summe aller Würfel zu berechnen.
     */
    static int sumAllDice(int[] dice) {
        int sum = 0;
        for (int die : dice) {
            sum += die;
        }
        return sum;
    }

    /**
     * Dreierpasch
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return Summe aller Augenzahlen, wenn mind. 3 gleiche Zahlen vorhanden, ansonsten 0 Punkte
     */
    static int threeOfAKind(int[] dice) {
        // Da das Array sortiert ist, müssen 3 gleiche Zahlen direkt nebeneinander liegen.
        // Mögliche Positionen: [AAAxx], [xAAA_x], [xxAAA]
        if (dice[0] == dice[2] || dice[1] == dice[3] || dice[2] == dice[4]) {
            return sumAllDice(dice);
        }
        return 0;
    }

    /**
     * Viererpasch
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return Summe aller Augenzahlen, wenn mind. 4 gleiche Zahlen vorhanden, ansonsten 0 Punkte
     */
    static int fourOfAKind(int[] dice) {
        // Mögliche Positionen: [AAAAx], [xAAAA]
        if (dice[0] == dice[3] || dice[1] == dice[4]) {
            return sumAllDice(dice);
        }
        return 0;
    }

    /**
     * Full House
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return 25 Punkte bei drei gleichen und zwei gleichen Zahlen, ansonsten 0 Punkte
     */
    static int fullHouse(int[] dice) {
        // Da sortiert, nur 2 Muster möglich: [AAABB] oder [AABBB]
        // Wichtig: Der Pasch (z.B. A) muss sich vom Paar (z.B. B) unterscheiden.

        // Muster [AAABB]
        boolean case1 = dice[0] == dice[2] && dice[3] == dice[4] && dice[2] != dice[3];
        // Muster [AABBB]
        boolean case2 = dice[0] == dice[1] && dice[2] == dice[4] && dice[1] != dice[2];

        if (case1 || case2) {
            return 25;
        }
        return 0;
    }

    /**
     * Hilfsmethode für die Kleine Straße: Prüft, ob eine Zahl im Array vorkommt.
     */
    static boolean contains(int[] dice, int num) {
        for (int die : dice) {
            if (die == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * Kleine Straße
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return 30 Punkte, wenn vier (direkt) aufeinanderfolgenden Augenzahlen existieren
     */
    static int smallStraight(int[] dice) {
        // Wir müssen 4 aufeinanderfolgende Zahlen finden. Duplikate sind okay.
        // Bsp: {1, 2, 2, 3, 4} zählt als {1,2,3,4}.
        // Wir prüfen auf die 3 möglichen kleinen Straßen:
        // {1,2,3,4}, {2,3,4,5}, {3,4,5,6}

        boolean s1234 = contains(dice, 1) && contains(dice, 2) && contains(dice, 3) && contains(dice, 4);
        boolean s2345 = contains(dice, 2) && contains(dice, 3) && contains(dice, 4) && contains(dice, 5);
        boolean s3456 = contains(dice, 3) && contains(dice, 4) && contains(dice, 5) && contains(dice, 6);

        if (s1234 || s2345 || s3456) {
            return 30;
        }
        return 0;
    }

    /**
     * Große Straße
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return 40 Punkte bei fünf (direkt) aufeinanderfolgenden Augenzahlen, ansonsten 0 Punkte
     */
    static int largeStraight(int[] dice) {
        // Da sortiert, müssen die Würfel {1,2,3,4,5} oder {2,3,4,5,6} sein.
        // Wir prüfen, ob jeder Würfel 1 größer ist als sein Vorgänger.
        boolean isStraight = true;
        for (int i = 1; i < dice.length; i++) {
            if (dice[i] != dice[i - 1] + 1) {
                isStraight = false;
                break;
            }
        }

        if (isStraight) {
            return 40;
        }
        return 0;
    }

    /**
     * Kniffel
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return 50 Punkte bei fünf gleichen Zahlen, ansonsten 0 Punkte
     */
    static int kniffel(int[] dice) {
        // Da sortiert, muss nur der erste und letzte Würfel gleich sein.
        if (dice[0] == dice[4]) {
            return 50;
        }
        return 0;
    }

    /**
     * Chance
     * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
     * @return Summe aller Augenzahlen
     */
    static int chance(int[] dice) {
        return sumAllDice(dice);
    }

    /**
     * Main-Methode zum Testen.
     * Dies ist eine korrekte Main-Signatur, damit das Programm lauffähig ist.
     */
    public static void main(String[] args) {

        System.out.println("--- Testfall 1: {1, 1, 1, 2, 3} (Beispiel aus Aufgabe) ---");
        int[] dice1 = {1, 1, 1, 2, 3};
        Arrays.sort(dice1); // Sicherstellen, dass sortiert
        runTests(dice1);

        System.out.println("\n--- Testfall 2: {2, 3, 4, 5, 6} (Beispiel aus Aufgabe) ---");
        int[] dice2 = {2, 3, 4, 5, 6};
        Arrays.sort(dice2);
        runTests(dice2);
        
        System.out.println("\n--- Testfall 3: Full House {2, 2, 5, 5, 5} ---");
        int[] dice3 = {5, 2, 5, 2, 5};
        Arrays.sort(dice3); // Wird zu {2, 2, 5, 5, 5}
        runTests(dice3);
        
        System.out.println("\n--- Testfall 4: Kniffel {6, 6, 6, 6, 6} ---");
        int[] dice4 = {6, 6, 6, 6, 6};
        Arrays.sort(dice4);
        runTests(dice4);
    }
    
    /**
     * Hilfsmethode, um alle Kategorien für einen Würfelsatz auszugeben.
     */
    static void runTests(int[] dice) {
        System.out.println("Würfel: " + Arrays.toString(dice));
        System.out.println("Einser: " + aces(dice));
        System.out.println("Zweier: " + twos(dice));
        System.out.println("Dreier: " + threes(dice));
        System.out.println("Vierer: " + fours(dice));
        System.out.println("Fünfer: " + fives(dice));
        System.out.println("Sechser: " + sixes(dice));
        System.out.println("Dreierpasch: " + threeOfAKind(dice));
        System.out.println("Viererpasch: " + fourOfAKind(dice));
        System.out.println("Full House: " + fullHouse(dice));
        System.out.println("Kleine Straße: " + smallStraight(dice));
        System.out.println("Große Straße: " + largeStraight(dice));
        System.out.println("Kniffel: " + kniffel(dice));
        System.out.println("Chance: " + chance(dice));
    }
}