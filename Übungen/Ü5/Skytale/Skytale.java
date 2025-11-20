public class Skytale {
    private static final int N = 4;  // Zeilen (Durchmesser)
    private static final int M = 7;  // Spalten (28 / 4)

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("ERROR: Genau zwei Argumente erforderlich.");
            return;
        }

        String mode = args[0];
        String text = args[1];

        if (!mode.equals("E") && !mode.equals("D")) {
            System.out.println("ERROR: Erstes Argument muss E oder D sein.");
            return;
        }

        if (text.length() != 28) {
            System.out.println("ERROR: Nachricht muss genau 28 Zeichen lang sein.");
            return;
        }

        if (mode.equals("E")) {
            System.out.println(verschluesseln(text));
        } else {
            System.out.println(entschluesseln(text));
        }
    }

    // Verschlüsseln: Klartext → Geheimtext
    // Schreibe SPALTENWEISE in 4×7-Matrix, lies ZEILENWEISE aus
    public static String verschluesseln(String klartext) {
        char[][] matrix = zeilenweiseInRasterSchreiben(klartext);
        return rasterSpaltenweiseAblesen(matrix);
    }

    // Entschlüsseln: Geheimtext → Klartext
    // Schreibe ZEILENWEISE in 4×7-Matrix, lies SPALTENWEISE aus
    public static String entschluesseln(String geheimtext) {
        char[][] matrix = spaltenweiseInRasterSchreiben(geheimtext);
        return rasterZeilenweiseAblesen(matrix);
    }

    // Hilfsmethode: Schreibe String ZEILENWEISE in Matrix
    public static char[][] zeilenweiseInRasterSchreiben(String text) {
        char[][] matrix = new char[N][M];
        int idx = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                matrix[row][col] = text.charAt(idx++);
            }
        }
        return matrix;
    }

    // Hilfsmethode: Schreibe String SPALTENWEISE in Matrix
    public static char[][] spaltenweiseInRasterSchreiben(String text) {
        char[][] matrix = new char[N][M];
        int idx = 0;
        for (int col = 0; col < M; col++) {
            for (int row = 0; row < N; row++) {
                matrix[row][col] = text.charAt(idx++);
            }
        }
        return matrix;
    }

    // Hilfsmethode: Lies Matrix ZEILENWEISE aus
    public static String rasterZeilenweiseAblesen(char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                sb.append(matrix[row][col]);
            }
        }
        return sb.toString();
    }

    // Hilfsmethode: Lies Matrix SPALTENWEISE aus
    public static String rasterSpaltenweiseAblesen(char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < M; col++) {
            for (int row = 0; row < N; row++) {
                sb.append(matrix[row][col]);
            }
        }
        return sb.toString();
    }
}