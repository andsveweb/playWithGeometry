/*
Andreas Svensson
svefastbygg@gmail.com
Datum 2023-04-02
*/
import java.awt.*;

class Circle extends Shapes {
    int radius;
    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }
    // Calculating distance between x and y and center of circle.
    @Override
    public boolean contains(int x, int y) {
        int dx = x - this.x;
        int dy = y - this.y;
        //System.out.println("Circle " + x +"," + y);
        return dx * dx + dy * dy <= radius * radius;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}
