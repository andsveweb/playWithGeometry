/*
Andreas Svensson
svefastbygg@gmail.com
Datum 2023-04-02
*/
import java.awt.*;

class Square extends Shapes {
    int side;
    public Square(int x, int y, int side, Color color) {
        super(x, y, color);
        this.side = side;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, side, side);
    }
    @Override
    public boolean contains(int x, int y) {
        // System.out.println("Checking Square " + x + "," + y);
        return x >= this.x && x <= this.x + side && y >= this.y && y <= this.y + side;
    }
}
