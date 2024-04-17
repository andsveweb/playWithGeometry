/*
Andreas Svensson
svefastbygg@gmail.com
Datum 2023-04-02
*/
import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        // Creating the frame and object
        JFrame frame = new JFrame("Uppgift 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        DrawingPanel panel = new DrawingPanel();
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}