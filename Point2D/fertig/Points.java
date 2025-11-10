static void main() {
//         Point point1 = new Point();
//         point1.x = 10;
//         point1.y = 10.10;
//         
//         System.out.println(point1.x);
//         System.out.println(point1.y);
//         
//         Point point2 = new Point();
//         point2.x = 20;
//         point2.y = 20.10;
//         
//         System.out.println(point2.x);
//         
// //         subtract(point1, point2);
//         point1.subtract(point2);
//         
// //         printPoint(point1);
//         
// //         "foo".toUpperCase()
//         point1.printPoint();
    
    
    Point point3 = new Point(5, 5);
    point3.printPoint(); // gibt *keinen* Fehler
    // new Color(255, 255, 255)
    
    point3.setX(1/.0);
    point3.printPoint();
    
//         System.out.println(point3.x);
    System.out.println(point3.getX());
    
    System.out.println(point3.toString() + "!");
    System.out.println(point3); // Besonderheit: Wenn in println ein Objekt gesteckt wird, wird automatisch toString auf dem Objekt aufgerufen.
                                // Weil der Code von println nicht im selben Ordner ist wie Point.java, muss toString public sein.
    System.out.println(point3.toString());
    
    Point point4 = new Point(5, 5);
    System.out.println(point3 == point4);
    
    System.out.println(point3.equals(point4));
    
    
}
