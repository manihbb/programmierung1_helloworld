public class Maximum {
    static int maximun(int a, int b){
        if (a > b){
            return a;
        }
        return b;

    }

    static double maximum(double a, double b){
        if(a > b){
            return a;
        }
        return b;
    }

    static double maximum(double a, double b, double c){
        if(a > b){
            return maximum(a, c);
        }
        return maximum(b, c);
    }

    static void main(){
        System.out.println(maximum(24, -2));
        System.out.println(maximum(24.3, -2));
        System.out.println(maximum(24, -2.5, 49));

        double m1 = maximum(12.4, 4.5);
        int m2 = maximum(12, 4);
        double m3 = maximum(12, 4);

    }
}