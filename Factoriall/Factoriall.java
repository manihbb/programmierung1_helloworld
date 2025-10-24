public class Factoriall {

    static void main() {

        int n = 4;
        int result = 1;
        
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        System.out.println(result);
    }
}