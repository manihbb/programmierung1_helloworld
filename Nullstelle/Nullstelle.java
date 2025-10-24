public class Nullstelle {
    public static void main(String[] args) {
        double nullstelle = nst(10, 5);
        System.out.println("Die Nullstelle von 10x + 5 ist " + nullstelle);
        System.out.println("Die Nullstelle von 1x + 0 ist " + nst(1.0, 0.0));
    }

    static double nst(double a, double b) {
        return -b / a;
    }
}