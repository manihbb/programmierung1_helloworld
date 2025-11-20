public class Minesweeper {
    public static void main(String[] args) {
        // Prüfe, ob Feldgröße angegeben ist
        if (args.length < 2) {
            System.out.println("ERROR: Bitte Feldgröße angeben");
            return;
        }

        // Feldgröße einlesen
        int numberOfColumns;
        int numberOfRows;
        try {
            numberOfColumns = Integer.parseInt(args[0]);
            numberOfRows = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Breite und Höhe müssen ganze Zahlen sein.");
            return;
        }

        if (numberOfColumns <= 0 || numberOfRows <= 0) {
            System.out.println("ERROR: Breite und Höhe müssen positiv sein.");
            return;
        }

        int expectedNumberOfFields = numberOfColumns * numberOfRows;
        /*
            F: Warum wird im folgenden Statement 2 subtrahiert?
            A: Weil die ersten beiden Argumente (args[0] und args[1]) die Breite und Höhe des Spielfelds angeben. Die eigentlichen Felder beginnen erst ab args[2]. Daher enthält args.length - 2 die Anzahl der übergebenen Feldwerte (0 oder 1).
        */
        int numberOfFieldsGiven = args.length - 2;
        if (expectedNumberOfFields != numberOfFieldsGiven) {
            System.out.println("ERROR: " + expectedNumberOfFields + " Felder erwartet, aber " + numberOfFieldsGiven + " angegeben.");
            return;
        }

        int[][] mines = getMinesArray(args, numberOfRows, numberOfColumns);

        int[][] neighborhood = calculateNeighborhoodNumbers(numberOfRows, numberOfColumns, mines);

        printBoard(neighborhood);
    }

    static int[][] getMinesArray(String[] args, int numberOfRows, int numberOfColumns) {
        int[][] mines = new int[numberOfRows][numberOfColumns];

        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                int index = row * numberOfColumns + col + 2;
                int val;
                try {
                    val = Integer.parseInt(args[index]);
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Ungültiger Feldwert.");
                    return mines; // return empty array, main will continue
                }
                if (val != 0 && val != 1) {
                    System.out.println("ERROR: Feldwerte müssen 0 oder 1 sein.");
                    return mines;
                }
                mines[row][col] = val;
            }
        }
        return mines;
    }

    static int[][] calculateNeighborhoodNumbers(int numberOfRows, int numberOfColumns, int[][] mines) {
        int[][] offsets = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int[][] neighborhood = new int[numberOfRows][numberOfColumns];

        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                /*
                    F: Welche Bedeutung hat es, wenn im mines-Array ein Eintrag den Wert 1 hat?
                    A: Der Wert 1 bedeutet, dass sich an dieser Position eine Mine befindet. Der Wert 0 bedeutet, dass kein Mine vorhanden ist.
                */
                if (mines[row][col] == 1) {
                    neighborhood[row][col] = -1;
                } else {
                    int count = 0;
                    for (int[] offset : offsets) {
                        int r = row + offset[1];
                        int c = col + offset[0];
                        /*
                            F: Was würde beim Ausführen des Programms (potentiell) passieren, wenn wir die folgende if-Verzweigung entfernen?
                            A: Es käme zu einer ArrayIndexOutOfBoundsException, sobald ein Randfeld geprüft wird. Ohne die Grenzprüfung würden auch Koordinaten außerhalb des gültigen Bereichs angesprochen werden.
                        */
                        if (r >= 0 && r < numberOfRows && c >= 0 && c < numberOfColumns) {
                            if (mines[r][c] == 1) {
                                count++;
                            }
                        }
                    }
                    neighborhood[row][col] = count;
                }
            }
        }
        return neighborhood;
    }

    static void printBoard(int[][] neighborhood) {
        for (int[] row : neighborhood) {
            for (int val : row) {
                if (val == -1) {
                    System.out.print("x ");
                } else if (val == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(val + " ");
                }
            }
            System.out.println();
        }
        int fields = neighborhood.length * neighborhood[0].length;
        int mines = 0;
        for (int[] row : neighborhood) {
            for (int val : row) {
                if (val == -1) {
                    mines++;
                }
            }
        }
        System.out.println(fields + " fields, " + mines + " mines");
    }
}