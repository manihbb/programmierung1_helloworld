/*
 * Zusatzfrage: Warum kann diese Methode nicht paket-privat sein?
 * Antwort: Die Methode toString() überschreibt die Methode aus der Klasse java.lang.Object.
 * Da toString() in Object als 'public' definiert ist, darf die Sichtbarkeit in der
 * überschreibenden Klasse nicht eingeschränkt werden (z.B. auf package-private).
 *
 * Bonusfrage: Warum ist es sinnvoll, dass der Konstruktor eine Defensive Copy anlegt?
 * Antwort: Arrays sind in Java veränderlich (mutable). Ohne eine Defensive Copy könnte
 * der Aufrufer den Inhalt der Matrix nachträglich über die Referenz auf das ursprüngliche
 * Array verändern, was die Kapselung und Integrität der Matrix verletzen würde.
 * Beispiel:
 * int[][] daten = {{1}};
 * Matrix m = new Matrix(daten);
 * daten[0][0] = 99; // Ohne Kopie würde sich m verändern.
 */

public class Matrix {

    private final int[][] values;
    private final int rows;
    private final int columns;

    Matrix(int[][] data) {
        if (data == null) {
            throw new IllegalArgumentException("Data must not be null");
        }
        if (data.length == 0) {
            throw new IllegalArgumentException("Data must not be empty");
        }

        this.rows = data.length;
        if (data[0] == null) {
            throw new IllegalArgumentException("Row 0 must not be null");
        }
        this.columns = data[0].length;

        if (this.columns == 0) {
            throw new IllegalArgumentException("Columns must not be empty");
        }

        this.values = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            if (data[i] == null) {
                throw new IllegalArgumentException("Row " + i + " must not be null");
            }
            if (data[i].length != columns) {
                throw new IllegalArgumentException("Matrix must be rectangular");
            }
            System.arraycopy(data[i], 0, this.values[i], 0, columns);
        }
    }

    int get(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= columns) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return values[row][column];
    }

    Matrix multiply(Matrix other) {
        if (other == null) {
            throw new IllegalArgumentException("Other matrix must not be null");
        }
        if (this.columns != other.rows) {
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication");
        }

        int[][] resultValues = new int[this.rows][other.columns];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                int sum = 0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.values[i][k] * other.get(k, j);
                }
                resultValues[i][j] = sum;
            }
        }

        return new Matrix(resultValues);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sb.append(values[i][j]);
                if (j < columns - 1) {
                    sb.append(" ");
                }
            }
            if (i < rows - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}