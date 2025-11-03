static void main() {

    double x0 = 2;
    double v0 = 10;
    double t = 1.5;
    
    double g = 9.81;
    double ergebnis = x0 + v0 * t - (g * t * t) / 2;
    
    System.out.println(ergebnis);
}