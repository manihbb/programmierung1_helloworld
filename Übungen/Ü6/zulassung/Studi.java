class Studi {
    private static final double TEILZULASSUNG = 0.2;
    private static final double GESAMTZULASSUNG = 0.5;

    private final String name;
    private final int[] punkte;

    Studi(String name, int[] punkte) {
        this.name = name;
        this.punkte = punkte.clone();
    }

    private int summeErsteHaelfte() {
        int sum = 0;
        for (int i = 0; i < punkte.length / 2; i++) sum += punkte[i];
        return sum;
    }

    private int summeZweiteHaelfte() {
        int sum = 0;
        for (int i = punkte.length / 2; i < punkte.length; i++) sum += punkte[i];
        return sum;
    }

    private int gesamtPunkte() {
        int sum = 0;
        for (int p : punkte) sum += p;
        return sum;
    }

    boolean hatTeilI(double maxPunkte) {
        return summeErsteHaelfte() >= maxPunkte * TEILZULASSUNG;
    }

    boolean hatTeilII(double maxPunkte) {
        return summeZweiteHaelfte() >= maxPunkte * TEILZULASSUNG;
    }

    boolean hatGesamtzulassung(double maxPunkte) {
        return gesamtPunkte() >= maxPunkte * GESAMTZULASSUNG
            && hatTeilI(maxPunkte)
            && hatTeilII(maxPunkte);
    }

    String getCsvZeile(double maxPunkte) {
        return name + "," + hatTeilI(maxPunkte) + "," + hatTeilII(maxPunkte) + "," + hatGesamtzulassung(maxPunkte);
    }

    String getName() {
        return name;
    }
}