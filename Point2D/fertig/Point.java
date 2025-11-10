class Point {

    private double x;
    private double y;
    
    Point(double x, double y) {
//         x = x;
//         y = y;
//         this.x = x;
        this.y = y;
        setX(x);
    }
    
    void setX(double newX) {
        if(newX == Double.POSITIVE_INFINITY || newX == Double.NEGATIVE_INFINITY || Double.isNaN(newX)) {
            System.out.println(newX + " verboten");
            return;
        }
        this.x = newX;
    }
    
    double getX() {
        return this.x;
    }

    // nicht static: auf Objekt aufrufbar
    void printPoint(/*this*/) {
        // System.out.print(this.x + " " + this.y);
        System.out.print(x + " " + y);
        System.out.println();
    }
    
    void subtract(/*Point this,*/ Point point2) {
        this.x = this.x - point2.x;
        this.y = this.y - point2.y;
    }
    
    public String toString() {
        // return this.x + " " + this.y;
        return x + " " + y;
    }
    
    boolean equals(Point that) {
        // hier wäre weglassen von »this.« eher verwirrend
        return this.x == that.x && this.y == that.y; // danger: Rundungsfehler
    }

}
