package api.api;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static java.lang.System.out;

public class Gui {
    static void main(String[] args) {

    }

    public static void build() {


        ImageIcon image = new ImageIcon("src/api/api/Algorithms.png");

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
        txt.setText("Select Action");
        txt.setSize(10, 10);
        txt.setBounds(0, 350, 350, 25);


        JPanel select_label = new JPanel();
        select_label.setBackground(Color.ORANGE);
        select_label.setBounds(0, 350, 350, 25);
        select_label.add(txt);


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
        AddEdgeButton.setText("(ADD)Add Edge");
        AddEdgeButton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        AddEdgeButton.addActionListener(e -> new AddEdge_PopUp());

        JButton ShortestPathButton = new JButton();
        ShortestPathButton.setBounds(0, 475, 350, 25);
        ShortestPathButton.setBackground(Color.green);
        ShortestPathButton.setText("(ADD)Shortest Path");
        ShortestPathButton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        ShortestPathButton.addActionListener(e -> new PopUpWindow("Shortest Path is: "));

        JButton b6 = new JButton();
        b6.setBounds(0, 500, 350, 25);
        b6.setBackground(Color.green);
        b6.setText("(ADD)Tsp Algorithm");
        b6.setFont(new Font("Comic Sans", Font.BOLD, 15));
        b6.addActionListener(e -> out.println("b6"));


        JFrame frame = new JFrame();
        frame.setBackground(Color.BLACK);
        frame.setTitle("OOP_2021 - Ex3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(365, 565);
        frame.setVisible(true);
        frame.add(saveButton);
        frame.add(AddNodeButton);
        frame.add(AddEdgeButton);
        frame.add(ShortestPathButton);
        frame.add(b6);
        frame.add(iconLabel);
        frame.add(select_label);
        frame.revalidate();
    }

}
