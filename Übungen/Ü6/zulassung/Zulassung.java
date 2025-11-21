class Zulassung {
    private static final String DATEN = """
        Name,Blatt 1,Blatt 2,Blatt 3,Blatt 4,Blatt 5,Blatt 6,Blatt 7,Blatt 8
        Tai Becker,2,10,13,3,4,5,7,18
        Sascha Maier,0,0,0,20,17,20,18,2
        Kim Müller,20,20,18,20,10,0,0,19
        Kari Nguyen-Kim,1,10,15,4,8,0,9,12
        Katara Schmidt,0,0,0,20,17,20,20,20""";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("genau ein Argument erwartet");
            return;
        }
        int maxPunkte = Integer.parseInt(args[0]);

        Studi[] alle = einlesen();
        java.util.Arrays.sort(alle, (a, b) -> a.getName().compareTo(b.getName()));

        for (Studi s : alle) {
            System.out.println(s.getCsvZeile(maxPunkte));
        }
    }

    private static Studi[] einlesen() {
        String[] zeilen = DATEN.split("\n");
        Studi[] ergebnis = new Studi[zeilen.length - 1];
        for (int i = 1; i < zeilen.length; i++) {
            String[] teile = zeilen[i].split(",");
            String name = teile[0];
            int[] punkte = new int[teile.length - 1];
            for (int j = 1; j < teile.length; j++) {
                punkte[j - 1] = Integer.parseInt(teile[j]);
            }
            ergebnis[i - 1] = new Studi(name, punkte);
        }
        return ergebnis;
    }
}