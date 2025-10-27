public class Ggt {
    static void main() {
        int a = 10;
        int b = 5;
        int e = ggt(a, b);
        System.out.println(e);
    }

    static int ggt(int a, int b){
        if(a == 0) {
            return b;
        }
        if(b == 0){
            return a;
        }
        int c = a % b;
        return ggt(b, c);
    }
}