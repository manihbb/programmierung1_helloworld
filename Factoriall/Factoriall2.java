public class Factoriall2 {
    static void main() {
        int n = 4;
        int result = 1;
        int i = 1;
        while(i <= n) {
            result *= i;
            i++;
        }
        System.out.println(result);
    }
}