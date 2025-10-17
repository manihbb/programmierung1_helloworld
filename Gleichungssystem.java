public class Gleichungssystem {
    static void main(){
        double p = 1.6;
        double q = 0.64;
        double radikant = p * p / 4 - q;
        if (Math.abs(radikant) < 0.00001 ) {
            System.out.println(-p / 2);
        }

        if (radikant < 0) {
            System.out.println("keine Nullstelle");
        }else {
            double wurzelwert = Math.sqrt(radikant);
            double x0 = -p/2.0 + wurzelwert;
            double x1 = -p/2.0 - wurzelwert;
            System.out.println(x0);
            System.out.println(x1);
        }
        System.out.println("Ende");
    }
    
}