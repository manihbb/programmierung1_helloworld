static void main() {
    Point2D point1 = new Point2D(2.5, 7.5);
    Point2D point2 = new Point2D(1.5, 0.5);
    
    point1.printPoint();
    
    point1.setX(1);
    point1.printPoint();
    
    point1.setX(1/0.);
    point1.printPoint();
    
    point1.subtract(point2);
    point1.printPoint();
    
    point2.printPoint();
}
