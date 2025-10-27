public class Fibunacci {
    public static int F(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return F(n - 1) + F(n - 2);
        }
    }

    public static void main(String[] args) {
        // Testen für verschiedene Werte von n
        int[] testValues = {0,45};
        for (int n : testValues) {
            int result = F(n);
            System.out.println("F(" + n + ") = " + result);
        }
    }
}