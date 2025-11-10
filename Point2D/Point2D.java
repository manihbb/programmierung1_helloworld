class Point2D {
    private double x;
    private double y;

    Point2D(/*Point2D this,*/ double x, double y) {
        this.setX(x);
        this.setY(y);
    }
    
    void subtract(/*Point2D this,*/ Point2D point2) {
        Point2D point1 = this;
        point1.x = point1.x - point2.x;
        point1.y = point1.y - point2.y;
    }
    
    void printPoint(/*Point2D this*/) {
        System.out.println(this.x + " " + this.y);
    }
    
    void setX(double x) {
        if(x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY || Double.isNaN(x)) {
            return;
        }
        this.x = x;
    }
    
    double getX() {
        return this.x;
    }
    
    void setY(double y) {
        if(y == Double.POSITIVE_INFINITY || y == Double.NEGATIVE_INFINITY || Double.isNaN(y)) {
            return;
        }
        this.y = y;
    }
    
    double getY() {
        return this.y;
    }
}
