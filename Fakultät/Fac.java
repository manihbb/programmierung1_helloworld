public class Fac {
    public static int fac(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fac(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int result = fac(n);
        System.out.println(n + "! = " + result);
    }
}
