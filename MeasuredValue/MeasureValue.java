public class MeasureValue {
    static void main() {
        double messwert1 = 20.5;
        double messwert2 = 21.1;
        double messwert3 = 21.3;
        double messwert4 = 21.5;
        double messwert5 = 20.1;

        double sum = messwert1 + messwert2 + messwert3 + messwert4 + messwert5;

        System.out.println(sum);

        double[] messwerte = {20.5, 21.1 , 21.3, 21.5, 20.1};

        double m = messwerte[0];
        System.out.println(m);

        int groesse = messwerte.length;
        System.out.print(groesse);

        double summe = 0;
        for(int i = 0; i < messwerte.length; i++) {
            summe += messwerte[i];
        }
    }
}