public class Ship {

    public static void main(String[] args) {

        double[] xHull = { 0.2, 0.8, 0.7, 0.3 };
        double[] yHull = { 0.2, 0.2, 0.4, 0.4 };
        StdDraw.polygon(xHull, yHull);

        StdDraw.line(0.5, 0.4, 0.5, 0.9);

        double[] xSail = { 0.5, 0.5, 0.8 };
        double[] ySail = { 0.9, 0.5, 0.5 };
        StdDraw.polygon(xSail, ySail);
    }
}

//test