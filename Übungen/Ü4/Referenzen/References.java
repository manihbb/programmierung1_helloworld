/**
 * Dies ist die Lösung zu Aufgabe 3: Referenzen.
 * * Der Code enthält die vorhergesagten Ausgaben und die Begründungen,
 * wie in der Aufgabenstellung verlangt.
 */
public class References {

    /**
     * Tauscht zwei primitive int-Werte.
     */
    static void swap1(int number1, int number2) {
        int oldNumber1 = number1;
        number1 = number2;
        number2 = oldNumber1;
    }

    /**
     * Tauscht die ersten beiden Elemente eines Arrays.
     */
    static void swap2(int[] array) {
        int oldFirstElement = array[0];
        array[0] = array[1];
        array[1] = oldFirstElement;
    }

    /**
     * Versucht, zwei Array-Referenzen zu tauschen.
     */
    static void swap3(int[] array1, int[] array2) {
        int[] oldArray1 = array1;
        array1 = array2;
        array2 = oldArray1;
    }

    /**
     * Hauptmethode zur Demonstration der Parameterübergabe.
     */
    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 8;

        swap1(n1, n2);

        System.out.println(n1); // Ausgabe: 5
        System.out.println(n2); // Ausgabe: 8
        /*
        Begründung:
        'n1' und 'n2' sind primitive Typen (int). Ihre Werte (5 und 8) werden
        direkt auf dem STACK gespeichert. Beim Aufruf von swap1(n1, n2) wird
        "Call by Value" verwendet: Es werden KOPIEN der Werte (5 und 8) erstellt
        und an die Methode übergeben.
        Die Methode 'swap1' tauscht auf ihrem eigenen Stack-Frame nur diese Kopien.
        Die originalen Variablen 'n1' und 'n2' im Stack-Frame der 'main'-Methode
        bleiben davon unberührt.
        */

        int[] v1 = {10, 20};

        swap2(v1);

        System.out.println(v1[0]); // Ausgabe: 20
        /*
        Begründung:
        'v1' ist ein Objekt-Typ (ein Array). Die Variable 'v1' auf dem STACK
        speichert nur eine REFERENZ (eine Adresse), die auf das eigentliche
        Array-Objekt [10, 20] auf dem HEAP zeigt.
        Beim Aufruf von swap2(v1) wird "Call by Value" verwendet: Es wird eine
        KOPIE DER REFERENZ erstellt und an 'swap2' übergeben.
                Sowohl die originale Referenz 'v1' als auch die Kopie 'array' in 'swap2'
        zeigen auf DASSELBE Objekt auf dem Heap. Die Methode 'swap2' ändert
        über ihre Referenz den *Inhalt* dieses Objekts (array[0] = array[1]).
        Da 'v1' immer noch auf dieses Objekt zeigt, ist die Änderung in 'main' sichtbar.
        */

        int[] v2 = {-1, 2};
        int[] v3 = {6, 4};

        swap3(v2, v3);

        System.out.println(v2[0]); // Ausgabe: -1
        System.out.println(v3[0]); // Ausgabe: 6
        /*
        Begründung:
        'v2' und 'v3' sind Referenzen auf dem STACK, die auf zwei verschiedene
        Array-Objekte auf dem HEAP zeigen. Beim Aufruf von 'swap3' werden
        KOPIEN DIESER REFERENZEN an die Methode übergeben.
        Die Methode 'swap3' tauscht nur diese *Kopien* der Referenzen. Die
        lokale Variable 'array1' in 'swap3' zeigt danach auf das Objekt von 'v3'
        und 'array2' auf das von 'v2'.
        Die originalen Referenzen 'v2' und 'v3' im Stack-Frame von 'main' werden
        davon NICHT beeinflusst. Sie zeigen immer noch auf ihre ursprünglichen
        Objekte auf dem Heap. Es wurde kein Objektinhalt verändert.
        */
    }
}