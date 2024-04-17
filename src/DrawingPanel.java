/*
Andreas Svensson
svefastbygg@gmail.com
Datum 2023-04-02
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {
    private final ArrayList<Shapes> shapes = new ArrayList<>();  //Arraylist with all the shapes
    private Shapes selectedShape = null;
    private int deltaX, deltaY;
    // Constructor for adding shapes to the array. And adding mouse listener to panel
    public DrawingPanel() {
        shapes.add(new Circle(250, 130, 50, Color.RED));
        shapes.add(new Square(300, 230, 100, Color.BLUE));
        shapes.add(new Triangle(140, 230, 100, 80, Color.GREEN));

        setBackground(Color.black);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    // Method to find index of the shape under mouse when clicked. If shape is not in front move it to front
    @Override
    public void mousePressed(MouseEvent e) {
        int indexOfShapeUnderMouse = findIndexOfShapeUnderMouse(e);
        if (indexOfShapeUnderMouse != -1) {
            selectAndMoveShapeToFront(indexOfShapeUnderMouse, e);
            repaint();
        }
    }
    // Method for using with mousePressed to find the index of shape under mouse
    private int findIndexOfShapeUnderMouse(MouseEvent e) {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i).contains(e.getX(), e.getY())) {
                selectedShape = shapes.get(i);
                deltaX = e.getX() - selectedShape.x;
                deltaY = e.getY() - selectedShape.y;
                return i;
            }
        }
        return -1;
    }
    // Method for changing place of the shape in the arraylist
    private void selectAndMoveShapeToFront(int shapeIndex, MouseEvent e) {
        Shapes shapeToMove = shapes.remove(shapeIndex);
        shapes.add(shapeToMove);
    }

    // Repainting when mouse is released
    @Override
    public void mouseReleased(MouseEvent e) {
        selectedShape = null;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    // Updates the position of selected shape where the mouse clicked is released.
    @Override
    public void mouseDragged(MouseEvent e) {
        if (selectedShape != null) {
            selectedShape.x = e.getX() - deltaX;
            selectedShape.y = e.getY() - deltaY;

            if (selectedShape instanceof Triangle) {
                ((Triangle) selectedShape).updatePolygon();
            }
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    // Drawing each shape in the array
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shapes shape : shapes) {
            shape.draw(g);
        }
    }
}
