public class PascalTriangle {

    static int pascalRecursive(int zeile, int spalte) {
        if (spalte == 0 || spalte == zeile) {
            return 1;
        }
        if (spalte < 0 || spalte > zeile) {
            return 0;
        }
        return pascalRecursive(zeile - 1, spalte - 1) + pascalRecursive(zeile - 1, spalte);
    }

    static void pascalTriangle(int n) {
        if (n <= 0) {
            return;
        }
        for (int zeile = 0; zeile < n; zeile++) {
            for (int spalte = 0; spalte <= zeile; spalte++) {
                System.out.print(pascalRecursive(zeile, spalte));
                if (spalte < zeile) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            int n = Integer.parseInt(args[0]);
            pascalTriangle(n);
        }
    }
}