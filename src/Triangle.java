/*
Andreas Svensson
svefastbygg@gmail.com
Datum 2023-04-02
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

class Triangle extends Shapes {
    int base, height;
    private final Polygon polygon;
    public Triangle(int x, int y, int base, int height, Color color) {
        super(x, y, color);
        this.base = base;
        this.height = height;

        this.polygon = new Polygon();
        polygon.addPoint(x, y);
        polygon.addPoint(x - base / 2, y + height);
        polygon.addPoint(x + base / 2, y + height);
    }
    @Override
    public boolean contains(int x, int y) {
        return polygon.contains(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillPolygon(polygon);
    }
    public void updatePolygon() {
        polygon.reset();
        polygon.addPoint(x, y);
        polygon.addPoint(x - base / 2, y + height);
        polygon.addPoint(x + base / 2, y + height);
    }
}

