package api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class addShortestPath_PopUp extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;

    public static void main(String[] args) {

    }

    addShortestPath_PopUp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout());
        this.setTitle("Shortest Path");

        button = new JButton("Insert src,dest");
        button.addActionListener(this);
        button.setBackground(Color.GREEN);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));

        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String ans = textField.getText();
            String[] Coordinates = ans.split(",");
            String src = Coordinates[0];
            String dest = Coordinates[1];
            int x = Integer.parseInt(src);
            int y = Integer.parseInt(dest);

            DWG_ALGO algo = new DWG_ALGO();
            try {
                algo.load("data/G1.json");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            algo.init(Grid.graph);
            double distance = algo.shortestPathDist(x,y);
            List<NodeData> path = algo.shortestPath(x,y);

            String Path = "";
            for (int i=0; i<path.size(); i++) {
               int temp = path.get(i).getKey();
                String temp1 = String.valueOf(temp);
                Path = Path+temp1;
                Path = Path+"->";
            }
            Path = Path.substring(0,Path.length()-2);

            new ShortestPath_PopUp(distance, Path);


        }
    }
}