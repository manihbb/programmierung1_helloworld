public class Cosinus {

    private static double fakultaet(int n) {
        double result = 1.0;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double cosinus(double x) {
        x = x % (2 * Math.PI);
        if (x < 0) x += 2 * Math.PI;

        double sum = 0.0;
        int sign = 1;
        for (int n = 0; n <= 20; n += 2) {
            double term = sign * Math.pow(x, n) / fakultaet(n);
            sum += term;
            sign = -sign;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("cosinus(0) = " + cosinus(0));
        System.out.println("cosinus(Math.PI/2) = " + cosinus(Math.PI/2));
        System.out.println("cosinus(Math.PI) = " + cosinus(Math.PI));
        System.out.println("cosinus(3*Math.PI/2) = " + cosinus(3*Math.PI/2));
        System.out.println("cosinus(2*Math.PI) = " + cosinus(2*Math.PI));

        double x = 0.5;
        System.out.printf("Näherung für x=%.1f: %.10f (Math.cos: %.10f)%n", x, cosinus(x), Math.cos(x));
    }
}

//test