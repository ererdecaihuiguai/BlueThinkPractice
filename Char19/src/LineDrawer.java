import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class LineDrawer extends JPanel {

    //存放所有的线条
    private List<List<Point>> lines = new ArrayList<List<Point>>();
    //当前线条
    private List<Point> currLine;

    public LineDrawer() {
        setBackground(Color.white);
        addMouseListener(new MouseAdapter() {
            //当用户按下鼠标，就开始绘制一条新的线条
            @Override
            public void mousePressed(MouseEvent e) {
                currLine = new ArrayList<Point>();
                lines.add(currLine);
                currLine.add(new Point(e.getX(), e.getY()));
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            //拖动鼠标时，随之画线条
            @Override
            public void mouseDragged(MouseEvent e) {
                currLine.add(new Point(e.getX(), e.getY()));
                repaint();
            }
        });
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        for (List<Point> points : lines) {
            int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
            for (Point point : points) {
                x2 = (int) point.getX();
                y2 = (int) point.getY();
                if (x1 != -1) {
                    graphics.drawLine(x1, y1, x2, y2);
                }
                x1 = x2;
                y1 = y2;
            }
        }
    }

    public static void main(String[] args) {
        JPanel panel = new LineDrawer();
        JFrame frame = new JFrame("Hello");
        frame.setContentPane(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
