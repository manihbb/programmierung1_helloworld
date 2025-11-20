public class Newton {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("ERROR: ungueltiges Argument");
            return;
        }
        double c;
        try {
            c = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: ungueltiges Argument");
            return;
        }
        if (c < 0) {
            System.out.println("ERROR: ungueltiges Argument");
            return;
        }
        if (c == 0) {
            System.out.println("0.000000000000000");
            return;
        }
        double t = c;
        double prev;
        do {
            prev = t;
            t = (t + c / t) / 2.0;
        } while (Math.abs(t - prev) >= 0.0001);
        System.out.printf("%.15f%n", t);
    }
}