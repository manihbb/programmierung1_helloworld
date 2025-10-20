public class Schaltjahr {
    public static void main(String[] args) {
        int jahr = 2024;

        boolean regel1 = jahr % 4 == 0;
        boolean regel2 = jahr % 100 == 0;
        boolean regel3 = jahr % 400 == 0;

        if ((regel1 && !regel2) || regel3) {
            System.out.println("Ja, " + jahr + " ist ein Schaltjahr.");
        } else {
            System.out.println("Nein, " + jahr + " ist kein Schaltjahr.");
        }
    }
}


