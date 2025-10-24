public class Aufgabe {
    public static double f(double x) {
        return 5 + Math.sin(x);
    }

    public static void testFunction() {
        System.out.println("f(0) = " + f(0));    // 5.0
        System.out.println("f(10) = " + f(10));  // ca. 5.46
    }

    public static void funktionsTabelle() {
        for (int x = -10; x <= 10; x++) {
            double result = f((double) x);
            System.out.println("f(" + x + ") = " + result);
        }
    }

    public static void main(String[] args) {
        testFunction();
        funktionsTabelle();
    }
}