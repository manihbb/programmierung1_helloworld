public class Absmax {
    static void absmax(int x, int y){
        int result;

        if(Math.abs(x) < Math.abs(y)) {
            result = y;
        } else {
            result = x;
        }
    }

    static void main() {
        int x = -20;
        int y = 11;
        int result = absmax(x,y);
        System.out.println(x);
    }
}
