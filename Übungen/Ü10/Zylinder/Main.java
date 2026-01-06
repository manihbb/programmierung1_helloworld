public class Main {
    public static void main(String[] args) {
        Cylinder[] cylinders = {
            new Cylinder(3, 5),
            new Cylinder(2, 8),
            new Cylinder(1, 10)
        };

        Cylinder[] sortedCylinders = Cylinder.sorted(cylinders);

        for (Cylinder cylinder : sortedCylinders) {
            System.out.println("Radius: " + cylinder.radius() + ", Höhe: " + cylinder.height() + ", Volumen: " + cylinder.volume());
        }
    }
}
