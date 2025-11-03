public class Vektor {
    static int[] sum(int[] a, int[] b){
        int [] sum = new int[a.length];

        for(int i = 0; int i < sum.length; i++){
            sum[i] = a[i] + b[i];
        }
        return sum;
    }


    static void main() {
        // (1 2 3) + (4 5 6) = ( 5 6 7)

        int [] a = {1,2,3};
        int [] b = new int[]{4,5,6};

        int [] sum = new int[a.length];
        
    }
}