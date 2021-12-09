package api.api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNode_PopUp extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;
    JTextField bro;
    public static void main(String[] args) {

    }
    AddNode_PopUp(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout());
        this.setTitle("Add Node");

        button =  new JButton("Add");
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
                String xstr = Coordinates[0];
                String ystr = Coordinates[1];
                double x = Double.parseDouble(xstr);
                double y = Double.parseDouble(ystr);

                NodeData node = new Node(DWG.nodes.size());
                Location p = new Location(x,y,0);

                DWG.nodes.put(DWG.nodes.size(), node);
                System.out.println("Added Node \nx:"+x+"\ny:"+y);

            }
        }
    }

