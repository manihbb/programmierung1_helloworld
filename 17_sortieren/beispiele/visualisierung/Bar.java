public class Bar {

    private int height;
    private int width;
    private java.awt.Color color;
    
    private static final int BASE_WIDTH = 10;

    public Bar(int height) {
        this.height = height;
        this.width = BASE_WIDTH + (int)Math.max(-50, (100 - height)) / 20;
        this.color = rainbowColor(height);
    }
    
    private static java.awt.Color rainbowColor(int value) {
        float hue = ((2 * value) % 100) / 100f;
        float saturation = 0.8f / (value / 50 + 1) + 0.2f;
        return java.awt.Color.getHSBColor(hue * 0.8f, saturation, 0.8f);
    }
    
    public String toString() {
        return "Height: " + height;
    }
    
    public double getSortKey() {
        return height;
    }
    
    public void draw(int xPosition) {
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(xPosition, 0, width / 2, height);
    }
    
    public static void draw(Bar[] bars, int pauseLength) {
        StdDraw.setPenColor(new java.awt.Color(255,255,255,175));
        StdDraw.filledRectangle(500,500,1000,1000);
        
        for(int i = 0; i < bars.length; i++) {
            bars[i].draw(BASE_WIDTH / 2 + 2 * i * BASE_WIDTH);
        }
        
        StdDraw.show();
        StdDraw.pause(pauseLength);
    }
}
