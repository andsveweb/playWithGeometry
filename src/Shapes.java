/*
Andreas Svensson
svefastbygg@gmail.com
Datum 2023-04-02
*/
import java.awt.*;
// Abstract class that have to be implemented with the other shapes.
public abstract class Shapes {
    protected int x, y;
    protected Color color;
    public Shapes(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public abstract void draw(Graphics g);
    public abstract boolean contains(int x, int y);
}
