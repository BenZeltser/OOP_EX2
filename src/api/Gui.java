package api;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

import static java.lang.System.out;

public class Gui {
    static void main(String[] args) {

    }

    public static void build() throws IOException {

        ImageIcon image = new ImageIcon("src/api/Algorithms.png");

        Border border = BorderFactory.createLineBorder(Color.green, 3);

        JLabel iconLabel = new JLabel("OOP_2021 - Ex3 Interface");
        iconLabel.setIcon(image);
        iconLabel.setHorizontalTextPosition(JLabel.CENTER);
        iconLabel.setVerticalTextPosition(JLabel.TOP);
        iconLabel.setForeground(Color.GREEN);
        iconLabel.setFont((new Font("MV Boli", Font.PLAIN, 20)));
        iconLabel.setIconTextGap(25);
        iconLabel.setBackground(Color.BLACK);
        iconLabel.setOpaque(true);
        iconLabel.setBorder(border);
        iconLabel.setVerticalAlignment(JLabel.TOP);
        iconLabel.setHorizontalAlignment(JLabel.CENTER);
        iconLabel.setBounds(0, 0, 350, 350);


        JLabel txt = new JLabel();
        txt.setSize(350,50);
        txt.setLocation(0,0);
        txt.setText("Select Action");
        txt.setOpaque(true);

        JPanel select_label = new JPanel();
        select_label.setBackground(Color.ORANGE);
        select_label.setBounds(0, 350, 350, 50);
        select_label.add(txt);
        select_label.setVisible(true);
        select_label.setEnabled(true);
        select_label.revalidate();

        JButton saveButton = new JButton();
        saveButton.setBounds(0, 400, 350, 25);
        saveButton.setBackground(Color.green);
        saveButton.setText("Save");
        saveButton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        saveButton.addActionListener(e -> out.println("saveButton"));

        JButton AddNodeButton = new JButton();
        AddNodeButton.setBounds(0, 425, 350, 25);
        AddNodeButton.setBackground(Color.green);
        AddNodeButton.setText("Add Node");
        AddNodeButton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        AddNodeButton.addActionListener(e -> new AddNode_PopUp());


        JButton AddEdgeButton = new JButton();
        AddEdgeButton.setBounds(0, 450, 350, 25);
        AddEdgeButton.setBackground(Color.green);
        AddEdgeButton.setText("Add Edge");
        AddEdgeButton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        AddEdgeButton.addActionListener(e -> new AddEdge_PopUp());

        JButton ShortestPathButton = new JButton();
        ShortestPathButton.setBounds(0, 475, 350, 25);
        ShortestPathButton.setBackground(Color.green);
        ShortestPathButton.setText("Shortest Path");
        ShortestPathButton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        ShortestPathButton.addActionListener(e -> new addShortestPath_PopUp());

        JButton tspButton = new JButton();
        tspButton.setBounds(0, 500, 350, 25);
        tspButton.setBackground(Color.green);
        tspButton.setText("(ADD)Tsp Algorithm");
        tspButton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        tspButton.addActionListener(e -> out.println("tspButton"));

        JButton isConnectedButton = new JButton();
        isConnectedButton.setBounds(0, 525, 350, 25);
        isConnectedButton.setBackground(Color.green);
        isConnectedButton.setText("(ADD)is Connected");
        isConnectedButton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        DWG_ALGO algo = new DWG_ALGO();
        algo.load("data/G1.json");
        algo.init(Grid.graph);
        isConnectedButton.addActionListener(e -> new addisConnected_PopUP());

        JFrame frame = new JFrame();
        frame.setBackground(Color.BLACK);
        frame.setTitle("OOP_2021 - Ex2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(365, 590);
        frame.setVisible(true);
        frame.add(saveButton);
        frame.add(AddNodeButton);
        frame.add(AddEdgeButton);
        frame.add(ShortestPathButton);
        frame.add(isConnectedButton);
        frame.add(tspButton);
        frame.add(iconLabel);
        frame.add(select_label);
        frame.add(txt);
        frame.revalidate();
    }

}
