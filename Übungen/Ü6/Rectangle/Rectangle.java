class Rectangle {
    private int width;
    private int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    Rectangle() {
        this.width = 0;
        this.height = 0;
    }

    int area() {
        return width * height;
    }

    int perimeter() {
        return 2 * (width + height);
    }

    boolean isSquare() {
        return width == height;
    }

    @Override
    public String toString() {
        if (width <= 0 || height <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    sb.append("* ");
                } else {
                    sb.append("  ");
                }
            }
            if (i < height - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 3);
        Rectangle square = new Rectangle(2, 2);

        System.out.println(rectangle.isSquare());
        System.out.println(rectangle.perimeter());
        System.out.println(rectangle.area());
        System.out.println(rectangle.toString());

        System.out.println(square.isSquare());
        System.out.println(square);
    }
}