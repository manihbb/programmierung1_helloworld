public class Absmax {
    static int absmax(int x, int y) {
        int result;

        if (Math.abs(x) < Math.abs(y)) {
            result = y;
        } else {
            result = x;
        }
        return result; // Rückgabe des Ergebnisses
    }

    public static void main(String[] args) {
        int x = -20;
        int y = 11;
        int result = absmax(x, y);
        System.out.println(result); // Ausgabe des Ergebnisses
    }
}