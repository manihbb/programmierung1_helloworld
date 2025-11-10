static void subtract(double[] point1, double[] point2) {
    point1[0] = point1[0] - point2[0];
    point1[1] = point1[1] - point2[1];
}

static void printPoint(double[] point) {
    for(double coordinate: point) {
        System.out.print(coordinate + " ");
    }
}

static void main() {
    double[] point1 = {0.3, 2.6};
    double[] point2 = {1.8, 0.3, 42.0};

    subtract(point1, point2);
    
    printPoint(point1);
}
