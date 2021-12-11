package api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEdge_PopUp extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;
    public static void main(String[] args) {

    }
    AddEdge_PopUp(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout());
        this.setTitle("Add Edge");

        button =  new JButton("Insert src,dest,weight");
        button.addActionListener(this);
        button.setBackground(Color.GREEN);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));

        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button) {
            String ans = textField.getText();
            String[] Coordinates = ans.split(",");
            String src = Coordinates[0];
            String dest = Coordinates[1];
            String weight = Coordinates[2];
            int x = Integer.parseInt(src);
            int y = Integer.parseInt(dest);
            double z = Double.parseDouble(weight);

            EdgeData edge = new Edge(z);
            ((Edge) edge).setSrc(x);
            ((Edge) edge).setDest(y);

            Node node = (Node) DWG.nodes.get(x);
            DWG.adjList.get(node).add(edge);
            System.out.println("Added Edge ");

        }
    }
}

