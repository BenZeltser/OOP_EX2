package api;

import javax.swing.*;
import java.awt.*;

public class Grider extends JFrame {
    public Grider() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Grider");
        this.setSize(420,420);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

            /*
                System.out.println("Hey");
        super.paintComponent(g);
        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g1.setPaint(Color.BLUE);
        ArrayList<NodeData> nodeList = new ArrayList<>();
        //Draw nodes
        for (int i = 0; i < graph.nodes.size(); i++) {
            nodeList.add(graph.nodes.get(i));
            double x = graph.nodes.get(i).getLocation().x();
            double y = graph.nodes.get(i).getLocation().y();
            float xScale = (float) (x - 35);
            float yScale = (float) (y - 32);
            float X = (xScale * 30000 - 5600);
            float Y = (yScale * 30000 - 2900);
            g1.fill(new Rectangle2D.Float(X, Y, 12, 12));
            String XCoordinate = "X:" + new String(String.valueOf(x));
            String YCoordinate = "Y:" + new String(String.valueOf(y));
            String Coordinates = (XCoordinate + " " + YCoordinate);
            g1.drawString(Coordinates, (float) X, (float) Y);

            System.out.println("small x:" + x);
            System.out.println("small y:" + y);
            System.out.println("Big x:" + X);
            System.out.println("Big y:" + Y);

        }

        for (int i = 0; i < graph.adjList.size(); i++) {
            Object exception = Exception;
            try {
                NodeData temp = nodeList.get(i);
                for (int j = 0; j < graph.adjList.get(temp).size(); j++) {
                    int src = graph.adjList.get(temp).get(j).getSrc();
                    int dest = graph.adjList.get(temp).get(j).getDest();

                    NodeData n1 = nodeList.get(src);
                    NodeData n2 = nodeList.get(dest);
                    double x1 = n1.getLocation().x();
                    double y1 = n1.getLocation().y();
                    double x2 = n2.getLocation().x();
                    double y2 = n2.getLocation().y();
                    double x1Scale = x1 - 35;
                    double y1Scale = y1 - 32;
                    double X1 = (x1Scale * 30000 - 5600);
                    double Y1 = (y1Scale * 30000 - 2900);

                    double x2Scale = x2 - 35;
                    double y2Scale = y2 - 32;
                    double X2 = (x2Scale * 30000 - 5600);
                    double Y2 = (y2Scale * 30000 - 2900);

                    Line2D l = new Line2D.Double(X1, Y1, X2, Y2);
                    ((Graphics2D) g).draw(l);
                }

            } catch (java.lang.Exception exception1) {
                continue;
            }
        }
    }
         */

    public void paint(Graphics g) {
        Graphics2D graph = (Graphics2D) g;



    }

}
